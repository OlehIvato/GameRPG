<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Setting</title>
</head>
<body>

<div align="center">
    <form action="${pageContext.request.contextPath}/game/setting/" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${settingTable != null}">
                <input type="hidden" name="id" value="<c:out value='${settingTable.id}' />"/>
            </c:if>

            <tr>
                <th>DEFAULT_HEAL_CAST:</th>
                <td>
                    <label>
                        <input required type="text" name="DEFAULT_HEAL_CAST" maxlength="3" size="3"
                               value="<c:out value='${settingTable.DEFAULT_HEAL_CAST}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>DEFAULT_RESTORE_HP_INDEX:
                </th>
                <td>
                    <label>
                        <input required type="text" name="DEFAULT_RESTORE_HP_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.DEFAULT_RESTORE_HP_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>SUPER_DAMAGE:</th>
                <td>
                    <label>
                        <input required type="text" name="SUPER_DAMAGE" maxlength="3" size="3"
                               value="<c:out value='${settingTable.SUPER_DAMAGE}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>LEVEL_COUNT:</th>
                <td>
                    <label>
                        <input required type="text" name="LEVEL_COUNT" maxlength="3" size="3"
                               value="<c:out value='${settingTable.LEVEL_COUNT}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>DEFAULT_GAME_WITHOUT_EQUIP_INDEX:</th>
                <td>
                    <label>
                        <input required type="text" name="DEFAULT_GAME_WITHOUT_EQUIP_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.DEFAULT_GAME_WITHOUT_EQUIP_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" type="submit" style="background-color: crimson">
                        <a style="color: #ffffff" href="/welcome">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>