package org.example;

import org.example.entidades.*;
import org.example.entidades.enums.*;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.entidades.enums.Estado.*;
import static org.example.entidades.enums.TipoEnvio.*;
import static org.example.entidades.enums.TipoEnvio.DELIVERY;
import static org.example.entidades.enums.TipoPromocion.*;
import static org.example.entidades.enums.FormaPago.*;
import static org.example.entidades.enums.Rol.*;

public class Main {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();


        try {
            // Iniciar una transacción
            em.getTransaction().begin();

            // Crear instancias de entidades y persistirlas
            UnidadMedida unidadMedida = new UnidadMedida("Kilogramo");
            em.persist(unidadMedida);

            Imagen ima1 = new Imagen("imagen harina");
            em.persist(ima1);

            Imagen ima2 = new Imagen("imagen pastel");
            em.persist(ima2);

            // Crear instancia de ArticuloInsumo y persistirla
            ArticuloInsumo articuloInsumo = new ArticuloInsumo(
                    "Harina",
                    10.5,
                    ima1,
                    unidadMedida,
                    5.5,
                    100,
                    500,
                    true
            );
            em.persist(articuloInsumo);

            // Crear instancia de ArticuloManufacturado y persistirla
            ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado(
                    "Pastel",
                    15.99,
                    ima2,
                    unidadMedida,
                    "Pastel de chocolate",
                    60,
                    "Mezclar ingredientes, hornear durante 30 minutos y decorar con crema de chocolate"
            );
            em.persist(articuloManufacturado);

            // Ejemplo con ArticuloManufacturadoDetalle
            ArticuloManufacturadoDetalle detalle = new ArticuloManufacturadoDetalle(
                    2,
                    articuloManufacturado,
                    articuloInsumo
            );
            em.persist(detalle);

            //////////////////////////////////
            Pais pais = new Pais("argentina");
            em.persist(pais);

            Provincia provincia = new Provincia("Mendoza", pais);
            em.persist(provincia);

            Localidad loca = new Localidad("Guaymallen", provincia);
            em.persist(loca);

            // 2 domicilios
            Domicilio domi1 = new Domicilio("San Martin",12434, 2332, loca);
            em.persist(domi1);

            Domicilio domi2 = new Domicilio("San Juan",12331, 3443, loca);
            em.persist(domi2);

            /////////////////////////

            Categoria subCate = new Categoria("sub categoria");
            em.persist(subCate);

            Categoria cate1 = new Categoria("categoria Torta", subCate);
            em.persist(cate1);

            Categoria cate2 = new Categoria("categoria Harina", subCate);
            em.persist(cate2);


            Empresa empresa = new Empresa(
                    "McDonald's",
                    "McDonald's Corporation",
                    123456789
            );
            em.persist(empresa);

            Sucursal sucursal = new Sucursal(
                    "McDonald's Mendoza",
                    LocalTime.of(8, 0),
                    LocalTime.of(22, 0),
                    false,
                    domi1,
                    empresa,
                    cate1
            );
            em.persist(sucursal);

            Factura factura = new Factura(
                    LocalDate.of(2024,6,8),
                    123456,
                    789012,
                    "MP1234567890",
                    "Credit Card",
                    EFECTIVO,
                    150.0
            );
            em.persist(factura);

            /// Personas empleado y cliente

            Imagen imagenEmpleado = new Imagen("imagen empleado");
            em.persist(imagenEmpleado);

            Imagen imagenCliente = new Imagen("imagen Cliente");
            em.persist(imagenCliente);

            Usuario usuarioEmpleado = new Usuario("passEmpleado", "userEmpleado");
            em.persist(usuarioEmpleado);

            Usuario usuarioCliente = new Usuario("passCliente", "userCliente");
            em.persist(usuarioCliente);

            Empleado empleado = new Empleado(
                    "Matias",
                    "Rodriguez",
                    "987654321",
                    "matias@gmail.com",
                    LocalDate.of(2003, 9, 25),
                    ADMINISTRADOR,
                    imagenEmpleado,
                    usuarioEmpleado,
                    sucursal
            );
            em.persist(empleado);

            Cliente cliente = new Cliente(
                    "Juan",
                    "Perez",
                    "123456789",
                    "juan@gmail.com",
                    LocalDate.of(1990, 5, 15),
                    CLIENTE,
                    imagenCliente,
                    usuarioCliente,
                    domi1
            );
            em.persist(cliente);

            Pedido ped1 = new Pedido(
                    LocalTime.of(12, 0),
                    50.0,
                    10.0,
                    PENDIENTE,
                    DELIVERY,
                    MERCADOPAGO,
                    LocalDate.of(2024, 6, 8),
                    empleado,
                    cliente,
                    domi1,
                    factura,
                    sucursal
            );
            em.persist(ped1);

            DetallePedido detallePedido = new DetallePedido(
                    1,
                    150.0,
                    ped1,
                    articuloInsumo
            );
            em.persist(detallePedido);

            /// promocion
            Imagen imagenPromocion = new Imagen("promo_verano");
            em.persist(imagenPromocion);

            Promocion promocion = new Promocion(
                    "Promocion de verano",
                    LocalDate.of(2024, 6, 1),
                    LocalDate.of(2024, 8, 31),
                    LocalTime.of(8, 0),
                    LocalTime.of(20, 0),
                    "Descuento del 20% en todos los productos de temporada.",
                    0.8,
                    HAPPYHOUR,
                    imagenPromocion
            );
            em.persist(promocion);

            PromocionDetalle detallePromocion = new PromocionDetalle(
                    1,
                    promocion,
                    articuloManufacturado
            );
            em.persist(detallePromocion);

            // Confirmar la transacción

            em.flush();

            em.getTransaction().commit();

        } catch (Exception e) {
            // Si hay un error, hacer rollback de la transacción
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase ");
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}
