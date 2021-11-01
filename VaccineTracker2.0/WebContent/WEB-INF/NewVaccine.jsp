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
	<div class="d-flex justify-content-center mt-1">
		<h3>Enter a New Vaccine</h3>
	</div>
	<form method="post">
		<div class="form-group">
			<label for="nameInput">Name</label>
			<input type="text" name="name" class="form-control" id="nameInput">
		</div>
		<div class="form-group">
				<label for="requiredInput">Doses Required</label>
				<select name="doseCount" class="form-control" id="requiredInput">
				<option value=1>1</option>
				<option value=2 selected>2</option>
				</select>
		</div>		
		<div class="form-group">		
			<label for="daysInput">Days Between Doses</label>
				<input type="text" name="dayCount" class="form-control" id="daysInput">
		</div>		
		<div class="form-group">
				<button class="btn btn-primary">Add</button>
		</div>		
	</form>

</body>
</html>