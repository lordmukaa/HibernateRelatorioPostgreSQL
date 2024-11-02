package model;

import jakarta.persistence.*;

@Entity
@Table(name = "FORNECEDOR")
public class FornecedorModel implements java.io.Serializable {

    @Id
    @Column(name = "FOR_CODIGO", nullable = false, precision = 10)
    private int FOR_CODIGO;

    @Column(name = "FOR_CONTATO", nullable = false, length = 80)
    private String FOR_CONTATO;

    @ManyToOne
    @JoinColumn(name = "PES_CODIGO", nullable = false)
    private PessoaModel pessoa;

    public FornecedorModel(){
    }

    public FornecedorModel(int FOR_CODIGO, String FOR_CONTATO, PessoaModel pessoa) {
        this.FOR_CODIGO = FOR_CODIGO;
        this.FOR_CONTATO = FOR_CONTATO;
        this.pessoa = pessoa;
    }

    public int getFOR_CODIGO() {
        return FOR_CODIGO;
    }

    public void setFOR_CODIGO(int FOR_CODIGO) {
        this.FOR_CODIGO = FOR_CODIGO;
    }

    public String getFOR_CONTATO() {
        return FOR_CONTATO;
    }

    public void setFOR_CONTATO(String FOR_CONTATO) {
        this.FOR_CONTATO = FOR_CONTATO;
    }

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }
}
