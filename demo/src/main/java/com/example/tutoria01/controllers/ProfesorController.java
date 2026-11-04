package com.example.tutoria01.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.services.ProfesorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/profesor") 
public class ProfesorController {
    
    @Autowired 
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.creaProfesor(profesor));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Profesor>> getAll(){
        return ResponseEntity.ok(profesorService.obtenerProfesores());
    }

    @PutMapping 
    public ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.actualizarProfesor(profesor));
    }    


}
