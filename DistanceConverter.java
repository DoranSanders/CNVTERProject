/*public class DistanceConverter {
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
}*/
import java.util.HashMap;
import java.util.Map;

public class DistanceConverter {
    // Distance conversion rates using HashMap
    private static final Map<Integer, Map<Integer, Double>> distanceConversionRates = new HashMap<>();

    static {
        // US conversion rates
        Map<Integer, Double> usConversions = new HashMap<>();
        usConversions.put(2, 1.60934);
        usConversions.put(3, 1.60934);
        usConversions.put(4, 1.60934);
        distanceConversionRates.put(1, usConversions);

        // Canada conversion rates
        Map<Integer, Double> canadaConversions = new HashMap<>();
        canadaConversions.put(1, 0.621371);
        canadaConversions.put(3, 1.0);
        canadaConversions.put(4, 1.0);
        distanceConversionRates.put(2, canadaConversions);

        // Mexico conversion rates
        Map<Integer, Double> mexicoConversions = new HashMap<>();
        mexicoConversions.put(1, 0.621371);
        mexicoConversions.put(2, 1.0);
        mexicoConversions.put(4, 1.0);
        distanceConversionRates.put(3, mexicoConversions);

        // Europe conversion rates
        Map<Integer, Double> europeConversions = new HashMap<>();
        europeConversions.put(1, 0.621371);
        europeConversions.put(2, 1.0);
        europeConversions.put(3, 1.0);
        distanceConversionRates.put(4, europeConversions);
    }

    public static double convert(double inputValue, Integer startCountry, Integer endCountry) {
        if (!distanceConversionRates.containsKey(startCountry) || !distanceConversionRates.get(startCountry).containsKey(endCountry)) {
            throw new IllegalArgumentException("Invalid country names provided.");
        }
        return inputValue * distanceConversionRates.get(startCountry).get(endCountry);
    }

    public static void main(String[] args) {
        // Example usage:
        double miles = convert(100, 1, 2);
        System.out.println("100 miles in US is " + miles + " kilometers in Canada.");

        double kilometers = convert(100, 2, 1);
        System.out.println("100 kilometers in Canada is " + kilometers + " miles in US.");
    }
}