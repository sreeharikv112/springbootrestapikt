package com.example.springbootrestapikt.controllers

import com.example.springbootrestapikt.pojo.Student
import com.example.springbootrestapikt.repo.StudentsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Controller class for various REST API operations.
 *
 * @author hari
 *
 */
@RestController
class StudentResource {

    @Autowired
    val studentsRepo = StudentsRepo()


    @GetMapping("getallstudents")
    fun getAllStudents(): List<Student>{

        return studentsRepo.retrieveAllStudents()
    }

    @PostMapping("/createStudent")
    fun createNewStudent(@RequestBody student:Student): List<Student>{

        return studentsRepo.addStudent(student)
    }

    @GetMapping("/findstudent/{name}")
    fun retrieveStudentByName(@PathVariable name:String): Student?{

        return studentsRepo.getStudentWithName(name)
    }

    @DeleteMapping("/deletestudent/{name}")
    fun deleteStudent(@PathVariable name:String): List<Student>{

        return studentsRepo.deleteByName(name)
    }

}