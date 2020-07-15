<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Hero Updating</title>
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Hero Updating</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/hero/update/" method="post" enctype="multipart/form-data">
        <table border="1" cellpadding="5">
            <c:if test="${heroes != null}">
                <input type="hidden" name="id" value="<c:out value='${heroes.id}' />"/>
            </c:if>
            <tr>
                <label>
                    <input readonly hidden type="number" name="id"
                           value="<c:out value='${heroes.id}' />"/>
                </label>
            </tr>

            <tr>
                <th>Class:</th>
                <td>
                    <label>
                        <select name="class_id">
                            <option selected hidden value='${hero_class.class_id}'>
                                <c:forEach items="${heroes.classes}" var="classes">
                                    ${classes.className}
                                </c:forEach>
                            </option>
                            <option value='1'>Mage</option>
                            <option value='2'>Warrior</option>
                            <option value='3'>Druid</option>
                            <option value='4'>Rogue</option>
                            <option value='5'>Monk</option>
                            <option value='6'>Shaman</option>
                            <option value='7'>Priest</option>
                            <option value='8'>Hunter</option>
                            <option value='9'>Paladin</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <th>Name:</th>
                <td>
                    <label>
                        <input required type="text" name="name" maxlength="30" size="15"
                               value="<c:out value='${heroes.name}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Health Point:</th>
                <td>
                    <label>
                        <input required type="text" name="hp" maxlength="3" size="3"
                               value="<c:out value='${heroes.hp}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="damage" maxlength="3" size="3"
                               value="<c:out value='${heroes.damage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Min Spell Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="minSpell" maxlength="3" size="3"
                               value="<c:out value='${heroes.minSpell}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Max Spell Damage:</th>
                <td>
                    <label>
                        <input required type="text" name="maxSpell" maxlength="3" size="3"
                               value="<c:out value='${heroes.maxSpell}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Restore Health Point:</th>
                <td>
                    <label>
                        <input required type="text" name="restore" maxlength="3" size="3"
                               value="<c:out value='${heroes.restore}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Mana:</th>
                <td>
                    <label>
                        <input required type="text" name="mana" maxlength="3" size="3"
                               value="<c:out value='${heroes.mana}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Armor type:</th>
                <td>
                    <label>
                        <select name="armor_id">
                            <option hidden selected value='${hero_armors.armor_id}'>
                                <c:forEach items="${heroes.armors}" var="armor">
                                    ${armor.armorName}
                                </c:forEach>
                            </option>
                            <option value='1'>Cloth</option>
                            <option value='2'>Leather</option>
                            <option value='3'>Plate</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <th>Hero Image:</th>
                <td>
                    <label>
                        <input name="img" id="img" type="file" value="<c:out value='${heroes.image}'/>">
                    </label>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="button" style="background-color: green" type="submit" value="Save">Save</button>
                    <a class="button" style="background-color: red" href="${pageContext.request.contextPath}/hero/all">Back</a>
                </td>
            </tr>


        </table>
    </form>
</div>
</body>
</html>