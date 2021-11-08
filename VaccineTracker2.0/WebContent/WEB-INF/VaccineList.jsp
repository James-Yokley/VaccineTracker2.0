<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Vaccine List</title>
</head>
<body>
	<div class="d-flex justify-content-left mt-1">
		<a href="FrontPage" class="btn btn-secondary" role="button">Home</a>
	</div>
	<div class="d-flex justify-content-center mt-1">
		<h2>Vaccine Tracker</h2>
	</div>
	<div class="d-flex justify-content-center mt-2">
		<a href="NewVaccine" class="btn btn-primary" role="button">New Vaccine</a>
		
		<a href="NewDoses" class="btn btn-primary" role="button">New Doses</a>
	</div>
	<table class="table table-striped table-hover mt-3">
		<tr>
			<th>Vaccine</th>
			<th>Doses Required</th>
			<th>Days Between Doses</th>
			<th>Total Doses Received</th>
			<th>Total Doses Left</th>
			<th></th>
		</tr>
		<c:forEach items="${entries}" var="entry">
			<tr>
				<td>${entry.getName()}</td>
				<td>${entry.getDoseCount()}</td>
				<td>${entry.getDayCount()}</td>
				<td>${entry.getDosesReceived()}</td>
				<td>${entry.getDosesLeft()}</td>
				<td><a href="EditVaccine?id=${entry.id}" class="btn btn-secondary">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>