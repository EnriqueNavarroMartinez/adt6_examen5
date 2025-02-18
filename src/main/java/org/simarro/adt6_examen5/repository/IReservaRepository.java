package org.simarro.adt6_examen5.repository;

import jakarta.transaction.Transactional;
import org.simarro.adt6_examen5.model.Cliente;
import org.simarro.adt6_examen5.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    //Metodos para eliminar
    @Modifying
    @Transactional
    @Query("delete FROM Reserva r WHERE LOWER(r.cliente.nombre) LIKE %:nombre%")
    void eliminarPorNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query("delete FROM Reserva r WHERE LOWER(r.cliente.email) LIKE %:email%")
    void eliminarPorEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("delete FROM Reserva r WHERE r.cliente.id = :id")
    void eliminarPorId(@Param("id") Integer id);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodos para  sumar
    @Query("select sum (r.precioTotal) FROM Reserva r WHERE LOWER(r.cliente.nombre) LIKE %:nombre%")
    Integer sumarPorNombre(@Param("nombre") String nombre);

    @Query("select sum (r.precioTotal) FROM Reserva r WHERE LOWER(r.cliente.email) LIKE %:email%")
    Integer sumarPorEmail(@Param("email") String email);

    @Query("select sum (r.precioTotal) FROM Reserva r WHERE (r.cliente.id) = :id")
    Integer sumarPorId(@Param("id") Integer id);

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodos buscar fecha

    @Query("select r FROM Reserva r WHERE LOWER(r.cliente.nombre) LIKE %:nombre% and (r.fechaEntrada >= :fechaBuscada)")
    List<Reserva> buscarPorNombreYFecha(@Param("nombre") String nombre, @Param("fechaBuscada") LocalDate fechaBuscada);

    @Query("select r FROM Reserva r WHERE (r.fechaEntrada >= :fechaBuscar) and (r.confirmada = true)")
    List<Reserva> buscarPorFechaYConfirmada(@Param("fechaBuscar") LocalDate fechaBuscar);

    @Query("select r FROM Reserva r WHERE (r.confirmada = :confirmada) and (r.cliente.id = :id)")
    List<Reserva> buscarPorConfirmadaYIdCliente(@Param("confirmada") Boolean confirmada, @Param("id") Integer id);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodos para contar

    @Query("select count(r) FROM Reserva r WHERE (r.confirmada = true) ")
    int contarReservadas();

    @Query("select count(r) FROM Reserva r WHERE (r.confirmada = false) ")
    int contarNoReservadas();


}
