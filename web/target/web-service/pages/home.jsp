<%--
  Created by IntelliJ IDEA.
  User: sachini
  Date: 7/23/18
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: #4DB6AC;
        }
        .navbar {
            padding-top: 15px;
            padding-bottom: 15px;
            border: 0;
            border-radius: 0;
            margin-bottom: 0;
            font-size: 12px;
            letter-spacing: 5px;
            background-color: black;
        }
        .navbar-nav  li a:hover {
            color: #1abc9c !important;
        }

        .bg-4 {
            background-color: #2f2f2f; /* Black Gray */
            color: #fff;
        }

        .container-fluid {
            padding-top: 29px;
            padding-bottom: 25px;
        }

    </style>

    <!--script src="webjars/jquery/1.9.1/jquery.min.js"></script-->
</head>
<body>
<div class="container text-center" style="background-color: darkkhaki; width: 100%;">
    <h1>ABC Company</h1>
    <p>Employee Details!</p>
</div>
<!-- Navbar -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="newEmployee">New Employee</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </div>
</nav>

<br><br>
<div class="container">
    <div class="row">

        <input class="form-control" id="myInput" type="text" placeholder="Search.."><br>

        <div class="jumbotron text-center">
            <div class="table-responsive ">
                <table class="table table-hover">
                    <thead>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Telephone</th>
                    <th>Edit Employee</th>
                    <th>Delete Employee</th>
                    </thead>

                    <tbody id="myTable" onclick="addRowHandlers()">
                    <c:forEach var="employee" items="${listEmployee}">
                        <tr>

                            <td>${employee.name}</td>
                            <td>${employee.email}</td>
                            <td>${employee.address}</td>
                            <td>${employee.telephone}</td>
                            <td><a href="editEmployee?id=${employee.id}">Edit</a></td>
                            <td><a href="deleteEmployee?id=${employee.id}">Delete</a></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<p id="demo"></p>

<script>

    //script for table onclick event
    function addRowHandlers() {
        var table = document.getElementById("myTable");
        var rows = table.getElementsByTagName("tr");
        for (i = 0; i < rows.length; i++) {
            var currentRow = table.rows[i];
            var createClickHandler = function(row) {
                return function() {
                    var cell = row.getElementsByTagName("td")[0];
                    var name = cell.innerHTML;
                    var cell = row.getElementsByTagName("td")[1];
                    var email = cell.innerHTML;
                    var cell = row.getElementsByTagName("td")[2];
                    var address = cell.innerHTML;
                    var cell = row.getElementsByTagName("td")[3];
                    var telephone = cell.innerHTML;

                    alert("name:" + name+ "\n"
                        + "email" + email + "\n"
                        + "address" + address + "\n"
                        + "Telephone Number" + telephone);

                };
            };

            currentRow.onclick = createClickHandler(currentRow);
        }
    }
    window.onload = addRowHandlers();

    /* script for search*/
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>

<!--footer-->
<footer class="container-fluid bg-4 text-center">
    <p>no 62-1, Elpitiya RD, Ambalangoda</p>
    <p>Contact num: 0772454265</p>
    <p>Copyright Ⓒ 2018</p>
</footer>
</body>
</html>
