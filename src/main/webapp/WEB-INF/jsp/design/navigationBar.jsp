<%@include file="bootstrap.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>


<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">L O G O</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="/welcome" class="nav-item nav-link active">Home</a>
                <a href="/info" class="nav-item nav-link">About Game</a>
<%--                <sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">--%>
                    <a href="${pageContext.request.contextPath}/admin/user-list" class="nav-item nav-link">List of
                        Users</a>
<%--                </sec:authorize>--%>
            </div>
        </div>
        <sec:authentication var="principal" property="principal"/>
        <div class="navbar-nav" style="align-content: end">
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/account/user">Profile</a>
            <a class="nav-item nav-link active" style="color: gold">${principal.username}</a>
            <sec:authorize access="isAuthenticated()">
                <a class="nav-item nav-link" style="color: #ff3030"
                   href="${pageContext.request.contextPath}/log-out">Log out</a>
            </sec:authorize>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">

</div>

</body>
</html>






