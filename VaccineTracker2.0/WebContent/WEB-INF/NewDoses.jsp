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
		<h3>Enter New Doses</h3>
	</div>
	<form method="post">
		<div class="form-group">
			<label for="doseNameInput">Vaccine Name</label>
			<select name="doseName" class="form-control" id="doseNameInput">
				<c:forEach items="${entries}" var="entry">
					<option value="${entry.getName()}">${entry.getName()}</option>
				</c:forEach>	
			</select>
		</div>
		<div class="form-group">
			<label for="newDosesInput">New Doses Received</label>
			<input type="text" name="dosesReceived" class="form-control" id="newDosesInput">
			<button class="btn btn-primary">Add</button>
		</div>
	</form>

</body>
</html>