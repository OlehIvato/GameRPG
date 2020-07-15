<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Forbidden Move</title>
</head>
<body>

<div style="text-align: center;">
    <h1>Forbidden</h1>
    <h1>You cant do that </h1>
</div>

<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/game/hero/select">
        <button type="button" class="btn btn-primary">Create new Hero</button>
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/game/menu/continue-game">
        <button type="button" class="btn btn-secondary">Continue Game</button>
    </a>
</div>


</body>
</html>