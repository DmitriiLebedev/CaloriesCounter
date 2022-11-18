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
                int month = stepTracker.askMonth(scanner);
                int toDay = stepTracker.askDay(scanner);
                int stepsInDay = stepTracker.askSteps(scanner);
                stepTracker.saveStepsMonth(month, toDay, stepsInDay);
            }
            if (userInput == 2) {
                System.out.println("Укажите месяц (от 0 до 11)");
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
}