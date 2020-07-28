<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <link href="${pageContext.request.contextPath}/css/profile.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="margin-left: 50px">
<%--    <c:forEach items="${user.profile}" var="profile">--%>
<%--        <form method="post">--%>
<%--            <fieldset>--%>
<%--                <h1>Account</h1>--%>
<%--                <th><strong> Username:</strong> ${user.username}</th>--%>
<%--                <br>--%>
<%--                <div class="btn-group">--%>
<%--                    <a style="width: 250px" class="btn btn-primary"--%>
<%--                       href="${pageContext.request.contextPath}/account/edit-username">Change--%>
<%--                        username</a>--%>
<%--                    <a style="width: 250px" class="btn btn-primary"--%>
<%--                       href="${pageContext.request.contextPath}/account/edit-password">Change--%>
<%--                        password</a>--%>
<%--                </div>--%>

<%--                <h1 style="margin-top: 30px">Contact Information</h1>--%>
<%--                <th><strong> Name:</strong> ${profile.name}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Surname:</strong> ${profile.surname}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Email:</strong> ${user.email}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Birthday:</strong> ${profile.birthday}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Gender:</strong> ${profile.gender}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Phone:</strong> ${profile.phone}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Country:</strong> ${profile.country}</th>--%>
<%--                <br>--%>
<%--                <th><strong> City:</strong> ${profile.city}</th>--%>
<%--                <br>--%>
<%--                <th><strong> Zip:</strong> ${profile.zip}</th>--%>
<%--                <br>--%>
<%--            </fieldset>--%>

<%--            <fieldset>--%>
<%--                <th>--%>
<%--                    <strong>Bio:</strong>--%>
<%--                    <label>--%>
<%--                        <textarea readonly rows="5" cols="60"> ${profile.bio} </textarea>--%>
<%--                    </label>--%>
<%--                </th>--%>
<%--            </fieldset>--%>

<%--            <div class="imagePosition">--%>
<%--                <h1> Avatar</h1>--%>
<%--                <div class="image">--%>
<%--                    <img style="width: 350px" alt="User Avatar" src="<c:url value="/ava/${profile.avatar}"/>"/>--%>
<%--                </div>--%>
<%--                <a style="width: 250px" class="btn btn-primary"--%>
<%--                   href="${pageContext.request.contextPath}/account/edit-avatar">Edit--%>
<%--                    Avatar</a>--%>
<%--            </div>--%>
<%--        </form>--%>

<%--    </c:forEach>--%>



        <form method="post">
            <fieldset>
                <h1>Account</h1>
                <th><strong> Username:</strong> ${user_profile.username}</th>
                <br>
                <div class="btn-group">
                    <a style="width: 250px" class="btn btn-primary"
                       href="${pageContext.request.contextPath}/account/edit-username">Change
                        username</a>
                    <a style="width: 250px" class="btn btn-primary"
                       href="${pageContext.request.contextPath}/account/edit-password">Change
                        password</a>
                </div>

                <h1 style="margin-top: 30px">Contact Information</h1>
                <th><strong> Name:</strong> ${user_profile.name}</th>
                <br>
                <th><strong> Surname:</strong> ${user_profile.surname}</th>
                <br>
                <th><strong> Email:</strong> ${user_profile.email}</th>
                <br>
                <th><strong> Birthday:</strong> ${user_profile.birthday}</th>
                <br>
                <th><strong> Gender:</strong> ${user_profile.gender}</th>
                <br>
                <th><strong> Phone:</strong> ${user_profile.phone}</th>
                <br>
                <th><strong> Country:</strong> ${user_profile.country}</th>
                <br>
                <th><strong> City:</strong> ${user_profile.city}</th>
                <br>
                <th><strong> Zip:</strong> ${user_profile.zip}</th>
                <br>
            </fieldset>

            <fieldset>
                <th>
                    <strong>Bio:</strong>
                    <label>
                        <textarea readonly rows="5" cols="60"> ${user_profile.bio} </textarea>
                    </label>
                </th>
            </fieldset>

            <div class="imagePosition">
                <h1> Avatar</h1>
                <div class="image">
                    <img style="width: 350px" alt="User Avatar" src="<c:url value="/ava/${user_profile.avatar}"/>"/>
                </div>
                <a style="width: 250px" class="btn btn-primary"
                   href="${pageContext.request.contextPath}/account/edit-avatar">Edit
                    Avatar</a>
            </div>
        </form>






    <a style="width: 250px" class="btn btn-primary"
       href="${pageContext.request.contextPath}/account/edit-info">Edit Contact Information</a>
</div>

</body>
</html>
