<%@include file="/WEB-INF/jsp/design/bootstrap.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Log In</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <div>
        <h3 class="text-center">Log In</h3>
        <form method="POST" action="${pageContext.request.contextPath}/login" class="form"
              style="text-align: center; width: 300px; margin: auto; ">
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <div style=" width: 330px;">
                    <input name="username" type="text" placeholder="Username" class="form-control"/>
                    <input name="password" type="password" placeholder="Password" class="form-control"/>
                        ${error}
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <h4 class="text-center">
                        <a href="${pageContext.request.contextPath}/registration">Create an account</a>
                    </h4>
                    <h4 class="text-center">
                        <a href="${pageContext.request.contextPath}/forgot-password">Forget Password</a>
                    </h4>
                </div>
            </div>
        </form>
    </div>
</sec:authorize>


</body>
</html>





