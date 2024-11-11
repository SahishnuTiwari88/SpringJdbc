package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
//we need daoimpl for loose coupling
//@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	//@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String query = "insert into student(id,name,city)values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());//here update used to insert
		return r;
	}

	public int change(Student student) {
		// Updating data
		String query = "update student set name = ?, city = ? where id = ?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	public int remove(int studentId) {
		// delete record can also be done by below concept
		String query = "delete from student where id = ?";
		int r = this.jdbcTemplate.update(query,studentId);
	    return r;
		
		
	}

	public Student getStudent(int studentId) {
		// it will select single row of student data
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper =  new RowMapperImpl();// storing child class object to the parent i.e. RowMapper(parent), 
		//we can take parent variable(rowMapper) to store child object
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		// selecting multiple students or all data
		String query = "select * from student";
		
		 List <Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}


	

}
