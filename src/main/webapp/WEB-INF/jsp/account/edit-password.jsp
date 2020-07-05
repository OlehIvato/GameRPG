<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <link href="${pageContext.request.contextPath}/css/account_edit.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
<%@include file="/WEB-INF/jsp/bootstrap.jsp" %>

<div style="margin-left:80px">
    <h1 style="margin-top: 10px">Change password</h1><br>

    <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/account/edit-password">

        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
        </c:if>

        <div>
            <label>
                <strong> Current password: </strong>
                <input required type="password" name="password_current"
                       value="<c:out value='${user.password_current}'/>"/>
            </label>
            <br><br>
        </div>

        <div>
            <label>
                <strong> New password: </strong>
                <input required type="password" name="password_new"
                       value="<c:out value='${user.password_new}'/>"/>
            </label>
            <br>

            <label>
                <strong> Confirm password: </strong>
                <input required type="password" name="password_confirm"
                       value="<c:out value='${user.password_confirm}'/>"/>
                ${passwordError}
            </label>
        </div>

        <input type="hidden" name="username" value="<c:out value='${user.username}'/>"/>
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