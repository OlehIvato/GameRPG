<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>New Password</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center;">
    <h1> Provide new password </h1>
    <form:form class="form-horizontal" method="POST" modelAttribute="newPasswordForm" action="/new-password"
               style="margin: auto;">

        <label>
            <form:input type="password" path="password_new" placeholder="New Password" autofocus="true"/>
        </label>
        <label>
            <form:input type="password" path="password_confirm" placeholder="Confirm Password" autofocus="true"/>
        </label>
        <br>
        ${error}

        <div class="col-sm-6">
            <a href="${pageContext.request.contextPath}/forgot-password">Back</a>
            <button type="submit" class="btn btn-primary btn-block">Update Password</button>
        </div>

    </form:form>
</div>

</body>
</html>