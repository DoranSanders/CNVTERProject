import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select starting country: ");
            System.out.println("1. US");
            System.out.println("2. Canada");
            System.out.println("3. Mexico");
            System.out.println("4. Europe");
            int startCountry = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Select ending country: ");
            System.out.println("1. US");
            System.out.println("2. Canada");
            System.out.println("3. Mexico");
            System.out.println("4. Europe");
            int endCountry = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Select conversion type: ");
            System.out.println("1. Distance");
            System.out.println("2. Weight");
            System.out.println("3. Currency");
            int conversionType = scanner.nextInt();
            scanner.nextLine();

            String inputUnit = getUnit(conversionType, startCountry);
            String outputUnit = getUnit(conversionType, endCountry);

            System.out.println("Enter the value to be converted (e.g. 12): ");
            double inputValue = scanner.nextDouble();

            // Perform conversion based on user selection
            switch (conversionType) {
                case 1:
                    // Perform distance conversion
                    double distanceResult = performDistanceConversion(inputValue, startCountry, endCountry);
                    System.out.println("Converted value: " + distanceResult + " " + outputUnit);
                    break;
                case 2:
                    // Perform weight conversion
                    double weightResult = performWeightConversion(inputValue, startCountry, endCountry);
                    System.out.println("Converted value: " + weightResult + " " + outputUnit);
                    break;
                case 3:
                    // Perform currency conversion
                    double currencyResult = performCurrencyConversion(inputValue, startCountry, endCountry);
                    System.out.println("Converted value: " + currencyResult + " " + outputUnit);
                    break;
                default:
                    System.out.println("Invalid conversion type.");
                    break;
            }

            System.out.println("Do you want to perform another conversion? (yes/no)");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    /**
     * Checks if the conversion type is in the map
     * @param conversionType conversionType
     * @param country chosen country
     * @return appropriate units based on chosen conversion type and country
     * @throws IllegalArgumentException if conversionType or country is not found
     */
    private static String getUnit(int conversionType, int country) {
        // Checks if the conversion type is in the map
        // If conversion type is found, it checks if the country chosen is in the map as well
        // If it passes, then the appropriate units will be returned

        if (conversionUnits.containsKey(conversionType)) {
            Map<Integer, String> units = conversionUnits.get(conversionType);

            if (units.containsKey(country)) {
                return units.get(country);
            } else {
                throw new IllegalArgumentException("Invalid country.");
            }

        } else if (!conversionUnits.containsKey(conversionType)) {
            throw new IllegalArgumentException("Invalid conversion type.");
        }
        return "";
    }

    // Mapping that assigns units to countries for each conversion type
    private static final Map<Integer,Map<Integer, String>> conversionUnits = new HashMap<>();

    static {
        Map<Integer, String> distanceUnits = new HashMap<>();
        distanceUnits.put(1, "miles");
        distanceUnits.put(2, "km");
        distanceUnits.put(3, "km");
        distanceUnits.put(4, "km");

        Map<Integer, String> weightUnits = new HashMap<>();
        weightUnits.put(1, "lbs");
        weightUnits.put(2, "kgs");
        weightUnits.put(3, "kgs");
        weightUnits.put(4, "kgs");

        Map<Integer, String> currencyUnits = new HashMap<>();
        currencyUnits.put(1, "USD");
        currencyUnits.put(2, "CAD");
        currencyUnits.put(3, "Peso");
        currencyUnits.put(4, "Euro");

        conversionUnits.put(1, distanceUnits);
        conversionUnits.put(2, weightUnits);
        conversionUnits.put(3, currencyUnits);


    }


    // Add conversion rates and formulas
    private static double performDistanceConversion(double inputValue, int startCountry, int endCountry) {
        // Implement distance conversion
        return 0.0; //  replace with actual conversion
    }

    private static double performWeightConversion(double inputValue, int startCountry, int endCountry) {
        // Implement weight conversion
        return 0.0; // replace with actual conversion
    }

    private static double performCurrencyConversion(double inputValue, int startCountry, int endCountry) {
        // Implement currency conversion
        return 0.0; // replace with actual conversion
    }
}