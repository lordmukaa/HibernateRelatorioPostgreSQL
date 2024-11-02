package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUTO")
public class ProdutoModel implements java.io.Serializable {

    @Id
    @Column(name = "PRO_CODIGO", nullable = false, precision = 10)
    private int PRO_CODIGO;

    @Column(name = "PRO_NOME", nullable = false, length = 80)
    private String PRO_NOME;

    @Column(name = "PRO_ESTOQUE", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_ESTOQUE;

    @Column(name = "PRO_UNIDADE", nullable = false, length = 5)
    private String PRO_UNIDADE;

    @Column(name = "PRO_PRECO", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_PRECO;

    @Column(name = "PRO_CUSTO", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_CUSTO;

    @Column(name = "PRO_ATACADO", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_ATACADO;

    @Column(name = "PRO_MIN", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_MIN;

    @Column(name = "PRO_MAX", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_MAX;

    @Column(name = "PRO_EMBALAGEM", nullable = false, precision = 9, scale = 0)
    private BigDecimal PRO_EMBALAGEM;

    @Column(name = "PRO_PESO", nullable = false, precision = 18, scale = 2)
    private BigDecimal PRO_PESO;

    @Column(name = "PRO_DTCADASTRO", nullable = false, precision = 10,  scale = 0)
    private LocalDate PRO_DTCADASTRO;

    @Column(name = "PRO_OBS", nullable = false, precision = 80)
    private String PRO_OBS;

    @Column(name = "PRO_ATIVO", nullable = false, precision = 1)
    private int PRO_ATIVO;

    @Column(name = "PRO_TIPO", nullable = false, length = 1)
    private String PRO_TIPO;

    public String toString(){
        return this.PRO_NOME;
    }

    public ProdutoModel(){
    }

    public ProdutoModel(int PRO_CODIGO, String PRO_NOME, BigDecimal PRO_ESTOQUE, String PRO_UNIDADE, BigDecimal PRO_PRECO, BigDecimal PRO_CUSTO, BigDecimal PRO_ATACADO, BigDecimal PRO_MIN, BigDecimal PRO_MAX, BigDecimal PRO_EMBALAGEM, BigDecimal PRO_PESO, LocalDate PRO_DTCADASTRO, String PRO_OBS, int PRO_ATIVO, String PRO_TIPO) {
        this.PRO_CODIGO = PRO_CODIGO;
        this.PRO_NOME = PRO_NOME;
        this.PRO_ESTOQUE = PRO_ESTOQUE;
        this.PRO_UNIDADE = PRO_UNIDADE;
        this.PRO_PRECO = PRO_PRECO;
        this.PRO_CUSTO = PRO_CUSTO;
        this.PRO_ATACADO = PRO_ATACADO;
        this.PRO_MIN = PRO_MIN;
        this.PRO_MAX = PRO_MAX;
        this.PRO_EMBALAGEM = PRO_EMBALAGEM;
        this.PRO_PESO = PRO_PESO;
        this.PRO_DTCADASTRO = PRO_DTCADASTRO;
        this.PRO_OBS = PRO_OBS;
        this.PRO_ATIVO = PRO_ATIVO;
        this.PRO_TIPO = PRO_TIPO;
    }

    public int getPRO_CODIGO() {
        return PRO_CODIGO;
    }

    public void setPRO_CODIGO(int PRO_CODIGO) {
        this.PRO_CODIGO = PRO_CODIGO;
    }

    public String getPRO_NOME() {
        return PRO_NOME;
    }

    public void setPRO_NOME(String PRO_NOME) {
        this.PRO_NOME = PRO_NOME;
    }

    public BigDecimal getPRO_ESTOQUE() {
        return PRO_ESTOQUE;
    }

    public void setPRO_ESTOQUE(BigDecimal PRO_ESTOQUE) {
        this.PRO_ESTOQUE = PRO_ESTOQUE;
    }

    public String getPRO_UNIDADE() {
        return PRO_UNIDADE;
    }

    public void setPRO_UNIDADE(String PRO_UNIDADE) {
        this.PRO_UNIDADE = PRO_UNIDADE;
    }

    public BigDecimal getPRO_PRECO() {
        return PRO_PRECO;
    }

    public void setPRO_PRECO(BigDecimal PRO_PRECO) {
        this.PRO_PRECO = PRO_PRECO;
    }

    public BigDecimal getPRO_CUSTO() {
        return PRO_CUSTO;
    }

    public void setPRO_CUSTO(BigDecimal PRO_CUSTO) {
        this.PRO_CUSTO = PRO_CUSTO;
    }

    public BigDecimal getPRO_ATACADO() {
        return PRO_ATACADO;
    }

    public void setPRO_ATACADO(BigDecimal PRO_ATACADO) {
        this.PRO_ATACADO = PRO_ATACADO;
    }

    public BigDecimal getPRO_MIN() {
        return PRO_MIN;
    }

    public void setPRO_MIN(BigDecimal PRO_MIN) {
        this.PRO_MIN = PRO_MIN;
    }

    public BigDecimal getPRO_MAX() {
        return PRO_MAX;
    }

    public void setPRO_MAX(BigDecimal PRO_MAX) {
        this.PRO_MAX = PRO_MAX;
    }

    public BigDecimal getPRO_EMBALAGEM() {
        return PRO_EMBALAGEM;
    }

    public void setPRO_EMBALAGEM(BigDecimal PRO_EMBALAGEM) {
        this.PRO_EMBALAGEM = PRO_EMBALAGEM;
    }

    public BigDecimal getPRO_PESO() {
        return PRO_PESO;
    }

    public void setPRO_PESO(BigDecimal PRO_PESO) {
        this.PRO_PESO = PRO_PESO;
    }

    public LocalDate getPRO_DTCADASTRO() {
        return PRO_DTCADASTRO;
    }

    public void setPRO_DTCADASTRO(LocalDate PRO_DTCADASTRO) {
        this.PRO_DTCADASTRO = PRO_DTCADASTRO;
    }

    public String getPRO_OBS() {
        return PRO_OBS;
    }

    public void setPRO_OBS(String PRO_OBS) {
        this.PRO_OBS = PRO_OBS;
    }

    public int getPRO_ATIVO() {
        return PRO_ATIVO;
    }

    public void setPRO_ATIVO(int PRO_ATIVO) {
        this.PRO_ATIVO = PRO_ATIVO;
    }

    public String getPRO_TIPO() {
        return PRO_TIPO;
    }

    public void setPRO_TIPO(String PRO_TIPO) {
        this.PRO_TIPO = PRO_TIPO;
    }
}
