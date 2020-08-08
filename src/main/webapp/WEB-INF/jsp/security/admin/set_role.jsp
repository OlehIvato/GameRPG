<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Role Updating</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Role Updating</h1></div>
<div align="center">
    <form action="${pageContext.request.contextPath}/admin/set-role" method="post">
        <table>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <input type="hidden" name="username" value="<c:out value='${user.username}'/>"/>
            <tr>
                <label><strong> User ID: </strong>
                    <strong>
                        <input style="border: 0" readonly type="number" name="id" maxlength="3" size="3"
                               value="<c:out value='${user.id}'/>"/>
                    </strong>
                </label>
            </tr>
            <tr>
                <label><strong> Role: </strong>
                    <select name="role_id">
                        <option hidden selected value="<c:out value='${user.role_id}'/>">${user.role.name} </option>
                        <option value="1">ROLE_ADMIN</option>
                        <option value="2">ROLE_MODERATOR</option>
                        <option value="3">ROLE_USER</option>
                    </select>
                </label>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="buttonStyle" type="submit" style="background-color: #4CAF50" value="Save">Save
                    </button>
                    <a href="${pageContext.request.contextPath}/admin/user-list">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>