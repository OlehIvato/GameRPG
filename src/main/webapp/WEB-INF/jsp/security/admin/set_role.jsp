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
            <c:if test="${user_roles != null}">
                <input type="hidden" name="id" value="<c:out value='${user_roles.user_id}' />"/>
            </c:if>
            <tr>
                <label><strong> User ID: </strong>
                    <strong>
                        <input style="border: 0" readonly type="number" name="user_id" maxlength="3" size="3"
                               value="<c:out value='${user_roles.user_id}'/>"/>
                    </strong>
                </label>
            </tr>
            <tr>
                <label><strong> Role: </strong>
                    <select name="roles_id">
                        <option hidden selected value="<c:out value='${user_roles.roles_id}'/>">${role.name} </option>
                        <option value="2">ROLE_MODERATOR</option>
                        <option value="3">ROLE_USER</option>
                    </select>
                </label>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a>
                        <button class="buttonStyle" type="submit" style="background-color: #4CAF50" value="Save">Save
                        </button>
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/user-list">
                        <button class="buttonStyle" style="background-color: crimson">Back</button>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>