package cl.bennu.common.security.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class CrudController<T> implements ICrud<T> {

    @Override
    public ResponseEntity<List<T>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<T> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<T> get(String name) {
        return null;
    }

    @Override
    public void save(T type) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<List<T>> find(T type) {
        return null;
    }
}
