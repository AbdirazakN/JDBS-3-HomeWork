package peaksoft.servises;

import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.enums.Gender;
import peaksoft.models.Student;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public String creatTable() {
        studentDao.createTable();
        return "Successfully created!";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudents(student);
        return "Successfully saved!";
    }

    @Override
    public Student findByStudentId(Long studentId) {
        Student student = studentDao.findByStudentID(studentId);
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        studentDao.updateStudent(studentId, newStudent);
        return "Successfully updated!";
    }

    @Override
    public String deleteByStudentId(Long studentID) {
        studentDao.deleteByStudentId(studentID);
        return "Successfully deleted!";
    }

    @Override
    public List<Student> sortByAge(String ascOrDesc) {
        return studentDao.sortByAge(ascOrDesc);
    }

    @Override
    public boolean checkByAge() {
        return studentDao.checkByAge();
    }

    @Override
    public void addColumnGender(Gender gender) {
        studentDao.addColumnGender(gender);
    }

    @Override
    public Map<Gender, List<Student>> groupByGender() {
        return null;
    }

    @Override
    public void deleteAllStudents() {
        studentDao.deleteAllStudents();
    }
}
