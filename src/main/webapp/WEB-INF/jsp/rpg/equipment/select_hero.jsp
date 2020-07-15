<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div align="center" id="tableMargin">
    <h1>Select Hero</h1>
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
        <tr>
            <th>Id</th>
            <th>Class</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Min Spell Damage</th>
            <th>Max Spell Damage</th>
            <th>Restore Hp</th>
            <th>Mana</th>
            <th>Armor type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hero" items="${heroes}">
        <tr>
            <td>${hero.id}</td>
            <td><c:forEach items="${hero.classes}" var="className">${className.className}</c:forEach>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td>${hero.minSpell}</td>
            <td>${hero.maxSpell}</td>
            <td>${hero.restore}</td>
            <td>${hero.mana}</td
            <td></td>
            <td>
                <c:forEach items="${hero.armors}" var="armor">${armor.armorName}</c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/game/hero/select/<c:out value='${hero.id}'/>">
                    <button class="buttonStyle" style="background-color: forestgreen"> Choose</button>
                </a>
            </td>
            </c:forEach>
        </tbody>

    </table>
</div>

</body>
</html>