package com.crudedemo.servlet;

import com.crudedemo.dao.EmployeeDAO;
import com.crudedemo.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {

        employeeDAO =
                new EmployeeDAO();
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String department =
                request.getParameter("department");

        double salary =
                Double.parseDouble(
                        request.getParameter("salary"));

        String city =
                request.getParameter("city");

        Employee employee =
                new Employee(
                        name,
                        email,
                        department,
                        salary,
                        city
                );

        employeeDAO.addEmployee(employee);

        response.sendRedirect(
                "viewEmployees");
    }
}