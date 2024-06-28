package lib;
import java.util.*;
import java.sql.*;

class Main{
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to PostgreSQL database!");

            // Get employee details from the user
            System.out.println("Enter employee regno:");
            int regNo = scanner.nextInt();

            scanner.nextLine(); // Consume newline character

            System.out.println("Enter employee name:");
            String name = scanner.nextLine();

            System.out.println("Enter employee DOB:");
            int dob = scanner.nextInt();

            scanner.nextLine(); // Consume newline character

            System.out.println("Enter employee age:");
            String age = scanner.nextLine();



            // Insert employee data into the "employees" table
            String insertQuery = "INSERT INTO employee (regNo, name, dob, age) " +
                    "VALUES (" + regNo + ", '" + name + "', " + dob + ", " + age + ")";
            int rowsInserted = statement.executeUpdate(insertQuery);

            if (rowsInserted > 0) {
                System.out.println("Employee data inserted successfully!");
            } else {
                System.out.println("Employee data failed to insert.");
                // return;
            }

            // Select and display all employee records from the "employees" table
            String selectQuery = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("Employee Records:");
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("regNo");
                String employeeName = resultSet.getString("name");
                int employeeDOB = resultSet.getInt("dob");
                String employeeAge = resultSet.getString("age");

                System.out.println("regno " + employeeId + ", Name: " + employeeName +
                        ", DOB: " + employeeDOB + ", Age: " + employeeAge);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }
}
