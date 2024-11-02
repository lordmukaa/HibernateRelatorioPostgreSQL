package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "COMPRA")
public class CompraModel implements java.io.Serializable {

    @Id
    @Column(name = "CPR_CODIGO", nullable = false, precision = 10)
    private int CPR_CODIGO;

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "FOR_CODIGO", nullable = false)
    private FornecedorModel fornecedor;

    @Column(name = "CPR_EMISSAO", nullable = false, precision = 10, scale = 0)
    private int CPR_EMISSAO;

    @Column(name = "CPR_VALOR", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_VALOR;

    @Column(name = "CPR_DESCONTO", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_DESCONTO;

    @Column(name = "CPR_TOTAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPR_TOTAL;

    @Column(name = "CPR_DTENTRADA", nullable = false, precision = 10)
    private int CPR_DTENTRADA;

    @Column(name = "VDA_OBS", nullable = false, precision = 80, scale = 2)
    private BigDecimal VDA_OBS;

    public CompraModel(){
    }

    public CompraModel(int CPR_CODIGO, UsuarioModel usuario, FornecedorModel fornecedor, int CPR_EMISSAO, BigDecimal CPR_VALOR, BigDecimal CPR_DESCONTO, BigDecimal CPR_TOTAL, int CPR_DTENTRADA, BigDecimal VDA_OBS) {
        this.CPR_CODIGO = CPR_CODIGO;
        this.usuario = usuario;
        this.fornecedor = fornecedor;
        this.CPR_EMISSAO = CPR_EMISSAO;
        this.CPR_VALOR = CPR_VALOR;
        this.CPR_DESCONTO = CPR_DESCONTO;
        this.CPR_TOTAL = CPR_TOTAL;
        this.CPR_DTENTRADA = CPR_DTENTRADA;
        this.VDA_OBS = VDA_OBS;
    }

    public int getCPR_CODIGO() {
        return CPR_CODIGO;
    }

    public void setCPR_CODIGO(int CPR_CODIGO) {
        this.CPR_CODIGO = CPR_CODIGO;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCPR_EMISSAO() {
        return CPR_EMISSAO;
    }

    public void setCPR_EMISSAO(int CPR_EMISSAO) {
        this.CPR_EMISSAO = CPR_EMISSAO;
    }

    public BigDecimal getCPR_VALOR() {
        return CPR_VALOR;
    }

    public void setCPR_VALOR(BigDecimal CPR_VALOR) {
        this.CPR_VALOR = CPR_VALOR;
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

    public int getCPR_DTENTRADA() {
        return CPR_DTENTRADA;
    }

    public void setCPR_DTENTRADA(int CPR_DTENTRADA) {
        this.CPR_DTENTRADA = CPR_DTENTRADA;
    }

    public BigDecimal getVDA_OBS() {
        return VDA_OBS;
    }

    public void setVDA_OBS(BigDecimal VDA_OBS) {
        this.VDA_OBS = VDA_OBS;
    }
}
