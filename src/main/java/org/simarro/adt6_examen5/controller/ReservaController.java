package org.simarro.adt6_examen5.controller;

import org.simarro.adt6_examen5.model.Cliente;
import org.simarro.adt6_examen5.model.Reserva;
import org.simarro.adt6_examen5.model.ReservaResponseDTO;
import org.simarro.adt6_examen5.model.ResumenDTO;
import org.simarro.adt6_examen5.repository.IClienteRepository;
import org.simarro.adt6_examen5.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService service;

    @Autowired
    private IClienteRepository repository;


    @DeleteMapping("/eliminarPorNombre")
    public ResponseEntity<Void> eliminarPorNombre(@RequestParam("nombre") String nombre){

        Cliente cliente = repository.listarPorNombre(nombre);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarPorNombre(nombre);
// Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/eliminarPorEmail/{email}")
    public ResponseEntity<Void> eliminarPorEmail(@PathVariable("email") String email){

        Cliente cliente = repository.listarPorEmail(email);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarPorEmail(email);
// Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id){

        Optional<Cliente> cliente = repository.findById(id);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarPorId(id);
// Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    //Metodos sumar

    @GetMapping("/sumarPorNombre")
    public ResponseEntity<Integer> sumarPorNombre(@RequestParam("nombre") String nombre){

        Cliente cliente = repository.listarPorNombre(nombre);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        int total = service.sumarPorNombre(nombre);

// Código 200 OK para select
        return new ResponseEntity<>(total, HttpStatus.OK);
    }



    @GetMapping("/sumarPorEmail/{email}")
    public ResponseEntity<Integer> sumarPorEmail(@PathVariable("email") String email){

        Cliente cliente = repository.listarPorEmail(email);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        int total = service.sumarPorEmail(email);

// Código 200 OK para select
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/sumarPorId/{id}")
    public ResponseEntity<Integer> sumarPorId(@PathVariable("id") Integer id){

        Optional<Cliente> cliente = repository.findById(id);

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        int total = service.sumarPorId(id);

// Código 200 OK para select
        return new ResponseEntity<>(total, HttpStatus.OK);
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/buscarPorNombreYFecha")
    public ResponseEntity<List<ReservaResponseDTO>> buscarPorNombreYFecha(@RequestParam("nombre") String nombre, @RequestParam("fechaBuscada") LocalDate fechaBuscada){
        List<ReservaResponseDTO> lista = service.buscarPorNombreYFecha(nombre,fechaBuscada);
// Código 200 OK para select
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscarPorFechaYConfirmada/{fechaBuscar}")
    public ResponseEntity<List<ReservaResponseDTO>> buscarPorFechaYConfirmada(@PathVariable(value = "fechaBuscar") LocalDate fechaBuscar){
        List<ReservaResponseDTO> lista = service.buscarPorFechaYConfirmada(fechaBuscar);
// Código 200 OK para select
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscarPorConfirmadaYIdCliente")
    public ResponseEntity<List<ReservaResponseDTO>> buscarPorConfirmadaYIdCliente(@RequestParam("confirmada") boolean confirmada, @RequestParam("id") Integer id){
        List<ReservaResponseDTO> lista = service.buscarPorConfirmadaYIdCliente(confirmada,id);
// Código 200 OK para select
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/resumenDTOnormal")
    public ResponseEntity<ResumenDTO> contarEstadosNormal(){

        ResumenDTO resumenDTO = service.contarEstadosNormal();
        // Código 200 OK para select
        return new ResponseEntity<>(resumenDTO, HttpStatus.OK);
    }

    @GetMapping("/resumenDTOcount")
    public ResponseEntity<ResumenDTO> contarEstadosCount(){

        ResumenDTO resumenDTO = service.contarEstadosNormal();
        // Código 200 OK para select
        return new ResponseEntity<>(resumenDTO, HttpStatus.OK);
    }

}
