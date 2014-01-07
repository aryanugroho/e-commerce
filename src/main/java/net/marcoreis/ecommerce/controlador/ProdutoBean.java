package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.util.IndexadorECommerce;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

@RequestScoped
@ManagedBean
public class ProdutoBean extends BaseBean {
    private static final long serialVersionUID = -6475971812078805662L;
    private static Logger logger = Logger.getLogger(ProdutoBean.class);
    private Produto produto;
    private Collection<Produto> produtos;
    private UploadedFile especificacaoFabricante;
    private IndexadorECommerce indexador;

    @PostConstruct
    public void init() {
	produto = new Produto();
	produto.setCategoria(new Categoria());
	carregarProdutos();
    }

    public void carregarProdutos() {
	EntityManager em = JPAUtil.getInstance().getEntityManager();
	produtos = em.createQuery("from Produto").getResultList();
	em.close();
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
    }

    public Produto getProduto() {
	return produto;
    }

    public Collection<Produto> getProdutos() {
	return produtos;
    }

    public void salvar() {
	try {
	    EntityManager em = JPAUtil.getInstance().getEntityManager();
	    em.getTransaction().begin();
	    if (getEspecificacaoFabricante() != null) {
		byte[] dados = IOUtils.toByteArray(getEspecificacaoFabricante()
			.getInputstream());
		getProduto().setEspecificacaoFabricante(dados);
	    }
	    em.persist(getProduto());
	    em.getTransaction().commit();
	    em.close();
	    //
	    getIndexador().indexarProdutos();
	    getIndexador().fechar();
	    //
	    infoMsg("Dados gravados com sucesso");
	} catch (Exception e) {
	    errorMsg(e);
	}
    }

    public void setEspecificacaoFabricante(UploadedFile especificacaoFabricante) {
	this.especificacaoFabricante = especificacaoFabricante;
    }

    public UploadedFile getEspecificacaoFabricante() {
	return especificacaoFabricante;
    }

    public IndexadorECommerce getIndexador() {
	if (indexador == null) {
	    indexador = new IndexadorECommerce();
	}
	return indexador;
    }
}
