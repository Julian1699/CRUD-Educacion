package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.ICursoService;
import com.example.demo.interfaces.ICurso;
import com.example.demo.modelo.Curso;

@Service
public class CursoService implements ICursoService{
	@Autowired
	private ICurso data;
	@Override
	public List<Curso> listar_Curso() {
		return (List<Curso>)data.findAll();
	}

	@Override
	public Optional<Curso> listar_CursoId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Curso p) {
		int res=0;
		Curso Curso=data.save(p);
		if(!Curso.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
