package org.simarro.adt6_examen5.controller;

import org.simarro.adt6_examen5.model.Cliente;
import org.simarro.adt6_examen5.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> listarPorId(@PathVariable Integer id) {
        Optional<Cliente> cliente = service.listarPorId(id);
        if(cliente == null) {
// Código 204 NoData para select
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
// Código 200 OK para select
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }
}
