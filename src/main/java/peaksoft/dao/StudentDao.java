package peaksoft.dao;

import peaksoft.enums.Gender;
import peaksoft.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //  create table
    void createTable();

    //  save students
    void saveStudents(Student student);

    //  find by studentID
    Student findByStudentID(Long studentId);

    // findAll
    List<Student> findAllStudents();

    //  update students
    void updateStudent(Long studentId ,Student newStudent);

    //  delete students
    void deleteByStudentId(Long studentId);

    //  sort by Age
    List<Student> sortByAge(String ascOrDesc);

    //  check by age
    boolean checkByAge();

    //  add column gender
    void addColumnGender(Gender gender);

    //   map Gender Students
    Map<Gender,List<Student>> groupByGender();

    //   truncate students DDL
    void deleteAllStudents();

    /**
     //delete
    void deleteByStudentId(Long studentID);

    List<Student> getAllStudentsSortByAge(String ascOrDesc);

    boolean checkByAge();

    void addColumnGender(Gender gender);

    Map<Gender, List<Student>> gruopByGender();

    void deleteAllStudents(); //ddl
    */
}
