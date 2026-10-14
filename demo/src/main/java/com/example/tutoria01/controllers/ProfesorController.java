package com.example.tutoria01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.services.ProfesorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/profesor") 
public class ProfesorController {
    
    @Autowired 
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.creaProfesor(profesor));
    }
    


}
