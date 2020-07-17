<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Game Mode</title>
</head>
<body>

<a style="margin-left: 100px" href="${pageContext.request.contextPath}/game/hero/select">
    <button> Back to Heroes List</button>
</a>

<div style="text-align: center;">
    <h3>You selected ${hero.name}, Class ${heroClass}</h3>
    <br>
    <a href="/game/equipment/get/<c:out value='${armorId}'/>">
        <button type="button" class="btn btn-primary">Game with equipments</button>
    </a>
    <a href="${pageContext.request.contextPath}/game/menu/mode/without-equipment">
        <button type="button" class="btn btn-primary">Game without equipments</button>
    </a>
    <br>
    <small>
        <a href="#" data-toggle="tooltip" title="some information about game with or without equipments!">about</a>
    </small>
</div>
</body>
</html>
