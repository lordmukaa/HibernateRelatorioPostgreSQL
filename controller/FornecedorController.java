package controller;

import dao.FornecedorDao;
import model.FornecedorModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FornecedorController implements GenericController<FornecedorModel> {

    FornecedorDao fornecedorDao;

    public FornecedorController(FornecedorDao fornecedorDao) {
        this.fornecedorDao = new FornecedorDao();
    }

    @Override
    public void incluir(FornecedorModel obj) throws Exception {
        fornecedorDao.incluir(obj);
    }

    @Override
    public void alterar(FornecedorModel obj) throws Exception {
        fornecedorDao.alterar(obj);
    }

    @Override
    public ArrayList<FornecedorModel> consultar(String filtro) {
        return fornecedorDao.consultar(filtro);
    }

    @Override
    public void excluir(FornecedorModel obj) throws Exception {
        fornecedorDao.excluir(obj);
    }

    @Override
    public void gravar(FornecedorModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioFornecedor.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("Fornecedor - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
