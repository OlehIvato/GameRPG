<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>

    <title>Equipment Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Equipment Database</h1></div>

<a style="margin-left: 100px" href="${pageContext.request.contextPath}/welcome">
    <button> Back</button>
</a>

<div align="center" id="tableMargin">
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Energy</th>
            <th>Energy Restoration</th>
            <th style="width: content-box">Spell Damage</th>
            <th>Mana</th>
            <th>Mana Restoration</th>
            <th>Type</th>
            <th>Armor Type</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="equip" items="${equipment}">
            <tr>
                <td>${equip.id}</td>
                <td>${equip.name}</td>
                <td style="text-align: center">${equip.hp}</td>
                <td>${equip.damage}</td>
                <td>${equip.energy}</td>
                <td>${equip.energyRes}</td>
                <td>${equip.spell_damage}</td>
                <td>${equip.mana}</td>
                <td>${equip.manaRes}</td>
                <td>${equip.type.type}</td>
                <td>${equip.armor.armorName}</td>
                <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/equipment/update/<c:out value='${equip.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                        </a>
                    </td>
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/equipment/delete/<c:out value='${equip.id}'/>">
                            <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                        </a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Energy</th>
            <th>Energy Restoration</th>
            <th>Spell Damage</th>
            <th>Mana</th>
            <th>Mana Restoration</th>
            <th>Type</th>
            <th>Armor Type</th>
        </tr>
        </tfoot>
    </table>
</div>
<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/equipment/create">Create
        new Equipment</a></button>
</sec:authorize>

</body>
</html>