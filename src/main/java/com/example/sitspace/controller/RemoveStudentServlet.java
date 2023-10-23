package com.example.sitspace.controller;

import com.example.sitspace.model.Student;
import com.example.sitspace.model.StudentList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "RemoveStudentServlet", value = "/RemoveStudent")
public class RemoveStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String removeId = request.getParameter("removeId");
        if (removeId == null) {
            request.setAttribute("removeError", "Input can't be null");
            request.getRequestDispatcher("add-remove.jsp").forward(request, response);
            return;
        }

        int idToRemove = Integer.parseInt(removeId);
        String removeMessage;
        HttpSession session = request.getSession();
        if (session.getAttribute("AllStudents") != null) {
            StudentList studentList = (StudentList) session.getAttribute("AllStudents");
            removeMessage = studentList.removeStudent(idToRemove) ? "Remove Successfully" : "Student with this id doesn't exist";
            request.setAttribute("removeMessage", removeMessage);
        } else {
            request.setAttribute("removeMessage", "No student found in the session");
        }
        request.getRequestDispatcher("add-remove.jsp").forward(request, response);
    }
}