<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Thank you for your business days!</h1>
            </div>
        </div>
    </section>

    <section class="container">
        <p>
            <a href="<spring:url value="/"/>" class="btn btn-default">Ok</a>
        </p>

    </section>
</div>

</div>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>