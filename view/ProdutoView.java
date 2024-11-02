package view;

import controller.ProdutoController;
import dao.ProdutoDao;
import model.ProdutoModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoView extends JFrame {

    private JTextField edtPRO_CODIGO, edtPRO_NOME, edtPRO_ESTOQUE, edtPRO_UNIDADE, edtPRO_PRECO, edtPRO_CUSTO, edtPRO_ATACADO, edtPRO_MIN, edtPRO_MAX, edtPRO_EMBALAGEM, edtPRO_PESO, edtPRO_DTCADASTRO, edtPRO_OBS, edtPRO_TIPO;
    private JCheckBox chkAtivo;
    private JButton btnSalvar, btnExcluir, btnNovo, btnCancelar;
    private JTable tblProdutos;
    private DefaultTableModel tableModel;

    private ProdutoController produtoController;
    private ArrayList<ProdutoModel> listaProdutos;
    private ProdutoModel produtoSelecionado;

    public ProdutoView() {
        produtoController = new ProdutoController(new ProdutoDao());

        setTitle("Cadastro de Produto");
        setSize(900, 700); // Aumenta o tamanho da janela para melhorar a disposição
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pnlForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Define um tamanho maior para os campos
        Dimension fieldSizeCol1 = new Dimension(250, 30);  // Para a primeira coluna
        Dimension fieldSizeCol2 = new Dimension(300, 30);  // Para a segunda coluna

        edtPRO_CODIGO = new JTextField();
        edtPRO_CODIGO.setPreferredSize(fieldSizeCol1);
        edtPRO_NOME = new JTextField();
        edtPRO_NOME.setPreferredSize(fieldSizeCol2);
        edtPRO_ESTOQUE = new JTextField();
        edtPRO_ESTOQUE.setPreferredSize(fieldSizeCol1);
        edtPRO_UNIDADE = new JTextField();
        edtPRO_UNIDADE.setPreferredSize(fieldSizeCol1);
        edtPRO_PRECO = new JTextField();
        edtPRO_PRECO.setPreferredSize(fieldSizeCol1);
        edtPRO_CUSTO = new JTextField();
        edtPRO_CUSTO.setPreferredSize(fieldSizeCol1);
        edtPRO_ATACADO = new JTextField();
        edtPRO_ATACADO.setPreferredSize(fieldSizeCol2);
        edtPRO_MIN = new JTextField();
        edtPRO_MIN.setPreferredSize(fieldSizeCol1);
        edtPRO_MAX = new JTextField();
        edtPRO_MAX.setPreferredSize(fieldSizeCol1);
        edtPRO_EMBALAGEM = new JTextField();
        edtPRO_EMBALAGEM.setPreferredSize(fieldSizeCol1);
        edtPRO_PESO = new JTextField();
        edtPRO_PESO.setPreferredSize(fieldSizeCol1);
        edtPRO_DTCADASTRO = new JTextField();
        edtPRO_DTCADASTRO.setPreferredSize(fieldSizeCol1);
        edtPRO_OBS = new JTextField();
        edtPRO_OBS.setPreferredSize(fieldSizeCol2);
        edtPRO_TIPO = new JTextField();
        edtPRO_TIPO.setPreferredSize(fieldSizeCol1);

        chkAtivo = new JCheckBox("Ativo");

        // Ajusta o layout para duas colunas
        addFieldToForm(pnlForm, gbc, "Código Produto:", edtPRO_CODIGO, 0, 0);
        addFieldToForm(pnlForm, gbc, "Nome:", edtPRO_NOME, 0, 1);
        addFieldToForm(pnlForm, gbc, "Estoque:", edtPRO_ESTOQUE, 0, 2);
        addFieldToForm(pnlForm, gbc, "Unidade:", edtPRO_UNIDADE, 0, 3);
        addFieldToForm(pnlForm, gbc, "Preço:", edtPRO_PRECO, 0, 4);
        addFieldToForm(pnlForm, gbc, "Custo:", edtPRO_CUSTO, 0, 5);
        addFieldToForm(pnlForm, gbc, "Atacado:", edtPRO_ATACADO, 1, 0);
        addFieldToForm(pnlForm, gbc, "Min:", edtPRO_MIN, 1, 1);
        addFieldToForm(pnlForm, gbc, "Max:", edtPRO_MAX, 1, 2);
        addFieldToForm(pnlForm, gbc, "Embalagem:", edtPRO_EMBALAGEM, 1, 3);
        addFieldToForm(pnlForm, gbc, "Peso:", edtPRO_PESO, 1, 4);
        addFieldToForm(pnlForm, gbc, "Data Cadastro:", edtPRO_DTCADASTRO, 1, 5);
        addFieldToForm(pnlForm, gbc, "Observação:", edtPRO_OBS, 0, 6, 2);  // Observação ocupa duas colunas
        addFieldToForm(pnlForm, gbc, "Tipo:", edtPRO_TIPO, 0, 7);
        addFieldToForm(pnlForm, gbc, "", chkAtivo, 1, 7);

        JPanel pnlButtons = new JPanel(new FlowLayout());
        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnCancelar = new JButton("Cancelar");

        pnlButtons.add(btnNovo);
        pnlButtons.add(btnSalvar);
        pnlButtons.add(btnExcluir);
        pnlButtons.add(btnCancelar);

        String[] colunas = {"Código", "Nome", "Estoque", "Unidade", "Preço", "Custo", "Atacado", "Min", "Max", "Embalagem", "Peso", "Data Cadastro", "Observação", "Ativo", "Tipo"};
        tableModel = new DefaultTableModel(colunas, 0);
        tblProdutos = new JTable(tableModel);
        tblProdutos.setPreferredScrollableViewportSize(new Dimension(850, 200));  // Aumenta a largura da tabela

        tblProdutos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProdutos.getSelectedRow();
                if (selectedRow >= 0) {
                    produtoSelecionado = listaProdutos.get(selectedRow);
                    preencherFormulario(produtoSelecionado);
                }
            }
        });

        btnNovo.addActionListener(e -> {
            limparFormulario();
            edtPRO_CODIGO.setEditable(true);
        });

        btnSalvar.addActionListener(e -> salvarProduto());

        btnExcluir.addActionListener(e -> {
            try {
                excluirProduto();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        btnCancelar.addActionListener(e -> limparFormulario());

        add(pnlForm, BorderLayout.NORTH);
        add(new JScrollPane(tblProdutos), BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);

        carregarProdutos();
        setVisible(true);
    }

    private void addFieldToForm(JPanel panel, GridBagConstraints gbc, String label, JComponent field, int x, int y) {
        addFieldToForm(panel, gbc, label, field, x, y, 1);
    }

    private void addFieldToForm(JPanel panel, GridBagConstraints gbc, String label, JComponent field, int x, int y, int width) {
        gbc.gridx = x * 2;  // Define a posição da coluna (multiplica para espaçar corretamente)
        gbc.gridy = y;      // Define a posição da linha
        panel.add(new JLabel(label), gbc);

        gbc.gridx = x * 2 + 1;
        gbc.gridwidth = width;
        panel.add(field, gbc);
        gbc.gridwidth = 1;  // Restaura o valor padrão de gridwidth para os próximos componentes
    }

    private void preencherFormulario(ProdutoModel produto) {
        edtPRO_CODIGO.setText(String.valueOf(produto.getPRO_CODIGO()));
        edtPRO_NOME.setText(produto.getPRO_NOME());
        edtPRO_ESTOQUE.setText(produto.getPRO_ESTOQUE().toString());
        edtPRO_UNIDADE.setText(produto.getPRO_UNIDADE());
        edtPRO_PRECO.setText(produto.getPRO_PRECO().toString());
        edtPRO_CUSTO.setText(produto.getPRO_CUSTO().toString());
        edtPRO_ATACADO.setText(produto.getPRO_ATACADO().toString());
        edtPRO_MIN.setText(produto.getPRO_MIN().toString());
        edtPRO_MAX.setText(produto.getPRO_MAX().toString());
        edtPRO_EMBALAGEM.setText(produto.getPRO_EMBALAGEM().toString());
        edtPRO_PESO.setText(produto.getPRO_PESO().toString());
        edtPRO_DTCADASTRO.setText(String.valueOf(produto.getPRO_DTCADASTRO()));
        edtPRO_OBS.setText(produto.getPRO_OBS().toString());
        chkAtivo.setSelected(produto.getPRO_ATIVO() == 1);
        edtPRO_TIPO.setText(produto.getPRO_TIPO());
        edtPRO_CODIGO.setEditable(false);
    }

    private void limparFormulario() {
        edtPRO_CODIGO.setText("");
        edtPRO_NOME.setText("");
        edtPRO_ESTOQUE.setText("");
        edtPRO_UNIDADE.setText("");
        edtPRO_PRECO.setText("");
        edtPRO_CUSTO.setText("");
        edtPRO_ATACADO.setText("");
        edtPRO_MIN.setText("");
        edtPRO_MAX.setText("");
        edtPRO_EMBALAGEM.setText("");
        edtPRO_PESO.setText("");
        edtPRO_DTCADASTRO.setText("");
        edtPRO_OBS.setText("");
        chkAtivo.setSelected(false);
        edtPRO_TIPO.setText("");
        edtPRO_CODIGO.setEditable(true);
    }

    private void salvarProduto() {
        try {
            if (edtPRO_CODIGO.getText().isEmpty() || edtPRO_NOME.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Os campos Código Produto e Nome são obrigatórios.");
                return;
            }

            int proCodigo = Integer.parseInt(edtPRO_CODIGO.getText());
            String nome = edtPRO_NOME.getText();
            BigDecimal estoque = new BigDecimal(edtPRO_ESTOQUE.getText());
            String unidade = edtPRO_UNIDADE.getText();
            BigDecimal preco = new BigDecimal(edtPRO_PRECO.getText());
            BigDecimal custo = new BigDecimal(edtPRO_CUSTO.getText());
            BigDecimal atacado = new BigDecimal(edtPRO_ATACADO.getText());
            BigDecimal min = new BigDecimal(edtPRO_MIN.getText());
            BigDecimal max = new BigDecimal(edtPRO_MAX.getText());
            BigDecimal embalagem = new BigDecimal(edtPRO_EMBALAGEM.getText());
            BigDecimal peso = new BigDecimal(edtPRO_PESO.getText());
            LocalDate dtCadastro = LocalDate.parse(edtPRO_DTCADASTRO.getText());
            String obs = edtPRO_OBS.getText();
            String tipo = edtPRO_TIPO.getText();

            // Configura o modelo ProdutoModel com os dados preenchidos
            ProdutoModel produto = produtoSelecionado != null ? produtoSelecionado : new ProdutoModel();
            produto.setPRO_CODIGO(proCodigo);
            produto.setPRO_NOME(nome);
            produto.setPRO_ESTOQUE(estoque);
            produto.setPRO_UNIDADE(unidade);
            produto.setPRO_PRECO(preco);
            produto.setPRO_CUSTO(custo);
            produto.setPRO_ATACADO(atacado);
            produto.setPRO_MIN(min);
            produto.setPRO_MAX(max);
            produto.setPRO_EMBALAGEM(embalagem);
            produto.setPRO_PESO(peso);
            produto.setPRO_DTCADASTRO(dtCadastro);
            produto.setPRO_OBS(obs);
            produto.setPRO_ATIVO(chkAtivo.isSelected() ? 1 : 0);
            produto.setPRO_TIPO(tipo);

            // Chama o método de gravação no controller
            produtoController.gravar(produto, produtoSelecionado == null ? "incluir" : "alterar");

            carregarProdutos(); // Atualiza a lista de produtos na tabela
            limparFormulario(); // Limpa o formulário após salvar

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Verifique se todos os campos numéricos estão corretos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage());
        }
    }

    private void excluirProduto() throws Exception {
        if (produtoSelecionado != null) {
            produtoController.excluir(produtoSelecionado);
            carregarProdutos();
            limparFormulario();
        }
    }

    private void carregarProdutos() {
        listaProdutos = produtoController.consultar("");
        tableModel.setRowCount(0); // Limpa a tabela
        for (ProdutoModel produto : listaProdutos) {
            tableModel.addRow(new Object[]{
                    produto.getPRO_CODIGO(),
                    produto.getPRO_NOME(),
                    produto.getPRO_ESTOQUE(),
                    produto.getPRO_UNIDADE(),
                    produto.getPRO_PRECO(),
                    produto.getPRO_CUSTO(),
                    produto.getPRO_ATACADO(),
                    produto.getPRO_MIN(),
                    produto.getPRO_MAX(),
                    produto.getPRO_EMBALAGEM(),
                    produto.getPRO_PESO(),
                    produto.getPRO_DTCADASTRO(),
                    produto.getPRO_OBS(),
                    produto.getPRO_ATIVO(),
                    produto.getPRO_TIPO()
            });
        }
    }

    public static void main(String[] args) {
        new ProdutoView();
    }
}
