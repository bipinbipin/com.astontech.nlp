<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
    <head>

        <c:url value="/static/images/favicon.ico" var="favicon" />
        <link href="${favicon}" rel="shortcut icon"/>

        <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
        <script src="${jquery}"></script>
        <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.js" var="bootstrap" />
        <script src="${bootstrap}"></script>
        <c:url value="/static/js/common.js" var="common" />
        <script src="${common}"></script>


        <title>Aston Data Resume Tool</title>
    </head>
    <body>



