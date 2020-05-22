import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        guessTheNumber();
    }

    public static void guessTheNumber() {
        System.out.println("Игра Угадайка! \nУ вас есть 3 попытки угадать число от 0 до 9! ");
        Random random = new Random();
        int guessedNumber = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        for (int i = 3; i >= 0; i--) {
            if (i == 0) {
                System.out.println("Вы проиграли!\nЗагаданное число:  " + guessedNumber);
                repeatGame();
                break;

            } else {
                System.out.println("Введите число у вас осталось " + i + " попыток!");
                int playerNumber = scanner.nextInt();
                if (playerNumber == guessedNumber) {
                    System.out.println("Поздравляю Вы угадали верно!");
                    repeatGame();
                    break;

                } else if (playerNumber > guessedNumber)
                    System.out.println("Загаданное число меньше.");

                else
                    System.out.println("Загаданное число больше.");

            }

        }
    scanner.close();
    }

    public static void repeatGame() {
        System.out.println("Хотите сыграть ещё? 1 - да, 0 - нет");
        Scanner scanner = new Scanner(System.in);
        int repeatChoose = scanner.nextInt();
        if (repeatChoose == 1)
            guessTheNumber();
        else if (repeatChoose == 0)
            System.out.println("Всего хорошего!");
        scanner.close();


    }
}


