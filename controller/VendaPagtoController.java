package controller;

import dao.VendaPagtoDao;
import model.VendaPagtoModel;

import java.util.ArrayList;

public class VendaPagtoController implements GenericController<VendaPagtoModel> {

    VendaPagtoDao vendaPagtoDao;

    public VendaPagtoController(VendaPagtoDao vendaPagtoDao) {
        this.vendaPagtoDao = vendaPagtoDao;
    }

    @Override
    public void incluir(VendaPagtoModel obj) throws Exception {
        vendaPagtoDao.incluir(obj);
    }

    @Override
    public void alterar(VendaPagtoModel obj) throws Exception {
        vendaPagtoDao.alterar(obj);
    }

    @Override
    public ArrayList<VendaPagtoModel> consultar(String filtro) {
        return vendaPagtoDao.consultar(filtro);
    }

    @Override
    public void excluir(VendaPagtoModel obj) throws Exception {
        vendaPagtoDao.excluir(obj);
    }

    @Override
    public void gravar(VendaPagtoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        return null;
    }
}
