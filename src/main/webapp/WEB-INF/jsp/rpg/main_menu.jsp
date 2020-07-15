<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<a style="margin-left: 100px" href="${pageContext.request.contextPath}/welcome">
    <button> Back</button>
</a>

<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/game/hero/select">
        <button type="button" class="btn btn-primary">Create new Hero</button>
    </a>
    <a href="${pageContext.request.contextPath}/game/menu/continue-game">
        <button type="button" class="btn btn-primary">Continue Game</button>
    </a>
</div>

</body>
</html>