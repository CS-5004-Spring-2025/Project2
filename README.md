# Project 2 - Payroll Generator

### Due - Monday, February 10, 11:59pm

Assignment Link:
[https://classroom.github.com/a/ZrOQ8BR3](https://classroom.github.com/a/ZrOQ8BR3)

*This project borrows heavily from Albert Lionelle's payroll-gen project and is used with his permission.*

In this assignment, you will implement a program that will generate and maintain payroll records for a set of employees.

You will practice with the following concepts:
- Inheritance and polymorphism
- Test Driven Development
- Class hierarchies
- Java collections/lists
- Streams 
- File input/output

<hr/>

## Program Operation

The `payroll.PayrollGenerator` class is the main point of entry for the program. When the program is run, it will perform the following tasks:

1. Read in a [CSV](https://en.wikipedia.org/wiki/Comma-separated_values#:~:text=Comma%2Dseparated%20values%20(CSV),typically%20represents%20one%20data%20record.) file containing employee information with one employee per line. The information maintained about each employee is as follows: 
  * Type - HOURLY or SALARY
  * Name - full name maintained as a single String
  * ID - unique String identifier
  * Pay Rate - amount they are paid
  * Pre-tax Deductions - amount deducted from gross pay before taxes are calculated
  * Year-to-date Earnings - updated every time payroll is calculated
  * Year-to-date Taxes Paid - updated every time payroll is calculated
2. Read in a CSV file containing time card information. Each line contains the time card for one employee. The information provided is the ID of the employee and the hours worked for that employee.
3. Run the payroll for each employee. This will calculate the net pay and taxes for a pay period and will update the YTD earnings and taxes paid. The result will be a new pay stub for each employee
4. Save the updated employee information to a new CSV file. 
5. Save the pay stubs to a new CSV file.

## Program Execution

The program may be executed one of two ways:

Option 1: `java payroll.PayrollGenerator` In this case, your solution will use the employee, time card, and pay stub file locations provided in the starter code.

Option 2:

```
java payroll.PayrollGenerator -e employees_mine.csv -t time_cards.csv -o pay_stubs_mine.csv
```

In this case, the user will specify the locations of the csv input and output files at the command line. 

The starter code provides you with an inner class `Arguments` to parse arguments of this format.

## Design

### Starter Code

- `Employee` - an interface that all employees must implement. DO NOT CHANGE THIS FILE. We are providing this file as a contract for you to follow. This may be used in our *hidden* test cases. 
  - Within this file, each method's purpose and constraints are detailed in the javadoc. Make sure to read this carefully.
- `PayStub` - an interface that all pay stubs must implement. You can change this file but it should not be necessary.
- `FileUtil` - This file contains methods that read and write lists from and to files. You can use this as is or you can modify it. Most students will leave this file unchanged. 
- `PayrollGenerator` - This is the main driver class for the program. You will need to complete the implementation of the main method in this class. We have provided some guidance in the file on using FileUtil.java to read and write files. You do not have to use it this way. DO NOT CHANGE the Arguments inner class, and make sure to use it in your code to get the file names. This will allow us to change the program arguments to test your code.
- `Builder` - Contains two methods you will want to implement. While you can add more, you shouldn't need to. Remember to add error checking to the methods as you are reading in file data.
- `TimeCard` - You can update this file but should not need to. Contains two suggested methods for TimeCard object.

### Resources

The `resources` directory contains several csv files you can use for testing. **These should not be the only files you use!** You may want to write another time_cards.csv that has negative values and other edge cases.

## Requirements

### Functionality

*At minimum*, your program must provide the following functionality:

- `Builder`: complete the two methods that have been specified for you in the starter code.
- `TimeCard`: implement a concrete class to provide the functionality specified in the interface.
- `PayStub`: implement a concrete class to provide the functionality specified in the interface.
- `Employee`: implement *at minimum* concrete classes for `HourlyEmployee` and `SalaryEmployee`. It is recommended that you consider an abstract superclass that implements the functionality common between hourly and salary.
- `PayrollGenerator`: complete the functionality described in the `main` method.

You are welcome to implement additional interfaces, abstract classes, or methods.

*Start by understanding the starter code and sketching our your design. Think carefully about the order in which you will implement the pieces of the program.*

### Test Driven Development

You are required to implement unit tests for *every* method you implement. 

Your GitHub commit history must demonstrate that you have used [test driven development](https://martinfowler.com/bliki/TestDrivenDevelopment.html). This means that we expect to see commits of your test code before your implementation! We also expect to see regular commits.  

A good place to start with your solution is the implementation of the `TimeCard` interface. This class will not require implementation of any other parts of your program. Here is one approach that would earn full credit.

1. Create a `TestTimeCard` class and implement several unit tests for your `TimeCard` implementation. You might start with one or two tests that will verify the constructor works as expected.
2. Commit your tests to GitHub. 
3. Work on your implementation of the class that implements the `TimeCard` interface. Implement the constructor, and maybe a `toString` method, and verify your tests pass. 
4. Commit your *partial* solution to GitHub.
5. Add two or three tests for the `getEmployeeID` method. 
6. Commit your revised `TestTimeCard` class to GitHub.
7. Implement the `getEmployeeID` method and verify it passes your tests.
8. Commit your *partial* solution to GitHub. 
9. Add two or three tests for the `getHoursWorked` method. 
10. Commit your revised `TestTimeCard` class to GitHub.
11. Implement the `getHoursWorked` method and verify it passes your tests.
12. Commit your solution to GitHub.

### End-to-end Tests

The test that is provided for you tests the end-to-end functionality of your program (rather than a single method as with a unit test). Using the code provided as a model, you are expected to implement at least two additional end-to-end tests that test different possible conditions.

## Implementation Hints
*Credit to Albert Lionelle.*

Here are a few tips to help you implement the program:

1. A `PayStub` can have a reference to an `Employee` rather than copying all information.

2. You can use the `String.split(",")` method to split a line of a csv file into an array of strings. For example:
   ```java
   String line = "HOURLY,John Doe,12345,15.00,100.0,1000.00,100.00";
   String[] parts = line.split(",");`
   // then each part can be accessed by the index
   if(parts[0].equals("HOURLY")) {
       // do something
   }
   String name = parts[1]; // etc
   ```
   You can check to see if a line is correct by checking the length of the array.
   ```java
   if(parts.length != 7) {
       // throw an exception or something
   }
   ```
3. Don't forget to use try/catch around converting strings to doubles. If you don't, your program will crash if the file is not formatted correctly.
   ```java
   double payRate;
   try {
       payRate = Double.parseDouble(parts[3]);
   } catch(NumberFormatException e) {
       // handle the error
   }
   ```
4. You can use format, round, or BigDecimal to round to two decimal places.
   ```java
   BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
   double rounded = bd.doubleValue();
   ```
   You  may even just want to store values as BigDecimal, and convert to double on request.
   To do this, you need to use some of methods built into BigDecimal like `add`, `subtract`, `multiply`, and `divide`.
   ```java
   public void doSomething(double val) {
      // assume value is a BigDecimal
      BigDecimal bd2 = new BigDecimal(val);
      this.value = value.add(bd2).setScale(2, RoundingMode.HALF_UP);
   }

   public double getValue() {
      return value.doubleValue();
   }
   ```
5. If you want to add a method to make sure your code compiles, but not implement it yet, you can use `throw new UnsupportedOperationException("Not implemented yet")`. This will throw an exception if the method is called, but allow you to compile and test other parts of your code.
   ```java
   public void doSomething() {
       throw new UnsupportedOperationException("doSomething() Not implemented yet");
   }
   ```

6. KEEP IT SIMPLE. Write each 'container' object. Make sure it works via tests, and then expand the features. The **last** thing you should update is the `main` method. Everything else should be tested and working before that.

Above all, make sure you test each method as you write it. This is the key to TDD, but also will make your final testing much, much easier.  

## Reflection

You are required to complete a thoughtful and thorough reflection on your solution, your experience implementing it, and what you learned. You will complete the questions outlined in [REFLECTION.md](REFLECTION.md).

## Grading Rubric

The assignment is worth 25 points in total. For criteria worth two points,
partial credit may be awarded. For criteria worth one point, the solution must
be completely correct to earn credit.

| Criterion                      | Points | 
|--------------------------------|--------|
| Passes test cases provided     | 1      | 
| Passes style check             | 1      | 
| `PayrollGenerator#main`        | 2      |
| `Builder#buildEmployeeFromCsv` | 2      |
| `Builder#buildTimeCardFromCsv` | 2      |
| `TimeCard` implementation      | 1      |
| `PayStub` implementation       | 2      |
| `Employee` hierarchy design    | 2      |
| `HourlyEmployee`               | 1      |
| `SalaryEmployee`               | 1      | 
| Unit tests                     | 2      | 
| End-to-end tests               | 2      | 
| GitHub commits demonstrate TDD | 4      | 
| Javadoc                        | 1      | 
| Reflection                     | 1      | 