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
        <input type="hidden" name="id" value="<c:out value='${user_profile.id}' />"/>
    </c:if>

    <label style="margin-left: 50px">
        <input name="ava" id="ava" type="file" value="<c:out value='${user_profile.avatar}'/>">
    </label><br><br>

    <input type="hidden" name="id" value="<c:out value='${user_profile.id}'/>"/>
    <input type="hidden" name="name" value="<c:out value='${user_profile.name}'/>"/>
    <input type="hidden" name="surname" value="<c:out value='${user_profile.surname}'/>"/>
    <input type="hidden" name="email" value="<c:out value='${user_profile.email}'/>"/>
    <c:if test="${user_profile.birthday != null}">
        <input type="hidden" name="birthday" value="<c:out value='${user_profile.birthday}'/>"/>
    </c:if>
    <input type="hidden" name="gender" value="<c:out value='${user_profile.gender}'/>"/>
    <input type="hidden" name="phone" value="<c:out value='${user_profile.phone}'/>"/>
    <input type="hidden" name="country" value="<c:out value='${user_profile.country}'/>"/>
    <input type="hidden" name="city" value="<c:out value='${user_profile.city}'/>"/>
    <input type="hidden" name="zip" value="<c:out value='${user_profile.zip}'/>"/>
    <input type="hidden" name="bio" value="<c:out value='${user_profile.bio}'/>"/>


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