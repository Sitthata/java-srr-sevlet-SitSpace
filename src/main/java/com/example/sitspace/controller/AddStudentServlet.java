package com.example.sitspace.controller;


import com.example.sitspace.model.Student;
import com.example.sitspace.model.StudentList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Map;
import java.util.List;
import java.io.IOException;


@WebServlet(name = "AllStudents", value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameter = request.getParameterMap();
        if (parameter.get("name") == null || parameter.get("id") == null || parameter.get("score") == null) {
            request.setAttribute("error", "Empty parameter, moron! Is it so hard to put in just 3 boxes of text!?");
        }
        HttpSession session = request.getSession();
        StudentList studentList = (StudentList) session.getAttribute("AllStudents");
        if (studentList == null) {
            studentList = new StudentList();
            session.setAttribute("AllStudents", studentList);
        }
        int id = Integer.parseInt(parameter.get("id")[0]);
        String name = parameter.get("name")[0];
        int score = Integer.parseInt(parameter.get("score")[0]);
        studentList.addStudent(id, name, score);
        request.setAttribute("message", "Added successfully");
        request.getRequestDispatcher("index.jsp").forward(request, response);
//        if(session.getAttribute("AllStudents") == null){
//            StudentList studentList = new StudentList();
//            int id = Integer.parseInt(parameter.get("id")[0]);
//            String name = parameter.get("name")[0];
//            int score = Integer.parseInt(parameter.get("score")[0]);
//            studentList.addStudent(id,name,score);
//            session.setAttribute("AllStudents", studentList.getStudentList());
//        } else {
//            StudentList studentList = (StudentList) session.getAttribute("AllStudents");
//            studentList.add()
//        }

    }
}