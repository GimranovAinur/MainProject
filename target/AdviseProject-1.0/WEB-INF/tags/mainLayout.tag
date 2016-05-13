<%@tag description="MainLayout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@attribute name="title"%>

<c:if test="${not empty messageType}" >
  <c:choose>
    <c:when test="${messageType == 'success'}">
      <c:set var="messageClass" value="success"/>
    </c:when>
    <c:when test="${messageType == 'fail'}">
      <c:set var="messageClass" value="error"/>
    </c:when>
  </c:choose>
</c:if>


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
  <link href="<c:url value="/assets/css/wish.css"/>" rel="stylesheet">
  <title>${title}</title>
</head>

<body id="home" class="homepage">
<c:if test="${not empty message}" >
  <div class="container">
    <div class="row">
      <div class="col-md-6" style="width: 70%; padding-left: 400px;">
        <div class="login-form-main-message show ${empty messageClass ? '' : messageClass}">${message}</div>
      </div>
    </div>
  </div>
</c:if>
  <jsp:include page="/WEB-INF/jsp/blocks/header.jsp"/>
    <jsp:doBody/>
  <jsp:include page="/WEB-INF/jsp/blocks/footer.jsp"/>
</body>
</html>