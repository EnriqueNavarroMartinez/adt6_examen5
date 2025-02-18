package org.simarro.adt6_examen5.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.simarro.adt6_examen5.model.Reserva;
import org.simarro.adt6_examen5.model.ReservaResponseDTO;
import org.simarro.adt6_examen5.model.ResumenDTO;
import org.simarro.adt6_examen5.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements IReservaService{


    @Autowired
    private IReservaRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    //MEtodos de eliminar
    @Override
    @Transactional
    public void eliminarPorNombre(String nombre) {
        repo.eliminarPorNombre(nombre);
    }

    @Override
    @Transactional
    public void eliminarPorEmail(String email) {
        repo.eliminarPorEmail(email);
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer id) {
        repo.eliminarPorId(id);
    }

    @Override
    public Integer sumarPorNombre(String nombre) {
        return repo.sumarPorNombre(nombre);
    }

    @Override
    public Integer sumarPorEmail(String email) {
        return repo.sumarPorEmail(email);
    }

    @Override
    public Integer sumarPorId(Integer id) {
        return repo.sumarPorId(id);
    }

    @Override
    public List<ReservaResponseDTO> buscarPorNombreYFecha(String nombre, LocalDate fechaBuscada) {
        return repo.buscarPorNombreYFecha(nombre,fechaBuscada).stream().map(reserva -> modelMapper.map(reserva, ReservaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReservaResponseDTO> buscarPorFechaYConfirmada(LocalDate fechaBuscar) {
        return repo.buscarPorFechaYConfirmada(fechaBuscar).stream().map(reserva -> modelMapper.map(reserva, ReservaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReservaResponseDTO> buscarPorConfirmadaYIdCliente(Boolean confirmada, Integer id) {
        return repo.buscarPorConfirmadaYIdCliente(confirmada,id).stream().map(reserva -> modelMapper.map(reserva, ReservaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResumenDTO contarEstadosNormal() {

        List<Reserva> reservas = repo.findAll();

        int confirmados = 0;
        int noconfirmados = 0;

        for(Reserva reserva : reservas){
            if(reserva.isConfirmada()){
                confirmados++;
            }else{
                noconfirmados++;
            }
        }

        return new ResumenDTO(confirmados,noconfirmados);
    }

    @Override
    public ResumenDTO contarEstadosCount() {

        int confirmadas = repo.contarReservadas();
        int noConfirmadas = repo.contarNoReservadas();

        return new ResumenDTO(confirmadas,noConfirmadas);
    }


}
