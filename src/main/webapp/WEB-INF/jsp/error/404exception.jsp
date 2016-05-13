<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta content="text/html" charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="<c:url value="/assets/css/404.css"/>" rel="stylesheet">
  <link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet">
  <title>404</title>
</head>

<body>

<div class="container bootstrap snippet">
  <div class="row">
    <div class="col-md-12">
      <div class="pull-right" style="margin-top:10px;">
        <div class="col-md-10 col-md-offset-1 pull-right">
          <img class="img-error" src="http://bootdey.com/img/Content/fdfadfadsfadoh.png">
          <h2>${code}</h2>
          <p>${message}</p>
          <div class="error-actions">
            <a href="<c:url value="/"/> " class="btn btn-primary btn-lg">
              <span class="glyphicon glyphicon-arrow-left"></span>
              Back Home
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>