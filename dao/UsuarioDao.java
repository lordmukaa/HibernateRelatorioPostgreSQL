package dao;

import java.util.ArrayList;
import model.UsuarioModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDao implements GenericDao<UsuarioModel> {

    @Override
    public void incluir(UsuarioModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(UsuarioModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<UsuarioModel> consultar(String filtro) {
        String sql = "from " + UsuarioModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<UsuarioModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(UsuarioModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public UsuarioModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (UsuarioModel) session.load(UsuarioModel.class, id);
    }
}
