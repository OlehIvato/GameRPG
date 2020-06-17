<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        .bs-example {
            margin: 0px;
        }

        hr.redLine {
            border: 4px solid red;
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Calculator</title>
</head>
<body>


<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">L O G O</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="/welcome" class="nav-item nav-link active">Home</a>
                <a href="/info" class="nav-item nav-link">About Game</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/admin/userlist" class="nav-item nav-link">List of Users</a>
                </sec:authorize>
            </div>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>


<div style="text-align: center"><h1>Calculator</h1></div>


<button style="margin-left: 100px"><a href="/welcome">Back</a></button>

<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/calculator" method="post">
        <input placeholder="a" type="text" size="5" name="a" value="<c:out value='${calculator.a}'/>"/>
        <input placeholder="b" type="text" size="5" name="b" value="<c:out value='${calculator.b}'/>"/>

        <p>
            <input type="submit" class="button" name="add" value="+"/>
            <input type="submit" class="button" name="subtract" value="-"/>
            <input type="submit" class="button" name="multiply" value="*"/>
            <input type="submit" class="button" name="divide" value="/"/>
        </p>

        <h1> ${result} </h1>

    </form>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>