package Moving.Fight;

import Main.Location.LocationMain;
import Moving.Random.RandomBoss;
import Moving.Random.RandomBoss_WithOut_Equipment;
import Moving.Random.RandomMob;
import Moving.Random.RandomMob_WithOut_Equipment;

public class Level {


    public static void level_1_1() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_1_2() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_1_3() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_2_1() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_2_2() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_2_3() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_3_1() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();

    }

    public static void level_3_2() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }

    public static void level_3_3() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob.get_random_mob();
    }


    public static void level_1_1_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();

    }

    public static void level_1_2_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void level_1_3_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 1 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void level_2_1_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();

    }

    public static void level_2_2_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void level_2_3_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 2 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void level_3_1_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== FIRST GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();

    }

    public static void level_3_2_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== SECOND GAME ======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void level_3_3_NOequip() {
        String cases = "\n\n===========================================================" +
                " \n========================== Level 3 ========================" +
                "\n======================== THIRD GAME =======================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomMob_WithOut_Equipment.get_random_mob_WITHOUT();
    }

    public static void fight_vs_boss() {
        String cases = "\n\n===========================================================" +
                        " \n========================== FIGHT ==========================" +
                         "\n========================= VS BOSS =========================" +
                         "\n===========================================================";
        System.out.println(cases);
        RandomBoss.get_random_boss();

    }


    public static void fight_vs_boss_without_equip() {
        String cases = "\n\n===========================================================" +
                " \n======================= FINAL FIGHT =======================" +
                "\n========================= VS BOSS =========================" +
                "\n===========================================================";
        System.out.println(cases);
        RandomBoss_WithOut_Equipment.get_random_boss_without_equip();

    }


}
