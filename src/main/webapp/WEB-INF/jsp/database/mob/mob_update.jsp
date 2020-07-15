<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Mob Updating</title>
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Mob Updating</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/mob/update/" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${mobs != null}">
                <input type="hidden" name="id" value="<c:out value='${mobs.id}' />"/>
            </c:if>
            <tr>
                <label>
                    <input hidden type="number" name="id" value="<c:out value='${mobs.id}' />"/>
                </label>
            </tr>

            <tr>
                <th>Name:</th>
                <td>
                    <label>
                        <input required type="text" name="name" maxlength="30" size="15"
                               value="<c:out value='${mobs.name}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Health Point:</th>
                <td>
                    <label>
                        <input required type="text" name="hp" maxlength="3" size="3"
                               value="<c:out value='${mobs.hp}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Min Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="minDamage" maxlength="3" size="3"
                               value="<c:out value='${mobs.minDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Max Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="maxDamage" maxlength="3" size="3"
                               value="<c:out value='${mobs.maxDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Chance To Super Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="chanceToSuperDamage" maxlength="3" size="3"
                               value="<c:out value='${mobs.chanceToSuperDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" type="submit" style="background-color: crimson"><a style="color: #ffffff"
                                                                                              href="/mob/all">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>