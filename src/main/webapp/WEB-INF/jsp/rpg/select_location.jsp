<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Location List</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>

</head>
<body>

<div align="center" id="tableMargin">
    <h1>Select Location</h1>
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
            <th colspan="2"><h4>location</h4></th>
            <th colspan="6"><h4>For Hero</h4></th>
            <th colspan="3"><h4>For Creature</h4></th>
        </tr>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>HP</th>
            <th>Damage</th>
            <th>Energy</th>
            <th>Spell Damage</th>
            <th>Restore HP</th>
            <th>Mana</th>
            <th>HP</th>
            <th>Damage</th>
            <th>Chance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="location" items="${location}">
        <tr>
            <td>${location.id}</td>
            <td>${location.name}</td>
            <td>${location.heroHp}</td>
            <td>${location.heroDamage}</td>
            <td>${location.heroEnergy}</td>
            <td>${location.heroSpellDamage}</td>
            <td>${location.heroRestoreHealth}</td>
            <td>${location.heroMana}</td>
            <td>${location.creatureHp}</td>
            <td>${location.creatureDamage}</td>
            <td>${location.creatureChance}</td>
            <td class="optionWidth">
                <a href="${pageContext.request.contextPath}/game/location/save/<c:out value='${location.id}'/>">
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