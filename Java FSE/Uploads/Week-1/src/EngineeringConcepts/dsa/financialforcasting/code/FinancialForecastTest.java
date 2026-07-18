package EngineeringConcepts.dsa.financialforcasting.code;

public class FinancialForecastTest {

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 3;

        double futureValue =
                FinancialForecast.calculateFutureValue(
                        currentValue,
                        growthRate,
                        years
                );

        System.out.printf(
                "Predicted value after %d years: %.2f",
                years,
                futureValue
        );
    }
}