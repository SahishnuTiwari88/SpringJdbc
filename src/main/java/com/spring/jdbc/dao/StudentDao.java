package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
//@Component
public interface StudentDao {
	public int insert(Student student);// we need student object to perform operation
	public int change(Student student);
	//public int remove(Student student);// we can do this just by passing student id
	public int remove(int studentId);
	public Student getStudent(int studentId);//it will return single object/ single row, return data in form of object
	
	public List<Student>getAllStudent(); //no parameter pass b/c we have to retrieve all information

}
//Dao is also known as repository

//Spring jdbc provide class JdbcTemplate which has all the important methods to perform operation with database
//once we create object of JdbcTemplate we can perform all database related operation
//Dao has all the methods with the help of which we can perform database operation


//select operation

//if we want single row/data we use queryForObject(String sql,RowMapper<T>rowMapper,Object args),jdbctemplate has this method
//where sql is select query,args is the parameter

//if we want more than one row than we use List<T>query(String sql,RowMapper<T>rowMapper), where rowmapper--> convert result set 
//to object