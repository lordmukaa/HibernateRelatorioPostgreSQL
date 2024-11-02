package dao;

import model.FornecedorModel;
import model.PessoaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class FornecedorDao implements GenericDao<FornecedorModel> {

    @Override
    public void incluir(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        PessoaModel pessoa = objModel.getPessoa();
        session.save(pessoa);
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        PessoaModel pessoa = objModel.getPessoa();
        session.update(pessoa);
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<FornecedorModel> consultar(String filtro) {
        String sql = "from " + FornecedorModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<FornecedorModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public FornecedorModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (FornecedorModel) session.load(FornecedorModel.class, id);
    }
}
