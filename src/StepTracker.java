public class StepTracker {
    MonthData[] monthToData;
    Converter converter = new Converter();
    int target = 10000;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    static void error() {
        System.out.println("Ошибка ввода");
    }
    void saveStepsMonth(int month, int day, int stepInDay) { //Сохраняем количество шагов в указанный месяц и день
        monthToData[month].saveStepsDay(day, stepInDay);
    }
    void changeTarget(int newTarget) {
        if (newTarget <= 0 | newTarget > 240000) {
            error();
        } else {
            target = newTarget;
        }
        System.out.println("Ваша цель " + target + " шагов в день");
    }
    void stepsCalc(int month) {
        if (month < 0 | month > 11) {
            error();
        } else {
            int sumSteps = 0;
            int seriesMax = 0;
            int seriesCalc = 0;
            int monthlyMax = 0;
            for (int i = 0; i < monthToData[month].monthTotal(); i++) {
                sumSteps = sumSteps + monthToData[month].stepsDay(i);
                System.out.println((i + 1) + " день: " + monthToData[month].stepsDay(i));
                if (i != monthToData[month].monthTotal() - 1) {
                    System.out.print("");
                }
                if (monthToData[month].stepsDay(i) >= target) {
                    seriesCalc++;
                    if (seriesCalc > seriesMax) {
                        seriesMax = seriesCalc;
                    }
                } else {
                    seriesCalc = 0;
                }
                if (monthToData[month].stepsDay(i) > monthlyMax) {
                    monthlyMax = monthToData[month].stepsDay(i);
                }
            }
            System.out.println("За " + month + "-й месяц вы сделали " + sumSteps + "ш. преодолев свою цель " + seriesMax + "д. подряд,");
            System.out.println("Пройдя в общем " + converter.stepsToKm(sumSteps) + "км. вы сожгли " + converter.stepsToKcal(sumSteps) + "Ккал.");
            System.out.println("Поставив рекорд в " + monthlyMax + "ш. за день, в среднем вы делали " + (sumSteps / monthToData[month].monthTotal()) + "ш. за месяц.");
        }
    }
    static class MonthData {
        int[] month;
        public MonthData() {
            month = new int[30];
        }
        void saveStepsDay(int day, int stepsInDay) {
            month[day - 1] = stepsInDay;
        }
        int monthTotal() {
            return month.length;
        }
        int stepsDay(int day) {
            return month[day];
        }
    }
}