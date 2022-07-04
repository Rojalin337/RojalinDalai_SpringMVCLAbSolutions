package springmvc_example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.StudentDao;
import springmvc_example.model.Student;
@Service
public class StudentServicesImpl  implements StudentServices{

	StudentDao studentdao;
	@Autowired
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	public List<Student> listAllStudents() {
		
		return studentdao.listAllStudents();
	}

	public Student findStudentById(int id) {
		
		return studentdao.findStudentById(id);
	}

	public void deleteStudent(int id) {
		studentdao.deleteStudent(id);
		
	}

	public void addStudent(Student stud) {
		studentdao.addStudent(stud);
		
	}

	public void updateStudent(Student stud) {
		studentdao.updateStudent(stud);
	}

}
