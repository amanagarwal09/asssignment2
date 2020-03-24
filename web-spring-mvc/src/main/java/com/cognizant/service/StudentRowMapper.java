package com.cognizant.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.model.Student;

public class StudentRowMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student st = new Student();
		st.setId(Integer.parseInt(rs.getString(1)));
		st.setName(rs.getString(2));
		return st;
	}
}
