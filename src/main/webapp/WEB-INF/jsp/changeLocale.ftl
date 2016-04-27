<#import "patterns/tags.ftl" as t/>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="<@t.core.url value="/assets/js/jquery-2.2.2.min.js"/>"></script>
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
<body>

<#if message??>
<h1>${message?capitalize}</h1>
</#if>

    <button type="submit" class="locale" id="RUS">RUS</button>
    <button type="submit" class="locale" id="ENG">ENG</button>
</body>
</html>