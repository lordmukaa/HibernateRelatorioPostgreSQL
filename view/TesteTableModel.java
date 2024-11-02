package view;

import model.FormaPagtoModel;
import model.UsuarioModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TesteTableModel extends AbstractTableModel {

    private ArrayList<FormaPagtoModel> linhas;
    String[] colunas = {"Código", "Nome", "Ativo"};

    public TesteTableModel(ArrayList<FormaPagtoModel> lista) {
        linhas = lista;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        FormaPagtoModel objModel = (FormaPagtoModel) linhas.get(row);
        switch (col) {
            case 0:
                return objModel.getFPG_CODIGO();
            case 1:
                return objModel.getFPG_NOME();
            case 2:
                return objModel.getFPG_ATIVO() == 1 ? "Sim" : "Não";
            default:
                return null;
        }
    }

    public void addLista(ArrayList<FormaPagtoModel> lstModel) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(lstModel);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
