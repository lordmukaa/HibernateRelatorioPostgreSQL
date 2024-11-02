package controller;

import dao.CompraDao;
import model.CompraModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraController implements GenericController<CompraModel> {

    CompraDao compraDao;

    public CompraController(CompraDao compraDao) {
        this.compraDao = new CompraDao();
    }

    @Override
    public void incluir(CompraModel obj) throws Exception {
        compraDao.incluir(obj);
    }

    @Override
    public void alterar(CompraModel obj) throws Exception {
        compraDao.alterar(obj);
    }

    @Override
    public ArrayList<CompraModel> consultar(String filtro) {
        return compraDao.consultar(filtro);
    }

    @Override
    public void excluir(CompraModel obj) throws Exception {
        compraDao.excluir(obj);
    }

    @Override
    public void gravar(CompraModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioCompra.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("Compra - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
