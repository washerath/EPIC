 <%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page import="com.epic.ib.bean.session.SessionBean" %> 
 <link href="resources/css/header/header.css" type="text/css" rel="stylesheet"> 
 <%
	SessionBean sessBean = (SessionBean) pageContext.getSession().getAttribute("scopedTarget.sessionBean");
%>
<%
	System.out.println("---in the header template. " + sessBean.getIbmobuser().getUsername());
%>
 
 <header class="main-header" style="box-shadow: 2px 2px 2px rgba(136, 136, 136, 0.43);">
                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation"   style="margin-left: 0!important;"                >
                    <!-- Navbar Right Menu -->


                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="ion-navicon" data-toggle="dropdown" role="button" style="background-color: #26518F;font-size: x-large; color: white;">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </a>

                            <!-- Menu start -->
                            <ul class="dropdown-menu multi-column columns-3 animation" style="position:relative;">
                                <div class="row" style="background-color: rgba(42, 90, 158, 0); background: url('resources/img/bank_logo_menu.png') no-repeat 92% 102% / 180px auto;" aria-expanded="false">
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.FDTR}</li>
                                            <li class="divider"></li>
                                            <c:forEach items="${menuPages.FDTR}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            </c:forEach>                                            
                                            <li class="divider"></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.INQR}</li>
                                            <li role="separator" class="divider"></li>
                                             <c:forEach items="${menuPages.INQR}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            </c:forEach>  
                                            <li role="separator" class="divider"></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.RQST}</li>
                                            <li class="divider"></li>
                                              <c:forEach items="${menuPages.RQST}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            </c:forEach> 

                                            <li>&nbsp;</li>
                                            <li>&nbsp;</li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.UTBL}</li>

                                            <li class="divider"></li>
                                             <c:forEach items="${menuPages.UTBL}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            </c:forEach>
                                            <li class="divider"></li>

                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.STOR}</li>

                                            <li role="separator" class="divider"></li>
                                             <c:forEach items="${menuPages.STOR}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            </c:forEach>
                                            <li>&nbsp;</li>
                                            <li class="divider"></li>
                                            <li>&nbsp;</li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li class="divider"></li>
                                            <li class="menu-sub-title">${menuSection.OTHR}</li>
                                            
                                            <li role="separator" class="divider"></li>
                                            <c:forEach items="${menuPages.OTHR}" var="item">
                                            <li><a href="${item.pageURL}">${item.description}</a></li>
                                            <li role="separator" class="divider"></li>
                                            </c:forEach>


                                        </ul>
                                    </div>
                                    <div class="col-lg-2"></div>
                                </div>
                            </ul>
                            <!-- Menu End-->
                            
                        </li>
                        <li class="liclass" style="margin-left: 4%;position:absolute;"><a class="active" href="home.htm">Home</a></li>
                        <li class="liclass prof"  style="position:absolute;">
                            <div class="navbar-custom-menu">
                                <ul class="nav navbar-nav">
                                    <!-- Messages: style can be found in dropdown.less-->
                                    <li class="dropdown messages-menu">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                            <i class="fa fa-envelope-o"></i>
                                            <span class="label label-success">4</span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li class="header">You have 4 messages</li>
                                            <li>
                                                <!-- inner menu: contains the actual data -->
                                                <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 200px;"><ul class="menu" style="overflow: hidden; width: 100%; height: 200px;">
                                                        <li><!-- start message -->
                                                            <a href="#">

                                                                <h4>
                                                                    Support Team
                                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                                </h4>
                                                                <p>Why not buy this?</p>
                                                            </a>
                                                        </li><!-- end message -->
                                                        <li>
                                                            <a href="#">

                                                                <h4>
                                                                    EPIC Design Team
                                                                    <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                                </h4>
                                                                <p>Why not buy this?</p>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#">

                                                                <h4>
                                                                    Developers
                                                                    <small><i class="fa fa-clock-o"></i> Today</small>
                                                                </h4>
                                                                <p>Why not buy this?</p>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#">

                                                                <h4>
                                                                    Sales Department
                                                                    <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                                </h4>
                                                                <p>Why not buy this?</p>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#">
                                                                <div class="pull-left">
                                                                    <img src="resources/img/user2-128x128.png" class="img-circle" alt="user image">
                                                                </div>
                                                                <h4>
                                                                    Reviewers
                                                                    <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                                </h4>
                                                                <p>Why not buy this?</p>
                                                            </a>
                                                        </li>
                                                    </ul><div class="slimScrollBar" style="width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 131.148px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>
                                            </li>
                                            <li class="footer"><a href="../inbox/inbox.html">See All Messages</a></li>
                                        </ul>
                                    </li>

                                    <!-- User Account: style can be found in dropdown.less -->
                                    <li class="dropdown user user-menu">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <img src="data:image/jpeg;base64,${userimage}" class="user-image" alt="User Image"/>
                                            <span class="hidden-xs">&nbsp;</span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <!-- User image -->
                                            <li class="user-header">
                                                <img src="resources/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                                                <p>
                                                    <%out.println(sessBean.getIbmobuser().getFirstname()); %>
                                                    <small>Member since Jan. 2016</small>
                                                    <small>Last login: <%
                                                    try{
                                                    out.println(new SimpleDateFormat().format(sessBean.getIbmobuser().getLastlogindate()));}catch(Exception e){
                                                    out.println("Today");	
                                                    } 
                                                    %></small>
                                                </p>
                                            </li>
                                            <!-- Menu Footer-->
                                            <li class="user-body">
                                                <div class="col-xs-4 text-center">
                                                    <a href="../profile/profile.html">Profile</a>
                                                </div>
                                                <div class="col-xs-4 text-center">
                                                    <a style="text-align: center; padding:5% 5%;"  href="../profile/changepassword.html">Change Password</a>
                                                </div>
                                                <div class="col-xs-4 text-center">
                                                    <a title="Sign out" style="padding-left: 50%; font-size: large;" class="fa fa-sign-out" href="logout.htm"></a>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>

                                    <li class="dropdown notifications-menu">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="fa fa-cogs"></i> 
                                        </a>
                                        <ul class="dropdown-menu">
                                            <!--<li class="header">Settings</li>-->
                                            <li>
                                                <!-- inner menu: contains the actual data -->
                                                <ul class="menu">
                                                    <li>
                                                        <a href="../profile/manageregistrations.html">
                                                            <i></i> Manage Accounts
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="../profile/customize_priority.html">
                                                            <i></i> Settings
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#">
                                                            <i></i> Help
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>    
                        </li>

                    </ul>
                </nav>
            </header>