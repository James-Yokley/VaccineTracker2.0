<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Patient List</title>
</head>
<body>
	<div class="d-flex justify-content-left mt-1">
		<a href="FrontPage" class="btn btn-secondary" role="button">Home</a>
	</div>
	<div class="d-flex justify-content-center mt-1">
		<h2>Patient Management</h2>
	</div>
	<div class="d-flex justify-content-center mt-2">
		<a href="AddPatient" class="btn btn-primary" role="button">Add Patient</a>
		
	</div>
	<table class="table table-bordered table-hover mt-3">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Vaccine</th>
			<th>1st Dose</th>
			<th>2nd Dose</th>
			<th></th>
		</tr>
		<c:forEach items="${patients}" var="patient">
			<tr>
				<td>${patient.getId()}</td>
				<td>${patient.getName()}</td>
			<c:forEach items="${entries}" var="entry">
				<c:if test="${entry.getId() == patient.getVaccineId()}">
					<td>${entry.getName()}</td>
					<td>${patient.getFormattedDate(patient.getDate())}</td>
					<c:if test="${entry.getDoseCount() == 1}">
						<td class="text-center">-</td>
					</c:if>
					<c:if test="${patient.getReceivedSecond()}">
						<c:if test="${entry.getDoseCount() > 1}">
						<td>${patient.getFormattedDate(patient.getNextDate())}</td>
						</c:if>
					</c:if>
					<c:if test="${!patient.getReceivedSecond()}">
						<c:if test="${entry.getDoseCount() > 1 }">
							<c:if test="${entry.getDosesLeft() > 0}">
							<td><form method="post" action="Received">
								<input type="hidden" name="patientId" value="${patient.getId()}">
								<input type="hidden" name="vaccineId" value="${entry.getId()}">
								<input type="submit" value="Received">
							</form></td>
							</c:if>
							<c:if test="${entry.getDosesLeft() <= 0}">
								<td>OUT OF STOCK</td>
							</c:if>	
						</c:if>
					</c:if>
				</c:if>
			</c:forEach>	
			</tr>
		</c:forEach>
	</table>

</body>
</html>