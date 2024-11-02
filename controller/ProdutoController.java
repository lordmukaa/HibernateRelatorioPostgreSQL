package controller;

import dao.ProdutoDao;
import model.ProdutoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoController implements GenericController<ProdutoModel> {

    ProdutoDao produtoDao;

    public ProdutoController(ProdutoDao produtoDao) {
        this.produtoDao = new ProdutoDao();
    }

    @Override
    public void incluir(ProdutoModel obj) throws Exception {
        produtoDao.incluir(obj);
    }

    @Override
    public void alterar(ProdutoModel obj) throws Exception {
        produtoDao.alterar(obj);
    }

    @Override
    public ArrayList<ProdutoModel> consultar(String filtro) {
        return produtoDao.consultar(filtro);
    }

    @Override
    public void excluir(ProdutoModel obj) throws Exception {
        produtoDao.excluir(obj);
    }

    @Override
    public void gravar(ProdutoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioProduto.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();

        List dados = consultar("");

        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Produto - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
