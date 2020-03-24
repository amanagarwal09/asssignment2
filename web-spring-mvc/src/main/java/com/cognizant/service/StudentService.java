package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
@Component("student")
public class StudentService {
	
	@Autowired
	private JdbcTemplate jdbc;
	
//	private List<Student> stList = new ArrayList<Student>(
//			Arrays.asList(new Student(1, "Avik"), new Student(2, "Sarkar"), new Student(3, "Piku")));

	public String insert(Student student) {
		String sqlInsert = "insert into student values(?,?)";
		int result = jdbc.update(sqlInsert, student.getId(), student.getName());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		for (Student st : stList) {
//			if (st.getId()==student.getId()) {
//				return "FAILED";
//			}
//		}
//		if (stList.add(student)) {
//			return "SUCCESS";
//		} else {
//			return "FAILED";
//		}
	}

	public String update(Student student) {
		String sqlUpdate = "update student set id = ?, name = ? where id = ?";
		int result = jdbc.update(sqlUpdate, student.getId(), student.getName(), student.getId());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		for (Student s1 : stList) {
//			if (s1.getId()==student.getId()) {
//				s1.setName(student.getName());
//				return "SUCCESS";
//			}
//		}
//		return "FAILED";
	}

	public String delete(Student student) {
		String sqlDelete = "delete from student where id = ?";
		int result = jdbc.update(sqlDelete, student.getId());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		for (Student s1 : stList) {
//			if (s1.getId()==student.getId()) {
//				stList.remove(s1);
//				return "SUCCESS";
//			}
//		}
//		return "FAILED";
	}

//	public String delete(Student student) {
//		int index = 0, flag = 0;
//		for (Student s1 : stList) {
//			if (s1.getId().equals(student.getId())) {
//				flag = 1;
//				index++;
//				break;
//			}
//		}
//		if(flag == 1) {
//			stList.remove(index);
//			return "SUCCESS";
//		}else
//			return "FAILED";
//	}
	
	public List<Student> getAll() {
		
		StudentRowMapper rowMapper = new StudentRowMapper();
		String sql = "select * from student";
		List<Student> result = jdbc.query(sql, rowMapper);
		return result;
		
//		System.out.println(stList);
//		return stList;
	}

}