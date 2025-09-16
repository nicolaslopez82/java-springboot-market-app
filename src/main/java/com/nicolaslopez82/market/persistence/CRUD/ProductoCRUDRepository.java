package com.nicolaslopez82.market.persistence.CRUD;

import com.nicolaslopez82.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Tres tipos de repositorios:
 *
 * CrudRepository: realizar el crue
 * PagingAndSortingRepository: incluye lo de Crud repository ademas de paginación y ordenamiento.
 * JPARepository: Ademas de tener CrudRepository y PagingAndSortingRepository nos permite tareas específicas como Flush.
 */
public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreASC(Integer idCategoria);

    Optional<List<Producto>> getProductosLessThanAndEstadoOrderByCategoriaASC(Integer cantidad, Boolean idEstado);
}
