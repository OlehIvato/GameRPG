<%@include file="/WEB-INF/jsp/design/navigationBar.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <style>
        p {
            margin-bottom: 0px;
        }

        code {
            border-radius: 6px;
            color: black;
            display: block;
            font: 14px/24px "Source Code Pro", Inconsolata, "Lucida Console", Terminal, "Courier New", Courier;
            padding: 24px 15px;
            text-align: center;
        }

        header,
        section,
        aside,
        footer {
            margin: 0 1.5% 24px 1.5%;
        }

        section {
            display: inline-block;
            width: 30%;
        }

        footer {
            margin-bottom: 0;
        }
    </style>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Fight Page</title>
</head>
<body>

<header>
    <code><h2>
        <c:if test="${getGameCount ==  1}"> FIRST GAME, </c:if>
        <c:if test="${getGameCount ==  2}"> SECOND GAME, </c:if>
        <c:if test="${getGameCount ==  3}"> THIRD GAME, </c:if>
        <c:if test="${getGameCount ==  4}"> GAME VS BOSS, </c:if>
        <c:if test="${getGameCount ==  5}"> FINAL GAME, </c:if>
        Level: ${getLevelCount}, Difficult +(${getLvlDifficult}%)</h2></code>
</header>

<section>
    <code>
        <div style="text-align: left;">
            <p>You fight against ${creature.name} </p>
            <p>He have ${creature.hp} hp</p>
            <p>Min Damage: ${creature.minDamage}</p>
            <p>Max Damage: ${creature.maxDamage}</p>
            <p>He also have ${creature.chanceToSuperDamage}% chance on super damage, super
                damage: ${creature.maxDamage * index.SUPER_DAMAGE} </p>
            <c:if test="${isBoss ==  1}">
                <p>He restoring ${creature.restoreHp} hp every move </p>
                <p>When his Health point will be less than 30, his damage will be as super Damage</p>
            </c:if>
            <br>
            <p>${hero.name}, Class: ${heroClass}</p>
            <p>Health Point: ${hero.hp}</p>
            <p>Damage: ${hero.damage}</p>
            <c:if test="${hero.minSpell != 0}">
                <p>Min Spell Damage: ${hero.minSpell}</p>
                <p>Max Spell Damage: ${hero.maxSpell}</p>
            </c:if>
            <c:if test="${hero.mana != 0}">
                <p>Plus to restore Health Point: ${hero.restore}, default restore
                    index: ${index.DEFAULT_RESTORE_HP_INDEX}</p>
                <p>You Have: ${hero.mana} Mana, one heal spell: ${index.DEFAULT_HEAL_CAST}</p>
            </c:if>
        </div>
    </code>
</section>

<section>
    <code>
        <c:if test="${isLose == false}">
            <div style="text-align: left;">
                <a href="${pageContext.request.contextPath}/game/fight/hero-move">
                    Hit ${creature.name} on ${hero.damage} hp</a>
                <br>
                <c:if test="${hero.minSpell > 0}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-spell">
                        Strike with magic on (Random damage from ${hero.minSpell} to ${hero.maxSpell} hp)</a>
                    <br>
                </c:if>
                <c:if test="${isHeal == false && hero.mana > 0}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-heal">
                        Restore ${index.DEFAULT_RESTORE_HP_INDEX + hero.restore} hp</a>
                    <br>
                </c:if>
                <br>
                <small>The game is saving automatically</small>
            </div>
        </c:if>

        <c:if test="${isLose == true}">
            <c:if test="${getGameCount == 5}">
                <h1>You lost Final Game </h1>
                <br>
            </c:if>
            <H1>Select next Option</H1>
            <br>
            <a href="${pageContext.request.contextPath}/game/menu/again-first-level">Play Again from first level</a>
            <br>
            <a href="/game/menu/again-current-game/${getLevelCount}/${getLvlDifficult}/${getGameCount}">Play
                Again from current game</a>
            <br>
            <a href="${pageContext.request.contextPath}/game/hero/select">Create new Player</a>
            <br>
            <a href="${pageContext.request.contextPath}/welcome">Main Page</a>

        </c:if>

    </code>
</section>


<section>
    <code>
        <div style="text-align: left;">
            <c:if test="${moveCount >= 1}">
                <h5>Description of actions</h5>
                <a> Move count: ${moveCount}</a>
            </c:if>
            <p> ${HERO_HIT}</p>
            <p> ${HERO_SPELL}</p>
            <p style="color: forestgreen">${HERO_HEAL}</p>
            <strong><p style="color: #84fab0">${BOSS_RESTORE}</p></strong>
            <strong><p style="color: darkslategray">${BOSS_LESS_HP}</p></strong>
            <strong><p style="color: chocolate;">${MOB_SUPER_DAMAGE}</p></strong>
            <p> ${MOB_HIT}</p>
            <strong><p style="color: green; font-size:20px;">${YOU_WIN}</p></strong>
            <strong><p style="color: black; font-size:20px">${NEW_CREATURE}</p></strong>
            <strong><p style="color: red; font-size:20px;">${YOU_LOSE}</p></strong>
        </div>
    </code>
</section>

<footer>
    <code>
        <div style="text-align: left;">
            <a href="${pageContext.request.contextPath}/game/menu/again-first-level">Start game again</a>
            <br>
            <a href="${pageContext.request.contextPath}/game/hero/select">Create new Hero</a>
        </div>
    </code>
</footer>

</body>
</html>