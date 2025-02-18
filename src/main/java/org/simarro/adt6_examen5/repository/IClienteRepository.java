package org.simarro.adt6_examen5.repository;

import org.simarro.adt6_examen5.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("FROM Cliente c WHERE LOWER(c.nombre) LIKE %:nombre%")
    Cliente listarPorNombre(@Param("nombre") String nombre);

    @Query("FROM Cliente c WHERE LOWER(c.email) LIKE %:email%")
    Cliente listarPorEmail(@Param("email") String email);

}
