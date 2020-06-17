<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        hr.redLine {
            border: 3px solid red;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            padding-bottom: 7px;
            padding-top: 7px
        }
    </style>
    <title>Role Updating</title>
</head>
<body>

<div style="text-align: center"><h1>Role Updating</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/admin/setrole" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${roles != null}">
                <input type="hidden" name="id" value="<c:out value='${roles.user_id}' />"/>
            </c:if>


            <tr>
                <th>User ID:</th>
                <td>
                    <label>
                        <input readonly type="number" name="user_id" maxlength="3" size="3"
                               value="<c:out value='${roles.user_id}'/>"/>
                    </label>
                </td>
            </tr>

            <tr>
                <th>Role:</th>
                <td>
                    <input type="radio" id="${roles.roles_id}" name="roles_id" value="1">
                    <label for="${roles.roles_id}">User</label><br>
                    <input type="radio" id="${roles.roles_id}" name="roles_id" value="2">
                    <label for="${roles.roles_id}">Admin</label><br>
                </td>
            </tr>

            <tr>

                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button"  style="background-color: crimson"><a style="color: #ffffff" href="${pageContext.request.contextPath}/admin/userlist">Back</a>
                    </button>
                </td>
            </tr>
        </table>
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
</html>