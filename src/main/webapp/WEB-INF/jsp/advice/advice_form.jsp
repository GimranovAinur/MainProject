<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:footerless_layout title="Wish">
    <div class="container">
      <div class="row">

        <div class="col-md-12">
          <div class="widget-area no-padding blank">
            <div class="status-upload">
              <form>
                <textarea placeholder="What are you doing right now?"></textarea>
                <ul>
                  <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Audio"><i class="fa fa-music"></i></a></li>
                  <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Video"><i class="fa fa-video-camera"></i></a></li>
                  <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Sound Record"><i class="fa fa-microphone"></i></a></li>
                  <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Picture"><i class="fa fa-picture-o"></i></a></li>
                </ul>
                <button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button>
              </form>
            </div>
            <!-- Status Upload  -->
          </div>
          <!-- Widget Area -->
        </div>

      </div>
    </div>
</t:footerless_layout>
