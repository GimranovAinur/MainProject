<%@tag description="MainLayout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@attribute name="title"%>

<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="<c:url value="/assets/js/form.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/owl.carousel.min.js"/>"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/mousescroll.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/smoothscroll.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.prettyPhoto.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.isotope.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.inview.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/wow.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/main.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/list.js"/>"></script>
    <!-- Bootstrap -->
    <link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/list.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/animate.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/owl.carousel.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/owl.transitions.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/prettyPhoto.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/responsive.css"/>" rel="stylesheet">
    <title>${title}</title>
</head>

<body id="home" class="homepage">
<c:if test="${not empty message}" >
    <c:out value="${message}"/>
</c:if>
<jsp:include page="/WEB-INF/jsp/blocks/header.jsp"/>
<jsp:doBody/>
</body>
</html>