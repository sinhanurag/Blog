<%--
  Created by IntelliJ IDEA.
  User: sinhanurag
  Date: 2/6/14
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<c:url value="/resources/assets/ico/favicon.ico"/>">

    <title>${time} Blog Archive</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/offcanvas.css"/>" rel="stylesheet">

   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>


<body>

<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Anurag's Corner</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div>

<div class="container">

    <div class="blog-header">
        <h3 class="list-group">${time} Blogpost Archive</h1>

    </div>

    <div class="row">

        <div class="col-sm-8 blog-main">

            <ul class="list-group">

                <c:forEach items="${timeLines}" var="timeLine">

                <li class="list-group-item"><a href="/blogPost/${timeLine.postid}">${timeLine.title}</a> </li>

                </c:forEach>
            </ul>

        </div>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
        <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>I am <em>Anurag Sinha</em> currently working at PayPal. I am a tech enthusiast and a photographer. Here I blog about topics that interest me.</p>
        </div>
        <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
                <c:forEach items="${archive.timeList}" var="time">
                    <li><a href="/archive/${time}">${time}</a></li>
                </c:forEach>
            </ol>
        </div>
        <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
                <li><a href="https://github.com/sinhanurag">GitHub</a></li>
                <li><a href="https://twitter.com/sinhanurag28">Twitter</a></li>
                <li><a href="https://www.facebook.com/anurag.sinha.31149">Facebook</a></li>
            </ol>
        </div>
    </div>

</div>
</div>


</body>
</html>