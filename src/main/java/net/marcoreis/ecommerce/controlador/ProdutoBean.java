package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.util.IndexadorECommerce;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

@ViewScoped
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
            produto = em.merge(getProduto());
            em.persist(getProduto());
            em.getTransaction().commit();
            em.close();
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

    public String editar(Produto produto) {
        this.produto = produto;
        return "produto?faces-redirect=true&includeViewParams=true";
    }

    public void excluir(Produto produto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.remove(produto);
            em.getTransaction().commit();
            produtos = em.createQuery("from Produto").getResultList();
            infoMsg("Produdo excluído: " + produto.getNome());
        } catch (Exception e) {
            errorMsg(e);
        } finally {
            em.close();
        }
    }

    public void carregarProdutosPorCategoria(ValueChangeEvent evento) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        String hql = "from Produto where categoria.id = :idCategoria";
        Query query = em.createQuery(hql);
        String newValue = evento.getNewValue().toString();
        Long idCategoria = Long.parseLong(newValue);
        query.setParameter("idCategoria", idCategoria);
        produtos = query.getResultList();
        em.close();
    }

}
