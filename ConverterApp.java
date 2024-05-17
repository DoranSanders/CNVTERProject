/*import java.util.Scanner;

public class ConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetUnit unit = new GetUnit();

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

            String inputUnit = unit.(conversionType, startCountry);
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
    }}

  /*  private static String getUnit(int conversionType, int country, int endcountry) {
        // Determine units based on conversion type and country
        // Return appropriate unit
        return ""; // replace with actual unit
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
}*/
import java.util.Map;
import java.util.Scanner;

public class ConverterApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //choosing what conversion user want to do
        while (true) {
            System.out.println("Choose conversion type(using the numbers):");
            System.out.println("1. Distance Conversion");
            System.out.println("2. Currency Conversion");
            System.out.println("3. Weight Conversion");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    distanceConversion(scanner);
                    break;
                case 2:
                    currencyConversion(scanner);
                    break;
                case 3:
                    weightConversion(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//calculates the conversion for distance
    private static void distanceConversion(Scanner scanner) {
        //options for countries to convert from and to
        System.out.println("Choose start country(using the numbers):");
        System.out.println("1. US");
        System.out.println("2. Canada");
        System.out.println("3. Mexico");
        System.out.println("4. Europe");
        int startCountry = scanner.nextInt();

        System.out.println("Choose end country(using the numbers):");
        System.out.println("1. US");
        System.out.println("2. Canada");
        System.out.println("3. Mexico");
        System.out.println("4. Europe");
        int endCountry = scanner.nextInt();

        System.out.println("Enter the distance:");
        double distance = scanner.nextDouble();
//converstion calculation
        double result = DistanceConverter.convert(distance, startCountry, endCountry);
        System.out.printf("Converted distance: %.2f%n", result);
    }
//conversion for currency
    private static void currencyConversion(Scanner scanner) {
        MoneyCNV moneyConverter = new MoneyCNV();
        //country choices
        System.out.println("Choose start currency(using the numbers):");
        System.out.println("1. US Dollar");
        System.out.println("2. Canadian Dollar");
        System.out.println("3. Mexican Peso");
        System.out.println("4. Euro");
        int startCurrency = scanner.nextInt();

        System.out.println("Choose end currency(Using the numbers:");
        System.out.println("1. US Dollar");
        System.out.println("2. Canadian Dollar");
        System.out.println("3. Mexican Peso");
        System.out.println("4. Euro");
        int endCurrency = scanner.nextInt();

        System.out.println("Enter the amount:");
        double amount = scanner.nextDouble();
        //calculation for the conversion
        double result = moneyConverter.convert(amount, startCurrency, endCurrency);
        //writes to the file
        moneyConverter.WriteToFile(amount, startCurrency,endCurrency);
        System.out.printf("Converted amount: %.2f%n", result);

    }
//weight conversion
    private static void weightConversion(Scanner scanner) {
        System.out.println("Choose start country(using the numbers:");
        System.out.println("1. US");
        System.out.println("2. Canada");
        System.out.println("3. Mexico");
        System.out.println("4. Europe");
        int startCountry = scanner.nextInt();

        System.out.println("Choose end country(using the numbers:");
        System.out.println("1. US");
        System.out.println("2. Canada");
        System.out.println("3. Mexico");
        System.out.println("4. Europe");
        int endCountry = scanner.nextInt();

        System.out.println("Enter the weight:");
        double weight = scanner.nextDouble();
        System.out.println("what is the unit? ");

        // Adjust the weight conversion logic
        double result = convertWeight(weight, startCountry, endCountry);
        System.out.printf("Converted weight: %.2f%n", result);
    }
    //This converts the distance calling it from the MoneyCNV
    private static double convertDistance( double distance, int fromUnit, int toUnit){
        Map<Integer, Double> fromRates = MoneyCNV.ConvRates.get(fromUnit);
        if (fromRates == null) {
            throw new IllegalArgumentException("Conversion rates for " + fromUnit + " not found.");
        }

        Double conversionRate = fromRates.get(toUnit);
        if (conversionRate == null) {
            throw new IllegalArgumentException("Conversion rate from " + fromUnit + " to " + toUnit + " not found.");
        }

        // Perform conversion
        return distance * conversionRate;
    }
    //Calls the convert weight code from the WeightCNV
    private static double convertWeight(double weight, int fromUnit, int toUnit) {
        // Retrieve conversion rate from the ConvRates map in WeightCNV class
        Map<Integer, Double> fromRates = WeightCNV.ConvRates.get(fromUnit);
        if (fromRates == null) {
            throw new IllegalArgumentException("Conversion rates for " + fromUnit + " not found.");
        }

        Double conversionRate = fromRates.get(toUnit);
        if (conversionRate == null) {
            throw new IllegalArgumentException("Conversion rate from " + fromUnit + " to " + toUnit + " not found.");
        }

        // Perform conversion
        return weight * conversionRate;
    }
}

