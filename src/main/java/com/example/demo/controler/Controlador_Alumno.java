package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IAlumnoService;

import com.example.demo.modelo.Alumno;

@Controller
@RequestMapping
public class Controlador_Alumno {
	@Autowired
	private IAlumnoService service;
	
	@GetMapping("/listar_Alumno")
	public String listar_Alumno(Model model) {
		List<Alumno>alumnos=service.listar_Alumno();
		model.addAttribute("alumnos", alumnos);
		return "index";
	}
	@GetMapping("/new_Alumno")
	public String agregar_Alumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "form_Alumno";
	}
	@PostMapping("/save_Alumno")
	public String save_Alumno(@Validated Alumno p, Model model) {
		service.save(p);
		return "redirect:/listar_Alumno";
	}
	@GetMapping("/editar_Alumno/{id}")
	public String editar_Alumno(@PathVariable int id, Model model) {
		Optional<Alumno>alumno=service.listar_AlumnoId(id);
		model.addAttribute("alumno", alumno);
		return "form_Alumno";
	}
	@GetMapping("/eliminar_Alumno/{id}")
	public String delete_Alumno(Model model, @PathVariable int id){
		service.delete(id);
		return "redirect:/listar_Alumno";
	}
}
