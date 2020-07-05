<!doctype html>
<html lang="en">
<head>
    <title>Location Updating</title>
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/navBar.jsp" %>
<%@include file="/WEB-INF/jsp/bootstrap.jsp" %>

<div style="text-align: center"><h1>Location Updating</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/location/update/" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${locations != null}">
                <input type="hidden" name="id" value="<c:out value='${locations.id}' />"/>
            </c:if>
            <tr>
                <label>
                    <input hidden type="number" name="id" value="<c:out value='${locations.id}' />"/>
                </label>
            </tr>

            <tr>
                <th>Location Name:</th>
                <td>
                    <label>
                        <input type="text" name="name" maxlength="30" size="15"
                               value="<c:out value='${locations.name}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Hero HP:</th>
                <td>
                    <label>
                        <input type="text" name="heroHp" maxlength="3" size="3"
                               value="<c:out value='${locations.heroHp}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Hero Damage</th>
                <td>
                    <label>
                        <input type="text" name="heroDamage" maxlength="3" size="3"
                               value="<c:out value='${locations.heroDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Hero Spell Damage:</th>
                <td>
                    <label>
                        <input type="text" name="heroSpellDamage" maxlength="3" size="3"
                               value="<c:out value='${locations.heroSpellDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Hero Restore HP:</th>
                <td>
                    <label>
                        <input type="text" name="heroRestoreHealth" maxlength="3" size="3"
                               value="<c:out value='${locations.heroRestoreHealth}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Creature HP:</th>
                <td>
                    <label>
                        <input type="text" name="creatureHp" maxlength="3" size="3"
                               value="<c:out value='${locations.creatureHp}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Creature Damage:</th>
                <td>
                    <label>
                        <input type="text" name="creatureDamage" maxlength="3" size="3"
                               value="<c:out value='${locations.creatureDamage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Creature Chance to Super Damage:</th>
                <td>
                    <label>
                        <input type="text" name="creatureChance" maxlength="3" size="3"
                               value="<c:out value='${locations.creatureChance}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>

                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" type="submit" style="background-color: crimson"><a style="color: #ffffff"
                                                                                              href="/location/all">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>