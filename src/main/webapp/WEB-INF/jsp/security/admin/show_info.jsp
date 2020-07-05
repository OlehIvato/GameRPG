<!doctype html>
<html lang="en">
<head>
    <title>User Info</title>
    <link href="${pageContext.request.contextPath}/css/textAreaStyle.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/imageStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
<%@include file="/WEB-INF/jsp/bootstrap.jsp" %>

<div style="text-align: center"><h1>User Info</h1></div>

<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/admin/userinfo/" method="post">
        <c:forEach items="${all_users_info.profile}" var="profile">
            <table border="1" cellpadding="5">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Email</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Zip</th>
                    <th>Avatar</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${profile.name}</td>
                    <td>${profile.surname}</td>
                    <td>${all_users_info.email}</td>
                    <td>${profile.birthday}</td>
                    <td>${profile.gender}</td>
                    <td>${profile.phone}</td>
                    <td>${profile.country}</td>
                    <td>${profile.city}</td>
                    <td>${profile.zip}</td>
                    <td><a href="#avatar">show</a></td>
                </tr>
                </tbody>
            </table>

            <div id="avatar">
                <img alt="User Avatar" src="<c:url value="/ava/${profile.avatar}"/>"/>
                <a href="#" class="close">close</a>
            </div>

            <div>
                <h2 style="margin-top: 10px">Bio</h2>
                <label for='test'></label>
                <textarea readonly rows="5" cols="110" name='bio' id='test'>
                    <c:out value="${profile.bio}"/>
                </textarea>
            </div>
        </c:forEach>
    </form>
</div>

<div align="center">
    <a href="/admin/userlist">
        <button class="buttonStyle" style="background-color: forestgreen">Back to List</button>
    </a>
</div>

</body>
</html>