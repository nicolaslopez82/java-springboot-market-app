package com.nicolaslopez82.market.persistence.mapper;

import com.nicolaslopez82.market.domain.Purchase;
import com.nicolaslopez82.market.persistence.entity.Compra;
import com.nicolaslopez82.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = PurchaseItemMapper.class)
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fechaCompra", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "purchaseItemList") // This mappins is used for the PurchaseItemMapper.class to convert these Items one to one.
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true) //As I don't have the Client object into the Purchase class (just I've got the String clientId), so I should ignore in the mapping from Purchase to Compra.
    Compra toCompra(Purchase purchase);

    // Always in the destiny class we should have all mappers. If not, we should ignore it/them.
}
