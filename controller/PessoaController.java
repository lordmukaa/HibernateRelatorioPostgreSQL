package controller;

import dao.PessoaDao;
import model.PessoaModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaController implements GenericController<PessoaModel> {

    PessoaDao pessoaDao;

    public PessoaController(PessoaDao pessoaDao) {
        this.pessoaDao = new PessoaDao();
    }

    @Override
    public void incluir(PessoaModel obj) throws Exception {
        pessoaDao.incluir(obj);
    }

    @Override
    public void alterar(PessoaModel obj) throws Exception {
        pessoaDao.alterar(obj);
    }

    @Override
    public ArrayList<PessoaModel> consultar(String filtro) {
        return pessoaDao.consultar(filtro);
    }

    @Override
    public void excluir(PessoaModel obj) throws Exception {
        pessoaDao.excluir(obj);
    }

    @Override
    public void gravar(PessoaModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioPessoa.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("Pessoa - Bean Collection Data Source", inputStream, parametros, ds);
        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
