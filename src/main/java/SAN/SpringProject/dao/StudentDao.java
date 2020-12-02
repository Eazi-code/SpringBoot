package SAN.SpringProject.dao;

import SAN.SpringProject.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Wojtek", "Informatyka"));
                put(2, new Student(2, "Szymon", "Doradztwo filozoficzne"));
                put(3, new Student(3, "Oliwia", "Architektura"));
                put(4, new Student(4, "Mateusz", "Administracja"));
                put(5, new Student(5, "Krystian", "Biotechnologia"));
                put(6, new Student(6, "Krystyna", "Prawo"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student);
    }
}
