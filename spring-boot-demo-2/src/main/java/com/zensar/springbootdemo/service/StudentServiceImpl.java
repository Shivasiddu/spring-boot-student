package com.zensar.springbootdemo.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	public StudentServiceImpl() {
	}

	@Override
	public StudentDto getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).get();
		// StudentDto dto=mapToDto(student);
		return modelMapper.map(student, StudentDto.class);
		// return dto;

	}

	@Override
	public List<StudentDto> getStudents(int pageNumber, int pageSize) {
		// List<Student>listOfStudents=studentRepository.findAll();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		// for(Student student:listOfStudents) {
		// listOfStudentDto.add(mapToDto(student));
		// listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		// }

		Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Student> content = findAll.getContent();
		for (Student student : content) {
			// listOfStudentDto.add(mapToDto(student));
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student insertedStudent = studentRepository.save(student);
		// StudentDto mapToDto= mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
		// return mapToDto;

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student updateStudent = studentRepository.save(student);
		// studentRepository.save(student);
		return modelMapper.map(updateStudent, StudentDto.class);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<StudentDto> getByStudentName(String studentName) {
		List<StudentDto> studentDto = new ArrayList();
		List<Student> students = studentRepository.test(studentName);
		for (Student student : students)
			studentDto.add(modelMapper.map(student, StudentDto.class));
		return studentDto;
	}

	/*
	 * @Override public List<Student> findByStudentNameAndStudentAge(String
	 * studentName, int age) { return
	 * studentRepository.findByStudentNameAndStudentAge(studentName, age); }
	 */

	/*
	 * @Override public List<Student> findByStudentNameOrStudentAge(String
	 * studentName, int age) { return
	 * studentRepository.findByStudentNameOrStudentAge(studentName, age); }
	 */

	@Override
	public List<StudentDto> findByStudentNameAndStudentAge(String studentName, int age) {
		List<StudentDto> studentDtos = new ArrayList();
		List<Student> students = studentRepository.test1(studentName, age);
		for (Student student : students)
			studentDtos.add(modelMapper.map(student, StudentDto.class));
		return studentDtos;
	}

	/*
	 * public StudentDto mapToDto(Student student) { StudentDto dto=new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentName(student.getStudentName());
	 * dto.setStudentAge(student.getStudentAge()); return dto;
	 * 
	 * }
	 * 
	 * 
	 * public Student mapToEntity(StudentDto studentDto) { Student student=new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge()); return student; }
	 */

}
