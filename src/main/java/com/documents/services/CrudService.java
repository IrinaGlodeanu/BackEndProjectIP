package com.documents.services;

import java.util.List;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
public interface CrudService<T> {
    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    void delete(Long id);
}
