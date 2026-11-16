package com.example.tutoria01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.tutoria01.models.Profesor;

@Repository
public interface IProfesorRepository extends CrudRepository<Profesor,Integer> {
        boolean existsByDni(String dni);
        boolean existsByCorreo(String correo);

        boolean existsByDniAndIdNot(String dni, Integer id);
    boolean existsByCorreoAndIdNot(String correo, Integer id);
}   
