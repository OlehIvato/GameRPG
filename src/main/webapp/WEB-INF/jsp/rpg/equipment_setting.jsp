<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Menu</title>
</head>
<body>

<div align="center">
    <form action="${pageContext.request.contextPath}/game/change-equipment-setting/" method="post">

        <c:if test="${equipmentSetting != null}">
            <input type="hidden" name="id" value="<c:out value='${equipmentSetting.id}' />"/>
        </c:if>


        <label>
            <th>Class
                <c:forEach items="${equipmentSetting.className}"
                           var="className">${className.className}
                </c:forEach></th>
        </label>

        <br>
        <label>
            <th>Head</th>
            <select name="head">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.head}'/>">${equipmentSetting.head} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Shoulder</th>
            <select name="shoulder">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.shoulder}'/>">${equipmentSetting.shoulder} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Chest</th>
            <select name="chest">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.chest}'/>">${equipmentSetting.chest} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Legs</th>
            <select name="legs">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.legs}'/>">${equipmentSetting.legs} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Wand</th>
            <select name="wand">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.wand}'/>">${equipmentSetting.wand} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Sword</th>
            <select name="sword">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.sword}'/>">${equipmentSetting.sword} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Shield</th>
            <select name="shield">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.shield}'/>">${equipmentSetting.shield} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <label>
            <th>Amulet</th>
            <select name="amulet">
                <option hidden selected
                        value="<c:out value='${equipmentSetting.amulet}'/>">${equipmentSetting.amulet} </option>
                <option value="0">0</option>
                <option value="1">1</option>
            </select>
        </label>

        <br>
        <button class="button" type="submit" value="Save">Save</button>
        <a style="margin-left: 100px" href="${pageContext.request.contextPath}/game/setting">
            <button> Back</button>
        </a>
    </form>
</div>


</body>
</html>