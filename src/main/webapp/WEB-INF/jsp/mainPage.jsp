<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                  <h2><span>Multi</span> is the best Onepage html template</h2>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna incididunt ut labore aliqua. </p>
                  <a class="btn btn-primary btn-lg" href="#">Read More</a>
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
                  <h2>Beautifully designed <span>free</span> one page template</h2>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna incididunt ut labore aliqua. </p>
                  <a class="btn btn-primary btn-lg" href="#">Read More</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

</t:mainLayout>
