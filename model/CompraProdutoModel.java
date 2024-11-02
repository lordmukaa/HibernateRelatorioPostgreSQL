package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "COMPRA_PRODUTO")
public class CompraProdutoModel implements java.io.Serializable{

    @Id
    @Column(name = "CPP_CODIGO", nullable = false, precision = 10, scale = 0)
    private int CPP_CODIGO;

    @ManyToOne
    @JoinColumn(name = "CPR_CODIGO", nullable = false)
    private CompraModel compra;

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO", nullable = false)
    private ProdutoModel produto;

    @Column(name = "CPR_QTDE", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_QTDE;

    @Column(name = "CPR_PRECO", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_PRECO;

    @Column(name = "CPR_DESCONTO", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_DESCONTO;

    @Column(name = "CPR_TOTAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_TOTAL;

    public CompraProdutoModel(){
    }

    public CompraProdutoModel(int CPP_CODIGO, CompraModel compra, ProdutoModel produto, BigDecimal CPR_QTDE, BigDecimal CPR_PRECO, BigDecimal CPR_DESCONTO, BigDecimal CPR_TOTAL) {
        this.CPP_CODIGO = CPP_CODIGO;
        this.compra = compra;
        this.produto = produto;
        this.CPR_QTDE = CPR_QTDE;
        this.CPR_PRECO = CPR_PRECO;
        this.CPR_DESCONTO = CPR_DESCONTO;
        this.CPR_TOTAL = CPR_TOTAL;
    }

    public int getCPP_CODIGO() {
        return CPP_CODIGO;
    }

    public void setCPP_CODIGO(int CPP_CODIGO) {
        this.CPP_CODIGO = CPP_CODIGO;
    }

    public CompraModel getCompra() {
        return compra;
    }

    public void setCompra(CompraModel compra) {
        this.compra = compra;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public BigDecimal getCPR_QTDE() {
        return CPR_QTDE;
    }

    public void setCPR_QTDE(BigDecimal CPR_QTDE) {
        this.CPR_QTDE = CPR_QTDE;
    }

    public BigDecimal getCPR_PRECO() {
        return CPR_PRECO;
    }

    public void setCPR_PRECO(BigDecimal CPR_PRECO) {
        this.CPR_PRECO = CPR_PRECO;
    }

    public BigDecimal getCPR_DESCONTO() {
        return CPR_DESCONTO;
    }

    public void setCPR_DESCONTO(BigDecimal CPR_DESCONTO) {
        this.CPR_DESCONTO = CPR_DESCONTO;
    }

    public BigDecimal getCPR_TOTAL() {
        return CPR_TOTAL;
    }

    public void setCPR_TOTAL(BigDecimal CPR_TOTAL) {
        this.CPR_TOTAL = CPR_TOTAL;
    }
}
