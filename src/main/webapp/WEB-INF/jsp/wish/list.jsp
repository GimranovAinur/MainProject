<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


  <security:authorize access="isAuthenticated()">
    <t:footerless_layout title="Feed">
  <div class="container">
    <div class="page-header text-center">
      <h1 id="timeline">Feed</h1>
    </div>
    <ul class="timeline">
      <c:choose>
        <c:when test="${not empty wishes}">
          <c:set var="count" value="1" scope="page"/>
          <c:forEach var="wish" items="${wishes}" varStatus="loop">
            <c:if test="${wish.user.id != user.id}">
            <c:choose>
              <c:when test="${count % 2 != 0}">
                <li>
                  <div class="timeline-badge primary"><a><i class="glyphicon glyphicon-record" rel="tooltip" title="${wish.dateTime}"></i></a></div>
                  <div class="timeline-panel">
                    <a href="<spring:url value="/${wish.user.id}"/>">
                      <div class="card hovercard">
                        <div class="card-background">
                          <img class="responsive" alt="" src="${wish.user.backgroundImage}">
                        </div>
                        <div class="useravatar">
                          <img alt="" src="${wish.user.avatar}">
                        </div>

                        <div class="card-info">${wish.user.name} ${wish.user.surname}
                        </div>
                      </div>
                    </a>
                    <div class="timeline-body">
                      <p>${wish.text}</p>
                    </div>
                    <p>
                      <a href="<spring:url value="/wish/${wish.id}/advice"/>" class="btn btn-info btn-block" type="submit">Give Advice!</a>
                    </p>
                  </div>
                </li>
              </c:when>
              <c:otherwise>
                <li class="timeline-inverted">
                  <div class="timeline-badge primary"><a><i class="glyphicon glyphicon-record" rel="tooltip" title="${wish.dateTime}"></i></a></div>
                  <div class="timeline-panel">
                    <a href="<spring:url value="/${wish.user.id}"/>">
                    <div class="card hovercard">
                      <div class="card-background">
                        <img class="responsive" alt="" src="${wish.user.backgroundImage}">
                        <!-- http://lorempixel.com/850/280/people/9/ -->
                      </div>
                      <div class="useravatar">
                        <img alt="" src="${wish.user.avatar}">
                      </div>
                      <div class="card-info">${wish.user.name} ${wish.user.surname}
                      </div>
                    </div>
                    </a>
                    <div class="timeline-body">
                      <p>${wish.text}</p>
                    </div>
                    <p>
                      <a href="<spring:url value="/wish/${wish.id}/advice"/> " class="btn btn-info btn-block" type="submit">Give Advice!</a>
                    </p>
                  </div>
                </li>
              </c:otherwise>
            </c:choose>
              <c:set var="count" value="${count + 1}" scope="page"/>
            </c:if>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <h3>No wishes to show</h3>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
    </t:footerless_layout>
  </security:authorize>
  <security:authorize access="isAnonymous()">
    <t:mainLayout title="Feed">
    <section id="cta2">
      <div class="container">
        <div class="text-center">
          <h2 class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms"><span>YOU</span> MUST BE AUTHORIZED TO SHOW FEED</h2>
          <p class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="100ms">Please log in or register</p>
          <p class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="200ms">
            <a class="btn btn-primary btn-lg" href="<spring:url value="/login"/>">Log In</a>
            <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('SC#register').build()}">Register</a>
          </p>
          <img class="img-responsive wow fadeIn" src="<c:url value="/assets/images/cta2/cta2-img.png"/>" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
        </div>
      </div>
    </section>
    </t:mainLayout>
  </security:authorize>