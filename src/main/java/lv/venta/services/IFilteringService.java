package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Course;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;

public interface IFilteringService {
	ArrayList<Student> retrieveAllStudents();
	ArrayList<Grade> retrieveAllGrades();
	ArrayList<Course> retrieveAllCourses();
	ArrayList<Professor> retrieveAllProfessors();
	ArrayList<Grade> retrieveAllGradesByStudentId(long id);
	ArrayList<Course> retrieveAllCoursesByStudentId(long id);
	ArrayList<Course>retrieveAllCoursesByProffesorId(long id);
	float calculateAVGGradeInCourdeId(long id);
	
	
	
}