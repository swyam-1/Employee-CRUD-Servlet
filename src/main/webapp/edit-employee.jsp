<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

    <title>Edit Employee</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>Edit Employee</h2>

    <form action="updateEmployee"
          method="post">

        <input type="hidden"
               name="id"
               value="${employee.id}">


        <label>Name</label>

        <input type="text"
               name="name"
               value="${employee.name}"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               value="${employee.email}"
               required>


        <label>Department</label>

        <input type="text"
               name="department"
               value="${employee.department}"
               required>


        <label>Salary</label>

        <input type="number"
               name="salary"
               step="0.01"
               value="${employee.salary}"
               required>


        <label>City</label>

        <input type="text"
               name="city"
               value="${employee.city}"
               required>


        <button type="submit">
            Update Employee
        </button>

    </form>

    <br>

    <a href="viewEmployees">
        Back to Employees
    </a>

</div>

</body>

</html>