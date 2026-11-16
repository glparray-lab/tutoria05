package com.example.tutoria01.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.repositories.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ProfesorService {
    
    @Autowired
    IProfesorRepository profesorRepository;

    public Profesor creaProfesor(Profesor profesor) {

    if (profesorRepository.existsByDni(profesor.getDni())) {
        return null;
    }
    if (profesorRepository.existsByCorreo(profesor.getCorreo())) {
        return null;
    }

    return profesorRepository.save(profesor);
}

    public ArrayList<Profesor> obtenerProfesores(){
        // SELECT * FROM profesor WHERE 1 = 1;
        return (ArrayList<Profesor>) profesorRepository.findAll();
    }

    public Profesor actualizarProfesor(Profesor profesor){
        // ternarios
        if (!existeProfesor(profesor.getId())) {
        return null;
    }

    if (profesorRepository.existsByDniAndIdNot(profesor.getDni(), profesor.getId())) {
        return null;
    }

    if (profesorRepository.existsByCorreoAndIdNot(profesor.getCorreo(), profesor.getId())) {
        return null;
    }
    return profesorRepository.save(profesor);
    }

    private boolean existeProfesor(int id){

        if(profesorRepository.findById(id) != null){
            return true;
        }else{
            return false;
        }

    }

    // metodo eliminar
    public boolean deleteProfesor(Integer id) { 
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
