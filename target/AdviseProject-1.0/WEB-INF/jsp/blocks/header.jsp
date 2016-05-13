
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<header id="header">
    <nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${spring:mvcUrl('WC#mainPage').build()}"><img src="/assets/images/logo.png" alt="logo"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <security:authorize access="isAuthenticated()">
                    <li class="scroll"><a href="${spring:mvcUrl('UC#myWishes').build()}">My Wishes</a></li>
                    </security:authorize>
                    <li class="scroll"><a href="${spring:mvcUrl('WC#add').build()}">Wish</a></li>
                    <li class="scroll"><a href="${spring:mvcUrl('WC#feed').build()}">Feed</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <security:authorize access="isAuthenticated()">
                        <li><a href="${spring:mvcUrl('SC#profile').build()}">Profile</a></li>
                        <li><a href="<spring:url value="/logout" />">Log out</a></li>
                    </security:authorize>
                    <security:authorize access="isAnonymous()">
                        <li><a href="${spring:mvcUrl('SC#register').build()}">Register</a></li>
                        <li><a href="<spring:url value="/login"/>">Log in</a></li>
                    </security:authorize>
                </ul>
            </div>
        </div>
    </nav>
</header>