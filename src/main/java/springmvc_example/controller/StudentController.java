package springmvc_example.controller;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.Student;
import springmvc_example.services.StudentServices;


	@Controller
	@RequestMapping(value="/student")
	public class StudentController {
		
		@Autowired
		StudentServices studentservices;
		
		@RequestMapping(value="/list",method=RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView model=new ModelAndView("student/list");
			List<Student> list=studentservices.listAllStudents();
			model.addObject("listStudent",list);
			return model;
			
		}
		
		@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
		public ModelAndView update(@PathVariable("id")int id) {
			ModelAndView model=new ModelAndView("student/form");
			Student student=studentservices.findStudentById(id);
			model.addObject("studentForm",student);
			return model;
			
		}
		@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
		 public ModelAndView delete(@PathVariable("id") int id){
		  studentservices.deleteStudent(id);
		  
		  return new ModelAndView("redirect:/student/list");
		 }
		 
		 @RequestMapping(value="/add", method=RequestMethod.GET)
		 public ModelAndView add(){
		  ModelAndView model = new ModelAndView("student/form");
		  Student student = new Student();
		  model.addObject("studentForm",student);
		  
		  return model;
		 }
		 
		 @RequestMapping(value="/save", method=RequestMethod.POST)
		 public ModelAndView save(@ModelAttribute("studentForm") Student student){
			 if(student!= null && student.getId() != null){
				   studentservices.updateStudent(student);
				  } else {
				   studentservices.addStudent(student);
				  }
				  
		  
		  return new ModelAndView("redirect:/student/list");
		 }
		}

