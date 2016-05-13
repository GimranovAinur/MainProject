<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:footerless_layout title="${user.name} ${user.surname}">

  <div class="container">
    <div class="fb-profile">
      <img align="left" class="fb-image-lg" src="${user.backgroundImage}" alt="Profile image example"/>
      <img align="left" class="fb-image-profile thumbnail" src="${user.avatar}" alt="Profile image example"/>
      <div class="fb-profile-text">
        <h1>${user.name} ${user.surname}</h1>
      </div>
    </div>
  </div>

  <section id="pricing">
    <div class="container">
      <div class="row">
        <c:forEach var="wish" items="${user.wishes}" varStatus="loop">
          <div class="col-sm-6 col-md-3">
            <div class="wow zoomIn" data-wow-duration="400ms" data-wow-delay="0ms">
              <ul class="pricing featured">
                <li class="plan-header">
                  <a class="price-duration" href="<c:url value="/wish/${wish.id}/advice"/> ">
								<span class="price">
								 ADVISE
								</span>
                                <span class="duration">
                                    ${wish.dateTime}
                                </span>
                  </a>
                </li>
                <li>
                    ${wish.text}
                </li>
              </ul>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </section>

</t:footerless_layout>