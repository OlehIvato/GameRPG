<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Location Database</title>
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
                <a href="${pageContext.request.contextPath}/entry" class="nav-item nav-link active">Home</a>
                <a href="${pageContext.request.contextPath}/info" class="nav-item nav-link">About Game</a>

            </div>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>


<div th:switch="${locations}">

    <div style="text-align: center"><h1>Location Database</h1></div>

    <div align="center">
        <table class=" table-sm table-striped" border="1" cellpadding="5">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Hero HP</th>
                <th>Hero Damage</th>
                <th>Hero Spell Damage</th>
                <th>Hero Restore HP</th>
                <th>Creature HP</th>
                <th>Creature Damage</th>
                <th>Creature Chance</th>
            </tr>
            <c:forEach var="location" items="${locations}">
                <tr>
                    <td>${location.id}</td>
                    <td>${location.name}</td>
                    <td>${location.heroHp}</td>
                    <td>${location.heroDamage}</td>
                    <td>${location.heroSpellDamage}</td>
                    <td>${location.heroRestoreHealth}</td>
                    <td>${location.creatureHp}</td>
                    <td>${location.creatureDamage}</td
                    <td>
                    <td>${location.creatureChance}</td
                    </td>
                    <td>
                    <td><a href="${pageContext.request.contextPath}/location/update/<c:out value='${location.id}'/>">
                        <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                    </a></td>
                    <td><a href="${pageContext.request.contextPath}/location/delete/<c:out value='${location.id}'/>">
                        <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                    </a></td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/location/create">Create new Location</a></button>


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