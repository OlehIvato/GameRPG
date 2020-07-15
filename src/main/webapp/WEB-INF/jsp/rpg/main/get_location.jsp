<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Location</title>
</head>
<body>

<div style="text-align: center;">
    <h1>Do you want to select Location for game?</h1>
    <a href="${pageContext.request.contextPath}/game/location/show">
        <button type="button" class="btn btn-primary">Yes</button>
    </a>
    <a href="${pageContext.request.contextPath}/game/menu/without-location">
        <button type="button" class="btn btn-primary">No</button>
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/game/hero/select">
        <button type="button" class="btn btn-primary">Create new Hero</button>
    </a>
    <br>
    <br>
    <small>
        <a href="#" data-toggle="tooltip" title="some information about locations">help</a>
    </small>
</div>


</body>
</html>