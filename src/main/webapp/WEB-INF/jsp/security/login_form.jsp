<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:mainLayout title="Authentication">

  <div class="text-center" style="padding:100px 0">
    <div class="logo">login</div>
    <!-- Main Form -->
    <div class="login-form-1">
      <form:form method="POST" commandName="loginForm" id="login-form" class="text-left">

        <c:if test="${error != null}">
          <div class="login-form-main-message show error">Wrong email-password.</div>
        </c:if>
        <div class="main-login-form">
          <div class="login-group">
            <div class="form-group">
              <t:input id="lg_username" label="E-mail" required="true" path="username" placeholder="mail"/>
            </div>
            <div class="form-group">
              <t:password label="Password" required="true" path="password" placeholder="password"/>
            </div>
          </div>
          <input type="hidden" name="${_csrf.parameterName}"
                 value="${_csrf.token}" />
          <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
        </div>
        <div class="etc-login-form">
          <p>new user? <a href="<c:url value="/registration"/> ">create new account</a></p>
        </div>
      </form:form>
    </div>
  </div>

</t:mainLayout>