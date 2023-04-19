package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Profesor;

public interface IProfesorService {
	public List<Profesor>listar_Profesor();
	public Optional<Profesor>listar_ProfesorId(int id);
	public int save(Profesor p);
	public void delete(int id);
}
