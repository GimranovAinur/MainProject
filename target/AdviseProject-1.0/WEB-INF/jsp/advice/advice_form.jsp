<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:mainLayout title="Advise">

  <security:authorize access="isAuthenticated()">
    <div class="container" style="padding-top: 40px;">
      <div class="section-header">
          <h2 class="section-title text-center wow fadeInDown">Give Advice</h2>
          <h4 class="text-center wow fadeInDown">${wish.text}</h4>
      </div>
    </div>
    <form:form method="POST" commandName="advice">
      <div class="container">
      <div class="row">
      <div class="col-md-12">
      <div class="widget-area no-padding blank">
      <div class="status-upload">
        <spring:bind path="text">
          <div class="form-group${status.error ? ' has-error' : '' }">
            <form:textarea id="contact-message" path="text" name="comments" placeholder="What's your opinion?"></form:textarea>
            <ul>
              <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Audio"><i class="fa fa-music"></i></a></li>
              <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Video"><i class="fa fa-video-camera"></i></a></li>
              <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Sound Record"><i class="fa fa-microphone"></i></a></li>
              <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Picture"><i class="fa fa-picture-o"></i></a></li>
            </ul>
            <button type="submit" class="btn btn-primary"><i class="fa fa-share"></i> Advise</button>
          </div>
          </div>
          <div  class="container">
            <div class="row">
              <c:if test="${status.error}">
                <div class="login-form-main-message show error" style="padding-top: 10px;">${status.errorMessage}</div>
              </c:if>
            </div>
          </div>
          </div>
          </div>
          </div>
          </div>
        </spring:bind>
    </form:form>

  </security:authorize>

  <security:authorize access="isAnonymous()">
    <section id="cta2">
      <div class="container">
        <div class="text-center">
          <h2 class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms"><span>YOU</span> MUST BE AUTHORIZED TO MAKE WISHES</h2>
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
</t:mainLayout>
