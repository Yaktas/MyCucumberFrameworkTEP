package DBSteps;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.sql.*;

public class DBStepDefinitions {
    String url = "jdbc:mysql://107.182.225.121:3306/LibraryMgmt";
    String username = "techpro";
    String password = "tchpr2020";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("user connects to the database")
    public void user_connects_to_the_database() throws SQLException {
        //When i was doing database testing , I remember getting the SQL Exception
        //I has to handle it by adding the SQLException to method signature

        connection=DriverManager.getConnection(url,username,password);
        //We need to create a statement 
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    @Given("user connects the Book Table")
    public void user_connects_the_Book_Table() throws SQLException {

        resultSet=statement.executeQuery("SELECT * FROM Book;");
    }

    @Given("prints the first value on BookName")
    public void prints_the_first_value_on_BookName() throws SQLException {
        //going to the first
        resultSet.next();
        //getting the value on the current row(which is row 1)
        String val1=resultSet.getString("BookName");
        System.out.println("FIRST VALUE : "+val1);

    }

    @Given("print the BookName values on the Book Table")
    public void print_the_BookName_values_on_the_Book_Table() throws SQLException {

        while (resultSet.next()){
            System.out.println(resultSet.getRow()+" => "+resultSet.getObject("BookName"));
        }

    }

    @Given("print the total row count")
    public void print_the_total_row_count() throws SQLException {
        //We were at the last row in the previous step
        //So we need to go back to the first row ans start counting
        resultSet.first();
        int rowCount=1;
        while (resultSet.next()){
            rowCount++;
        }
        System.out.println("NUMBER OF ROW => "+rowCount);

    }

    @Given("verify the 5th value is Java")
    public void verify_the_5th_value_is_Java() throws SQLException {
        resultSet.absolute(5);
        String val5=resultSet.getString("BookName");
        Assert.assertTrue(val5.equals("Java"));

    }

    @Given("verify the 1st value is SQL")
    public void verify_the_1st_value_is_SQL() throws SQLException {
        resultSet.first();
        String val1=resultSet.getString("BookName");
        Assert.assertTrue(val1.equals("SQL"));
    }

    @Given("verify the last value is UIPath")
    public void verify_the_last_value_is_UIPath() throws SQLException {
        resultSet.last();
        String valLast=resultSet.getString("BookName");
        Assert.assertTrue(valLast.equals("UIPath"));

    }

}
