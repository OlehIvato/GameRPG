<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Forget Password</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<div style="text-align: center;">
    <h1> Provide your Email address </h1>
    <form:form class="form-horizontal" method="POST" modelAttribute="userForm" action="/forgot-password"
               style="margin: auto;">
        <label>
            <form:input type="text" path="email" placeholder="Email" autofocus="true"/>
        </label>
        <h3> ${error} </h3>

        <div class="col-sm-6">
            <a href="${pageContext.request.contextPath}/login">Back</a>
            <button type="submit" class="btn btn-primary btn-block">Check</button>
        </div>

    </form:form>
</div>

</body>
</html>