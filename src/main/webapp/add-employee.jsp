<!DOCTYPE html>

<html>

<head>

    <title>Add Employee</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>Add Employee</h2>

    <form action="addEmployee"
          method="post">

        <label>Name</label>

        <input type="text"
               name="name"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               required>


        <label>Department</label>

        <input type="text"
               name="department"
               required>


        <label>Salary</label>

        <input type="number"
               name="salary"
               step="0.01"
               required>


        <label>City</label>

        <input type="text"
               name="city"
               required>


        <button type="submit">
            Add Employee
        </button>

    </form>

    <br>

    <a href="index.jsp">
        Back to Home
    </a>

</div>

</body>

</html>