<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <style>
        .bs-example {
            margin: 0px;
        }

        hr.redLine {
            border: 4px solid red;
        }

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

    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Profile</title>

</head>
<body>
<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">RPG Mini Game</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="/welcome" class="nav-item nav-link active">Home</a>
                <a href="/info" class="nav-item nav-link">About Game</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/admin" class="nav-item nav-link">List of Users</a>
                </sec:authorize>
            </div>
        </div>
        <div>


        </div>
        <div style="margin-right: 50px">
            <sec:authorize access="isAuthenticated()">
                <h4>
                    <a style="color: #fffbfb">${pageContext.request.userPrincipal.name}</a>
                    <a style="color: #ff3030" href="/logout">Logout</a>
                </h4>
            </sec:authorize>
        </div>

    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>


<div style="margin-left: 50px">
    <form>
        <fieldset>
            <h1>Account</h1>
            <c:forEach items="${user.profile}" var="profile">
            <th><strong> Username:</strong> ${user.username}</th>
            <br>
            <th><strong> Email:</strong> ${user.email}</th>
            <br>
            <a style="width: 250px" class="btn btn-primary"
               href="${pageContext.request.contextPath}/account/editsecurity/<c:out value='${user.id}'/>">Change security</a>
            <br><br>

            <h1>Contact Information</h1>
            <th><strong> Name:</strong> ${profile.name}</th>
            <br>
            <th><strong> Surname:</strong> ${profile.surname}</th>
            <br>
            <th><strong> Birthday:</strong> ${profile.birthday}</th>
            <br>
            <th><strong> Gender:</strong> ${profile.gender}</th>
            <br>
            <th><strong> Phone:</strong> ${profile.phone}</th>
            <br>
            <th><strong> Country:</strong> ${profile.country}</th>
            <br>
            <th><strong> City:</strong> ${profile.city}</th>
            <br>
            <th><strong> Zip:</strong> ${profile.zip}</th>
            <br>
        </fieldset>

        <fieldset>
            <th><strong>Bio:</strong>
                <label>
                    <textarea rows="5" cols="60"> ${profile.bio} </textarea>
                </label>
            </th>
            <br>

        </fieldset>
        </c:forEach>
    </form>
    <a style="width: 250px" class="btn btn-primary"
       href="${pageContext.request.contextPath}/account/editinfo/<c:out value='${user.id}'/>">Edit Contact Information</a>

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