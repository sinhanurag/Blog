<%--
  Created by IntelliJ IDEA.
  User: sinhanurag
  Date: 2/6/14
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
<c:forEach items="${timeLines}" var="timeLine">
    <li>${timeLine.postid}&nbsp;&nbsp;${timeLine.title}</li>

</c:forEach>
    </ul>

</body>
</html>
