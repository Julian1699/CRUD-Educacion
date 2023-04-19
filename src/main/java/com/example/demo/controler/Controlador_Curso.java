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

import com.example.demo.interfaceService.ICursoService;

import com.example.demo.modelo.Curso;

@Controller
@RequestMapping
public class Controlador_Curso {
	@Autowired
	private ICursoService service;
	
	@GetMapping("/listar_Curso")
	public String listar_Curso(Model model) {
		List<Curso>cursos=service.listar_Curso();
		model.addAttribute("cursos", cursos);
		return "index";
	}
	@GetMapping("/new_Curso")
	public String agregar_Curso(Model model) {
		model.addAttribute("curso", new Curso());
		return "form_Curso";
	}
	@PostMapping("/save_Curso")
	public String save_Curso(@Validated Curso p, Model model) {
		service.save(p);
		return "redirect:/listar_Curso";
	}
	@GetMapping("/editar_Curso/{id}")
	public String editar_Curso(@PathVariable int id, Model model) {
		Optional<Curso>curso=service.listar_CursoId(id);
		model.addAttribute("curso", curso);
		return "form_Curso";
	}
	@GetMapping("/eliminar_Curso/{id}")
	public String delete_Curso(Model model, @PathVariable int id){
		service.delete(id);
		return "redirect:/listar_Curso";
	}
}
