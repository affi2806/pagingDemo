package com.example.demo.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.example.demo.model.Student;

import com.example.demo.service.DemoService;



@RestController

public class ControllerDemo {

   @Autowired

   DemoService stud;

   @GetMapping(value="fetchStudents")

   public List<Student> getAllStudents()

   {

	   List<Student>studList=stud.getAllStudents();

	   return studList;

   }

   @PostMapping(value="/saveStudent")

   public Student saveStudent(@RequestBody Student s)

   {

	   return stud.saveStudent(s);

   }

   @GetMapping(value="/sortStudents/{name}")

   public List<Student>sortStudents(@PathVariable String name) 

   { 

	   return stud.sortStudents(name); 

   }

   ///pagination

   // http://localhost:8080/pageStudents/0/1

   @GetMapping(value="/pagingStudents/{offset}/{pageSize}")
   public List<Student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize)

   {

	   return stud.pagingStudents(offset,pageSize); 

   }
   
   
   //http://localhost:8080?fetchhStudentsByNamePrefix?prefix=a
    
   @GetMapping(value="/pagingAndSorting/{offset}/{pagesize}/{field}")
   public List<Student> PagingAndSorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field)
   {
	   return stud.PagingAndSorting(offset, pagesize, field);
   }
   


}



 



