<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>User Info</title>
    <link href="${pageContext.request.contextPath}/css/textAreaStyle.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/imageStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<div style="text-align: center"><h1>User Info</h1></div>

<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/admin/user-info/" method="post">

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
                    <td>${all_users_info.profile.name}</td>
                    <td>${all_users_info.profile.surname}</td>
                    <td>${all_users_info.email}</td>
                    <td>${all_users_info.profile.birthday}</td>
                    <td>${all_users_info.profile.gender}</td>
                    <td>${all_users_info.profile.phone}</td>
                    <td>${all_users_info.profile.country}</td>
                    <td>${all_users_info.profile.city}</td>
                    <td>${all_users_info.profile.zip}</td>
                    <td><a href="#avatar">show</a></td>
                </tr>
                </tbody>
            </table>

            <div id="avatar">
                <img alt="User Avatar" src="<c:url value="/ava/${all_users_info.profile.avatar}"/>"/>
                <a href="#" class="close">close</a>
            </div>

            <div>
                <h2 style="margin-top: 10px">Bio</h2>
                <label for='test'></label>
                <textarea readonly rows="5" cols="110" name='bio' id='test'>
                    <c:out value="${all_users_info.profile.bio}"/>
                </textarea>
            </div>
    </form>
</div>

<div align="center">
    <a href="${pageContext.request.contextPath}/admin/user-list">
        <button class="buttonStyle" style="background-color: forestgreen">Back to List</button>
    </a>
</div>

</body>
</html>