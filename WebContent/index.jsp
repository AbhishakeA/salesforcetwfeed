<!--##Salesforce Twitter Feed Application##

This JSP is forwarded from TwitterServlet
The scope of this page is list of statuses from Servlet

It renders multiple divs and display all the paramenters
of top ten status of Salesforce Twitter handle

There is a search on top of the page which invokes the javascript
which performs the search operation on the list/table redendered

There is also another javascript function to reload page for every 60 seconds
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="twitter4j.Status" %>
<%@ page import="java.util.*" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Salesforce Twitter Feed</title>
      <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
      <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
      <link rel="stylesheet" type="text/css" href="/css/styleSheet.css">
      <script type="text/javascript" charset="utf8" src="/js/tfeed.js"></script>
      <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
      <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>
      
   </head>
   <body onload = "setTimeout(reLoad, 61000);">
      <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:13%"></div>
      <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:13%;right:0"></div>
      <div style="margin-left:13%;margin-right:13%">
         <div class="w3-container w3-teal">
            <h1 align ="center">Salesforce Twitter Feed</h1>
         </div>
         <div class="w3-container w3-teal">
            <table >
               <tr style="vertical-align:center">
                  <td style="vertical-align:center">
                     <input type="text"  size="40" id="myInput" onkeyup="mySearch()"  placeholder="Search Feed..">
                  </td>
               </tr>
            </table>
         </div>
         <div class="w3-container">
            <table cellpadding="0" cellspacing="0" border="0" class="dataTable" id="feedTable">
               <tbody>
                  <c:forEach items="${statuses}" var="status">
                     <tr style="border-bottom: 0.5px solid #ddd">
                        <td style="vertical-align:top;border-bottom: 0.5px solid #ddd">
                           <img src="
                           <c:url value="${status.getUser().getProfileImageURL()}"/>
                           " width="50" height ="50"/>
                        </td>
                        <td style="vertical-align:top;border-bottom: 0.5px solid #ddd">
                           <span style="font-weight:bold">
                              <c:out value="${status.getUser().getName()}"/>
                           </span>@<c:out value="${status.getUser().getScreenName()}"/>
                        </td>
                        <td style="vertical-align:top;border-bottom: 0.5px solid #ddd">
                           <c:out value="${status.getText()}"/>
                           <c:set var="urlList" value="${status.getURLEntities()}" scope="application" />
                           <c:forEach items="${urlList}" var="urlLink">
                              <a style="color: blue" href=
                              <c:url value="${urlLink.getDisplayURL()}"/>
                              >
                              <c:url value="${urlLink.getDisplayURL()}"/>
                              </a>	
                           </c:forEach>
                           <c:set var="medialist" value="${status.getMediaEntities()}" scope="application" />
                           <c:forEach items="${medialist}" var="media">
                              <img src="
                              <c:url value="${media.getMediaURL()}"/>
                              " width="350" height ="300"/>
                           </c:forEach>
                        </td>
                        <td style="vertical-align:top;border-bottom: 0.5px solid #ddd">
                           <table>
                              <tr>
                                 <td style="vertical-align:top" >
                                    <c:out value="${status.getRetweetCount()}"/>
                                    Retweets
                                 </td>
                                 <td style="vertical-align:top">
                                    <fmt:formatDate type = "both" 
                                       dateStyle = "short" timeStyle = "short" value = "${status.getCreatedAt()}" />
                                 </td>
                              </tr>
                           </table>
                        </td>
                     </tr>
                  </c:forEach>
               <tbody>
            </table>
         </div>
      </div>
   </body>
</html>