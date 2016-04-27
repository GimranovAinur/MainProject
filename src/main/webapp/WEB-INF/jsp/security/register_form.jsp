<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:mainLayout title="Registration">

    <div class="text-center" style="padding:50px 0">
        <div class="logo">register</div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form:form method="POST" commandName="user" id="register-form" class="text-left">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <t:input cssClass="form-control" label="Name" required="true" path="name" placeholder="name"/>
                        </div>
                        <div class="form-group">
                            <t:input label="Surname" required="true" path="surname" placeholder="surname"/>
                        </div>
                        <div class="form-group">
                            <t:input label="E-mail" required="true" path="username" placeholder="mail"/>
                        </div>
                        <div class="form-group">
                            <t:password label="Password" required="true" path="password" placeholder="password"/>
                        </div>
                        <div class="form-group">
                            <t:password label="Confirm password" required="true" path="passwordRepeat" placeholder="confirm password"/>
                        </div>

                        <div class="form-group login-group-checkbox">
                            <input type="radio" class="" name="reg_gender" id="male" placeholder="username">
                            <label for="male">male</label>

                            <input type="radio" class="" name="reg_gender" id="female" placeholder="username">
                            <label for="female">female</label>
                        </div>

                        <div class="form-group login-group-checkbox">
                            <input type="checkbox" class="" id="reg_agree" name="reg_agree">
                            <label for="reg_agree">i agree with <a href="#">terms</a></label>
                        </div>
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p>already have an account? <a href="#">login here</a></p>
                </div>
            </form:form>
        </div>
        <!-- end:Main Form -->
    </div>

</t:mainLayout>