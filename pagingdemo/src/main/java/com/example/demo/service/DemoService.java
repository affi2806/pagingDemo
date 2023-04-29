package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.DemoRepository;

@Service

public class DemoService {

 @Autowired

 DemoRepository rep;

 public List<Student> getAllStudents()

 {

	 List<Student>studList=rep.findAll();

	 return studList;

 }

 public Student saveStudent(Student s)

 {

	 Student obj=rep.save(s);

	 return obj;

 }

 public List<Student> sortStudents(String name) 

 {

	   return rep.findAll(Sort.by(name));

 } 

 public List<Student> pagingStudents(int offset,int pageSize) 

 {

	   Pageable paging=PageRequest.of(offset,pageSize);

	   Page<Student> studData=rep.findAll(paging);

	   List<Student>studList=studData.getContent(); 

	   return studList;

 }
 
 public List<Student> PagingAndSorting(int offset,int pagesize,String field)
 {
	 Pageable paging=PageRequest.of(pagesize, pagesize).withSort(Sort.by(field));
	 Page<Student> stud=rep.findAll(paging);
	 return stud.getContent();
 }


}

