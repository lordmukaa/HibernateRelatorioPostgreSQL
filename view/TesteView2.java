package view;

import dao.FormaPagtoDao;
import model.FormaPagtoModel;

import javax.swing.*;
import java.awt.*;

public class TesteView2 extends JFrame {

        // Componentes da tela de cadastro de forma de pagamento
        private JTextField codigoFormaPagamentoTextField, nomeTextField;
        private JCheckBox ativoCheckBox;
        private JButton salvarButton, cancelarButton;

        public TesteView2() {
            // Configurações básicas da janela
            setTitle("Cadastro de Forma de Pagamento");
            setSize(800, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null); // Centralizar a janela na tela

            // Inicializando os componentes
            Dimension fieldSize = new Dimension(200, 25); // Tamanho dos campos de texto

            codigoFormaPagamentoTextField = new JTextField();
            codigoFormaPagamentoTextField.setPreferredSize(fieldSize);
            codigoFormaPagamentoTextField.setBackground(new Color(60, 60, 60)); // Fundo escuro
            codigoFormaPagamentoTextField.setForeground(Color.WHITE); // Texto branco

            nomeTextField = new JTextField();
            nomeTextField.setPreferredSize(fieldSize);
            nomeTextField.setBackground(new Color(60, 60, 60));
            nomeTextField.setForeground(Color.WHITE);

            ativoCheckBox = new JCheckBox("Ativo");
            ativoCheckBox.setBackground(new Color(45, 45, 45)); // Fundo escuro do checkbox
            ativoCheckBox.setForeground(Color.WHITE); // Texto branco

            salvarButton = new JButton("Salvar");
            salvarButton.setBackground(new Color(70, 130, 180)); // Cor de fundo azul
            salvarButton.setForeground(Color.WHITE); // Texto branco

            cancelarButton = new JButton("Cancelar");
            cancelarButton.setBackground(new Color(255, 69, 0)); // Cor de fundo vermelho
            cancelarButton.setForeground(Color.WHITE); // Texto branco
            cancelarButton.addActionListener(e -> dispose()); // Fecha a janela atual

            // Configurando o layout com GridBagLayout
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(45, 45, 45)); // Fundo do painel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Linha 1
            gbc.gridx = 0; gbc.gridy = 0;
            JLabel labelCodigoFormaPagamento = new JLabel("Código Forma de Pagamento:");
            labelCodigoFormaPagamento.setForeground(Color.WHITE);
            panel.add(labelCodigoFormaPagamento, gbc);
            gbc.gridx = 1; gbc.gridy = 0;
            panel.add(codigoFormaPagamentoTextField, gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            JLabel labelNome = new JLabel("Nome:");
            labelNome.setForeground(Color.WHITE);
            panel.add(labelNome, gbc);
            gbc.gridx = 1; gbc.gridy = 1;
            panel.add(nomeTextField, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            panel.add(ativoCheckBox, gbc);

            // Linha 3 - Botões
            gbc.gridx = 0; gbc.gridy = 3;
            panel.add(salvarButton, gbc);
            gbc.gridx = 1; gbc.gridy = 3;
            panel.add(cancelarButton, gbc);

            // Adicionando o painel ao frame
            add(panel);

            // Tornando a janela visível
            setVisible(true);

            salvarButton.addActionListener(e -> salvarFormaPagamento());

        }
        private void salvarFormaPagamento() {
            try {
                // Captura dos dados dos campos
                int codigo = Integer.parseInt(codigoFormaPagamentoTextField.getText());
                String nome = nomeTextField.getText();
                int ativo = ativoCheckBox.isSelected() ? 1 : 0;

                // Criação do objeto de modelo
                FormaPagtoModel formaPagto = new FormaPagtoModel(codigo, nome, ativo);

                // Uso do DAO para salvar no banco
                FormaPagtoDao dao = new FormaPagtoDao();
                dao.incluir(formaPagto);

                JOptionPane.showMessageDialog(this, "Forma de Pagamento salva com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar Forma de Pagamento: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            // Executa a tela de cadastro de forma de pagamento
            SwingUtilities.invokeLater(() -> new TesteView2());
        }
}


