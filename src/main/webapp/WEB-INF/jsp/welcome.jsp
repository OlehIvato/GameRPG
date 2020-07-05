<!doctype html>
<html lang="en">
<head>

    <title>Main</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="navBar.jsp" %>
<%@include file="bootstrap.jsp" %>

<div style="text-align: center;"><h1>Main</h1></div>

<div class="container">
    <h2>Databases</h2>
    <p>list / delete / update / create</p>
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/hero/all" class="btn btn-primary">Hero</a>
        <a href="${pageContext.request.contextPath}/location/all" class="btn btn-primary">Location</a>
        <a href="${pageContext.request.contextPath}/mob/all" class="btn btn-primary">Mob</a>
        <a href="${pageContext.request.contextPath}/boss/all" class="btn btn-primary">Boss</a>
        <a href="${pageContext.request.contextPath}/equipment/all" class="btn btn-primary">Equipment</a>
    </div>
</div>


<div class="container">
    <p>
    <div class="btn-group">
        <a style=" font-size: 10px"
           href="${pageContext.request.contextPath}/calculator" class="btn btn-primary">Calculator</a>
    </div>
</div>

</body>
</html>