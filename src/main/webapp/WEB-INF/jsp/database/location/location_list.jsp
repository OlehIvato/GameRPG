<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Location Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<div style="text-align: center"><h1>Location Database</h1></div>
<a style="margin-left: 100px" href="${pageContext.request.contextPath}/welcome">
    <button> Back</button>
</a>

<div align="center" id="tableMargin">


    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
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
        <c:forEach var="location" items="${locations}">
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
                <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/location/update/<c:out value='${location.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                        </a>
                    </td>
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/location/delete/<c:out value='${location.id}'/>">
                            <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                        </a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/location/create">Create
        new Location</a></button>
</sec:authorize>

</body>
</html>