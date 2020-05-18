<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <style>
        .bs-example {
            margin: 0px;
        }

        hr.redLine {
            border: 4px solid red;
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Main</title>
</head>
<body>

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
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/admin/userlist" class="nav-item nav-link">List of Users</a>
                </sec:authorize>
            </div>
        </div>

        <div class="navbar-nav" style="align-content: end">
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/account/user/<c:out value='${user.id}'/>">Profile</a>
            <a class="nav-item nav-link active" style="color: gold">${user.username}</a>
            <sec:authorize access="isAuthenticated()">
                <a class="nav-item nav-link" style="color: #ff3030"
                   href="${pageContext.request.contextPath}/logout">Log out</a>
            </sec:authorize>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>
<div style="text-align: center;"><h1 id="main">Main</h1></div>


<div class="container">
    <h2>Databases</h2>
    <p>list / delete / update / create</p>
    <div class="btn-group">
        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/hero/all" class="btn btn-primary">Hero</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/location/all" class="btn btn-primary">Location</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/mob/all" class="btn btn-primary">Mob</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/boss/all" class="btn btn-primary">Boss</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/equipment/all" class="btn btn-primary">Equipment</a>
    </div>
</div>


<div class="container">
    <p>
    <h2> game</h2>
    <div class="btn-group">
        <a style=" font-size: 20px"
           href="${pageContext.request.contextPath}/game/new-game" class="btn btn-primary">start</a>
    </div>
</div>

<div class="container">
    <p>
    <div class="btn-group">
        <a style=" font-size: 10px"
           href="${pageContext.request.contextPath}/calculator" class="btn btn-primary">Calculator</a>
    </div>
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