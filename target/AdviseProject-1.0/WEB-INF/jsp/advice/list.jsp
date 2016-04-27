<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<t:footerless_layout title="Feed">
  <div class="container">
    <div class="page-header text-center">
      <h1 id="timeline">Feed</h1>
    </div>
    <ul class="timeline">
      <c:choose>
        <c:when test="${not empty wishes}">
          <c:forEach var="wish" items="${wishes}" varStatus="loop">
            <c:choose>
              <c:when test="${ wish.id % 2 != 0}">
                <li>
                  <div class="timeline-badge primary"><a><i class="glyphicon glyphicon-record" rel="tooltip" title="11 hours ago via Twitter"></i></a></div>
                  <div class="timeline-panel">
                    <div class="card hovercard">
                      <div class="card-background">
                        <img class="responsive" alt="" src="http://lorempixel.com/1600/500/sports/2">
                        <!-- http://lorempixel.com/850/280/people/9/ -->
                      </div>
                      <div class="useravatar">
                        <img alt="" src="http://lorempixel.com/100/100/people/9/">
                      </div>
                      <div class="card-info"> <span class="card-title">${wish.user.name} ${wish.user.surname}</span>
                      </div>
                    </div>
                    <div class="timeline-body">
                      <p>${wish.text}</p>
                    </div>

                    <div class="timeline-footer">
                      <a><i class="glyphicon glyphicon-thumbs-up"></i></a>
                      <a><i class="glyphicon glyphicon-share"></i></a>
                      <a class="pull-right">${wish.user.name} ${wish.user.surname}</a>
                    </div>
                  </div>
                </li>
              </c:when>
              <c:otherwise>
                <li class="timeline-inverted">
                  <div class="timeline-badge primary"><a><i class="glyphicon glyphicon-record" rel="tooltip" title="11 hours ago via Twitter"></i></a></div>
                  <div class="timeline-panel">

                    <div class="card hovercard">
                      <div class="card-background">
                        <img class="responsive" alt="" src="http://lorempixel.com/100/100/people/9/">
                        <!-- http://lorempixel.com/850/280/people/9/ -->
                      </div>
                      <div class="useravatar">
                        <img alt="" src="http://lorempixel.com/100/100/people/9/">
                      </div>
                      <div class="card-info"> <span class="card-title">${wish.user.name} ${wish.user.surname}</span>
                      </div>
                    </div>
                    <div class="timeline-body">
                      <p>${wish.text}</p>
                    </div>

                    <div class="timeline-footer">
                      <a class="pull-right">${wish.user.name} ${wish.user.surname}</a>
                    </div>
                    <p>
                      <a class="btn btn-info btn-block" type="submit">Give Advice!</a>
                    </p>
                  </div>
                </li>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <h3>No wishes to show</h3>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</t:footerless_layout>