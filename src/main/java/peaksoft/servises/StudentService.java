package peaksoft.servises;

import peaksoft.enums.Gender;
import peaksoft.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    // create table
    String creatTable();

    // save students
    String saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    String updateStudent(Long studentId, Student newStudent);

    //delete
    String deleteByStudentId(Long studentID);

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
}
