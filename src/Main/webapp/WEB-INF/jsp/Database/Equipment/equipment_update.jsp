<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        hr.redLine {
            border: 3px solid red;
        }

        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            padding-bottom: 7px;
            padding-top: 7px
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Equipment Updating</title>
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
                <th>ID:</th>
                <td>
                    <label>
                        <input readonly type="number" name="id" maxlength="3" size="3"
                               value="<c:out value='${equipment.id}' />"
                        />
                    </label>
                </td>
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
                <th>Type:</th>
                <td>
                    <label>
                        <select size="1" name="types_id">
                            <option id="${type.types_id}" value='1'>Head</option>
                            <option id="${type.types_id}" value='2'>Shoulder</option>
                            <option id="${type.types_id}" value='3'>Chest</option>
                            <option id="${type.types_id}" value='4'>Legs</option>
                            <option id="${type.types_id}" value='5'>Wand</option>
                            <option id="${type.types_id}" value='6'>Sword</option>
                            <option id="${type.types_id}" value='7'>Shield</option>
                            <option id="${type.types_id}" value='8'>Amulets</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <th>Armor Type:</th>
                <td>
                    <label>
                        <select size="1" name="armors_id">
                            <option id="${armors.armors_id}" value='4'>Weapon</option>
                            <option id="${armors.armors_id}" value='1'>Cloth</option>
                            <option id="${armors.armors_id}" value='2'>Leather</option>
                            <option id="${armors.armors_id}" value='3'>Plate</option>
                        </select>
                    </label>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" type="submit" style="background-color: crimson"><a style="color: #ffffff"
                                                                                              href="${pageContext.request.contextPath}/equipment/all">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>