package EngineeringConcepts.dsa.financialforcasting.code;

public class FinancialForecast {

    public static double calculateFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        // Base case
        if (years == 0) {
            return currentValue;
        }

        // Recursive case
        return calculateFutureValue(
                currentValue,
                growthRate,
                years - 1
        ) * (1 + growthRate);
    }
}