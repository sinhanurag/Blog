<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Anurag's Corner</title>
    <meta name="description" content="A blog written by Anurag Sinha. The topics include Technology, Photography, Travel and anything that interests me.I am a Java, Node.JS, C++ and PHP programmer.">
    <meta name="keywords" content="Anurag Sinha,Technology,Blog,Java,Node.JS,Javascript,PayPal,Photography,Travel,Experiences,Bangalore,India,Hadoop,Big Data,Machine Learning,California,eBay,Spring,Web,Internet programming">
    <meta name="robots" content="index, follow">
    <meta name="language" content="EN">
    <meta name="author" content="Anurag Sinha">
    <meta name="creationdate" content="February 5 2014">
    <meta name="distribution" content="global">
    <meta name="rating" content="general">
    <meta name="generator" content="FreeMetaTagGenerator.com">

    <link rel="shortcut icon" href="<c:url value="/resources/assets/ico/favicon.ico"/>">

    <title>Anurag's Corner</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/offcanvas.css"/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="/resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
            <a class="navbar-brand" href="#">Anurag's Corner</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!-- /.navbar -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="jumbotron">
                <h1>Anurag's Corner</h1>
                <p>Hi! This is my corner on the web. Here I rant about technology, photography and anything that interests me. </p>
            </div>
            <div class="row">
                <c:forEach items="${miniPosts}" var="miniPost">
                    <div class="col-6 col-sm-6 col-lg-4">
                        <h2>${miniPost.title}</h2>
                        <p>${miniPost.text}</p>
                        <p><a class="btn btn-default" href="/blogPost/${miniPost.postid}" role="button">Read &raquo;</a></p>
                </div>
                 </c:forEach>

            </div><!--/row-->
        </div><!--/span-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <div class="list-group">
                <c:forEach items="${timeLine}" var="timeLineEnt">
                    <c:forEach items="${timeLineEnt.value}" var="post">
                        <a href="/blogPost/${post.postid}" class="list-group-item">${post.title}</a>
                    </c:forEach>

                </c:forEach>
            </div>
        </div><!--/span-->
    </div><!--/row-->

    <hr>

    <footer>
        <p>&copy; Company 2014</p>
    </footer>

</div><!--/.container-->



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/offcanvas.js"/>"></script>
</body>
</html>
