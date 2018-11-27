<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.ezdms.com/tags/utils" prefix="u" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0"/>
  <title>ezDMS Mobile</title>
  <link rel="apple-touch-icon" href="img/condor.jpg" />
  <link rel="stylesheet" href="../css/jquery.mobile-1.2.0.min.css" />
  <script src="../js/jquery-1.11.3.min.js"></script>
  <script src="../js/jquery.mobile-1.2.0.min.js"></script>
</head>
<body>
  <u:constantsMap className="com.ezdms.dao.bean.Translation" var="Translation"/>
  <u:constantsMap className="com.ezdms.core.Config" var="Config"/>
  <c:url value="Desktop" var="urlDesktop">
    <c:param name="action" value="browse"/>
  </c:url>
  <c:url value="Search" var="urlSearch">
    <c:param name="action" value="searchNormal"/>
  </c:url>
  <c:url value="Dashboard" var="urlDashboard">
    <c:param name="action" value="mainMenu"/>
  </c:url>
  <c:url value="General" var="urlLogout">
    <c:param name="action" value="logout"/>
  </c:url>
  <div data-role="page" data-theme="${Config.MOBILE_THEME}">
    <div data-role="header" data-theme="${Config.MOBILE_THEME}"> 
	  <h1>ezDMS</h1> 
    </div> 
    <div data-role="content" data-theme="${Config.MOBILE_THEME}">
      <div data-role="controlgroup">
	    <a href="${urlDesktop}" data-role="button" data-theme="${Config.MOBILE_THEME}"><u:message key="menu.desktop" module="${Translation.MODULE_MOBILE}"/></a>
	    <a href="${urlSearch}" data-role="button" data-theme="${Config.MOBILE_THEME}"><u:message key="menu.search" module="${Translation.MODULE_MOBILE}"/></a>
	    <a href="${urlDashboard}" data-role="button" data-theme="${Config.MOBILE_THEME}"><u:message key="menu.dashboard" module="${Translation.MODULE_MOBILE}"/></a>
      </div>
      <form method="post" data-ajax="false" action="${urlLogout}">
        <fieldset>          
          <button class="ui-btn-hidden" value="submit" name="submit" data-theme="${Config.MOBILE_THEME}" type="submit"><u:message key="menu.logout" module="${Translation.MODULE_MOBILE}"/></button>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>