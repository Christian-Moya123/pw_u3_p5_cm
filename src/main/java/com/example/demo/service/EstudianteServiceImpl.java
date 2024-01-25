package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepository estudainteRepo;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudainteRepo.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudainteRepo.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudainteRepo.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudainteRepo.seleccionar(id);
	}

	@Override
	public void borrarr(Integer id) {
		// TODO Auto-generated method stub
		this.estudainteRepo.eliminar(id);
	}

}
