package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@Controller
public class PatientControllers {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}

	@GetMapping("/patients")
	public String patients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyw) {
		Page<Patient> pagePatients = patientRepository.findByNomContains(keyw, PageRequest.of(page, size));
		model.addAttribute("patients", pagePatients.getContent());
		model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", keyw);
		return "patients";
	}

	@GetMapping("/deletePatient")
	public String delete(Long id, String keyword, int page, int size) {
		patientRepository.deleteById(id);
		return "redirect:/patients?page=" + page + "&size=" + size + "&keyword=" + keyword;
	}

	@GetMapping("/deletePatient2")
	public String delete2(Long id, String keyword, int page, int size, Model model) {
		patientRepository.deleteById(id);
		return patients(model, page, size, keyword);
	}

	@GetMapping(path = "/patients/{id}")
	public Patient patients(@PathVariable Long id) {
		return patientRepository.findById(id).get();
	}

	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("model","new");
		return "formPatient";
	}

	@PostMapping("/savePatient")
																								
	public String savePatient(Model model,@Validated Patient patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formPatient";
		patientRepository.save(patient);
		model.addAttribute("patient",patient);
		return "confirmation";
	}

	@GetMapping(path = "/editPatient")
	public String editPatient(Model model, Long id) {
		Patient p = patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		model.addAttribute("model","edit");
		return "formPatient";
	}

}
