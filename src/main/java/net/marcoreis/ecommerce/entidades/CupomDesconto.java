package net.marcoreis.ecommerce.entidades;

/**
 * Cupom de desconto que é aplicado ao produto na hora da compra. <br />
 * O cliente preenche o código e o preço do item é automaticamente ajustado.
 * <br />
 * Os códigos são limitados e cadastrados pela loja.
 * 
 * @author marco
 *
 */
public class CupomDesconto {
    private String codigo;
    private Produto produto;
    private Double desconto;
}
