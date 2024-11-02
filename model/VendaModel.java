package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "VENDA")
public class VendaModel implements java.io.Serializable{

    @Id
    @Column(name = "VDA_CODIGO", nullable = false, precision = 10)
    private int VDA_CODIGO;

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "CLI_CODIGO", nullable = false)
    private ClienteModel cliente;

    @Column(name = "VDA_DATE", nullable = false, precision = 10, scale = 0)
    private int VDA_DATE;

    @Column(name = "VDA_VALOR", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_VALOR;

    @Column(name = "VDA_DESCONTO", nullable = false, precision = 18,  scale = 2)
    private BigDecimal VDA_DESCONTO;

    @Column(name = "VDA_TOTAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDA_TOTAL;

    @Column(name = "VDA_OBS", nullable = false, precision = 80, scale = 2)
    private BigDecimal VDA_OBS;

    public VendaModel(){
    }

    public VendaModel(int VDA_CODIGO, UsuarioModel usuario, ClienteModel cliente, int VDA_DATE, BigDecimal VDA_VALOR, BigDecimal VDA_DESCONTO, BigDecimal VDA_TOTAL, BigDecimal VDA_OBS) {
        this.VDA_CODIGO = VDA_CODIGO;
        this.usuario = usuario;
        this.cliente = cliente;
        this.VDA_DATE = VDA_DATE;
        this.VDA_VALOR = VDA_VALOR;
        this.VDA_DESCONTO = VDA_DESCONTO;
        this.VDA_TOTAL = VDA_TOTAL;
        this.VDA_OBS = VDA_OBS;
    }

    public int getVDA_CODIGO() {
        return VDA_CODIGO;
    }

    public void setVDA_CODIGO(int VDA_CODIGO) {
        this.VDA_CODIGO = VDA_CODIGO;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public int getVDA_DATE() {
        return VDA_DATE;
    }

    public void setVDA_DATE(int VDA_DATE) {
        this.VDA_DATE = VDA_DATE;
    }

    public BigDecimal getVDA_VALOR() {
        return VDA_VALOR;
    }

    public void setVDA_VALOR(BigDecimal VDA_VALOR) {
        this.VDA_VALOR = VDA_VALOR;
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

    public BigDecimal getVDA_OBS() {
        return VDA_OBS;
    }

    public void setVDA_OBS(BigDecimal VDA_OBS) {
        this.VDA_OBS = VDA_OBS;
    }
}
