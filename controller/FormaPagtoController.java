package controller;

import dao.FormaPagtoDao;
import model.FormaPagtoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormaPagtoController implements GenericController<FormaPagtoModel> {

    FormaPagtoDao formapagtodao;

    public FormaPagtoController(){
        formapagtodao = new FormaPagtoDao();
    }

    @Override
    public void incluir(FormaPagtoModel obj) throws Exception {
        formapagtodao.incluir(obj);
    }

    @Override
    public void alterar(FormaPagtoModel obj) throws Exception {
        formapagtodao.alterar(obj);
    }

    @Override
    public ArrayList<FormaPagtoModel> consultar(String filtro) {
        return formapagtodao.consultar(filtro);
    }

    @Override
    public void excluir(FormaPagtoModel obj) throws Exception {
        formapagtodao.excluir(obj);
    }

    @Override
    public void gravar(FormaPagtoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioUsuario.jasper");

        Map parametros = new HashMap();

        List dados = consultar("");

        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            ReportUtils.openReport("Formas de Pagamento - Bean Collection Data Source", inputStream, parametros, ds);
        }catch (Exception ex){
            retorno =  ex;
        }
        return retorno;
    }
}
