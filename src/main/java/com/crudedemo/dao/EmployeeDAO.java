package com.crudedemo.dao;

import com.crudedemo.model.Employee;
import com.crudedemo.utill.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // CREATE
    public boolean addEmployee(Employee employee) {

        String sql =
                "INSERT INTO employees " +
                "(name, email, department, salary, city) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getCity());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // READ - All Employees
    public List<Employee> getAllEmployees() {

        List<Employee> employees =
                new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee =
                        new Employee();

                employee.setId(
                        rs.getInt("id"));

                employee.setName(
                        rs.getString("name"));

                employee.setEmail(
                        rs.getString("email"));

                employee.setDepartment(
                        rs.getString("department"));

                employee.setSalary(
                        rs.getDouble("salary"));

                employee.setCity(
                        rs.getString("city"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return employees;
    }


    // READ - Employee by ID
    public Employee getEmployeeById(int id) {

        Employee employee = null;

        String sql =
                "SELECT * FROM employees WHERE id = ?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                employee =
                        new Employee();

                employee.setId(
                        rs.getInt("id"));

                employee.setName(
                        rs.getString("name"));

                employee.setEmail(
                        rs.getString("email"));

                employee.setDepartment(
                        rs.getString("department"));

                employee.setSalary(
                        rs.getDouble("salary"));

                employee.setCity(
                        rs.getString("city"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return employee;
    }


    // UPDATE
    public boolean updateEmployee(Employee employee) {

        String sql =
                "UPDATE employees SET " +
                "name=?, email=?, department=?, " +
                "salary=?, city=? " +
                "WHERE id=?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getCity());
            ps.setInt(6, employee.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // DELETE
    public boolean deleteEmployee(int id) {

        String sql =
                "DELETE FROM employees WHERE id=?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}