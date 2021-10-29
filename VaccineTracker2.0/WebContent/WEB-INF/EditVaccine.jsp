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
		<table class="table table-striped table-hover mt-3">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${entry.getName()}">
					<input type="hidden" name="id" value="${entry.id}">
				</td>
			</tr>
			<tr>
				<td>Doses Required</td>
				<td><select name="doseCount">
				<c:if test="${entry.getDoseCount() == 1}">
					<option value=1 selected>1</option>
					<option value=2>2</option>
				</c:if>
				<c:if test="${entry.getDoseCount() == 2}">
					<option value=1>1</option>
					<option value=2 selected>2</option>
				</c:if>

				</select>
			</tr>
			<tr>
				<td>Days Between Doses</td>
				<td><input type="text" name="dayCount" value="${entry.getDayCount()}"></td>
			</tr>
			<tr colspan="2">
				<td colspan="2"><button class="btn btn-primary">Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>