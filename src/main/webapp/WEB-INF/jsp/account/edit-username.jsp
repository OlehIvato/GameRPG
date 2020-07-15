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

        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
        </c:if>

        <label><strong> Username: </strong>
            <input style="margin-left: 5px" type="text" name="username" placeholder="Username..."
                   value="<c:out value='${user.username}'/>"/>
                ${userError}

        </label><br>

        <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
        <input type="hidden" name="password" value="<c:out value='${user.password}'/>"/>
        <input type="hidden" name="email" value="<c:out value='${user.email}'/>"/>

        <input type="hidden" name="user_id" value="<c:out value='${user_roles.user_id}'/>"/>
        <input type="hidden" name="roles_id" value="<c:out value='${user_roles.roles_id}'/>"/>
        <input type="hidden" name="user_id" value="<c:out value='${user_profile.user_id}'/>"/>
        <input type="hidden" name="profile_id" value="<c:out value='${user_profile.profile_id}'/>"/>

        <div class="btn-group">
            <button class="btn btn-primary" type="submit" value="Save">Save</button>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/account/user">Back</a>
        </div>


    </form>
</div>
</body>
</html>