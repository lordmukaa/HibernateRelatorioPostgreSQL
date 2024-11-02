package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_CODIGO", nullable = false, precision = 10)
    private int CLI_CODIGO;

    @Column(name = "CLI_LIMITECRED", nullable = false, precision = 18, scale = 2)
    private BigDecimal CLI_LIMITECRED;

    @ManyToOne
    @JoinColumn(name = "PES_CODIGO", nullable = false)
    private PessoaModel PES_CODIGO;

    public ClienteModel(){
    }

    public ClienteModel(int CLI_CODIGO, PessoaModel PES_CODIGO, BigDecimal CLI_LIMITECRED) {
        this.CLI_CODIGO = CLI_CODIGO;
        this.CLI_LIMITECRED = CLI_LIMITECRED;
        this.PES_CODIGO = PES_CODIGO;
    }

    public int getCLI_CODIGO() {
        return CLI_CODIGO;
    }

    public void setCLI_CODIGO(int CLI_CODIGO) {
        this.CLI_CODIGO = CLI_CODIGO;
    }

    public BigDecimal getCLI_LIMITECRED() {
        return CLI_LIMITECRED;
    }

    public void setCLI_LIMITECRED(BigDecimal CLI_LIMITECRED) {
        this.CLI_LIMITECRED = CLI_LIMITECRED;
    }

    public PessoaModel getPES_CODIGO() {
        return PES_CODIGO;
    }

    public void setPES_CODIGO(PessoaModel PES_CODIGO) {
        this.PES_CODIGO = PES_CODIGO;
    }
}
