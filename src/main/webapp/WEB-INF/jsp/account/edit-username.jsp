<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <link href="${pageContext.request.contextPath}/css/account_edit.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div style="margin-left:80px">
    <h1 style="margin-top: 10px">Change Username</h1><br>
    <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/account/edit-username" >

<%--        <c:if test="${user_profile != null}">--%>
<%--            <input type="hidden" name="username" value="<c:out value='${user_profile.username}' />"/>--%>
<%--        </c:if>--%>

<%--      <input type="hidden" name="userID" value="<c:out value='${user_profile.userID}'/>"/>--%>

        <label><strong> Username: </strong>
            <input style="margin-left: 5px" type="text" name="username" placeholder="Username..."
                   value="<c:out value='${user_profile.username}'/>"/>
                ${userError}

        </label><br>

        <div class="btn-group">
            <button class="btn btn-primary" type="submit" value="Save">Save</button>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/account/user">Back</a>
        </div>

    </form>
</div>
</body>
</html>