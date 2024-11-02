package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMAPAGTO")
public class FormaPagtoModel implements java.io.Serializable{

    @Id
    @Column(name = "FPG_CODIGO", nullable = false, precision = 10)
    private int FPG_CODIGO;

    @Column(name = "FPG_NOME", nullable = false, length = 30)
    private String FPG_NOME;

    @Column(name = "FPG_ATIVO", nullable = false, precision = 1)
    private int FPG_ATIVO;

    public FormaPagtoModel(){
    }

    public FormaPagtoModel(int FPG_CODIGO, String FPG_NOME, int FPG_ATIVO){
        this.FPG_CODIGO = FPG_CODIGO;
        this.FPG_NOME = FPG_NOME;
        this.FPG_ATIVO = FPG_ATIVO;
    }

    public String getFPG_NOME() {
        return FPG_NOME;
    }

    public void setFPG_NOME(String FPG_NOME) {
        this.FPG_NOME = FPG_NOME;
    }

    public int getFPG_CODIGO() {
        return FPG_CODIGO;
    }

    public void setFPG_CODIGO(int FPG_CODIGO) {
        this.FPG_CODIGO = FPG_CODIGO;
    }

    public int getFPG_ATIVO() {
        return FPG_ATIVO;
    }

    public void setFPG_ATIVO(int FPG_ATIVO) {
        this.FPG_ATIVO = FPG_ATIVO;
    }
}
