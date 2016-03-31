<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--
--@Author : Bilal AK
--@Date Time : Mar 25, 2016 : 10:56:13 AM
--%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/bootstrap/css/ionicons.min.css" rel="stylesheet" type="text/css">
        <link href="resources/css/rowmenu/rowmenu.css" type="text/css" rel="stylesheet" />        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	
	<div class="body">
		<tiles:insertAttribute name="topbar" />	
	
	</div>	
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>