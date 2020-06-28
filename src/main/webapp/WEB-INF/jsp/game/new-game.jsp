<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Select your hero</title>
</head>
<body>

<div style="text-align: center;"><h1 id="main">${pageContext.request.userPrincipal.name} select your Hero</h1></div>


<button style="margin-left: 100px"><a href="/welcome">Back</a></button>
<div align="center">
    <table class=" table-sm table-striped" border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>Class</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Min Spell Damage</th>
            <th>Max Spell Damage</th>
            <th>Restore Hp</th>
            <th>Mana</th>
            <th>Armor type</th>
            <th>Image</th>
        </tr>

        <c:forEach var="hero" items="${heroes}">
        <tr>
            <td>${hero.id}</td>
            <td><c:forEach items="${hero.AClasses}" var="className">${className.className}</c:forEach>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td>${hero.minSpell}</td>
            <td>${hero.maxSpell}</td>
            <td>${hero.restore}</td>
            <td>${hero.mana}</td
            </td>
            <td><c:forEach items="${hero.armors}" var="armor">${armor.armorName}</c:forEach>
            <td><img style="width: 35px" class="scale" alt="Hero image" src="/images/${hero.image}"></td>

            <td><a href="${pageContext.request.contextPath}/game/equipment-select/<c:out value='${hero.id}'/>">
                <button type="submit"  value="Save" class="buttonStyle" style="background-color: green"> Choose</button>
            </a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<script crossorigin="anonymous"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>