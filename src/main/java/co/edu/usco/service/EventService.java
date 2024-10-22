package co.edu.usco.service;

import java.util.List;

public interface EventService<T, ID> {
    List<T> getAll();
    T getById(ID id);
    void create(T entity);
    void update(ID id, T entity);
    void delete(ID id);;
}
