<%@include file="design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Main</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>

</head>
<body>
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
<br>

<div class="container">
    <h2>Game</h2>
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/game/menu/main">
            <button type="button" class="btn btn-success btn-lg">Start</button>
        </a>
        <a href="${pageContext.request.contextPath}/game/setting">
            <button type="button" class="btn btn-success btn-sm">Setting</button>
        </a>
    </div>
</div>

<br>
<div class="container">
    <a href="${pageContext.request.contextPath}/calculator">
        <button type="button" class="btn btn-warning">Calculator</button>
    </a>
</div>

</body>
</html>