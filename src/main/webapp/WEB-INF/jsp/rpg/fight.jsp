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
        <c:if test="${CHF.fightGameCount ==  1}"> FIRST GAME, </c:if>
        <c:if test="${CHF.fightGameCount ==  2}"> SECOND GAME, </c:if>
        <c:if test="${CHF.fightGameCount ==  3}"> THIRD GAME, </c:if>
        <c:if test="${CHF.fightGameCount ==  4}"> GAME VS BOSS, </c:if>
        <c:if test="${CHF.fightGameCount ==  5}"> FINAL GAME, </c:if>
        Level: ${CHF.fightLevelCount}
        <c:if test="${CHF.fightLevelDifficult >=10 || CHF.fightLevelDifficult == index.GAME_WITHOUT_EQUIP_DIFFICULTY}">
            , Difficult
            <c:if test="${CHF.fightLevelDifficult >=0}"> +</c:if>
            ${CHF.fightLevelDifficult}%
        </c:if>
    </h2></code>
</header>

<section>

    <code>
        <div style="text-align: left;">
            <p>You fight against ${CHF.creatureName} </p>
            <p>He have ${CHF.creatureHp} hp</p>
            <p>Min Damage: ${CHF.creatureMinDamage}</p>
            <p>Max Damage: ${CHF.creatureMaxDamage}</p>
            <p>He also have ${CHF.creatureChanceToSuperDamage}% chance on super damage, which
                equals: ${CHF.creatureMaxDamage * index.SUPER_DAMAGE_MULTIPLY_INDEX}</p>
            <c:if test="${CHF.fightIsBoss ==  1}">
                <p>He restoring ${CHF.creatureRestoreHp} hp every move </p>
                <p>When his Health point will be less than 30, his damage will be as super Damage</p>
            </c:if>
            <br>
            <p>${CHF.heroName}, Class: ${heroClass}</p>
            <p>Health Point: ${CHF.heroHp}</p>
            <c:if test="${CHF.heroDamage > 0}">
                <p>Damage: ${CHF.heroDamage}</p>
            </c:if>
            <c:if test="${CHF.heroEnergy >= index.ENERGY_HIT_INDEX}">
                <p>You Have: ${CHF.heroEnergy} Energy, one energy hit: ${index.ENERGY_HIT_INDEX} energy</p>
                <p>Every next level restoring ${CHF.heroEnergyRes} energy</p>
            </c:if>
            <c:if test="${CHF.heroMinSpell > 0}">
                <p>Min Spell Damage: ${CHF.heroMinSpell}</p>
                <p>Max Spell Damage: ${CHF.heroMaxSpell}</p>
            </c:if>
            <c:if test="${CHF.heroMana >= index.HEAL_CAST_INDEX}">
                <p>Plus to restore Health Point: ${CHF.heroRestore}, restore index: ${index.RESTORE_HP_INDEX}</p>
                <p>You Have: ${CHF.heroMana} Mana, one heal spell: ${index.HEAL_CAST_INDEX}</p>
                <p>Every next level restoring ${CHF.heroManaRes} mana</p>
            </c:if>
        </div>
    </code>
</section>

<section>
    <code>
        <c:if test="${isLose == false}">
            <div style="text-align: left;">
                <c:if test="${CHF.heroDamage >0}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-hit">
                        Hit ${CHF.creatureName} on ${CHF.heroDamage} hp</a>
                    <br>
                </c:if>
                <c:if test="${CHF.heroEnergy >= index.ENERGY_HIT_INDEX}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-energy_hit">
                        Hit ${CHF.creatureName} on ${CHF.heroDamage * index.ENERGY_MULTIPLY_INDEX} hp using Energy </a>
                    <br>
                </c:if>
                <c:if test="${CHF.heroMinSpell > 0}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-spell">
                        Strike with magic on (Random damage from ${CHF.heroMinSpell} to ${CHF.heroMaxSpell} hp)</a>
                    <br>
                </c:if>
                <c:if test="${isHeal == false && CHF.heroMana > index.HEAL_CAST_INDEX}">
                    <a href="${pageContext.request.contextPath}/game/fight/hero-heal">
                        Restore ${index.HEAL_CAST_INDEX + CHF.heroRestore} hp</a>
                    <br>
                </c:if>
                <br>
                <small>The game is saving automatically</small>
            </div>
        </c:if>

        <c:if test="${isLose == true}">
            <c:if test="${CHF.fightGameCount == 5}">
                <h1>You lost Final Game </h1>
                <br>
            </c:if>
            <H1>Select next Option</H1>
            <br>
            <a href="${pageContext.request.contextPath}/game/menu/again-first-level">Play Again from first level</a>
            <br>
            <a href="/game/menu/again-current-game/${CHF.fightLevelCount}/${CHF.fightLevelDifficult}/${CHF.fightGameCount}">Play
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
                <p> ${HERO_ENERGY_HIT}</p>
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