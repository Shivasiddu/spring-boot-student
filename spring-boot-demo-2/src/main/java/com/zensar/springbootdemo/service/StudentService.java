package com.zensar.springbootdemo.service;

import java.util.List;

import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;

public interface StudentService {

	public StudentDto getStudent(int studentId);

	public List<StudentDto> getStudents(int pageNumber, int pageSize);

	public StudentDto insertStudent(StudentDto student);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);

	// List<Student>getByStudentName(String studentName);
	// List<Student>findByStudentNameAndStudentAge(String studentName,int age);
	// List<Student>findByStudentNameOrStudentAge(String studentName,int age);
	List<StudentDto> getByStudentName(String studentName);

	List<StudentDto> findByStudentNameAndStudentAge(String studentName, int age);
}