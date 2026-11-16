package com.example.tutoria01.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.services.ProfesorService;


@RestController
@RequestMapping("/profesor") 
public class ProfesorController {
    
    @Autowired 
    private ProfesorService profesorService;

   @PostMapping
public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {

    Profesor nuevo = profesorService.creaProfesor(profesor);

    if (nuevo != null) {
        return ResponseEntity.status(201).body(nuevo);
    }

    return ResponseEntity.status(409).build();
}

    @GetMapping
    public ResponseEntity<ArrayList<Profesor>> getAll(){
        return ResponseEntity.ok(profesorService.obtenerProfesores());
    }

   @PutMapping
public ResponseEntity<?> actualizarProfesor(@RequestBody Profesor profesor) {
    Profesor actualizado = profesorService.actualizarProfesor(profesor);
    
    if (actualizado == null) {
        return ResponseEntity.badRequest()
                .body("No se pudo actualizar: el ID no existe o el DNI/correo ya pertenece a otro profesor.");
    }
    
    return ResponseEntity.ok(actualizado);
}
    
    @DeleteMapping
public ResponseEntity<Void> deleteProfesor(@RequestBody Profesor profesor) {
    // Validamos que no envíen el JSON vacío o sin id
    if (profesor.getId() <= 0) {
        return ResponseEntity.badRequest().build();
    }

    if (profesorService.deleteProfesor(profesor.getId())) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}


}
