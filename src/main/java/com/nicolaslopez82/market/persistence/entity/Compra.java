package com.nicolaslopez82.market.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "fecha")
    private LocalDateTime fechaCompra;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;


}
