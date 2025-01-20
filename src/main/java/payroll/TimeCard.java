package payroll;

/**
 * An interface that specifies the operations that may be performed on a TimeCard.
 *
 * While you are free to modify this, we use this in the Builder to help convert the CSV file to a
 * list of time cards.
 */
public interface TimeCard {

    /**
     * Gets the employee ID.
     *
     * @return the employee ID
     */
    String getEmployeeID();

    /**
     * Gets the hours worked by the employee.
     *
     * @return the hours worked by the employee
     */
    double getHoursWorked();

}
