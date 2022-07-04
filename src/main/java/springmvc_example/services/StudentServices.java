package springmvc_example.services;

import java.util.List;

import springmvc_example.model.Student;

public interface StudentServices {
	public List<Student> listAllStudents();
	 
	 public Student findStudentById(int id);
	 
	 public void deleteStudent(int id);
	 public void addStudent(Student stud);
	 public void updateStudent(Student stud);
}
