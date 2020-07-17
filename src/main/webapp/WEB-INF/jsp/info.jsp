<%@include file="design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>

    <title>Info</title>
    <link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div style="margin-left: 50px">
    <h4>
        <p> That is a mini rpg game</p>
        <p>The game consists of ${index.LEVEL_COUNT_INDEX} levels</p>
        <p>In each level there are three games and one game against the boss</p>
        <p>To pass the level you need to pass 4 games (that mean, you need to kill 3 mobs and one boss)</p>
        <p>The boss differs from a simple mob in that the boss has additional features</p>
        <p>You can select Hero, add equipments, add location for fight </p>
        <p>Or you can play without equipments, in that case all creatures characteristics will reduce
            on ${index.GAME_WITHOUT_EQUIP_INDEX}% for every game</p>
        <p>If you play with equipments all creatures characteristics will increase every level
            on ${index.LEVEL_DIFFICULT_PERCENT}%</p>
        <p>Every Hero have different features, some can only beat, other only use spell, healing, energy hit etc</p>
        <p>For some Hero spell need some resource, for example, for healing need mana, for energy hit need energy
            etc</p>
        <p>These resources restored depending on the game with or without equipment</p>
        <p>If game with equipments, resources will be restored every level, if without equipments, resources will be
            restored every game </p>
        <p>All these resources will be restored according to the default index</p>
        <p>Hero hp updating every game on default hp </p>
        <p>Each game gets a random mob and boss</p>
        <p>The game is saved automatically and can be resumed</p>

    </h4>
</div>
</body>
</html>