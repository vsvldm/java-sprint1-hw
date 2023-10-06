import java.util.Scanner;

class StepTracker {
    Scanner sc;
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        sc = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца от 1 до 12: ");
        int month = sc.nextInt();
        if (month < 0 || month >= 12) {
            System.out.println("Ошибка ввода месяца! Попробуй еще раз!");
            return;
        }
        System.out.print("Введите день от 1 до 30: ");
        int day = sc.nextInt();
        if (day < 0 || day > 30) {
            System.out.println("Ошибка ввода дня! Попробуй еще раз! ");
            return;
        }
        System.out.print("Введите количество шагов: ");
        int steps = sc.nextInt();
        if (steps < 0) {
            System.out.println("Ошибка ввода количества шагов! Количество шагов всегда положительно и не равно нулю!");
            return;
        }

        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = steps;
    }

    void changeStepGoal() {
        System.out.print("Введите новую цель: ");
        goalByStepsPerDay = sc.nextInt();
        if (goalByStepsPerDay <= 0) {
            System.out.println("Ошибка ввода цели! Цель не может быть отрицательной или равной нулю!");
        } else if (goalByStepsPerDay > 10000) {
            System.out.println("Цель обновлена! Преодоление трудностей — это путь к совершенству!");
        } else {
            System.out.println("Цель обновлена! Великие дела начинаются с малых шагов!");
        }
    }

    void printStatistic() {
        System.out.print("Введите месяц, за который хотите посмотреть статистику: ");
        int month = sc.nextInt();
        if (month < 0 || month >= 12) {
            System.out.println("Ошибка ввода месяца! Попробуй еще раз!");
        } else {
            MonthData monthData = monthToData[month - 1];
            int sumStep = monthData.sumStepsFromMonth();
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Сумма шагов за месяц: " + sumStep);
            System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps());
            System.out.println("Среднее количество шагов за месяц: " + (sumStep/30));
            System.out.println("Дистанция пройденная за месяц в км: " + converter.convertToKm(sumStep));
            System.out.println("Количество сожженных килокалорий за месяц: " + converter.convertStepsToKilocalories(sumStep));
            System.out.println("Лучшая серия выполненной цели: " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}