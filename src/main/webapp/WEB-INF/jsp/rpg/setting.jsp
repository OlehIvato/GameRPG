<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        code {
            border-radius: 6px;
            color: black;
            display: block;
            font: 14px/24px "Source Code Pro", Inconsolata, "Lucida Console", Terminal, "Courier New", Courier;
            padding: 24px 15px;
            text-align: center;
        }

        section {
            display: inline-block;
            width: 30%;
        }
    </style>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Setting</title>
</head>
<body>

<div align="center">
    <form action="${pageContext.request.contextPath}/game/setting/" method="post">
        <header>
            <code>
            </code>
        </header>
        <section>
            <code>
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
                                <input required type="text" name="GAME_WITHOUT_EQUIP_DIFFICULTY" maxlength="3" size="3"
                                       value="<c:out value='${settingTable.GAME_WITHOUT_EQUIP_DIFFICULTY}' />"
                                />
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <button class="button" type="submit" value="Save">Save</button>
                            <h3 style="color: #4CAF50"> ${settingSave} </h3>
                        </td>
                    </tr>
                </table>
            </code>
        </section>

        <section>
            <code>
                <table border="1" cellpadding="5">
                    <thead>
                    <tr>
                        <th>Class</th>
                        <th>Head</th>
                        <th>Shoulder</th>
                        <th>Chest</th>
                        <th>Legs</th>
                        <th>Wand</th>
                        <th>Sword</th>
                        <th>Shield</th>
                        <th>Amulet</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="setting" items="${equipmentSetting}">
                    <tr>
                        <td>
                            <c:forEach items="${setting.className}" var="classes">${classes.className}</c:forEach>
                        </td>
                        <td>${setting.head}</td>
                        <td>${setting.shoulder}</td>
                        <td>${setting.chest}</td>
                        <td>${setting.legs}</td>
                        <td>${setting.wand}</td>
                        <td>${setting.sword}</td>
                        <td>${setting.shield}</td>
                        <td>${setting.amulet}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/game/change-equipment-setting/<c:out value='${setting.id}'/>">Edit
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    <td>
                        <h3 style="color: #4CAF50"> ${equipmentSettingSaved} </h3>
                    </td>
                </table>
            </code>
        </section>
        <footer>
            <code>
                <a href="/welcome">Back</a>
            </code>
        </footer>
    </form>
</div>
</body>
</html>