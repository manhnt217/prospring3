<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Page</title>
    </head>
    <body>
        <c:if test="${not empty bookList}">
        <table border="thin">
            <tr>
                <th>Name</th>
                <th>Category</th>
            </tr>
            <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.category}</td>
            </tr>
            </c:forEach>
        </table>
        </c:if>
    </body>
</html>