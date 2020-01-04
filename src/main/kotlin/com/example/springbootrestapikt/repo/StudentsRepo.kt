package com.example.springbootrestapikt.repo

import com.example.springbootrestapikt.pojo.Student
import org.springframework.stereotype.Repository

/**
 * Repository class for connecting to database.
 * For demonstration used local variable as list of students.
 * @author hari
 *
 */
@Repository
class StudentsRepo {

    var mAllStudents = mutableListOf<Student>()

    init {
        val s1 = Student("Hari",24,"Student Address 1")
        val s2 = Student("Sandy",33,"Student Address 2")
        val s3 = Student("Jenny",12,"Student Address 3")

        mAllStudents.add(s1)
        mAllStudents.add(s2)
        mAllStudents.add(s3)
    }

    /**
     * Retrieve all students.
     */
    fun retrieveAllStudents(): List<Student>{
        return mAllStudents
    }

    /**
     * Adding new student.
     */
    fun addStudent(newStudent:Student): List<Student>{

        mAllStudents.add(newStudent)

        return mAllStudents
    }

    /**
     *  Get student with name.
     */
    fun getStudentWithName(name:String): Student?{

        return findStudentByName(name)

    }

    /**
     * Delete student by name.
     */
    fun deleteByName(name:String): List<Student>{

        var student: Student? = findStudentByName(name)
        mAllStudents.remove(student)

        return mAllStudents
    }

    /**
     * Find student by name.
     */
    fun findStudentByName(name:String): Student?{
        return mAllStudents.find{it.name == name}
    }
}