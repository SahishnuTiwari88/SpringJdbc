package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student>{ //it will ask which type of object u want to works on (student) 
	//here it is student object as we have to give our own implementation

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {//we have to give implementation of mapRow method
		// TODO Auto-generated method stub
		//we fetch data from resultset(rs) and put it in student object and return it.
		Student student = new Student();
		student.setId(rs.getInt(1)); //return first column from database i.e. id, return data using rs and place in student
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		
		return student;
	}

}
