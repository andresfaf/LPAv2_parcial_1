package org.lpav2.app.controller;

import javax.validation.Valid;

import org.lpav2.app.model.entity.Estudiante;
import org.lpav2.app.model.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/estudiante")
@SessionAttributes("estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/listado")
	public String estudiantesListar(Model model) {
		model.addAttribute("titulo", "listado de estudiantes");
		model.addAttribute("estudiantes", estudianteService.findAll());
		return "estudiante/listado_estudiantes";
	}
	
	@GetMapping("/formulario")
	public String estudiantesFormulario(Model model) {
		model.addAttribute("titulo", "Formulario de estudiantes");
		model.addAttribute("estudiante", new Estudiante());
		return "estudiante/formulario_estudiantes";
	}
	
	@PostMapping("/agregar")
	public String estudiantesAgregar(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de estudiantes");
			return "estudiante/formulario_estudiantes";
		}
		estudianteService.update(estudiante);
		status.setComplete();
		return "redirect:/estudiante/listado";
	}
	
	@GetMapping("/modificar/{id}")
	public String estudiantesModificar(@PathVariable(value = "id") Integer id, Model model) {
		Estudiante estudiante = null;
		if(id > 0) {
			estudiante = estudianteService.findById(id);
			if(estudiante == null) return "redirect:/estudiante/listado";
		}else return "redirect:/estudiante/listado";
		
		model.addAttribute("titulo", "Formulario de estudiantes");
		model.addAttribute("estudiante", estudiante);
		return "estudiante/formulario_estudiantes";
	}
	
	@GetMapping("/consultar/{id}")
	public String estudianteConsultar(@PathVariable(value = "id") Integer id, Model model) {
		Estudiante estudiante = estudianteService.findById(id);
		System.out.println("asf");
		if(estudiante == null) return "redirect:/estudiante/listado";
		
		model.addAttribute("titulo", "Consultando estudiante");
		model.addAttribute("estudiante", estudiante);
		return "estudiante/consultar_estudiante.html";
	}
	
	@GetMapping("/eliminar/{id}")
	public String estudianteEliminar(@PathVariable(value = "id") Integer id) {
		estudianteService.deleteById(id);
		return "redirect:/estudiante/listado";
	}

}
