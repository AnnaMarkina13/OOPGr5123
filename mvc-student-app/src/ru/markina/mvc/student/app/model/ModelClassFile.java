package ru.markina.mvc.student.app.model;

import ru.markina.mvc.student.app.controller.interfaces.GetModel;
import ru.markina.mvc.student.app.model.core.Student;
import ru.markina.mvc.student.app.model.core.id.IdProducer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ModelClassFile implements GetModel {

    private final String fileName;

    public ModelClassFile(String fileName) {
        this.fileName = fileName;

        try (var fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> students() {
        List<Student> students = new ArrayList<>();
        try {
            var reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                var studentData = line.split(" ");
                var student = new Student(studentData[0], LocalDate.parse(studentData[1],
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")), IdProducer.ofInt(Integer.parseInt(studentData[2])));
                students.add(student);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public Student deleteStudent(final Long id) {
        for (int i = 0; i < students().size(); i++) {
            if (students().get(i).getId() == id) {
                return students().remove(i);
            }
        }
        System.out.println("Студента с таким id нет.");
        return null;
    }


    public void saveAllStudentToFile(List<Student> students) {
        try (var fw = new FileWriter(fileName, true)) {
            for (Student student : students) {
                fw.write(student.getName() + " " + student.getAge() + " " + student.getId() + "\n");
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
