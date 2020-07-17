<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Equipments List</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div align="center" id="tableMargin">
    <c:if test="${typeId == 1}"><h1>Select Head Armor</h1></c:if>
    <c:if test="${typeId == 2}"><h1>Select Shoulder Armor</h1></c:if>
    <c:if test="${typeId == 3}"><h1>Select Chest Armor</h1></c:if>
    <c:if test="${typeId == 4}"><h1>Select Legs Armor</h1></c:if>
    <c:if test="${type == 5}"><h1>Select Wand</h1></c:if>
    <c:if test="${type == 6}"><h1>Select Sword</h1></c:if>
    <c:if test="${type == 7}"><h1>Select Shield</h1></c:if>
    <c:if test="${type == 8}"><h1>Select Amulet</h1></c:if>
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
      <h3>Current characteristics of your hero:</h3>
        <p><b>
            Hp: ${hero.hp},
            Damage: ${hero.damage},
            Energy: ${hero.energy},
            Energy Restoration: ${hero.energyRes}
            Min Spell ${hero.minSpell},
            Max Spell ${hero.maxSpell},
            Restore Hp ${hero.restore},
            Mana: ${hero.mana},
            Mana Restoration: ${hero.manaRes}</b></p>
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
            <c:if test="${typeId <= 4}">
                <th>Armor Type</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="equip" items="${equipment}">
            <tr>
                <td>${equip.id}</td>
                <td>${equip.name}</td>
                <td>${equip.hp}</td>
                <td>${equip.damage}</td>
                <td>${equip.energy}</td>
                <td>${equip.energyRes}</td>
                <td>${equip.spell_damage}</td>
                <td>${equip.mana}</td>
                <td>${equip.manaRes}</td>
                <td><c:forEach items="${equip.types}" var="type">${type.type}</c:forEach></td>
                <c:if test="${typeId <= 4}">
                    <td><c:forEach items="${equip.armors}" var="armor">${armor.armorName}</c:forEach></td>
                </c:if>
                <td class="optionWidth">
                    <a href="${pageContext.request.contextPath}/game/equipment/save/
                                                         <c:out value='${armorId}'/>
                                                         /<c:out value='${equip.id}'/>">
                        <button class="buttonStyle" style="background-color: forestgreen"> Choose</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>