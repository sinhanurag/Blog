<%--
  Created by IntelliJ IDEA.
  User: sinhanurag
  Date: 2/5/14
  Time: 8:47 PM
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

    <title>${blogPost.title}</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/offcanvas.css"/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

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
</div>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">Anurag's Corner</h1>
        <p class="lead blog-description">Welcome to my corner on the web!</p>
    </div>

    <div class="row">

        <div class="col-sm-8 blog-main">

            <div class="blog-post">
                <h2 class="blog-post-title">${blogPost.title}</h2>
                <p class="blog-post-meta"><fmt:formatDate value="${blogPost.date}" pattern="EEE, d MMM yyyy" />&nbsp;by &nbsp;<a href="#">Anurag</a></p>

                ${blogPost.text}
            </div><!-- /.blog-post -->


            <ul class="pager">
                <li><a href="/blogPost/${blogPost.postid}">Previous</a></li>
                <li><a href="/blogPost/${blogPost.postid}">Next</a></li>
            </ul>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>About</h4>
                <p>I am <em>Anurag Sinha</em> currently working at PayPal. I am a tech enthusiast and a photographer. Here I blog about topics that interest me.</p>
            </div>
            <div class="sidebar-module">
                <h4>Archives</h4>
                <ol class="list-unstyled">
                    <li><a href="#">January 2014</a></li>
                    <li><a href="#">December 2013</a></li>
                    <li><a href="#">November 2013</a></li>
                    <li><a href="#">October 2013</a></li>
                    <li><a href="#">September 2013</a></li>
                    <li><a href="#">August 2013</a></li>
                    <li><a href="#">July 2013</a></li>
                    <li><a href="#">June 2013</a></li>
                    <li><a href="#">May 2013</a></li>
                    <li><a href="#">April 2013</a></li>
                    <li><a href="#">March 2013</a></li>
                    <li><a href="#">February 2013</a></li>
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
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</div><!-- /.container -->

<div class="blog-footer">
    <p>Anurag's Corner</p>
    <p>
        <a href="#">Back to top</a>
    </p>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/offcanvas.js"/>"></script>
<script src="../../assets/js/docs.min.js"></script>
</body>
</html>

