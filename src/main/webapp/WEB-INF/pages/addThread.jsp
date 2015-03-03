<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addThread</title>
</head>
<body>
	<form action="#" th:action="@{/add}" th:object="${task}" method="post">
    	<p>Name: <input type="text" th:field="*{name}" /></p>
        <p><input type="submit" value="Submit" />
        <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>