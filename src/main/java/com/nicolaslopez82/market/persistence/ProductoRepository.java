package com.nicolaslopez82.market.persistence;

import com.nicolaslopez82.market.persistence.CRUD.ProductoCRUDRepository;
import com.nicolaslopez82.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository{

    private ProductoCRUDRepository crudRepository;

    public ProductoRepository(ProductoCRUDRepository crudRepository) {}

    public List<Producto> findAll(){
        return (List<Producto>) crudRepository.findAll();
    }

    public List<Producto> findByCategoria(Integer idCategoria){
        return crudRepository.findByIdCategoriaOrderByNombreASC(idCategoria);
    }

    public Optional<List<Producto>> getLowStock(Integer cantidad, Boolean idEstado){
        return crudRepository.getProductosLessThanAndEstadoOrderByCategoriaASC(cantidad, idEstado);
    }
}
