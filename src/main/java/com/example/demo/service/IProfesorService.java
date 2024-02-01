package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorService {
	
	void insertar(Profesor profesor);
    void actualizar(Profesor profesor);
    void actualizarParcial(String apellido, String nombre, Integer id);
    Profesor seleccionar(Integer id);
    void eliminar(Integer id);
    List<Profesor> consultarTodos(String genero);

}
