package com.nicolaslopez82.market.persistence.mapper;

import com.nicolaslopez82.market.domain.PurchaseItem;
import com.nicolaslopez82.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",  uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "totalPrice"),
            @Mapping(source = "estado", target = "purchased")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);
    //List<PurchaseItem> toPurchaseItems(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    ComprasProducto toComprasProduct(PurchaseItem purchaseItem);
}
