package Main.EnumTestPac;

import java.time.LocalTime;

public class EnumCases {

    public static void TestEnum(ENUM e) {
        switch (e) {
            case STARTGAME: {
                LocalTime time = LocalTime.now();
                System.out.println("You Start Game AT " + time);
                break;
            }
            case FINISHED: {
                LocalTime time = LocalTime.now();
                System.out.println("You Finished Game AT " + time);
                break;
            }
        }
    }
}



