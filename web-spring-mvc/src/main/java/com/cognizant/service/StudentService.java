package com.cognizant.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
public class StudentService {

	private List<Student> stList = new ArrayList<Student>(
			Arrays.asList(new Student(1, "Avik"), new Student(2, "Sarkar"), new Student(3, "Piku")));

	public String insert(Student student) {
		for (Student st : stList) {
			if (st.getId()==student.getId()) {
				return "FAILED";
			}
		}
		if (stList.add(student)) {
			return "SUCCESS";
		} else {
			return "FAILED";
		}
	}

	public String update(Student student) {
		for (Student s1 : stList) {
			if (s1.getId()==student.getId()) {
				s1.setName(student.getName());
				return "SUCCESS";
			}
		}
		return "FAILED";
	}

	public String delete(Student student) {
		for (Student s1 : stList) {
			if (s1.getId()==student.getId()) {
				stList.remove(s1);
				return "SUCCESS";
			}
		}
		return "FAILED";
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
		System.out.println(stList);
		return stList;
	}

}