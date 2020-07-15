<%@include file="/WEB-INF/jsp/design/bootstrap.jsp" %>
<!doctype html>
<html lang="en">
<head>
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
                <form:input type="password" path="password_confirm" placeholder="Confirm your password"/>
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

</body>
</html>
