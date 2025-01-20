package payroll;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings. These objects are
 * then used in the rest of the program. Often these builders are associated with the objects themselves and the concept
 * of a factory, but we placed them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }

    /**
     * Builds an {@link payroll.Employee Employee} object from a CSV string.
     * <p>
     * Suggested algorithm: (1) determine the type of employee based on the first element of the CSV string; (2) build
     * an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static Employee buildEmployeeFromCsv(String csv) {
        return null;
    }


    /**
     * Builds a {@link payroll.TimeCard TimeCard} object from a CSV string.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static TimeCard buildTimeCardFromCsv(String csv) {
        return null;
    }
}
