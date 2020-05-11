<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <style>

        .buttonStyle {
            background-color: darkred;
            padding-left: 4px;
            padding-right: 4px;
            padding-top: 0px;
            padding-bottom: 0px;
            border-right-width: 0px;
            border-left-width: 0px;
            border-bottom-width: 0px;
            border-top-width: 0px;
        }

        .btn {
            flex: 1 1 auto;
            margin: 10px;
            padding: 30px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: white;
            box-shadow: 0 0 20px #eee;
            border-radius: 10px;
            background-image: linear-gradient(to right, #84fab0 0%, #8fd3f4 51%, #84fab0 100%);
        }

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
    <title>Boss Database</title>
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
                    <a href="/admin/users_list" class="nav-item nav-link">List of Users</a>
                </sec:authorize>
            </div>
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

<div style="text-align: center"><h1>Boss Database</h1></div>
<button style="margin-left: 100px"><a href="/welcome">Back</a></button>
<div align="center">
    <table class=" table-sm table-striped" border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Min Damage</th>
            <th>Max Damage</th>
            <th>Restore HP</th>
            <th>Change To Super Damage</th>
        </tr>
        <c:forEach var="boss" items="${bosses}">
            <sec>
                <td>${boss.id}</td>
                <td>${boss.name}</td>
                <td>${boss.hp}</td>
                <td>${boss.minDamage}</td>
                <td>${boss.maxDamage}</td>
                <td>${boss.restoreHealth}</td>
                <td>${boss.chanceToSuperDamage}</td>

                        <sec:authorize access="hasRole('ADMIN')">
                <td><a href="${pageContext.request.contextPath}/boss/update/<c:out value='${boss.id}'/>">
                    <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                </a></td>
                <td><a href="${pageContext.request.contextPath}/boss/delete/<c:out value='${boss.id}'/>">
                    <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                </a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
<sec:authorize access="hasRole('ADMIN')">
<button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/boss/create">Create new
    Boss</a></button>
</sec:authorize>

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