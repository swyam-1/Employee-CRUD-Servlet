package com.crudedemo.servlet;



import com.crudedemo.dao.EmployeeDAO;
import com.crudedemo.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {

        employeeDAO =
                new EmployeeDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees =
                employeeDAO.getAllEmployees();

        request.setAttribute(
                "employees",
                employees
        );

        request.getRequestDispatcher(
                "view-employees.jsp"
        ).forward(request, response);
    }
}