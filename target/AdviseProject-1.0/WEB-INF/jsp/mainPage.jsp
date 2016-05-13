<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:mainLayout title="Home">

  <section id="main-slider">
    <div class="owl-carousel">
      <div class="item" style="background-image: url(<c:url value="/assets/images/slider/bg1.jpg"/>);">
        <div class="slider-inner">
          <div class="container">
            <div class="row">
              <div class="col-sm-6">
                <div class="carousel-content">
                  <h2><span>Adviser</span> is the best Q&A service.</h2>
                  <p>He that will not be counselled cannot be helped.</p>
                  <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('WC#add').build()}">Make a Wish</a>
                  <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('WC#feed').build()}">Give Advice</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="item" style="background-image: url(<c:url value="/assets/images/slider/bg2.jpg"/>);">
        <div class="slider-inner">
          <div class="container">
            <div class="row">
              <div class="col-sm-6">
                <div class="carousel-content">
                  <h2>People need your <span>ADVICE</span></h2>
                  <p>Make the other person's life easier.</p>
                  <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('WC#add').build()}">Make a Wish</a>
                  <a class="btn btn-primary btn-lg" href="${spring:mvcUrl('WC#feed').build()}">Give Advice</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

</t:mainLayout>
