<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Boss Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Boss Database</h1></div>
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
            <th>Min Damage</th>
            <th>Max Damage</th>
            <th>Restore HP</th>
            <th>Change To Super Damage</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="boss" items="${bosses}">
            <tr>
                <td>${boss.id}</td>
                <td>${boss.name}</td>
                <td>${boss.hp}</td>
                <td>${boss.minDamage}</td>
                <td>${boss.maxDamage}</td>
                <td>${boss.restoreHealth}</td>
                <td>${boss.chanceToSuperDamage}</td>
                <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/boss/update/<c:out value='${boss.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                        </a>
                    </td>
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/boss/delete/<c:out value='${boss.id}'/>">
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
            <th>Min Damage</th>
            <th>Max Damage</th>
            <th>Restore HP</th>
            <th>Change To Super Damage</th>
        </tr>
        </tfoot>
    </table>
</div>
<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/boss/create">Create new
        Boss</a></button>
</sec:authorize>

</body>
</html>