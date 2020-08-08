<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <style type="text/css">
        .showImage {
            position: center;
            cursor: auto;
            display: inline-block;
        }

        .showImage img + img {
            position: absolute;
            left: 0px;
            top: 0px;
            z-index: 100;
            display: none;
        }

        .showImage:hover img + img {
            display: block;
        }
    </style>

    <title>Hero Database</title>
    <link href="${pageContext.request.contextPath}/css/tablesStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Hero Database</h1></div>

<a style="margin-left: 100px" href="${pageContext.request.contextPath}/welcome">
    <button> Back</button>
</a>
<div align="center" id="tableMargin">
    <table class="table table-striped table-bordered table-sm" id="tableSize">
        <thead>
        <tr>
            <th>Id</th>
            <th>Class</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Energy</th>
            <th>Energy Restoration</th>
            <th>Min Spell Damage</th>
            <th>Max Spell Damage</th>
            <th>Restore Hp</th>
            <th>Mana</th>
            <th>Mana Restoration</th>
            <th>Armor type</th>
            <th>Hero Image</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hero" items="${heroes}">
            <tr>
                <td>${hero.id}</td>
                <td>${hero.classes.className}</td>
                <td>${hero.name}</td>
                <td>${hero.hp}</td>
                <td>${hero.damage}</td>
                <td>${hero.energy}</td>
                <td>${hero.energyRes}</td>
                <td>${hero.minSpell}</td>
                <td>${hero.maxSpell}</td>
                <td>${hero.restore}</td>
                <td>${hero.mana}</td
                <td></td>
                <td>${hero.manaRes}</td>
                <td>${hero.armor.armorName}</td>
                <td>
                    <div class="showImage">
                        <img style="width: 60px" src="/heroImg/${hero.image}" alt="Image"/>
                        <img width="50%" src="/heroImg/${hero.image}" alt="Image"/>
                    </div>
                </td>
                <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/hero/update/<c:out value='${hero.id}'/>">
                            <button class="buttonStyle" style="background-color: forestgreen"> Edit</button>
                        </a>
                    </td>

                    <td class="optionWidth">
                        <a href="${pageContext.request.contextPath}/hero/delete/<c:out value='${hero.id}'/>">
                            <button class="buttonStyle" style="background-color: darkred"> Delete</button>
                        </a>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>Id</th>
            <th>Class</th>
            <th>Name</th>
            <th>Health Point</th>
            <th>Damage</th>
            <th>Energy</th>
            <th>Energy Restoration</th>
            <th>Min Spell Damage</th>
            <th>Max Spell Damage</th>
            <th>Restore Hp</th>
            <th>Mana</th>
            <th>Mana Restoration</th>
            <th>Armor type</th>
            <th>Logo</th>
        </tr>
        </tfoot>
    </table>
</div>
<sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
    <button class="btn" style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/hero/create">Create new
        Hero</a></button>
</sec:authorize>

</body>
</html>