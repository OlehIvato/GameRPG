package Moving.Fight;
import Main.ChoseNewHero;
import Main.EnumTestPac.ENUM;
import Main.EnumTestPac.EnumCases;
import java.util.Scanner;

public class Winning {


    public static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n:::::::::::::    congratulations you went through three levels and won    :::::::::::::" +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        backtomain();
    }


    public static void backtomain() {
        String cases = "\n\n\n Select option :" +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. EXIT ";
        System.out.println(cases);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: {
                ChoseNewHero.main();
                break;
            }
            case 2: {
                EnumCases.TestEnum(ENUM.FINISHED);
                System.err.println(" EXIT ");
                System.exit(0);
                break;
            }
        }
    }

}