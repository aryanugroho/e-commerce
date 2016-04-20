package net.marcoreis.ecommerce.entidades;

import javax.persistence.Column;
import javax.persistence.Lob;

public class ImagemProduto {
    @Lob
    @Column(length = 1024 * 1024 * 5)
    private byte[] foto;
    private Produto produto;
    private String descricao;

}
