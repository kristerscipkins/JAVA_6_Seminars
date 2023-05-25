package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.services.IFilteringService;

@Controller
public class FilterController {

	@Autowired
	private IFilteringService filteringService;
	
	@GetMapping("/info/showAllStudents")//localhost:8080/info/showAllStudents
	public String getAllStudentsFunc(Model model) {
		model.addAttribute("students", filteringService.retrieveAllStudents());
		return "all-students-page";//will show all-students-page.html
	}
	
	@GetMapping("/info/showAllProfesors")//localhost:8080/info/showAllProfesors
	public String getAllProffesorsFunc(Model model) {
		model.addAttribute("profesors", filteringService.retrieveAllProfessors());
		return "all-profesors-page";//will show all-students-page.html
	}
	
	@GetMapping("/info/showAllGrades")//localhost:8080/info/showAllGrades
	public String getAllGradesFunc(Model model) {
		model.addAttribute("grades", filteringService.retrieveAllGrades());
		return "all-grades-page";//will show all-students-page.html
	}
	
	@GetMapping("/info/showAllCourses")//localhost:8080/info/showAllCourses
	public String getAllCoursesFunc(Model model) {
		model.addAttribute("courses", filteringService.retrieveAllCourses());
		return "all-courses-page";//will show all-students-page.html
	}
}