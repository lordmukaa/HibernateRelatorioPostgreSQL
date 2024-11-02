package view;

import controller.FornecedorController;
import dao.FornecedorDao;
import model.FornecedorModel;
import model.PessoaModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class FornecedorView extends JFrame {

    // Campos para a entidade PessoaModel
    private JTextField edtPES_CODIGO, edtPES_NOME, edtPES_CPFCNPJ, edtPES_ENDERECO, edtPES_NUMERO, edtPES_COMPLEMENTO, edtPES_BAIRRO, edtPES_CIDADE;
    private JTextField edtPES_UF, edtPES_CEP, edtPES_FONE1, edtPES_FONE2, edtPES_CELULAR, edtPES_EMAIL, edtPES_DTCADASTRO;
    private JTextField edtPES_FANTASIA, edtPES_RGIE, edtPES_SITE;

    // Checkbox para indicar se a pessoa é física e se está ativa
    private JCheckBox chkAtivo, chkFisica;

    // Campos para a entidade FornecedorModel
    private JTextField edtFOR_CODIGO, edtFOR_CONTATO;

    // Botões de ação
    private JButton btnSalvar, btnExcluir, btnNovo, btnCancelar;

    // Tabela para exibir fornecedores
    private JTable tblFornecedores;
    private DefaultTableModel tableModel;

    private FornecedorController fornecedorController;
    private ArrayList<FornecedorModel> listaFornecedores;
    private FornecedorModel fornecedorSelecionado;

    public FornecedorView() {
        fornecedorController = new FornecedorController(new FornecedorDao());

        setTitle("Cadastro de Fornecedor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para formulário de dados usando GridBagLayout
        JPanel pnlForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Configuração dos campos da entidade PessoaModel
        edtPES_CODIGO = new JTextField();
        edtPES_CODIGO.setPreferredSize(new Dimension(150, 25));
        edtPES_NOME = new JTextField();
        edtPES_NOME.setPreferredSize(new Dimension(200, 25));
        edtPES_CPFCNPJ = new JTextField();
        edtPES_CPFCNPJ.setPreferredSize(new Dimension(150, 25));
        edtPES_ENDERECO = new JTextField();
        edtPES_ENDERECO.setPreferredSize(new Dimension(200, 25));
        edtPES_NUMERO = new JTextField();
        edtPES_NUMERO.setPreferredSize(new Dimension(80, 25));
        edtPES_COMPLEMENTO = new JTextField();
        edtPES_COMPLEMENTO.setPreferredSize(new Dimension(100, 25));
        edtPES_BAIRRO = new JTextField();
        edtPES_BAIRRO.setPreferredSize(new Dimension(150, 25));
        edtPES_CIDADE = new JTextField();
        edtPES_CIDADE.setPreferredSize(new Dimension(150, 25));
        edtPES_UF = new JTextField();
        edtPES_UF.setPreferredSize(new Dimension(50, 25));
        edtPES_CEP = new JTextField();
        edtPES_CEP.setPreferredSize(new Dimension(100, 25));
        edtPES_FONE1 = new JTextField();
        edtPES_FONE1.setPreferredSize(new Dimension(100, 25));
        edtPES_FONE2 = new JTextField();
        edtPES_FONE2.setPreferredSize(new Dimension(100, 25));
        edtPES_CELULAR = new JTextField();
        edtPES_CELULAR.setPreferredSize(new Dimension(100, 25));
        edtPES_EMAIL = new JTextField();
        edtPES_EMAIL.setPreferredSize(new Dimension(200, 25));
        edtPES_DTCADASTRO = new JTextField();
        edtPES_DTCADASTRO.setPreferredSize(new Dimension(100, 25));

        // Novos campos
        edtPES_FANTASIA = new JTextField();
        edtPES_FANTASIA.setPreferredSize(new Dimension(150, 25));
        edtPES_RGIE = new JTextField();
        edtPES_RGIE.setPreferredSize(new Dimension(150, 25));
        edtPES_SITE = new JTextField();
        edtPES_SITE.setPreferredSize(new Dimension(200, 25));

        // Configuração dos campos da entidade FornecedorModel
        edtFOR_CODIGO = new JTextField();
        edtFOR_CODIGO.setPreferredSize(new Dimension(100, 25));
        edtFOR_CONTATO = new JTextField();
        edtFOR_CONTATO.setPreferredSize(new Dimension(200, 25));

        // Checkbox para o status ativo
        chkAtivo = new JCheckBox("Ativo");
        chkFisica = new JCheckBox("Pessoa Física");

        // Adicionando os campos ao painel usando GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        pnlForm.add(new JLabel("Código Pessoa:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        pnlForm.add(edtPES_CODIGO, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        pnlForm.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_NOME, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlForm.add(new JLabel("CPF/CNPJ:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        pnlForm.add(edtPES_CPFCNPJ, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Endereço:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_ENDERECO, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlForm.add(new JLabel("Número:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_NUMERO, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Complemento:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_COMPLEMENTO, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlForm.add(new JLabel("Bairro:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_BAIRRO, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Cidade:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_CIDADE, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        pnlForm.add(new JLabel("UF:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_UF, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("CEP:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_CEP, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        pnlForm.add(new JLabel("Telefone 1:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_FONE1, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Telefone 2:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_FONE2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        pnlForm.add(new JLabel("Celular:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_CELULAR, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Email:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_EMAIL, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        pnlForm.add(new JLabel("Data de Cadastro:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_DTCADASTRO, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        pnlForm.add(new JLabel("Fantasia:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_FANTASIA, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("RG/IE:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtPES_RGIE, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        pnlForm.add(new JLabel("Site:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtPES_SITE, gbc);

        // Checkbox para indicar se é pessoa física
        gbc.gridx = 0;
        gbc.gridy = 10;
        pnlForm.add(chkFisica, gbc);

        // Campos específicos de Fornecedor
        gbc.gridx = 0;
        gbc.gridy = 11;
        pnlForm.add(new JLabel("Código Fornecedor:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtFOR_CODIGO, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Contato:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtFOR_CONTATO, gbc);

        // Adiciona o checkbox "Ativo"
        gbc.gridx = 0;
        gbc.gridy = 12;
        pnlForm.add(chkAtivo, gbc);

        // Painel de botões
        JPanel pnlButtons = new JPanel(new FlowLayout());
        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnCancelar = new JButton("Cancelar");

        pnlButtons.add(btnNovo);
        pnlButtons.add(btnSalvar);
        pnlButtons.add(btnExcluir);
        pnlButtons.add(btnCancelar);

        // Painel de tabela para exibir fornecedores
        String[] colunas = {"Código Fornecedor", "Nome", "CPF/CNPJ", "Contato"};
        tableModel = new DefaultTableModel(colunas, 0);
        tblFornecedores = new JTable(tableModel);

        // Ação de clicar na tabela e trazer os dados
        tblFornecedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tblFornecedores.getSelectedRow();
                    if (selectedRow >= 0) {
                        fornecedorSelecionado = listaFornecedores.get(selectedRow);
                        preencherFormulario(fornecedorSelecionado);
                    }
                }
            }
        });

        // Ações dos botões
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
                edtPES_CODIGO.setEditable(true);  // Torna o campo editável
                edtFOR_CODIGO.setEditable(true);  // Torna o campo editável
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarFornecedor();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirFornecedor();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
                edtPES_CODIGO.setEditable(false);  // Bloqueia o campo
                edtFOR_CODIGO.setEditable(false);  // Bloqueia o campo
            }
        });

        // Adiciona componentes à tela
        add(pnlForm, BorderLayout.NORTH);
        add(new JScrollPane(tblFornecedores), BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);

        // Inicialmente bloqueia os campos de ID
        edtPES_CODIGO.setEditable(false);
        edtFOR_CODIGO.setEditable(false);

        carregarFornecedores();
        setVisible(true);
    }

    private void preencherFormulario(FornecedorModel fornecedor) {
        edtFOR_CODIGO.setText(String.valueOf(fornecedor.getFOR_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(fornecedor.getPessoa().getPES_CODIGO()));
        edtPES_NOME.setText(fornecedor.getPessoa().getPES_NOME());
        edtPES_CPFCNPJ.setText(fornecedor.getPessoa().getPES_CPFCNPJ());
        edtPES_ENDERECO.setText(fornecedor.getPessoa().getPES_ENDERECO());
        edtPES_NUMERO.setText(fornecedor.getPessoa().getPES_NUMERO());
        edtPES_COMPLEMENTO.setText(fornecedor.getPessoa().getPES_COMPLEMENTO());
        edtPES_BAIRRO.setText(fornecedor.getPessoa().getPES_BAIRRO());
        edtPES_CIDADE.setText(fornecedor.getPessoa().getPES_CIDADE());
        edtPES_UF.setText(fornecedor.getPessoa().getPES_UF());
        edtPES_CEP.setText(fornecedor.getPessoa().getPES_CEP());
        edtPES_FONE1.setText(fornecedor.getPessoa().getPES_FONE1());
        edtPES_FONE2.setText(fornecedor.getPessoa().getPES_FONE2());
        edtPES_CELULAR.setText(fornecedor.getPessoa().getPES_CELULAR());
        edtPES_EMAIL.setText(fornecedor.getPessoa().getPES_EMAIL());
        edtPES_DTCADASTRO.setText(String.valueOf(fornecedor.getPessoa().getPES_DTCADASTRO()));
        edtPES_FANTASIA.setText(fornecedor.getPessoa().getPES_FANTASIA());
        edtPES_RGIE.setText(fornecedor.getPessoa().getPES_REIE());
        edtPES_SITE.setText(fornecedor.getPessoa().getPES_SITE());
        edtFOR_CONTATO.setText(fornecedor.getFOR_CONTATO());

        chkAtivo.setSelected(fornecedor.getPessoa().getPES_ATIVO().equals("1"));
        chkFisica.setSelected(fornecedor.getPessoa().getPES_FISICA().equals("1"));
    }

    private void salvarFornecedor() {
        try {
            if (edtPES_CODIGO.getText().isEmpty() || edtFOR_CODIGO.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Os campos de Código Pessoa e Código Fornecedor são obrigatórios.");
                return;
            }

            int pesCodigo = Integer.parseInt(edtPES_CODIGO.getText());
            int forCodigo = Integer.parseInt(edtFOR_CODIGO.getText());

            String nome = edtPES_NOME.getText();
            String cpfCnpj = edtPES_CPFCNPJ.getText();
            String endereco = edtPES_ENDERECO.getText();
            String numero = edtPES_NUMERO.getText();
            String complemento = edtPES_COMPLEMENTO.getText();
            String bairro = edtPES_BAIRRO.getText();
            String cidade = edtPES_CIDADE.getText();
            String uf = edtPES_UF.getText();
            String cep = edtPES_CEP.getText();
            String fone1 = edtPES_FONE1.getText();
            String fone2 = edtPES_FONE2.getText();
            String celular = edtPES_CELULAR.getText();
            String email = edtPES_EMAIL.getText();
            String fantasia = edtPES_FANTASIA.getText();
            String rgIe = edtPES_RGIE.getText();
            String site = edtPES_SITE.getText();
            LocalDate dtCadastro = LocalDate.now();

            String contato = edtFOR_CONTATO.getText();

            // Configura PessoaModel com os dados do fornecedor
            PessoaModel pessoa = fornecedorSelecionado != null ? fornecedorSelecionado.getPessoa() : new PessoaModel();
            pessoa.setPES_CODIGO(pesCodigo);
            pessoa.setPES_NOME(nome);
            pessoa.setPES_CPFCNPJ(cpfCnpj);
            pessoa.setPES_ENDERECO(endereco);
            pessoa.setPES_NUMERO(numero);
            pessoa.setPES_COMPLEMENTO(complemento);
            pessoa.setPES_BAIRRO(bairro);
            pessoa.setPES_CIDADE(cidade);
            pessoa.setPES_UF(uf);
            pessoa.setPES_CEP(cep);
            pessoa.setPES_FONE1(fone1);
            pessoa.setPES_FONE2(fone2);
            pessoa.setPES_CELULAR(celular);
            pessoa.setPES_EMAIL(email);
            pessoa.setPES_FANTASIA(fantasia);
            pessoa.setPES_REIE(rgIe);
            pessoa.setPES_SITE(site);
            pessoa.setPES_DTCADASTRO(dtCadastro);

            pessoa.setPES_ATIVO(chkAtivo.isSelected() ? "1" : "0");
            pessoa.setPES_FISICA(chkFisica.isSelected() ? "1" : "0");

            // Configura FornecedorModel
            FornecedorModel fornecedor = fornecedorSelecionado != null ? fornecedorSelecionado : new FornecedorModel();
            fornecedor.setFOR_CODIGO(forCodigo);
            fornecedor.setPessoa(pessoa);
            fornecedor.setFOR_CONTATO(contato);

            fornecedorController.gravar(fornecedor, fornecedorSelecionado == null ? "incluir" : "alterar");

            carregarFornecedores();
            limparFormulario();

            // Bloqueia os campos novamente após salvar
            edtPES_CODIGO.setEditable(false);
            edtFOR_CODIGO.setEditable(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar fornecedor: " + ex.getMessage());
        }
    }

    private void excluirFornecedor() {
        if (fornecedorSelecionado != null) {
            try {
                fornecedorController.excluir(fornecedorSelecionado);
                carregarFornecedores();
                limparFormulario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir fornecedor: " + ex.getMessage());
            }
        }
    }

    private void carregarFornecedores() {
        listaFornecedores = fornecedorController.consultar("");
        tableModel.setRowCount(0);
        for (FornecedorModel fornecedor : listaFornecedores) {
            tableModel.addRow(new Object[]{
                    fornecedor.getFOR_CODIGO(),
                    fornecedor.getPessoa().getPES_NOME(),
                    fornecedor.getPessoa().getPES_CPFCNPJ(),
                    fornecedor.getFOR_CONTATO()
            });
        }
    }

    private void limparFormulario() {
        fornecedorSelecionado = null;
        edtFOR_CODIGO.setText("");
        edtPES_CODIGO.setText("");
        edtPES_NOME.setText("");
        edtPES_CPFCNPJ.setText("");
        edtPES_ENDERECO.setText("");
        edtPES_NUMERO.setText("");
        edtPES_COMPLEMENTO.setText("");
        edtPES_BAIRRO.setText("");
        edtPES_CIDADE.setText("");
        edtPES_UF.setText("");
        edtPES_CEP.setText("");
        edtPES_FONE1.setText("");
        edtPES_FONE2.setText("");
        edtPES_CELULAR.setText("");
        edtPES_EMAIL.setText("");
        edtPES_FANTASIA.setText("");
        edtPES_RGIE.setText("");
        edtPES_SITE.setText("");
        edtFOR_CONTATO.setText("");
        chkAtivo.setSelected(false);
        chkFisica.setSelected(false);
        tblFornecedores.clearSelection();
    }

    public static void main(String[] args) {
        new FornecedorView();
    }
}
