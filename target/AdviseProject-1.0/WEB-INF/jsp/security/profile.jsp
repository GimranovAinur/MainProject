<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:footerless_layout title="Profile">
  <div class="container">
    <div class="fb-profile">
      <img align="left" class="fb-image-lg" src="<security:authentication property="principal.backgroundImage" />" alt="Profile image example"/>
      <img align="left" class="fb-image-profile thumbnail" src="<security:authentication property="principal.avatar" />" alt="Profile image example"/>
      <div class="fb-profile-text">
        <h1><security:authentication property="principal.name" /> <security:authentication property="principal.surname" /></h1>
      </div>
    </div>
  </div>
  <form:form method="POST" commandName="user" class="text-left">
    <div class="container" style="padding-top: 15px;">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <t:input label="Name" required="true" path="name"/>
          </div>
          <div class="form-group">
            <t:input label="Surname" required="true" path="surname"/>
          </div>
          <div class="form-group">
            <t:input path="backgroundImage" required="true" label="Background Image URL:"/>
          </div>
          <div class="form-group">
            <t:input path="avatar" required="true" label="Avatar URL:"/>
          </div>
          <button class="btn btn-primary" style="align: center;" type="submit">Edit</button>
        </div>
      </div>
    </div>
  </form:form>
</t:footerless_layout>
