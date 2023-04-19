package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IProfesorService;
import com.example.demo.interfaces.IProfesor;
import com.example.demo.modelo.Profesor;

@Service
public class ProfesorService implements IProfesorService{
	@Autowired
	private IProfesor data;
	@Override
	public List<Profesor> listar_Profesor() {
		return (List<Profesor>)data.findAll();
	}

	@Override
	public Optional<Profesor> listar_ProfesorId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Profesor p) {
		int res=0;
		Profesor Profesor=data.save(p);
		if(!Profesor.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
