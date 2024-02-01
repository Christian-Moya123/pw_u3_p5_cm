package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
    
    @Id
    @GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
    @Column(name = "prof_id")
    private Integer id;
    
    @Column(name = "prof_nombre")
    private String nombre;
    
    @Column(name = "prof_apellido")
    private String apellido;
    
    @Column(name = "prof_genero")
    private String genero;
    
    @Column(name = "prof_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;
    
 
    @Column(name = "prof_experiencia_laboral")
    private int experienciaLaboral;
    
    @Column(name = "prof_correo_electronico")
    private String correoElectronico;
    
    // getters y setters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(int experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

    
    
}