import java.awt.Point;

public class Main {

    public static int getRandomNumberX() {
        return (int) (Math.random() * 39);
    }

    public static int getRandomNumberY() {
        return (int) (Math.random() * 9);
    }


    public static void main(String[] args) {

        Point playerPosition = new Point(getRandomNumberX(), getRandomNumberY());
        Point snakePosition1 = new Point(getRandomNumberX(), getRandomNumberY());
        Point snakePosition2 = new Point(getRandomNumberX(), getRandomNumberY());
        Point goldPosition1 = new Point(getRandomNumberX(), getRandomNumberY());
        Point goldPosition2 = new Point(getRandomNumberX(), getRandomNumberY());
        Point doorPosition = new Point(getRandomNumberX(), getRandomNumberY());
        boolean rich1 = false;
        boolean rich2 = false;
        int rounds = 0;

        while (true) {

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (playerPosition.equals(p))
                        System.out.print('P');
                    else if (snakePosition1.equals(p))
                        System.out.print('S');
                    else if (snakePosition2.equals(p))
                        System.out.print('S');
                    else if (goldPosition1.equals(p))
                        System.out.print('$');
                    else if (goldPosition2.equals(p))
                        System.out.print('$');
                    else if (doorPosition.equals(p))
                        System.out.print('#');
                    else System.out.print('.');
                }
                System.out.println();
            }

            // check status

            if (rich1 && rich2 && playerPosition.equals(doorPosition)) {
                System.out.println("Gewonnen!");
                return;
            }
            if (playerPosition.equals(snakePosition1) || playerPosition.equals(snakePosition2)) {
                System.out.println("Oh nein! Die Schlange hat dich gefangen!");
                return;
            }

            if (playerPosition.equals(goldPosition1)) {
                rich1 = true;
                goldPosition1.setLocation(-1, -1);
            }
            if (playerPosition.equals(goldPosition2)) {
                rich2 = true;
                goldPosition2.setLocation(-1, -1);
            }


            switch (new java.util.Scanner(System.in).next()) {
                case "u" -> {
                    playerPosition.y = Math.max(0, playerPosition.y - 1);
                    rounds++;
                }
                case "d" -> {
                    playerPosition.y = Math.min(9, playerPosition.y + 1);
                    rounds++;
                }
                case "l" -> {
                    playerPosition.x = Math.max(0, playerPosition.x - 1);
                    rounds++;
                }
                case "r" -> {
                    playerPosition.x = Math.min(39, playerPosition.x + 1);
                    rounds++;
                }
            }
            System.out.println(rounds);
            // Snakes moving towards player after 4 rounds
            if (rounds > 4) {

                if (playerPosition.x < snakePosition1.x)
                    snakePosition1.x--;
                else if (playerPosition.x > snakePosition1.x)
                    snakePosition1.x++;
                if (playerPosition.y < snakePosition1.y)
                    snakePosition1.y--;
                else if (playerPosition.y > snakePosition1.y)
                    snakePosition1.y++;

                if (playerPosition.x < snakePosition2.x)
                    snakePosition2.x--;
                else if (playerPosition.x > snakePosition2.x)
                    snakePosition2.x++;
                if (playerPosition.y < snakePosition2.y)
                    snakePosition2.y--;
                else if (playerPosition.y > snakePosition2.y)
                    snakePosition2.y++;
            }
        }// end while
    }
}