import java.util.Map;
import java.util.HashMap;

public class WeightCNV {
    //assigning conversion rates
    private static final double UsToEuro = 0.453592;
    private static final double UsToCad = 0.453592;
    private static final double UsToMex = 0.453592;

    private static final double EuroToUS = 2.20462;
    private static final double CadToUS = 2.20462;
    private static final double MexToUS = 2.20462;
    //Might have to switch numbers around depending on my code we will se in the future
    //create mapping for the weight conversion
    public static final Map<Integer, Map<Integer, Double>> ConvRates = new HashMap<>();

    static {
        Map<Integer, Double> UsRates = new HashMap<>();
        UsRates.put(4, UsToEuro);
        UsRates.put(2, UsToCad);
        UsRates.put(3, UsToMex);

        Map<Integer, Double> EuroRates = new HashMap<>();
        EuroRates.put(1, EuroToUS);

        Map<Integer, Double> CanadianRates = new HashMap<>();
        CanadianRates.put(1, CadToUS);

        Map<Integer, Double> MexicanRates = new HashMap<>();
        MexicanRates.put(1, MexToUS);

        ConvRates.put(1, UsRates);
        ConvRates.put(4, EuroRates);
        ConvRates.put(3, MexicanRates);
        ConvRates.put(2, CanadianRates);
    }
}
    // Function to convert weight from one unit to another
    /*public static double convertWeight(double weight, int fromUnit, int toUnit) {
        // Retrieve conversion rate from the ConvRates map
        Map<Integer, Double> fromRates = ConvRates.get(fromUnit);
        if (fromRates == null) {
            System.out.println("Conversion rates for " + fromUnit + " not found.");
            return -1; // or throw an exception
        }

        Double conversionRate = fromRates.get(toUnit);
        if (conversionRate == null) {
            System.out.println("Conversion rate from " + fromUnit + " to " + toUnit + " not found.");
            return -1; // or throw an exception
        }

        // Perform conversion
        return weight * conversionRate;
    }*/



