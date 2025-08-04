package modelo.dao;

import java.util.List;

public interface GenericDAO<T> {

    void guardar(T entidad);

    T buscarPorId(String id);

    List<T> listarTodos();

    List<T> listarNoProcesados();
}
