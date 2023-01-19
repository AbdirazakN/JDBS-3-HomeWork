package peaksoft;

import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.enums.Gender;
import peaksoft.models.Student;
import peaksoft.servises.StudentService;
import peaksoft.servises.StudentServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        StudentService service = new StudentServiceImpl();
//        System.out.println(service.creatTable());
//        System.out.println(service.saveStudents(new Student("Alisher",(byte)18)));
//        System.out.println(service.saveStudents(new Student("Asylbek",(byte)17)));
//        System.out.println(service.saveStudents(new Student("Aktan",(byte)15)));
//        System.out.println(service.saveStudents(new Student("Almaz",(byte)22)));
//        System.out.println(service.saveStudents(new Student("Aikyz",(byte)20)));
//        System.out.println(service.findByStudentId(1L));

//        System.err.println(service.findAllStudents());
//        service.findAllStudents().forEach(System.out::println);
//        service.updateStudent(2L,new Student("Bakyt",(byte) 18));
//        service.findAllStudents().forEach(System.out::println);
//        service.deleteAllStudents();
//        service.addColumnGender(new Gender());
//        System.out.println("Enter ASC or DESC to sort Age: ");
//        System.out.println(service.sortByAge(new Scanner(System.in).nextLine()));
//        System.out.println("Enter ID Student's to delete: ");
//        System.out.println(service.deleteByStudentId(new Scanner(System.in).nextLong()));
//        System.err.println(service.findAllStudents());
        System.out.println(service.checkByAge());

    }
}
