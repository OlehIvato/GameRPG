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

    <title>Hero Updating</title>
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
                    <button class="button" type="submit" value="Save">Save</button>
                    <button class="button" style="background-color: crimson"><a style="color: #ffffff"
                                                                                href="${pageContext.request.contextPath}/hero/all">Back</a>
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