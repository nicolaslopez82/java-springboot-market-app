package com.nicolaslopez82.market.persistence.CRUD;

import com.nicolaslopez82.market.domain.Purchase;
import com.nicolaslopez82.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCRUDRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
