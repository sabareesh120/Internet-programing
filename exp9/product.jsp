<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>

<%
  // Define the database connection details
  String databaseName = "mydatabase";
  String databaseURL = "jdbc:mysql://localhost:3306/" + databaseName;
  String databaseUsername = "root";
  String databasePassword = "mypassword";
  
  // Create a connection to the database
  Connection conn = null;
  try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  } catch (SQLException e) {
    e.printStackTrace();
  }
  
  // Retrieve the total number of products
  int totalProducts = 0;
  try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
    if (rs.next()) {
      totalProducts = rs.getInt(1);
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  
  // Retrieve the average price of all products
  double averagePrice = 0;
  try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT AVG(price) FROM products");
    if (rs.next()) {
      averagePrice = rs.getDouble(1);
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  
  // Retrieve the category with the highest total price
  String category = "";
  try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT category, SUM(price * quantity) AS total FROM products GROUP BY category ORDER BY total DESC LIMIT 1");
    if (rs.next()) {
      category = rs.getString("category");
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  
  // Close the database connection
  try {
    conn.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
%>

<!-- Display the retrieved data in a table format -->
<table>
  <tr>
    <th>Total Number of Products</th>
    <td><%= totalProducts %></td>
  </tr>
  <tr>
    <th>Average Price of all Products</th>
    <td><%= averagePrice %></td>
  </tr>
  <tr>
    <th>Category with Highest Total Price</th>
    <td><%= category %></td>
  </tr>
</table>
