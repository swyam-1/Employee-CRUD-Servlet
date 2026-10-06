package com.crudedemo.servlet;



import com.crudedemo.dao.EmployeeDAO;
import com.crudedemo.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {

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

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        Employee employee =
                employeeDAO.getEmployeeById(id);

        request.setAttribute(
                "employee",
                employee
        );

        request.getRequestDispatcher(
                "edit-employee.jsp"
        ).forward(request, response);
    }
}