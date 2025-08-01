package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;


@Service
public class StudentServiceImplement implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	
	//	GET
	@Override
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}


	
	//	POST	
	@Override
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}



	@Override
	public Student getStudentById(Long id)
	{
		return studentRepository.findById(id).get();
	}



	@Override
	public Student updateStudent(Student student)
	{
		return studentRepository.save(student);
	}



	@Override
	public void deleteStudentById(Long id)
	{
		studentRepository.deleteById(id);
	}

}
