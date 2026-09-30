package com.example.tutoria01.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.repositories.IProfesorRepository;

@Service 
public class ProfesorService {
    
    @Autowired
    IProfesorRepository profesorRepository;

    public Profesor creaProfesor(Profesor profesor){
        // INSERT INTO profesor (...) VALUES();
        return profesorRepository.save(profesor);
    }

    public ArrayList<Profesor> obtenerProfesores(){
        // SELECT * FROM profesor WHERE 1 = 1;
        return (ArrayList<Profesor>) profesorRepository.findAll();
    }


}
