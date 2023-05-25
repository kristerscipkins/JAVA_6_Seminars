package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Ids;

import lv.venta.models.Student;
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
	
	
	
	@GetMapping("/info/showAllGrades/students/{id}")//localhost:8080/info/showAllGrades/students/{id}
	public String getAllGradesByStudentID(@PathVariable (name="id") long id, Model model) {
		try {
			model.addAttribute("grades", filteringService.retrieveAllGradesByStudentId(id));
			return "all-grades-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";	
		}
	}
	
	@GetMapping("/info/showAllCourses/students")//localhost:8080/info/showAllCourses/students?id=1
	public String getShowAllCoursesByStudentId(@RequestParam("id") long id, Model model) {
		try {
			model.addAttribute("courses", filteringService.retrieveAllCoursesByStudentId(id));
			return "all-courses-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	
}