import java.sql.*;
import java.util.Scanner;


public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_crud";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Choose an operation: 1. Create 2. Read 3. Update 4. Delete 5. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createEmployee(connection, scanner);
                        break;
                    case 2:
                        readEmployees(connection);
                        break;
                    case 3:
                        updateEmployee(connection, scanner);
                        break;
                    case 4:
                        deleteEmployee(connection, scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter employee id:");
        int id = scanner.nextInt();
        System.out.println("Enter employee name:");
        String name = scanner.next();
        System.out.println("Enter employee department:");
        String department = scanner.next();

        String query = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, department);
        preparedStatement.executeUpdate();
        System.out.println("Employee created successfully.");
    }

    private static void readEmployees(Connection connection) throws SQLException {
        String query = "SELECT * FROM Employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            System.out.println(new Employee(id, name, department));
        }
    }

    private static void updateEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter employee id to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new employee name:");
        String name = scanner.next();
        System.out.println("Enter new employee department:");
        String department = scanner.next();

        String query = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, department);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter employee id to delete:");
        int id = scanner.nextInt();

        String query = "DELETE FROM Employee WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Employee deleted successfully.");
    }
}
