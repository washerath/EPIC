<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page import="com.epic.ib.bean.session.SessionBean" %> 
 <link href="resources/css/header/header.css" type="text/css" rel="stylesheet"> 
 <%
	SessionBean sessBean = (SessionBean) pageContext.getSession().getAttribute("scopedTarget.sessionBean");
%>
<%--
--@Author : Asitha Perera,Bilal AK
--@Date Time : Mar 18, 2016 : 3:18:37 PM
--%>

<!DOCTYPE html>
<html>


    <head>
        <meta charset="UTF-8">
        <title>Union Bank | Internet Banking</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/font-awesome-4.5.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="lockscreen"  style="background: #032C67;;background-blend-mode: initial;
          color: white;">
        <div class="lockscreen-wrapper">
            <div class="lockscreen-logo" >
                <img style="width: 80%;margin-bottom: 5%;" src="resources/img/logo.png"/>
            </div>
            <div class="lockscreen-name" style="background-color:white;padding-bottom: 20px;
                 padding-top: 5%;font-size: medium; color: black;     border-radius: 9px;">Welcome, ${title}. ${firstname} ${lastname}</div>

            <div class="lockscreen-item" style="padding-bottom: 3%;width: 75%;" >
                <div class="lockscreen-image">
                    <img src="data:image/jpeg;base64,${userimage}" alt="user image"/>
                </div>

                
				<form:form action="checkPassword.htm" modelAttribute="loginform" cssClass="lockscreen-credentials">
                    <div class="input-group" >

                        <label style="color: black;    margin-bottom: 5%;
                               margin-top: 5%;">Please Enter Your Password:</label>
                              
                        <div class="form-group has-feedback">
						<form:password path="password" cssClass="form-control" placeholder="Password" required="required"  />
                            
                            <span class="glyphicon glyphicon-lock  form-control-feedback" style="color: rgba(54, 133, 255, 0.54);
                                  font-size: smaller;"></span>
                        </div>
                        <div class="input-group-btn">
                            <button class="btn" style="
                                    margin-top: 100% !important;
                                    margin-bottom: 0%;
                                    "><i class="fa fa-arrow-right text-muted"></i></button>
                        </div>
                    </div>
                     <label style="color: black;"><c:if test="${message.message != null}">
							${message.message}
						</c:if></label>
                </form:form>
            </div>
            <!--            <div class="help-block text-center">
                            Enter your password to continue your session
                        </div>-->
            <div class='lockscreen-footer text-center' style="padding-top: 30px;font-size: 11px;">
                <b>Version 1.0</b><br>
                <b>Powered by Epic Lanka Technologies (pvt) Ltd. © 2016</b><br>
                All rights reserved
            </div>

            <!--<small style="font-size: 12px;font-weight: 700;margin-top: 5px;margin-bottom: 5px;">Copyright &copy - 2016 Powered by <a href="#" style="color: #3C8DBC">Epic Lanka Technologies (pvt) Ltd.</a></small>-->
        </div>
        <script src="resources/js/jquery-2.2.2.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
