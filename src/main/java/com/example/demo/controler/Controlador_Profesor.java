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

import com.example.demo.interfaceService.IProfesorService;

import com.example.demo.modelo.Profesor;

@Controller
@RequestMapping
public class Controlador_Profesor {
	@Autowired
	private IProfesorService service;
	
	@GetMapping("/listar_Profesor")
	public String listar_Profesor(Model model) {
		List<Profesor>profesors=service.listar_Profesor();
		model.addAttribute("profesors", profesors);
		return "index";
	}
	@GetMapping("/new_Profesor")
	public String agregar_Profesor(Model model) {
		model.addAttribute("profesor", new Profesor());
		return "form_Profesor";
	}
	@PostMapping("/save_Profesor")
	public String save_Profesor(@Validated Profesor p, Model model) {
		service.save(p);
		return "redirect:/listar_Profesor";
	}
	@GetMapping("/editar_Profesor/{id}")
	public String editar_Profesor(@PathVariable int id, Model model) {
		Optional<Profesor>profesor=service.listar_ProfesorId(id);
		model.addAttribute("profesor", profesor);
		return "form_Profesor";
	}
	@GetMapping("/eliminar_Profesor/{id}")
	public String delete_Profesor(Model model, @PathVariable int id){
		service.delete(id);
		return "redirect:/listar_Profesor";
	}
}
