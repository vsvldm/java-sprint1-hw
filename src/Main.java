import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(sc);
        Motivator motivator = new Motivator();
        while(true) {
            System.out.println();
            System.out.println("Цель сегодня: " + stepTracker.goalByStepsPerDay);
            printMenu();

            int command = sc.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                System.out.println(motivator.getMotivation());
            } else if (command == 0) {
                System.out.println("Дорога возникает под ногами идущего!");
                System.out.println("Выход!");
                sc.close();
                return;
            } else {
                System.out.println("Такой команды нет!");
            }
        }

    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за месяц");
        System.out.println("4 - Мотивировать");
        System.out.println("0 - Выйти из приложения");
    }
}
