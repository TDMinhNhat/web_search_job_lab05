package dev.skyherobrine.app.backend.resources;

import dev.skyherobrine.app.backend.models.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IManagement<T, P> {
    ResponseEntity<Response> insert(T t);
    ResponseEntity<Response> insertAll(List<T> list);
    ResponseEntity<Response> update(P p, T t);
    ResponseEntity<Response> delete(P p);
    ResponseEntity<Response> getById(P p);
    ResponseEntity<Response> getAll();
}
