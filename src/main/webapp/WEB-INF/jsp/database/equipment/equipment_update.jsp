<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Equipment Updating</title>
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div style="text-align: center"><h1>Equipment Updating</h1></div>
<hr class="redLine">

<div align="center">
    <form action="${pageContext.request.contextPath}/equipment/update/" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${equipment != null}">
                <input type="hidden" name="id" value="<c:out value='${equipment.id}' />"/>
            </c:if>

            <tr>
                <label>
                    <input hidden type="number" name="id"
                           value="<c:out value='${equipment.id}' />"/>
                </label>
            </tr>

            <tr>
                <th>Name:</th>
                <td>
                    <label>
                        <input type="text" name="name" maxlength="30" size="15"
                               value="<c:out value='${equipment.name}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Health Point:</th>
                <td>
                    <label>
                        <input type="text" name="hp" maxlength="3" size="3"
                               value="<c:out value='${equipment.hp}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Damage:</th>
                <td>
                    <label>
                        <input type="text" name="damage" maxlength="3" size="3"
                               value="<c:out value='${equipment.damage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Enegry:</th>
                <td>
                    <label>
                        <input type="text" name="energy" maxlength="3" size="3"
                               value="<c:out value='${equipment.energy}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Energy Restoration:</th>
                <td>
                    <label>
                        <input type="text" name="energyRes" maxlength="3" size="3"
                               value="<c:out value='${equipment.energyRes}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Spell Damage:</th>
                <td>
                    <label>
                        <input type="text" name="spell_damage" maxlength="3" size="3"
                               value="<c:out value='${equipment.spell_damage}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Mana:</th>
                <td>
                    <label>
                        <input type="text" name="mana" maxlength="3" size="3"
                               value="<c:out value='${equipment.mana}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Mana Restoration:</th>
                <td>
                    <label>
                        <input type="text" name="manaRes" maxlength="3" size="3"
                               value="<c:out value='${equipment.manaRes}' />"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Type:</th>
                <td>
                    <label>
                        <select name="types_id">
                            <option hidden selected value='${equipment_type.types_id}'>
                                <c:forEach
                                        items="${equipment.types}" var="type">${type.type}
                                </c:forEach>
                            </option>
                            <option value='1'>Head</option>
                            <option value='2'>Shoulder</option>
                            <option value='3'>Chest</option>
                            <option value='4'>Legs</option>
                            <option value='5'>Wand</option>
                            <option value='6'>Sword</option>
                            <option value='7'>Shield</option>
                            <option value='8'>Amulet</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <th>Armor Type:</th>
                <td>
                    <label>
                        <select size="1" name="armors_id">
                            <option hidden selected value='${equipment_armor.armors_id}'>
                                <c:forEach
                                        items="${equipment.armors}" var="armor">${armor.armorName}
                                </c:forEach>
                            </option>
                            <option value='4'>Weapon</option>
                            <option value='1'>Cloth</option>
                            <option value='2'>Leather</option>
                            <option value='3'>Plate</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" type="submit" style="background-color: crimson">
                        <a style="color: #ffffff" href="${pageContext.request.contextPath}/equipment/all">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>