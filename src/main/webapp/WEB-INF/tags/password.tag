<%@tag description="Extended password tag to allow for sophisticated errors and Bootstrap theming" pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<%@attribute name="placeholder" required="false" type="java.lang.String" %>
<%--
  Spring form tags: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-form.tld.html
  Spring tags (including bind and its' status variable): http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring.tld.html
--%>
<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">
        <label class="sr-only" for="${path}">${label}</label>
            <form:password path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}" placeholder="${placeholder}"/>
            <c:if test="${status.error}">
                <label id="lg_username-error" class="form-invalid" for="${id}" style="display: block;">
                        ${status.errorMessage}
                </label>
            </c:if>
</spring:bind>