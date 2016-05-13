<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:footerless_layout title="My Wishes">
  <security:authorize access="isAuthenticated()">
      <section id="pricing">
        <div class="container">
          <div class="row">
            <c:forEach var="wish" items="${wishes}" varStatus="loop">
            <div class="col-sm-6 col-md-3">
              <div class="wow zoomIn" data-wow-duration="400ms" data-wow-delay="0ms">
                  <ul class="pricing featured">
                    <li class="plan-header">
                      <a class="price-duration" href="<c:url value="/wish/${wish.id}"/> ">
								<span class="price">
								 SHOW
								</span>
                                <span class="duration">
                                    ${wish.dateTime}
                                </span>
                      </a>
                    </li>
                    <li>
                        <p style="white-space:normal; word-break: break-all;">${wish.text}</p>
                    </li>
                  </ul>
              </div>
            </div>
            </c:forEach>
          </div>
        </div>
      </section>
  </security:authorize>

  <security:authorize access="isAnonymous()">
    <section id="cta2">
      <div class="container">
        <div class="text-center">
          <h2 class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms"><span>YOU</span> MUST BE AUTHORIZED TO SHOW WISHES</h2>
          <p class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="100ms">Please log in or register</p>
          <p class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="200ms">
            <a class="btn btn-primary btn-lg" href="<spring:url value="/login"/>">Log In</a>
            <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('SC#register').build()}">Register</a>
          </p>
          <img class="img-responsive wow fadeIn" src="<c:url value="/assets/images/cta2/cta2-img.png"/>" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
        </div>
      </div>
    </section>
  </security:authorize>

</t:footerless_layout>