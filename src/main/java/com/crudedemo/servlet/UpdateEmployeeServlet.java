package com.crudedemo.servlet;



import com.crudedemo.dao.EmployeeDAO;
import com.crudedemo.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

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

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

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
                        id,
                        name,
                        email,
                        department,
                        salary,
                        city
                );

        employeeDAO.updateEmployee(employee);

        response.sendRedirect(
                "viewEmployees");
    }
}
