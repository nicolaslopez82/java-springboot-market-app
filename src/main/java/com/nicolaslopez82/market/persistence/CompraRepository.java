package com.nicolaslopez82.market.persistence;

import com.nicolaslopez82.market.domain.Purchase;
import com.nicolaslopez82.market.domain.repository.PurchaseRepository;
import com.nicolaslopez82.market.persistence.CRUD.CompraCRUDRepository;
import com.nicolaslopez82.market.persistence.entity.Compra;
import com.nicolaslopez82.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This repository talks in terms of Domain (Purchase).
 */
@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    CompraCRUDRepository compraCRUDRepository;

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>)compraCRUDRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCRUDRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase); // I save the compra record in cascade with products. Compra knows which Productos have, and Products know to which Compra belong to.
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCRUDRepository.save(compra));
    }
}
