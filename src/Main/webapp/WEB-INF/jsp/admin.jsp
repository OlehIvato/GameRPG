<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
    <title>List of Users</title>
</head>
<body>

<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">RPG Mini Game</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="/welcome" class="nav-item nav-link active">Home</a>
                <a href="/info" class="nav-item nav-link">About Game</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/admin" class="nav-item nav-link">List of Users</a>
                </sec:authorize>
            </div>
        </div>
        <div>

        </div>
        <div style="margin-right: 50px">
            <sec:authorize access="isAuthenticated()">
                <h4>
                    <a style="color: #fffbfb">${pageContext.request.userPrincipal.name}</a>
                    <a style="color: #ff3030" href="/logout">Logout</a>
                </h4>
            </sec:authorize>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>

<div align="center">
    <table class=" table-sm table-striped" border="1" cellpadding="5">
        <thead>
        <th>ID</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Gender</th>
        <th>Roles</th>
        </thead>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td width="23px">${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.address}</td>
                <td>${user.gender}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button style="background-color: darkred" type="submit">Delete</button>
                    </form>
                    <a href="${pageContext.request.contextPath}/setRole/<c:out value='${user.id}'/>">
                        <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                    </a>

                </td>
            </tr>

        </c:forEach>
    </table>
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
</html>