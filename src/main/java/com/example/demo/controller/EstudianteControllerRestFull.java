package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> buscar(@PathVariable(name = "id") Integer id) {
		
		//240> grupo satisfactorio
		//240 rescurso Estudiante encontrado satifactoriamente
		Estudiante estu = this.estudianteService.buscar(id);
		//Contrato de la API(`. documentacion, Swagger.io)
		
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

  //http://localhost:8080/API/v1.0/Matricula/estudiante/buscar

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void guardar(@RequestBody Estudiante estudiante){
      this.estudianteService.guardar(estudiante);
  }
  //http://localhost:8080/API/v1.0/Matricula/estudiante/guardar
  
  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void actualizar(@RequestBody Estudiante estudiante, @PathVariable(name = "id") Integer id) {
	estudiante.setId(id);
	  this.estudianteService.actualizar(estudiante);
  }
  
  @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable(name = "id") Integer id) {
	  this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
  }
  
  //PATHVARIABLE
  @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void borrar(@PathVariable(name = "id") Integer id) {
	  this.estudianteService.borrarr(id);
  }
  
  
  //REQUESTPARAM
  //consultarTodos?genero=F
  //consultarTodos?genero=F&edad=100
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Estudiante>>consultarTodos(@RequestParam(required = false, defaultValue = "M", name = "genero") String genero) {
      List<Estudiante> lista = this.estudianteService.consultarTodos(genero);
      
      HttpHeaders cabeceras = new HttpHeaders();
      cabeceras.add("mensaje_242", "lista consultada de manera satisfactoria");
      cabeceras.add("mensaje_info", "el sistema va a estar en mantenimiento el fin de semana");
      
      return new ResponseEntity<>(lista, cabeceras,242);
  }
}
