<!doctype html>
<html lang="en">
<head>

    <style>
        .bs-example{
            margin: 0px;
        }
        hr.redLine {
            border: 4px solid red;
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Main</title>
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
                <a href="/entry" class="nav-item nav-link active">Home</a>
                <a href="/info" class="nav-item nav-link">About Game</a>
            </div>
        </div>
    </nav>
    <hr class="redLine" style="margin-top:0px">
</div>
<div style="text-align: center;"> <h1 id="main">Main</h1> </div>










<div class="container">
    <h2>Databases</h2>
    <p>see all list / delete / update / create</p>
    <div class="btn-group">
        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/hero/all" class="btn btn-primary">Hero</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/location/all" class="btn btn-primary">Location</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/mob/all" class="btn btn-primary">Mob</a>

        <a style="padding-bottom: 4px;padding-top: 6px;border-bottom-width: 0px;border-top-width: 0px;height: 40px;"
           href="${pageContext.request.contextPath}/boss/all" class="btn btn-primary">Boss</a>
    </div>
</div>













<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>