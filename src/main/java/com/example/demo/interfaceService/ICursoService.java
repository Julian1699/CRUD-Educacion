package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Curso;

public interface ICursoService {
	public List<Curso>listar_Curso();
	public Optional<Curso>listar_CursoId(int id);
	public int save(Curso p);
	public void delete(int id);
}
