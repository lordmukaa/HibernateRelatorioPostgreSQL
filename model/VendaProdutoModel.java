package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "VENDA_PRODUTO")
public class VendaProdutoModel implements java.io.Serializable{

    @Id
    @Column(name = "VEP_CODIGO", nullable = false, precision = 10, scale = 0)
    private int VEP_CODIGO;

    @ManyToOne
    @JoinColumn(name = "VDA_CODIGO", nullable = false)
    private VendaModel venda;

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO", nullable = false)
    private ProdutoModel produto;

    @Column(name = "VDA_QTDE", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_QTDE;

    @Column(name = "VDA_PRECO", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_PRECO;

    @Column(name = "VDA_DESCONTO", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_DESCONTO;

    @Column(name = "VDA_TOTAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_TOTAL;

    public VendaProdutoModel() {
    }

    public VendaProdutoModel(int VEP_CODIGO, VendaModel venda, ProdutoModel produto, BigDecimal VDA_QTDE, BigDecimal VDA_PRECO, BigDecimal VDA_DESCONTO, BigDecimal VDA_TOTAL) {
        this.VEP_CODIGO = VEP_CODIGO;
        this.venda = venda;
        this.produto = produto;
        this.VDA_QTDE = VDA_QTDE;
        this.VDA_PRECO = VDA_PRECO;
        this.VDA_DESCONTO = VDA_DESCONTO;
        this.VDA_TOTAL = VDA_TOTAL;
    }

    public int getVEP_CODIGO() {
        return VEP_CODIGO;
    }

    public void setVEP_CODIGO(int VEP_CODIGO) {
        this.VEP_CODIGO = VEP_CODIGO;
    }

    public VendaModel getVenda() {
        return venda;
    }

    public void setVenda(VendaModel venda) {
        this.venda = venda;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public BigDecimal getVDA_QTDE() {
        return VDA_QTDE;
    }

    public void setVDA_QTDE(BigDecimal VDA_QTDE) {
        this.VDA_QTDE = VDA_QTDE;
    }

    public BigDecimal getVDA_PRECO() {
        return VDA_PRECO;
    }

    public void setVDA_PRECO(BigDecimal VDA_PRECO) {
        this.VDA_PRECO = VDA_PRECO;
    }

    public BigDecimal getVDA_DESCONTO() {
        return VDA_DESCONTO;
    }

    public void setVDA_DESCONTO(BigDecimal VDA_DESCONTO) {
        this.VDA_DESCONTO = VDA_DESCONTO;
    }

    public BigDecimal getVDA_TOTAL() {
        return VDA_TOTAL;
    }

    public void setVDA_TOTAL(BigDecimal VDA_TOTAL) {
        this.VDA_TOTAL = VDA_TOTAL;
    }
}
