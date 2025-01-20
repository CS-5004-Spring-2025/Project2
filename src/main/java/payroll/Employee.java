package payroll;

/**
 * An interface that specifies the operations that may be performed on an Employee.
 * <p>
 * DO NOT MODIFY THIS FILE! (unless you are cleaning up comments/style changes)
 * <p>
 * This file is provided, and hidden auto-grader tests may test the methods required in this interface.
 */
public interface Employee {

    /**
     * Gets the employee's name.
     *
     * @return the name of the employee
     */
    String getName();

    /**
     * Gets the employee's ID.
     *
     * @return the ID of the employee
     */
    String getID();

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    double getPayRate();

    /**
     * Gets the employee's Type as a string.
     * <p>
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     * <p>
     * You may want to consider using an enum to store the type, and using .name() to get the string representation.
     *
     * @return the type of the employee as a string
     */
    String getEmployeeType();

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    double getYtdEarnings();

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    double getYtdTaxesPaid();

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set amounts or percents,
     * and often more than one type of deduction.
     * <p>
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     *
     * @return the pretax deductions for the employee
     */
    double getPretaxDeductions();

    /**
     * Runs the employee's payroll.
     * <p>
     * This will calculate the pay for the current pay, update the YTD earnings, and update the taxes paid YTD.
     * <p>
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for withholding. or 22.65% total.
     * They are calculated on the net pay (after pretax deductions).
     * <p>
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours, then payRate * 1.5 *
     * (hoursWorked - 40) for overtime.
     * <p>
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * <p>
     * If either type of employee has < 0 hours, they are skipped this payroll period. (suggestion return null, and skip
     * adding nulls to your paystub list)
     * <p>
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * <p>
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * <p>
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors. SUGGESTION: You
     * may want to create a protected abstract calculateGrossPay(double hoursWorked) method to calculate the gross pay
     * for the pay period, as runPayroll is exactly the same for both SalaryEmployee and HourlyEmployee, but
     * calculateGrossPay is different.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    PayStub runPayroll(double hoursWorked);


    /**
     * Converts the employee to a CSV string.
     * <p>
     * Format of the String s as follows:
     * <p>
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * <p>
     * employee_type has the options for HOURLY or SALARY.
     * <p>
     * You do not have to worry about commas in the name or any other field.
     *
     * @return the employee as a CSV string
     */
    String toCsv();

}
