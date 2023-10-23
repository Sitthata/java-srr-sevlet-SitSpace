package com.example.sitspace.model;

import java.util.LinkedList;
import java.util.List;

public class StudentList {
    private static List<Student> studentList = new LinkedList<>();

    public boolean addStudent(int id, String name, int score) {
        return studentList.add(new Student(id, name, score));
    }

    public boolean removeStudent(int id) {
        Student removeStudent = studentList
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
        if (removeStudent == null) return false;
        studentList.remove(removeStudent);
        return true;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
