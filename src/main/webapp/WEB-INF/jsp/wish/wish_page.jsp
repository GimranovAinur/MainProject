<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:footerless_layout title="Wish Page">
  <c:if test="${not empty wish}">
  <security:authorize access="isAuthenticated()">
  <div class="container" style="padding-top: 20px;">
    <div class="section-header">
      <h2 class="section-title text-center wow fadeInDown">${wish.dateTime}</h2>
      <h3 class="text-center wow fadeInDown">${wish.text}</h3>
    </div>
    <div class="row">
    <div class="col-md-12">
      <h3 class="column-title">Advices</h3>
      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <c:if test="${empty wish.advices}">
          <h4>No Advices</h4>
        </c:if>
        <c:forEach var="advice" items="${wish.advices}" varStatus="loop">
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="heading${advice.id}">
              <h3 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse${advice.id}" aria-expanded="true" aria-controls="collapse${advice.id}">
                    ${advice.user.name} ${advice.user.surname}: ${advice.user.username}
                </a>
              </h3>
            </div>
            <div id="collapse${advice.id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${advice.id}">
              <div class="panel-body">
                ${advice.text}
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    </div>
  </div>
  </security:authorize>
  </c:if>
</t:footerless_layout>
