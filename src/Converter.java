public class Converter {
    double stepsToKm(int steps) {
        final double distance = steps * 75;
        return  distance / 100000;
    }
    double stepsToKcal(int steps) {
        final double kcal = steps * 50;
        return kcal / 1000;
    }
}