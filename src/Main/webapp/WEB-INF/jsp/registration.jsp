<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        body {
            background-color: #eee;
        }

        *[role="form"] {
            max-width: 530px;
            padding: 15px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 0.3em;
        }

        *[role="form"] h2 {
            margin-left: 5em;
            margin-bottom: 1em;
        }


    </style>

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
<form:form class="form-horizontal" method="POST" modelAttribute="userForm" action="/registration">
        <h2>Registration Form</h2>
        <div class="form-group">
            <label for="username" class="col-sm-3 control-label">Username</label>
            <div class="col-sm-9">
                <form:input type="text" path="username" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
                ${usernameError}
            </div>
        </div>


        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <form:input type="password" path="password"
                            placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
                ${passwordError}
            </div>
        </div>


        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Verify Password</label>
            <div class="col-sm-9">
                <form:input type="password" path="passwordConfirm"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="password"></form:errors>
                ${passwordError}
            </div>
        </div>

    <div class="form-group">
        <label for="password" class="col-sm-3 control-label" re>Email</label>
        <div class="col-sm-9">
            <form:input type="email" path="email" placeholder="Email"></form:input>
            <form:errors path="email" cssClass="error"/>
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-3 control-label">Phone Number</label>
        <div class="col-sm-9">
            <form:input type="tel" path="phone" placeholder="Phone"></form:input>
            <form:errors path="phone" cssClass="error"/>
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-3 control-label">Address</label>
        <div class="col-sm-9">
            <form:input type="text" path="address" placeholder="Address"></form:input>
            <form:errors path="address" cssClass="error"/>
        </div>
    </div>




        <div class="form-group">
            <label class="control-label col-sm-3">Gender</label>
            <div class="col-sm-6">
                <form:radiobutton path="gender" value="Male" label="Male"/>
                <form:radiobutton path="gender" value="Female" label="Female"/>
                <form:errors path="gender" cssClass="error"/>
            </div>
        </div>

        <%--        <div class="form-group">--%>
        <%--            <div class="col-sm-9 col-sm-offset-3">--%>
        <%--                <div class="checkbox">--%>
        <%--                    <label>--%>
        <%--                        <input type="checkbox">I accept <a href="#">terms</a>--%>
        <%--                    </label>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div> <!-- /.form-group -->--%>


        <div class="form-group">
            <div class="col-sm-6">
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </div>
        </div>
    <div class="col-sm-6">
        <p></p>Already have an account? <a href="/login">Sign in</a></p>
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
