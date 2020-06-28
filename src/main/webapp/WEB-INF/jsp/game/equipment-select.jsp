<%@ page import="java.sql.*" %>
<%@ page import="game.primary.MainData" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page import="java.io.IOException" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Equipment Database</title>
</head>
<body>


<div style="text-align: center"><h1>Equipment Database</h1></div>
<button style="margin-left: 100px"><a href="/welcome">Back</a></button>


<%--<%--%>


<%--    String headSelect = "Select Head Armor:\n";--%>
<%--    String shoulderSelect = "Select Shoulder Armor:\n";--%>
<%--    String chestSelect = "Select Chest Armor:\n";--%>
<%--    String legSelect = "Select Leg Armor\n";--%>
<%--    String wandSelect = "Select Wand\n";--%>
<%--    String swordSelect = "Select Sword\n";--%>
<%--    String shieldSelect = "Select Shield\n";--%>
<%--    String amuletsSelect = "Select Amulet\n";--%>

<%--    String type_Head = "Head";--%>
<%--    String type_Shoulder = "Shoulder";--%>
<%--    String type_Chest = "Chest";--%>
<%--    String type_Legs = "Legs";--%>
<%--    String type_Wand = "Wand";--%>
<%--    String type_Sword = "Sword";--%>
<%--    String type_Shield = "Shield";--%>
<%--    String type_Amulets = "Amulet";--%>


<%--    String armor_Cloth = "Cloth";--%>
<%--    String armor_leather = "Leather";--%>
<%--    String armor_Plate = "Plate";--%>
<%--    String armor_Weapon = "Weapon";--%>


<%--    if (TheMain.getHeroArmor().equals("Cloth")) {--%>
<%--        System.out.println(headSelect);--%>

<%--        show(out, armor_Cloth, type_Head);--%>


<%--     }--%>

<%--    if (TheMain.getHeroArmor().equals("Plate")) {--%>
<%--        System.out.println(headSelect);--%>

<%--        show(out, armor_Plate, type_Head);--%>


<%--    }--%>
<%--%>--%>

<%--<%!--%>
<%--    private void show(JspWriter out, String armor, String type) {--%>

<%--        try {--%>
<%--            Connection connection = DriverManager.getConnection(TheMain.getUrl(), TheMain.getUsername(), TheMain.getPassword());--%>
<%--            Statement statementMain = connection.createStatement();--%>
<%--            Statement statementType = connection.createStatement();--%>
<%--            Statement statementArmor = connection.createStatement();--%>

<%--            ResultSet resultMain = statementMain.executeQuery("SELECT * FROM equipment ");--%>
<%--            ResultSet resultType = statementType.executeQuery("select types0_.equipment_model_id as equipmen1_10_0_, type1_.type as type from equipment_types types0_ inner join type type1_ on types0_.types_id=type1_.id   order by equipmen1_10_0_");--%>
<%--         ResultSet resultArmor = statementArmor.executeQuery("select armors0_.equipment_model_id as equipmen1_9_0_, armor1_.armor as armor from equipment_armors armors0_ inner join armor armor1_ on armors0_.armors_id = armor1_.id order by equipmen1_9_0_");--%>

<%--            while (resultMain.next() && resultType.next() && resultArmor.next()) {--%>

<%--                if (resultArmor.getString("armor").equals(armor) && resultType.getString("type").equals(type)) {--%>
<%--                    String getFormat = "%1$-4s|%2$-30s|%3$-8s|%4$-11s|%5$-18s|%6$-9s|%7$-16s|%8$-21s|";--%>
<%--                    String value = String.format(getFormat,--%>
<%--                            resultMain.getLong("id"),--%>
<%--                            resultMain.getString("name"),--%>
<%--                            " HP: " + resultMain.getInt("hp"),--%>
<%--                            " Damage: " + resultMain.getInt("damage"),--%>
<%--                            " Spell Damage: " + resultMain.getInt("spell_damage"),--%>
<%--                            " Mana: " + resultMain.getInt("mana"),--%>
<%--                            " Type: " + resultType.getString("type"),--%>
<%--                            " Armor Type: " + resultArmor.getString("armor"));--%>
<%--                    out.print("\n <h1></h1>"+ value  );--%>
<%--                out.print(TheMain.getMobName());--%>
<%--                }--%>
<%--            }--%>
<%--        } catch (SQLException | IOException e) {--%>
<%--            e.printStackTrace();--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
















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
