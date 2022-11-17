import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Привет! Это счетчик калорий, что вы хотите сделать?");
        menu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                int month = askMonth(scanner);
                int toDay = askDay(scanner);
                int stepsInDay = askSteps(scanner);
                stepTracker.saveStepsMonth(month, toDay, stepsInDay);
            }
            if (userInput == 2) {
                printMonths();
                int month = scanner.nextInt();
                stepTracker.stepsCalc(month);
            }
            if (userInput == 3) {
                System.out.println("Введите новую цель");
                int newTarget = scanner.nextInt();
                stepTracker.changeTarget(newTarget);
            }
            if (userInput < 0 || userInput > 3) {
                StepTracker.error();
            }
            menu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
    private static void menu() {
        System.out.println("Меню:\n1 - Ввести количество шагов\n2 - Посмотреть статистику\n3 - Изменить цель\n0 - Выход");
    }
    private static void printMonths() {
        System.out.println("Укажите месяц (от 0 до 11)");
    }
    private static int askMonth(Scanner scanner) {
        printMonths();
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            StepTracker.error();
            printMonths();
            month = scanner.nextInt();
        }
        return month;
    }
    private static int askDay(Scanner scanner) {
        System.out.println("Укажите день");
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            StepTracker.error();
            day = scanner.nextInt();
        }
        return day;
    }
    private static int askSteps(Scanner scanner) {
        System.out.println("Количество шагов");
        int steps = scanner.nextInt();
        while (steps < 0) {
            StepTracker.error();
            steps = scanner.nextInt();
        }
        return steps;
    }
}