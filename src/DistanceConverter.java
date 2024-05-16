public class DistanceConverter {
    // Distance conversion rates
    private static final double[][] distanceConversionRates = {
            // US to others: miles to kilometers
            {1.0, 1.60934, 1.60934, 1.60934},
            // Canada to others: kilometers to miles
            {0.621371, 1.0, 1.0, 1.0},
            // Mexico to others: kilometers to miles
            {0.621371, 1.0, 1.0, 1.0},
            // Europe to others: kilometers to miles
            {0.621371, 1.0, 1.0, 1.0}
    };

    public static double convert(double inputValue, int startCountry, int endCountry) {
        return inputValue * distanceConversionRates[startCountry - 1][endCountry - 1];
    }
}

