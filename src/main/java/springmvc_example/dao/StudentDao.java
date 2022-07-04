package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Student;

public interface StudentDao {
	public List<Student> listAllStudents();
	 
	 public Student findStudentById(int id);
	 
	 public void deleteStudent(int id);
	 public void addStudent(Student stud);
	 public void updateStudent(Student stud);
}
