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
                <th>LEVEL_DIFFICULT_PERCENT:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="LEVEL_DIFFICULT_PERCENT" maxlength="3" size="3"
                               value="<c:out value='${settingTable.LEVEL_DIFFICULT_PERCENT}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>HEAL_CAST_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="HEAL_CAST_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.HEAL_CAST_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>RESTORE_HP_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="RESTORE_HP_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.RESTORE_HP_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>ENERGY_HIT_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="ENERGY_HIT_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.ENERGY_HIT_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>ENERGY_MULTIPLY_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="ENERGY_MULTIPLY_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.ENERGY_MULTIPLY_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>SUPER_DAMAGE_MULTIPLY_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="SUPER_DAMAGE_MULTIPLY_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.SUPER_DAMAGE_MULTIPLY_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>LEVEL_COUNT_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="LEVEL_COUNT_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.LEVEL_COUNT_INDEX}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>GAME_WITHOUT_EQUIP_INDEX:
                    <small>
                        <a href="#" data-toggle="tooltip" title="some information about ">about</a>
                    </small>
                </th>
                <td>
                    <label>
                        <input required type="text" name="GAME_WITHOUT_EQUIP_INDEX" maxlength="3" size="3"
                               value="<c:out value='${settingTable.GAME_WITHOUT_EQUIP_INDEX}' />"
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