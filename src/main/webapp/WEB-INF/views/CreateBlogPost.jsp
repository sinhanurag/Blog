<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Create a new BlogPost</title>
</head>

<body>

<form:form method="post" action="createBlogPost.html">

<form:label path="location">Location</form:label>
<form:input type="text" path="location"/>

<form:label path="title">Title</form:label>
<form:input type="text" path="title"/>

<form:label path="content">BlogPost</form:label>
<form:textarea path="content" rows="5" cols="30"/>

<input type="submit" value="Post"/>

</form:form>


</body>

</html>