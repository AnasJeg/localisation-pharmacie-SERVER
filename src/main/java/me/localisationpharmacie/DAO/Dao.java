package me.localisationpharmacie.DAO;

import java.util.List;

public interface Dao<T> {
    T save(T c);
    T findById(int id);
    List<T> findAll();

    void delete(T c);
    void update(T c);
}
