<%-- 
    Document   : list-tasks
    Created on : Oct 27, 2017, 6:45:34 PM
    Author     : raitis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.servletContext.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"/>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/static/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/static/jquery/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Tasks!</h1>
        <div class="container">
            <!--Tasks List-->
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
            
            <form action="${pageContext.servletContext.contextPath}/webtasks" method="get" id="taskForm" role="form" >              
                <input type="hidden" id="idTask" name="idTask">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty taskList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Description</td>
                                    <td>Date Created</td>
                                    <td>Finished</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="task" items="${taskList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idTask == task.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/webtasks/do?id=${task.id}&action=searchById">${task.id}</a>
                                    </td>                                    
                                    <td>${task.name}</td>
                                    <td>${task.descriptor}</td>
                                 <td><fmt:formatDate value="${task.date_created}" type="date" pattern="dd-MM-yyyy HH:mm"/>
                                 </td>
                                    <!--td>${task.date_created}</td -->
                                    <td>${task.finished}</td>
                                    
                                    <td>
                                        <form >
                                            
                                        </form>
                                    </td>
                                    <td><a href="${pageContext.servletContext.contextPath}/webtasks/do?id=${task.id}&action=remove" id="remove"> 
                                            <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No Task anymore...
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <a href="${pageContext.servletContext.contextPath}/webtasks/new-task"><span class="btn btn-primary  btn-md">New Task</span></a>
            <!-- form action ="jsp/new-task.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New Task</button> 
            </form-->
        </div>
    </body>
</html>
