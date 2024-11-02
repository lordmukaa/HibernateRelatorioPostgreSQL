package view;

import controller.ClienteController;
import dao.ClienteDao;
import model.ClienteModel;
import model.PessoaModel;

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

public class ClienteView extends JFrame {

    // Campos para a entidade PessoaModel
    private JTextField edtPES_CODIGO, edtPES_NOME, edtPES_CPFCNPJ, edtPES_ENDERECO, edtPES_NUMERO, edtPES_COMPLEMENTO, edtPES_BAIRRO, edtPES_CIDADE;
    private JTextField edtPES_UF, edtPES_CEP, edtPES_FONE1, edtPES_FONE2, edtPES_CELULAR, edtPES_EMAIL, edtPES_DTCADASTRO;
    private JTextField edtPES_FANTASIA, edtPES_RGIE, edtPES_SITE; // Novos campos

    // Checkbox para indicar se a pessoa é física e se está ativa
    private JCheckBox chkAtivo, chkFisica;

    // Campos para a entidade ClienteModel
    private JTextField edtCLI_CODIGO, edtCLI_LIMITECRED;

    // Botões de ação
    private JButton btnSalvar, btnExcluir, btnNovo, btnCancelar;

    // Tabela para exibir clientes
    private JTable tblClientes;
    private DefaultTableModel tableModel;

    private ClienteController clienteController;
    private ArrayList<ClienteModel> listaClientes;
    private ClienteModel clienteSelecionado;

    public ClienteView() {
        clienteController = new ClienteController(new ClienteDao());

        setTitle("Cadastro de Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para formulário de dados usando GridBagLayout
        JPanel pnlForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre componentes

        // Configuração dos campos da entidade PessoaModel
        edtPES_CODIGO = new JTextField();
        edtPES_CODIGO.setPreferredSize(new Dimension(150, 25)); // Ajusta a largura
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

        // Configuração dos campos da entidade ClienteModel
        edtCLI_CODIGO = new JTextField();
        edtCLI_CODIGO.setPreferredSize(new Dimension(100, 25));
        edtCLI_LIMITECRED = new JTextField();
        edtCLI_LIMITECRED.setPreferredSize(new Dimension(100, 25));

        // Checkbox para o status ativo
        chkAtivo = new JCheckBox("Ativo");
        chkFisica = new JCheckBox("Pessoa Física"); // Novo checkbox para indicar se é pessoa física

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
        gbc.gridwidth = 1;
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

        // Novos campos
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
        pnlForm.add(chkFisica, gbc); // Checkbox para pessoa física

        // Código Cliente
        gbc.gridx = 0;
        gbc.gridy = 11;
        pnlForm.add(new JLabel("Código Cliente:"), gbc);
        gbc.gridx = 1;
        pnlForm.add(edtCLI_CODIGO, gbc);

        gbc.gridx = 3;
        pnlForm.add(new JLabel("Limite de Crédito:"), gbc);
        gbc.gridx = 4;
        pnlForm.add(edtCLI_LIMITECRED, gbc);

        // Adiciona o checkbox "Ativo"
        gbc.gridx = 0;
        gbc.gridy = 12;
        pnlForm.add(chkAtivo, gbc); // Adiciona o checkbox ao formulário

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

        // Painel de tabela para exibir clientes
        String[] colunas = {"Código", "Nome", "CPF/CNPJ", "Endereço", "Limite de Crédito"};
        tableModel = new DefaultTableModel(colunas, 0);
        tblClientes = new JTable(tableModel);

        // Ação de clicar na tabela e trazer os dados
        tblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tblClientes.getSelectedRow();
                    if (selectedRow >= 0) {
                        clienteSelecionado = listaClientes.get(selectedRow);
                        preencherFormulario(clienteSelecionado);
                    }
                }
            }
        });

        // Ações dos botões
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
                edtPES_CODIGO.setEditable(true);
                edtCLI_CODIGO.setEditable(true);
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCliente();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
            }
        });

        // Adiciona componentes à tela
        add(pnlForm, BorderLayout.NORTH);
        add(new JScrollPane(tblClientes), BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);

        carregarClientes();
        setVisible(true);
    }

    private void preencherFormulario(ClienteModel cliente) {
        edtCLI_CODIGO.setText(String.valueOf(cliente.getCLI_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(cliente.getPES_CODIGO().getPES_CODIGO()));  // Preenche o código da pessoa
        edtPES_NOME.setText(cliente.getPES_CODIGO().getPES_NOME());
        edtPES_CPFCNPJ.setText(cliente.getPES_CODIGO().getPES_CPFCNPJ());
        edtPES_ENDERECO.setText(cliente.getPES_CODIGO().getPES_ENDERECO());
        edtPES_NUMERO.setText(cliente.getPES_CODIGO().getPES_NUMERO());
        edtPES_COMPLEMENTO.setText(cliente.getPES_CODIGO().getPES_COMPLEMENTO());
        edtPES_BAIRRO.setText(cliente.getPES_CODIGO().getPES_BAIRRO());
        edtPES_CIDADE.setText(cliente.getPES_CODIGO().getPES_CIDADE());
        edtPES_UF.setText(cliente.getPES_CODIGO().getPES_UF());
        edtPES_CEP.setText(cliente.getPES_CODIGO().getPES_CEP());
        edtPES_FONE1.setText(cliente.getPES_CODIGO().getPES_FONE1());
        edtPES_FONE2.setText(cliente.getPES_CODIGO().getPES_FONE2());
        edtPES_CELULAR.setText(cliente.getPES_CODIGO().getPES_CELULAR());
        edtPES_EMAIL.setText(cliente.getPES_CODIGO().getPES_EMAIL());
        edtPES_DTCADASTRO.setText(String.valueOf(cliente.getPES_CODIGO().getPES_DTCADASTRO()));
        edtPES_FANTASIA.setText(cliente.getPES_CODIGO().getPES_FANTASIA()); // Preenche o campo fantasia
        edtPES_RGIE.setText(cliente.getPES_CODIGO().getPES_REIE()); // Preenche o campo RG/IE
        edtPES_SITE.setText(cliente.getPES_CODIGO().getPES_SITE()); // Preenche o campo site
        edtCLI_LIMITECRED.setText(cliente.getCLI_LIMITECRED().toString());

        // Define se a pessoa está ativa
        chkAtivo.setSelected(cliente.getPES_CODIGO().getPES_ATIVO().equals("1")); // Marcar o checkbox se estiver ativo
        chkFisica.setSelected(cliente.getPES_CODIGO().getPES_FISICA().equals("1")); // Marcar o checkbox se for física

        // Torne os campos de ID não editáveis se eles estiverem preenchidos
        edtCLI_CODIGO.setEditable(cliente.getCLI_CODIGO() == 0);
        edtPES_CODIGO.setEditable(cliente.getPES_CODIGO().getPES_CODIGO() == 0);
    }

    private void salvarCliente() {
        try {
            if (edtPES_CODIGO.getText().isEmpty() || edtCLI_CODIGO.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Os campos de Código Pessoa e Código Cliente são obrigatórios.");
                return;
            }

            int pesCodigo = Integer.parseInt(edtPES_CODIGO.getText());
            int cliCodigo = Integer.parseInt(edtCLI_CODIGO.getText());

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
            String fantasia = edtPES_FANTASIA.getText(); // Obtém o valor de fantasia
            String rgIe = edtPES_RGIE.getText(); // Obtém o valor de RG/IE
            String site = edtPES_SITE.getText(); // Obtém o valor do site
            LocalDate dtCadastro = LocalDate.now();  // Assumimos que será preenchido automaticamente

            BigDecimal limiteCredito = new BigDecimal(edtCLI_LIMITECRED.getText());

            // Configura PessoaModel com os dados do cliente
            PessoaModel pessoa = clienteSelecionado != null ? clienteSelecionado.getPES_CODIGO() : new PessoaModel();
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
            pessoa.setPES_FANTASIA(fantasia); // Define o campo fantasia
            pessoa.setPES_REIE(rgIe); // Define o campo RG/IE
            pessoa.setPES_SITE(site); // Define o campo site
            pessoa.setPES_DTCADASTRO(dtCadastro);

            // Define se a pessoa está ativa
            pessoa.setPES_ATIVO(chkAtivo.isSelected() ? "1" : "0"); // Atualiza o campo de ativo
            pessoa.setPES_FISICA(chkFisica.isSelected() ? "1" : "0"); // Atualiza o campo de física

            // Configura ClienteModel
            ClienteModel cliente = clienteSelecionado != null ? clienteSelecionado : new ClienteModel();
            cliente.setCLI_CODIGO(cliCodigo);
            cliente.setPES_CODIGO(pessoa);
            cliente.setCLI_LIMITECRED(limiteCredito);

            // Chama o método de gravação no controller
            clienteController.gravar(cliente, clienteSelecionado == null ? "incluir" : "alterar");

            carregarClientes();  // Atualiza a lista de clientes na tabela
            limparFormulario();  // Limpa o formulário após salvar

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente: " + ex.getMessage());
        }
    }

    private void excluirCliente() {
        if (clienteSelecionado != null) {
            try {
                clienteController.excluir(clienteSelecionado);
                carregarClientes();
                limparFormulario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + ex.getMessage());
            }
        }
    }

    private void carregarClientes() {
        listaClientes = clienteController.consultar("");
        tableModel.setRowCount(0);  // Limpa a tabela
        for (ClienteModel cliente : listaClientes) {
            tableModel.addRow(new Object[]{
                    cliente.getCLI_CODIGO(),
                    cliente.getPES_CODIGO().getPES_NOME(),
                    cliente.getPES_CODIGO().getPES_CPFCNPJ(),
                    cliente.getPES_CODIGO().getPES_ENDERECO(),
                    cliente.getCLI_LIMITECRED()
            });
        }
    }

    private void limparFormulario() {
        clienteSelecionado = null;
        edtCLI_CODIGO.setText("");
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
        edtPES_FANTASIA.setText(""); // Limpa o campo fantasia
        edtPES_RGIE.setText(""); // Limpa o campo RG/IE
        edtPES_SITE.setText(""); // Limpa o campo site
        edtCLI_LIMITECRED.setText("");
        chkAtivo.setSelected(false); // Reseta o checkbox "Ativo"
        chkFisica.setSelected(false); // Reseta o checkbox "Pessoa Física"
        tblClientes.clearSelection();
    }

    public static void main(String[] args) {
        new ClienteView();
    }
}
