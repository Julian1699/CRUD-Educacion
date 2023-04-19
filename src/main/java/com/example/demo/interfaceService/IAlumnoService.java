package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Alumno;

public interface IAlumnoService {
	public List<Alumno>listar_Alumno();
	public Optional<Alumno>listar_AlumnoId(int id);
	public int save(Alumno p);
	public void delete(int id);
}
