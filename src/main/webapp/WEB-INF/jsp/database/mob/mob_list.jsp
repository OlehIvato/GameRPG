<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Mob Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div style="text-align: center"><h1>Mob Database</h1></div>

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
            <th>Change To Super Damage</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mob" items="${mobs}">
            <tr>
                <td>${mob.id}</td>
                <td>${mob.name}</td>
                <td>${mob.hp}</td>
                <td>${mob.minDamage}</td>
                <td>${mob.maxDamage}</td>
                <td>${mob.chanceToSuperDamage}</td>

                <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                    <td><a href="${pageContext.request.contextPath}/mob/update/<c:out value='${mob.id}'/>">
                        <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                    </a></td>
                    <td><a href="${pageContext.request.contextPath}/mob/delete/<c:out value='${mob.id}'/>">
                        <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                    </a></td>
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
            <th>Change To Super Damage</th>
        </tr>
        </tfoot>
    </table>
</div>

<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/mob/create">Create new
        Mob</a></button>
</sec:authorize>

</body>
</html>