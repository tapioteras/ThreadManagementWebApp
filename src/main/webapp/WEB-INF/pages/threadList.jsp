<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	
	<script>
function threadsController($scope,$http) {
  $http.post("getThreadTasks.html")
  .success(function(response) {$scope.threads = response;});
}
</script>
</head>	
<body>
	<h1>list of threads</h1>
	<div ng-app="" ng-controller="threadsController"> 
	<table>
	  <tr ng-repeat="t in threads">
	    <td>{{ t.id }}</td>
	    <td>{{ t.name }}</td>
	    <td>{{ t.currentStatus }}</td>
	    <td>{{ t.runCount }}</td>
	  </tr>
	</table>
	</div>
</body>
</html>