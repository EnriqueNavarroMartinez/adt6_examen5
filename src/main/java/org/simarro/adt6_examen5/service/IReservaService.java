package org.simarro.adt6_examen5.service;

import jakarta.transaction.Transactional;
import org.simarro.adt6_examen5.model.Reserva;
import org.simarro.adt6_examen5.model.ReservaResponseDTO;
import org.simarro.adt6_examen5.model.ResumenDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {

    //Metodos de eliminar
    @Transactional
    void eliminarPorNombre( String nombre);
    @Transactional
    void eliminarPorEmail( String email);
    @Transactional
    void eliminarPorId( Integer id);


    //Metodos para sumar
    Integer sumarPorNombre(String nombre);
    Integer sumarPorEmail( String email);
    Integer sumarPorId( Integer id);



    //Metodos buscar

    List<ReservaResponseDTO> buscarPorNombreYFecha(String nombre, LocalDate fechaBuscada);
    List<ReservaResponseDTO> buscarPorFechaYConfirmada(LocalDate fechaBuscar);
    List<ReservaResponseDTO> buscarPorConfirmadaYIdCliente(Boolean confirmada, Integer id);

    //Metodos resumen

    ResumenDTO contarEstadosNormal();

    ResumenDTO contarEstadosCount();



}
