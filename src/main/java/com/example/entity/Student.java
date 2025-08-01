package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "First name is requried")
	@Size(min = 2, max = 30, message = "First name must be between 2 and 30")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	
	@NotBlank(message = "Last name is requried")
	@Size(min = 2, max = 30, message = "Last name must be between 2 and 30")
	@Column(name = "last_name")
	private String lastName;
	
	
	
	@NotBlank(message = "Email is requried")
	@Email(message = "Invalid email address")
	@Column(name = "email")
	private String email;


	
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

	public Student(Long id,
			@NotBlank(message = "First name is requried") @Size(min = 2, max = 30, message = "First name must be between 2 and 30") String firstName,
			@NotBlank(message = "Last name is requried") @Size(min = 2, max = 30, message = "Last name must be between 2 and 30") String lastName,
			@NotBlank(message = "Email is requried") @Email(message = "Invalid email address") String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
