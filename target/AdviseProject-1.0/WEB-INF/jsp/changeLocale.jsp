<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-2.2.2.min.js"/>"></script>
        <script type="text/javascript">
        $(document).ready(function () {
            $('#RUS').click(function () {
                document.cookie = "lang=ru_RU"
                window.location.reload();
            });

            $('#ENG').click(function () {
                document.cookie = "lang=en_EN"
                window.location.reload();
            });
        })
    </script>

    <title>Name</title>
</head>
<h1>${message}</h1>

    <button type="submit" class="locale" id="RUS">RUS</button>
    <button type="submit" class="locale" id="ENG">ENG</button>
</body>
</html>