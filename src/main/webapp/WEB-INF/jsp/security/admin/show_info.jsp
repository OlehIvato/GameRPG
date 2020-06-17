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

        textarea {
            font-size: .8rem;
            letter-spacing: 1px;
        }

        textarea {
            padding: 10px;
            line-height: 1.5;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-shadow: 1px 1px 1px #999;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        #avatar {
            width: 300px;
            background-color: #999999;
            border: #999999;
            margin-left: 25px;

            display: none;
            position: absolute;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;

        }

        #avatar:target {
            display: block;
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
    <form action="${pageContext.request.contextPath}/admin/userinfo/" method="post">
        <c:forEach items="${all_users_info.profile}" var="profile">
            <table border="1" cellpadding="5">
                <thead>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Country</th>
                <th>City</th>
                <th>Zip</th>
                <th>Avatar</th>
                </thead>
                <tbody>
                <tr>
                    <td>${profile.name}</td>
                    <td>${profile.surname}</td>
                    <td>${all_users_info.email}</td>
                    <td>${profile.birthday}</td>
                    <td>${profile.gender}</td>
                    <td>${profile.phone}</td>
                    <td>${profile.country}</td>
                    <td>${profile.city}</td>
                    <td>${profile.zip}</td>
                    <td><a href="#avatar">show</a></td>
                </tr>
                </tbody>
            </table>

            <div id="avatar">
                <img alt="User Avatar" src="<c:url value="/ava/${profile.avatar}"/>"/>
                <a href="#" class="close">close</a>
            </div>

            <div>
                <h2 style="margin-top: 10px">Bio</h2>
                <label for='test'></label>
                <textarea readonly rows="5" cols="110" name='bio' id='test'><c:out
                        value="${profile.bio}"/></textarea>
            </div>
        </c:forEach>
    </form>
</div>

<div align="center">
    <a href="/admin/userlist">
        <button class="buttonStyle" style="background-color: forestgreen">Back to List</button>
    </a>
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