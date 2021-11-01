<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>New Vaccine Entry</title>
</head>
<body>
	<form method="post">
		<div class="form-group">
			<label for="doseName">Name</label>
			<input class="form-control" id="doseName" type="text" name="name" value="${entry.getName()}">
			<input type="hidden" name="id" value="${entry.id}">
		</div>		
		<div class="form-group">	
			<label for="dosesRequiredInput">Doses Required</label>
			<select class="form-control" name="doseCount" id="dosesRequiredInput">
			<c:if test="${entry.getDoseCount() == 1}">
				<option value=1 selected>1</option>
				<option value=2>2</option>
			</c:if>
			<c:if test="${entry.getDoseCount() == 2}">
				<option value=1>1</option>
				<option value=2 selected>2</option>
			</c:if>
			</select>
		</div>
		<div class="form-group">
			<label for="dayCountInput">Days Between Doses</label>
			<input type="text" class="form-control" id="dayCountInput" name="dayCount" value="${entry.getDayCount()}">
			<button class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>