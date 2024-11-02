package controller;

import dao.ClienteDao;
import model.ClienteModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteController implements GenericController<ClienteModel> {

    ClienteDao clienteDao;

    public ClienteController(ClienteDao clienteDao) {
        this.clienteDao = new ClienteDao();
    }

    @Override
    public void incluir(ClienteModel obj) throws Exception {
        clienteDao.incluir(obj);
    }

    @Override
    public void alterar(ClienteModel obj) throws Exception {
        clienteDao.alterar(obj);
    }

    @Override
    public ArrayList<ClienteModel> consultar(String filtro) {
        return clienteDao.consultar(filtro);
    }

    @Override
    public void excluir(ClienteModel obj) throws Exception {
        clienteDao.excluir(obj);
    }

    @Override
    public void gravar(ClienteModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioCliente.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("Cliente - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
