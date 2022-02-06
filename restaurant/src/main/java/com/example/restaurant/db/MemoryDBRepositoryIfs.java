package com.example.restaurant.db;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemoryDBRepositoryIfs <T> {

    Optional<T> findById(int index);
    T save(T entity);
    void deleteById(int index);
    List<T> findAll();
}
