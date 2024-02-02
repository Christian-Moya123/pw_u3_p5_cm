package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;



//SERVICIO -> Controller: Clase controller
@RestController
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFull {

	@Autowired
  private IEstudianteService estudianteService;

	//capaciadades
  //Get
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable(name = "id") Integer id) {
	    return this.estudianteService.buscar(id);
	}

  //http://localhost:8080/API/v1.0/Matricula/estudiante/buscar

  @PostMapping
  public void guardar(@RequestBody Estudiante estudiante){
      this.estudianteService.guardar(estudiante);
  }
  //http://localhost:8080/API/v1.0/Matricula/estudiante/guardar
  
  @PutMapping(path = "/{id}")
  public void actualizar(@RequestBody Estudiante estudiante, @PathVariable(name = "id") Integer id) {
	estudiante.setId(id);
	  this.estudianteService.actualizar(estudiante);
  }
  
  @PatchMapping(path = "/{id}")
  public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable(name = "id") Integer id) {
	  this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
  }
  
  //PATHVARIABLE
  @DeleteMapping(path = "/{id}")
  public void borrar(@PathVariable(name = "id") Integer id) {
	  this.estudianteService.borrarr(id);
  }
  
  
  //REQUESTPARAM
  //consultarTodos?genero=F
  //consultarTodos?genero=F&edad=100
  @GetMapping
  public List<Estudiante> consultarTodos(@RequestParam(required = false, defaultValue = "M", name = "genero") String genero) {
      return this.estudianteService.consultarTodos(genero);
  }
}
