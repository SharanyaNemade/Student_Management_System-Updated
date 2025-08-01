package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

import jakarta.validation.Valid;



@Controller
public class StudentController
{
	
	@Autowired
	StudentService studentService;
	
	
	//	GET METHOD
	
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; 			// return base.html
    }
	
	
	
	
    
    
    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        model.addAttribute("student", new Student());
    	model.addAttribute("contentFragment", "create_student :: createStudentForm");
    	return "create_student";			// return base.html    =>    loads header + footer + form
    }

    
    
    
    
    
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
    	studentService.saveStudent(student);
    	return "redirect:/students";
    }
    
    
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model)
    {
    	model.addAttribute("student", studentService.getStudentById(id));
    	return "edit_student";
    }
    
    
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model)
    {
    	
    	if(bindingResult.hasErrors())
    	{
    		return "edit_student";
    	}
    	
    	
    	//	If the validation is passed this part will run
    	//	get student from database by id
    
    	Student existingStudent = studentService.getStudentById(id);
    	
    	existingStudent.setId(id);
    	existingStudent.setFirstName(student.getFirstName());
    	existingStudent.setLastName(student.getLastName());
    	existingStudent.setEmail(student.getEmail());
    	
    	
    	//	save updated student object
    	
    	
    	studentService.updateStudent(existingStudent);
    	return "redirect:/students";
    }
    
    
    
    //	Handler Methods to Delete Student Request
    
    
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
    	studentService.deleteStudentById(id);
    	return "redirect:/students";
    }
    

}
