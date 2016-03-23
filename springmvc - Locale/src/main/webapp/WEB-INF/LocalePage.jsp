<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<h1>Spring MVC internationalization example</h1>

	Language :
	<a href="?language=en">English</a>|
	<a href="?language=zh_CN">Chinese</a>
	<a href="?language=si_LK">Sinhala</a>

	<h2>
		welcome.springmvc :
		<spring:message code="welcome.springmvc" text="default text" />
	</h2>

	Current Locale : ${pageContext.response.locale}

</body>
</html>
