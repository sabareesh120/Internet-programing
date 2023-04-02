<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="books" value="${fn:sort(bookList, 'price')}" />

<table>
  <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
      <th>ISBN</th>
      <th>Price</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.isbn}</td>
        <td><fmt:formatNumber value="${book.price}" type="currency"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>

Collections.sort(books, Comparator.comparing(Book::getPrice));
request.setAttribute("books", books);

List<Book> books = new ArrayList<Book>();
books.add(new Book("Book 1", "John Doe", "1234567890", 10.99));
books.add(new Book("Book 2", "Jane Smith", "0987654321", 5.99));
books.add(new Book("Book 3", "Bob Johnson", "1357908642", 20.50));

  <table>
  <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
      <th>ISBN</th>
      <th>Price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Book 2</td>
      <td>Jane Smith</td>
      <td>0987654321</td>
      <td>$5.99</td>
    </tr>
    <tr>
      <td>Book 1</td>
      <td>John Doe</td>
      <td>1234567890</td>
      <td>$10.99</td>
    </tr>
    <tr>
      <td>Book 3</td>
      <td>Bob Johnson</td>
      <td>1357908642</td>
      <td>$20.50</td>
    </tr>
