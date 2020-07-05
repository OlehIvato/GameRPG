<!doctype html>
<html lang="en">
<head>
    <title>Location Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
<%@include file="/WEB-INF/jsp/bootstrap.jsp" %>


<div style="text-align: center"><h1>Location Database</h1></div>
<a style="margin-left: 100px" href="${pageContext.request.contextPath}/welcome">
    <button> Back</button>
</a>

<div align="center" id="tableMargin">
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Hero HP</th>
            <th>Hero Damage</th>
            <th>Hero Spell Damage</th>
            <th>Hero Restore HP</th>
            <th class="verticalLineForLocationTable">Creature HP</th>
            <th>Creature Damage</th>
            <th>Creature Chance</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="location" items="${locations}">
            <tr>
                <td>${location.id}</td>
                <td>${location.name}</td>
                <td>${location.heroHp}</td>
                <td>${location.heroDamage}</td>
                <td>${location.heroSpellDamage}</td>
                <td>${location.heroRestoreHealth}</td>
                <td class="verticalLineForLocationTable">${location.creatureHp}</td>
                <td>${location.creatureDamage}</td>

                <td>${location.creatureChance}</td>

                <sec:authorize access="hasRole('ADMIN')">
                    <td>
                        <a href="${pageContext.request.contextPath}/location/update/<c:out value='${location.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/location/delete/<c:out value='${location.id}'/>">
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
            <th>Hero HP</th>
            <th>Hero Damage</th>
            <th>Hero Spell Damage</th>
            <th>Hero Restore HP</th>
            <th class="verticalLineForLocationTable">Creature HP</th>
            <th>Creature Damage</th>
            <th>Creature Chance</th>
        </tr>
        </tfoot>
    </table>
</div>


<sec:authorize access="hasRole('ADMIN')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/location/create">Create
        new Location</a></button>
</sec:authorize>

</body>
</html>