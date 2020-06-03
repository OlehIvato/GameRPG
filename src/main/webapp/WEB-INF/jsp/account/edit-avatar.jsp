<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>

    <title>Change Your Image</title>
</head>
<body>

<h1 style="margin-left: 50px">Upload An Image</h1><br>
<form action="${pageContext.request.contextPath}/account/edit-avatar/" method="post" enctype="multipart/form-data">

    <c:if test="${profile != null}">
        <input type="hidden" name="id" value="<c:out value='${profile.id}' />"/>
    </c:if>


    <label style="margin-left: 50px">
        <input name="ava" id="ava" type="file" value="<c:out value='${profile.avatar}'/>">
    </label><br><br>


    <input type="hidden" name="id" value="<c:out value='${profile.id}'/>"/>
    <input type="hidden" name="name" value="<c:out value='${profile.name}'/>"/>
    <input type="hidden" name="surname" value="<c:out value='${profile.surname}'/>"/>
    <input type="hidden" name="email" value="<c:out value='${user.email}'/>"/>
    <c:if test="${profile.birthday != null}">
        <input type="hidden" name="birthday" value="<c:out value='${profile.birthday}'/>"/>
    </c:if>
    <input type="hidden" name="gender" value="<c:out value='${profile.gender}'/>"/>
    <input type="hidden" name="phone" value="<c:out value='${profile.phone}'/>"/>
    <input type="hidden" name="country" value="<c:out value='${profile.country}'/>"/>
    <input type="hidden" name="city" value="<c:out value='${profile.city}'/>"/>
    <input type="hidden" name="zip" value="<c:out value='${profile.zip}'/>"/>
    <input type="hidden" name="bio" value="<c:out value='${profile.bio}'/>"/>


    <div class="btn-group" style="margin-left: 50px">
        <button style="color: green" class="btn btn-primary" type="submit" value="Save">Save</button>
        <button class="btn btn-primary"
                href="${pageContext.request.contextPath}/account/user/<c:out value='${user.id}'/>">Back
        </button>
        <a style="color: red" href="${pageContext.request.contextPath}/account/delete-avatar/<c:out value='${user.id}'/>">Delete
        </a>
    </div>


</form>


</body>
</html>