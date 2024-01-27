package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;


//SERVICIO -> Controller: Clase controller
@RestController
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFull {

    private IEstudianteService estudianteService;
	
	//capaciadades
    //Get
    @GetMapping(path ="/buscar")
	public Estudiante buscar() {
        return this.estudianteService.buscar(1);		
	}

    //http://localhost:8080/API/v1.0/Matricula/estudiante/buscar

    @PostMapping(path ="/guardar")
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }
    //http://localhost:8080/API/v1.0/Matricula/estudiante/guardar
}
