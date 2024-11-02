package controller;

import dao.CompraProdutoDao;
import model.CompraProdutoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraProdutoController implements GenericController<CompraProdutoModel> {

    CompraProdutoDao compraProdutoDao;

    public CompraProdutoController(CompraProdutoDao compraProdutoDao) {
        this.compraProdutoDao = new CompraProdutoDao();
    }

    @Override
    public void incluir(CompraProdutoModel obj) throws Exception {
        compraProdutoDao.incluir(obj);
    }

    @Override
    public void alterar(CompraProdutoModel obj) throws Exception {
        compraProdutoDao.alterar(obj);
    }

    @Override
    public ArrayList<CompraProdutoModel> consultar(String filtro) {
        return compraProdutoDao.consultar(filtro);
    }

    @Override
    public void excluir(CompraProdutoModel obj) throws Exception {
        compraProdutoDao.excluir(obj);
    }

    @Override
    public void gravar(CompraProdutoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioCompraProduto.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("CompraProduto - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
