package controller;

import dao.VendaProdutoDao;
import model.VendaProdutoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendaProdutoController implements GenericController<VendaProdutoModel> {

    VendaProdutoDao vendaProdutoDao;

    public VendaProdutoController(VendaProdutoDao vendaProdutoDao) {
        this.vendaProdutoDao = new VendaProdutoDao();
    }

    @Override
    public void incluir(VendaProdutoModel obj) throws Exception {
        vendaProdutoDao.incluir(obj);
    }

    @Override
    public void alterar(VendaProdutoModel obj) throws Exception {
        vendaProdutoDao.alterar(obj);
    }

    @Override
    public ArrayList<VendaProdutoModel> consultar(String filtro) {
        return vendaProdutoDao.consultar(filtro);
    }

    @Override
    public void excluir(VendaProdutoModel obj) throws Exception {
        vendaProdutoDao.excluir(obj);
    }

    @Override
    public void gravar(VendaProdutoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioVendaProduto.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("VendaProduto - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
