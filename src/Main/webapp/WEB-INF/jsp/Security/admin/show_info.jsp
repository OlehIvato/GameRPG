<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        hr.redLine {
            border: 3px solid red;
        }

        .button {
            background-color: #4CAF50; /* Green */
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

        div.container4 {
            height: 10em;
            position: relative
        }

        div.container4 p {
            margin: 0;
            background: yellow;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-right: -50%;
            transform: translate(-50%, -50%)
        }

    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>User Info</title>
</head>
<body>
<div style="text-align: center"><h1>User Info</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/admin/all_users_information/" method="post">
        <table border="1" cellpadding="5">
            <thead>
            <th>Name</th>
            <th>Surname</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Country</th>
            <th>City</th>
            <th>Zip</th>
            </thead>
            <tbody>
            <tr>
                <td>${all_users_info.userInformation.name}</td>
                <td>${all_users_info.userInformation.surname}</td>
                <td>${all_users_info.userInformation.birthday}</td>
                <td>${all_users_info.userInformation.gender}</td>
                <td>${all_users_info.userInformation.phone}</td>
                <td>${all_users_info.userInformation.country}</td>
                <td>${all_users_info.userInformation.city}</td>
                <td>${all_users_info.userInformation.zip}</td>
            </tr>
            </tbody>
        </table>

        <div class="container4">
            <h2>Bio</h2>
            <a> ${all_users_info.userInformation.bio} </a>
        </div>


    </form>
</div>

<div align="center">
    <button  class="button" type="submit" style="background-color: #4CAF50"><a style="color: #ffffff" href="${pageContext.request.contextPath}/admin/users_list">Back to List</a>
    </button>
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