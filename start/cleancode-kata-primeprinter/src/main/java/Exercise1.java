import java.time.LocalDate;

public class Exercise1 {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public Exercise1(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return (this.expirationDate.isAfter(LocalDate.now()) &&
                this.approvedForConsumption &&
                this.inspectorId != null);
    }


    public class Exercise3 {
        /**
         *
         * @param amount price
         * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
         * @param years Time in years that the client is our customer
         * @return THE PRICE
         */
        public double calculate(double amount, int type, int years)
        {
            double disc = (years > 5) ? 0.05 : (double) years / 100;
            double result;

            switch (type) {
                case 2:
                    result = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
                    break;
                case 3:
                    result = (0.7 * amount) - disc * (0.7 * amount);
                    break;
                case 4:
                    result = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));
                    break;
                default:
                    result = amount;
            }

            return result;
        }
    }
}

