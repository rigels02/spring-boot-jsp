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

        
        <div class="container">
            <img src="${pageContext.servletContext.contextPath}/static/images/Exquisite-kwrite.svg" height="15%" width="15%" class="rounded float-right" alt="img">
            <c:if test="${not empty message}">                
                <div class="alert alert-info">
                    ${message}
                </div>
            </c:if> 
            <form action="${pageContext.servletContext.contextPath}/webtasks" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idTask" name="idTask" value="${task.id}">
                <h2>Employee</h2>
                <div class="form-group col-xs-4">
                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${task.name}" required="true" maxlength="45"/>                                   


                    <label for="createdate" class="control-label col-xs-4">Create Date:</label>  

                    <fmt:formatDate value="${task.date_created}" var= "fdate" type="date" pattern="dd-MM-yyyy HH:mm"/>
                    <!--pattern="^\d{2}-\d{2}-\d{4}$" -->         
                    <input type="text" pattern="^\d{2}-\d{2}-\d{4} \d{2}:\d{2}$"  name="createdate" id="createdate" 
                           class="form-control" value="${fdate}" maxlength="16" placeholder="dd-MM-yyyy HH:mm" 
                           required="true" data-toggle="mytip" title="Date format: dd-MM-yyyy HH:mm"/>


                    <label for="descriptor" class="control-label col-xs-4">Description:</label>
                    <input type="text" name="descriptor" id="descriptor" class="form-control" value="${task.descriptor}" required="true" maxlength="45"/>

                    <label for="completed" class="control-label  col-xs-4">Completed:</label>
                    <select id="completed" name="completed" class="form-control">
                        <option value="0">False</option>
                        <option value="1">True</option>
                    </select>
                    <c:if test="${task.finished}">                
                        <script>

                            var el = document.getElementById('completed');
                            el.value = 1;
                        </script>
                    </c:if>

                    <!--
                    <input type="text" name="completed" id="role" class="form-control" value="${task.finished}" required="true"/> 
                    -->
                    <br></br>

                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
        <script>
            $(document).ready(function () {
                $('[data-toggle="mytip"]').tooltip();
            });
        </script>
    </body>
</html>
