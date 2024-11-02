package dao;

import model.ClienteModel;
import model.PessoaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class ClienteDao implements GenericDao<ClienteModel> {

    @Override
    public void incluir(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        PessoaModel pessoa = objModel.getPES_CODIGO();
        session.save(pessoa);
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        PessoaModel pessoa = objModel.getPES_CODIGO();
        session.update(pessoa);
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<ClienteModel> consultar(String filtro) {
        String sql = "from " + ClienteModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<ClienteModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ClienteModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (ClienteModel) session.load(ClienteModel.class, id);
    }
}
