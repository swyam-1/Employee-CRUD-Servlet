<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

    <title>View Employees</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="container">

    <h2>All Employees</h2>

    <a class="add-btn"
       href="add-employee.jsp">

        Add Employee

    </a>

    <br><br>

    <table>

        <tr>

            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>City</th>
            <th>Action</th>

        </tr>


        <c:forEach
                var="employee"
                items="${employees}">

            <tr>

                <td>
                    ${employee.id}
                </td>

                <td>
                    ${employee.name}
                </td>

                <td>
                    ${employee.email}
                </td>

                <td>
                    ${employee.department}
                </td>

                <td>
                    ${employee.salary}
                </td>

                <td>
                    ${employee.city}
                </td>

                <td>

                    <a href="editEmployee?id=${employee.id}">
                        Edit
                    </a>

                    |

                    <a href="deleteEmployee?id=${employee.id}"
                       onclick="return confirm('Are you sure you want to delete this employee?');">

                        Delete

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a href="index.jsp">
        Back to Home
    </a>

</div>

</body>

</html>