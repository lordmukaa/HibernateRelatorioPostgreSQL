package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "VENDA_PAGTO")
public class VendaPagtoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VDP_CODIGO", nullable = false, precision = 10)
    private int VDP_CODIGO;

    @ManyToOne
    @JoinColumn(name = "VDA_CODIGO", nullable = false)
    private VendaModel venda;

    @ManyToOne
    @JoinColumn(name = "FPG_CODIGO", nullable = false)
    private FormaPagtoModel formaPagtoModel;

    @Column(name = "VDP_VALOR", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDP_VALOR;

    public VendaPagtoModel() {
    }

    public VendaPagtoModel(int VDP_CODIGO, VendaModel venda, FormaPagtoModel formaPagtoModel, BigDecimal VDP_VALOR) {
        this.VDP_CODIGO = VDP_CODIGO;
        this.venda = venda;
        this.formaPagtoModel = formaPagtoModel;
        this.VDP_VALOR = VDP_VALOR;
    }

    public int getVDP_CODIGO() {
        return VDP_CODIGO;
    }

    public void setVDP_CODIGO(int VDP_CODIGO) {
        this.VDP_CODIGO = VDP_CODIGO;
    }

    public VendaModel getVenda() {
        return venda;
    }

    public void setVenda(VendaModel venda) {
        this.venda = venda;
    }

    public FormaPagtoModel getFormaPagtoModel() {
        return formaPagtoModel;
    }

    public void setFormaPagtoModel(FormaPagtoModel formaPagtoModel) {
        this.formaPagtoModel = formaPagtoModel;
    }

    public BigDecimal getVDP_VALOR() {
        return VDP_VALOR;
    }

    public void setVDP_VALOR(BigDecimal VDP_VALOR) {
        this.VDP_VALOR = VDP_VALOR;
    }
}
