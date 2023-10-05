class Converter {
    int step = 75;
    int caloriesPerStep = 50;
    int caloriesInKilocalories = 1000;
    int centimetersInKm = 100000;

    int convertToKm(int steps) {
        return (steps * step) / centimetersInKm;
    }
    int convertStepsToKilocalories(int steps) {
        return (steps * caloriesPerStep) / caloriesInKilocalories;
    }
}
