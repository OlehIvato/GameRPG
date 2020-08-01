<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Change Your Image</title>
</head>
<body>
<h1 style="margin-left: 50px">Upload An Image</h1><br>
<form action="${pageContext.request.contextPath}/account/edit-avatar" method="post" enctype="multipart/form-data">

    <c:if test="${user_profile != null}">
        <input type="hidden" name="username" value="<c:out value='${user_profile.username}' />"/>
    </c:if>

    <label style="margin-left: 50px">
        <input name="ava" id="ava" type="file" value="<c:out value='${user_profile.avatar}'/>">
    </label><br><br>

    <div style="margin-left: 50px">
        <button class="buttonStyle" style="background-color: forestgreen" type="submit" value="Save">Save</button>

        <button class="buttonStyle" style="background-color: cornflowerblue"
                href="${pageContext.request.contextPath}/account/user">Back
        </button>

        <a style="color: #ff3030"
           href="${pageContext.request.contextPath}/account/delete-avatar">Delete
        </a>
    </div>
</form>

</body>
</html>