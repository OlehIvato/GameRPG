package game.primary;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu implements DefaultValues {

    public static void main() {
        try {
            System.out.println("Main Menu \n 1. New Game \n 2. Upload saved game \n 3. Exit".toUpperCase());
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    createPlayerName();
                    second();
                }
                case 2 -> Storage.getFilesFromFolder(true);
                case 3 -> {
                    System.err.println("Exit");
                    System.exit(0);
                }
            }
        } catch (NullPointerException | InputMismatchException |
                IllegalArgumentException e) {
            System.err.println("Something went wrong\n");
            main();
        }

    }

    public static void second() {
        String create = "\n" + Setting.getPlayerName() + ", select next option:\n" +
                "1. Create new Hero \n" +
                "2. Upload saved equipped hero, and play new game \n" +
                "3. Back";
        System.out.println(create);
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> NewGame.newGame();
            case 2 -> Storage.getFilesFromFolder(false);
            case 3 -> main();
        }
    }

    private static void createPlayerName() {
        if (Setting.getPlayerName() == null) {
            System.out.println("What is your name ? ");
            Pattern pattern = Pattern.compile("[A-Za-z]*");
            while (SCANNER.hasNext()) {
                if (SCANNER.hasNext(pattern)) {
                    Setting.setPlayerName(SCANNER.next());
                    break;
                } else
                    System.err.println("Attribute name must contain word characters only");
                SCANNER.next();
            }
        }
    }


}

