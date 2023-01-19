package peaksoft.dao;

import peaksoft.config.DatabaseConnection;
import peaksoft.enums.Gender;
import peaksoft.models.Student;
import peaksoft.servises.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    private Connection connection;

    public StudentDaoImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createTable() {
        String query = """
                create table if not exists students(
                id serial primary key,
                name varchar(50) not null,
                age smallint not null
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveStudents(Student student) {
        String sqlQuery = """
                insert into students(name,age)
                values (?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setByte(2, student.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student findByStudentID(Long studentId) {
        String sqlQuery = """
                select * from students where id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,studentId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            Student student = new Student();
            if (!resultSet.next()) {
                System.out.println("Does not exist!");
            }
                while (resultSet.next()) {
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString(2));
                    student.setAge(resultSet.getByte(3));
                }
            resultSet.close();
            return student;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        String query = """
                select * from students;
                """;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                allStudents.add(student);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return allStudents;
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        String query = """
                update students 
                set name = ? ,
                age = ?
                where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,newStudent.getName());
            preparedStatement.setByte(2,newStudent.getAge());
            preparedStatement.setLong(3,studentId);

            int i = preparedStatement.executeUpdate();
            if (i>0){
                System.out.println("Successfully updated!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByStudentId(Long studentId) {
        String query = """
                DELETE FROM students WHERE id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,studentId);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                System.out.println("Successfully deleted!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> sortByAge(String ascOrDesc) {
        List<Student> sorted = new ArrayList<>();
        if (ascOrDesc.toLowerCase().equals("asc")){
            String query = """
                    Select * from students order by age;
                    """;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString(2));
                    student.setAge(resultSet.getByte(3));
                    sorted.add(student);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }if (ascOrDesc.toLowerCase().equals("desc")){
            String query = """
                    Select * from students order by age desc;
                    """;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString(2));
                    student.setAge(resultSet.getByte(3));
                    sorted.add(student);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return sorted;
    }

    @Override
    public boolean checkByAge() {
        String query = """
                ALTER TABLE students ADD CONSTRAINT age CHECK (age > 0 AND age < 120);
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addColumnGender(Gender gender) {
        String query = """
                create type Gender as enum('Male','Female');
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Successfully added Gender Enum!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query1 = """
                alter table students add Gender;
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Successfully added Gender to Students!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Map<Gender, List<Student>> groupByGender() {
        String query = """
                select Gender,* from students group by Gender;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteAllStudents() {
        String query = """
                truncate students;
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Successfully deleted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
