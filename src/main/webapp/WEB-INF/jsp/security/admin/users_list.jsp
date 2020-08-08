<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        td {
            width: 0px;
            padding-left: 0px;
            border-right-width: 0px;
            height: 0px;
            padding-bottom: 0px;
            border-top-width: 0px;
            border-bottom-width: 0px;
            padding-right: 0px;
            padding-top: 0px;
            border-left-width: 0px;
        }
    </style>

    <title>List of Users</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div align="center" id="tableMargin">
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
        <tr>
            <th>ID</th>
            <th>USERNAME</th>
            <th>PASSWORD</th>
            <th>EMAIL</th>
            <th>ROLE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.role.name}</td>

                <sec:authorize access="hasRole('ADMIN')">
                    <td class="optionWidth">
                        <a href="/admin/set-role/<c:out value='${user.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen">Edit</button>
                        </a>
                    </td>
                </sec:authorize>

                <td class="optionWidth">
                    <a href="/admin/user-info/<c:out value='${user.id}'/>">
                        <button class="buttonStyle" style="background-color: forestgreen">Info</button>
                    </a>
                </td>

                <sec:authorize access="hasRole('ADMIN')">
                    <td class="optionWidth">
                        <a href="/admin/remove-user/<c:out value='${user.id}'/>">
                            <button class="buttonStyle" style="background-color: darkred">Delete</button>
                        </a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>ID</th>
            <th>USERNAME</th>
            <th>PASSWORD</th>
            <th>EMAIL</th>
            <th>ROLE</th>
        </tr>
        </tfoot>
    </table>
</div>

</body>
</html>