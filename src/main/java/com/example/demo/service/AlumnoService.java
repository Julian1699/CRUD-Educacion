package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IAlumnoService;
import com.example.demo.interfaces.IAlumno;
import com.example.demo.modelo.Alumno;

@Service
public class AlumnoService implements IAlumnoService{
	@Autowired
	private IAlumno data;
	@Override
	public List<Alumno> listar_Alumno() {
		return (List<Alumno>)data.findAll();
	}

	@Override
	public Optional<Alumno> listar_AlumnoId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Alumno p) {
		int res=0;
		Alumno Alumno=data.save(p);
		if(!Alumno.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
