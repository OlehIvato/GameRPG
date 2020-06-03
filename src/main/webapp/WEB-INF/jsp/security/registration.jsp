<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <title>Registration</title>
</head>
<body>

<div class="container">
    <form:form class="form-horizontal" method="POST" modelAttribute="userForm" action="/registration"
               style="margin: auto;">
        <h2>Registration Form</h2>
        <div class="form-group">
            <label for="username" class="col-sm-3 control-label">Username</label>
            <div class="col-sm-9">
                <form:input type="text" path="username" placeholder="Username" autofocus="true"/>
                <form:errors path="username"/> ${usernameError}
            </div>
        </div>


        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <form:input type="password" path="password" placeholder="Password"/>
                <form:errors path="password"/>${passwordError}
            </div>
        </div>


        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Verify Password</label>
            <div class="col-sm-9">
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"/>
                <form:errors path="password"/>${passwordError}
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <form:input type="email" path="email" placeholder="Email"/>
                <form:errors path="email"/>${emailError}
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-6">
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </div>
        </div>
        <div class="col-sm-6">
            <p></p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>
        </div>
    </form:form>
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
