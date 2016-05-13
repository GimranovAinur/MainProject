<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:mainLayout title="Wish">
    <security:authorize access="isAuthenticated()">
    <form:form method="POST" commandName="wish" id="Highlighted-form" class="col-sm-6 col-sm-offset-3">
    <spring:bind path="text">
    <div class="form-group${status.error ? ' has-error' : '' }">
        <label class="control-label" for="contact-message">Message</label>
        <div class="controls">
            <form:textarea id="contact-message" path="text" name="comments" placeholder="What's in your mind?" class="form-control requiredField Highlighted-label" data-new-placeholder="Your message" rows="6" data-error-empty="Please enter your message"></form:textarea>
            <i class="fa fa-comment"></i>
        </div>
    </div>
    <p><button name="submit" type="submit" class="btn btn-info btn-block" data-error-message="Error!" data-sending-message="Sending..." data-ok-message="Sent"><i class="fa fa-location-arrow"></i>Send</button></p>
    <input type="hidden" name="submitted" id="submitted" value="true">
        <c:if test="${status.error}">
            <div class="login-form-main-message show error">${status.errorMessage}</div>
        </c:if>
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
