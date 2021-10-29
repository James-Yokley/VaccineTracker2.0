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
				<td>Vaccine Name</td>
				<td><select name="doseName">
					<c:forEach items="${entries}" var="entry">
						<option value="${entry.getName()}">${entry.getName()}</option>
					</c:forEach>
				
				</select></td>
			</tr>
			<tr>
				<td>New Doses Received</td>
				<td><input type="text" name="dosesReceived"></td>
			</tr>
			<tr colspan="2">
				<td colspan="2"><button class="btn btn-primary">Add</button></td>
			</tr>
		</table>
	</form>

</body>
</html>