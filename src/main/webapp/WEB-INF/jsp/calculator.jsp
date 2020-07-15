<%@include file="design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Calculator</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div style="text-align: center"><h1>Calculator</h1></div>

<a href="/welcome">
    <button type="button" class="btn btn-success btn-sm">Back</button>
</a>


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

