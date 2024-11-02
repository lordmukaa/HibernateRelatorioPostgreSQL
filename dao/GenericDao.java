package dao;

import java.util.ArrayList;

public interface GenericDao<T> {
    public void incluir(T objModel) throws Exception;
    public void alterar(T objModel) throws Exception;
    public ArrayList<T> consultar(String filtro);
    public void excluir(T objModel) throws Exception;
    public T get(long id);    
}
