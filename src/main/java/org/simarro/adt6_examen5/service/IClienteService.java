package org.simarro.adt6_examen5.service;

import org.simarro.adt6_examen5.model.Cliente;

import java.util.Optional;

public interface IClienteService {

    Optional<Cliente> listarPorId(Integer id);
}
