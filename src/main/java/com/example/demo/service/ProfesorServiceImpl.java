package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService{

	 @Autowired
	 private IProfesorRepository  profesorRepository;
	
	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorRepository.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorRepository.actualizar(profesor);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
        profesorRepository.actualizarParcial(apellido, nombre, id);

	}

	@Override
	public Profesor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return profesorRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
        profesorRepository.eliminar(id);

	}

	@Override
	public List<Profesor> consultarTodos(String genero) {
		// TODO Auto-generated method stub
		return profesorRepository.consultarTodos(genero);
		}

}
