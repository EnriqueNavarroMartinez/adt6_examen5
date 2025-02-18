package org.simarro.adt6_examen5.service;

import org.simarro.adt6_examen5.model.Cliente;
import org.simarro.adt6_examen5.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository repo;

    @Override
    public Optional<Cliente> listarPorId(Integer id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? Optional.of(op.get()) : null;
    }
}
