<!doctype html>
<html lang="en">
<head>

    <title>Calculator</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet" />

</head>
<body>
<%@include file="navBar.jsp" %>
<%@include file="bootstrap.jsp" %>

<div style="text-align: center"><h1>Calculator</h1></div>


<button style="margin-left: 100px"><a href="/welcome">Back</a></button>

<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/calculator" method="post">
        <input placeholder="a" type="text" size="5" name="a" value="<c:out value='${calculator.a}'/>"/>
        <input placeholder="b" type="text" size="5" name="b" value="<c:out value='${calculator.b}'/>"/>

        <p>
            <input type="submit" class="button" name="add" value="+"/>
            <input type="submit" class="button" name="subtract" value="-"/>
            <input type="submit" class="button" name="multiply" value="*"/>
            <input type="submit" class="button" name="divide" value="/"/>
        </p>

        <h1> ${result} </h1>

    </form>
</div>
</body>
</html>

