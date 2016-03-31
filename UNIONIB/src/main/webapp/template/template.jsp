<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--
--@Author : Asitha Perera
--@Date Time : Mar 18, 2016 : 6:26:13 AM
--%>
<!DOCTYPE html>
<html>
<head>
<script src="resources/js/jquery-2.2.2.js" type="text/javascript"></script>
 <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <link href="resources/font-awesome-4.5.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
 
 <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
 <link href="resources/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
 <link href="resources/css/skins/skin-blue.min.css" rel="stylesheet" type="text/css" />
 <link href="resources/css/scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" /> 
         <script src="resources/js/scrollbar/jquery.mCustomScrollbar.concat.min.js" type="text/javascript"></script>
          <link href="resources/css/home/home.css" rel="stylesheet" type="text/css" />
   <script>
            $(function() {
                $("#rowmenu").load("template/rowmenu.jsp");
            });
            $(function() {
                $("#head").load("template/header.jsp");
            });
        </script>
</head>

<body class="skin-blue layout-top-nav">
	<div class="body">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>