<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>

    <style>
        textarea {
            font-size: .8rem;
            letter-spacing: 1px;
        }

        textarea {
            padding: 10px;
            line-height: 1.5;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-shadow: 1px 1px 1px #999;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        div {
            margin-left: 5px;
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Profile</title>

</head>
<body>


<div style="margin-left:80px">
    <h1 style="margin-top: 10px">Change password</h1><br>
    <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/account/edit-password/">

        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
        </c:if>

        <div>
            <label><strong> Current password: </strong>
                <input required type="password" name="currentPassword"
                       value="<c:out value='${user.password_current}'/>"/>
            </label><br><br>
        </div>

        <div>
            <label><strong> New password: </strong>
                <input required type="password" name="newPassword"
                       value="<c:out value='${user.password_new}'/>"/>
            </label><br>

            <label><strong> Confirm password: </strong>
                <input required type="password" name="passwordConfirm"
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
               href="${pageContext.request.contextPath}/account/user/<c:out value='${user.id}'/>">Back</a>
        </div>


    </form>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>