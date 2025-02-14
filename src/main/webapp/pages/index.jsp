<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<h3 class="pb-3 pt-3">Reports Application</h3>
		
		<form:form action="search" modelAttribute="search" method="POST">
			<table>
			  <tr>
			  		<td>PlanName:</td>
			  		<td>
			  			<form:select path="planName">
			  					<form:option value="">-select-</form:option>
			  					<form:options items="${plans}"/>
			  			</form:select>
			  		</td>
			  		
			  		<td>PlanStatus:</td>
			  		<td>
			  			<form:select path="PlanStatus">
			  					<form:option value="">-select-</form:option>
			  					<form:options items="${status}"/>
			  			</form:select>
			  		</td>
			  		
			  		<td>Gender:</td>
			  		<td>
			  			<form:select path="gender">
			  					<form:option value="">-select-</form:option>
			  					<form:option value="Male">Male</form:option>
			  					<form:option value="Fe-Male">Fe-Male</form:option>
			  			</form:select>
			  		</td>
			  </tr>
			  <tr>
			  		<td>StartDate:</td>
			  		<td> <form:input path="planStartDate" type="date" /></td>
			  		<td>EndDate:</td>
			  		<td> <form:input path="planEndDate" type="date" /></td>
			  </tr>
			  
			  <tr>
			  <td><a href="/" class="btn btn-secondary">Reset</a> </td>
			  		<td>
			  		 <input type="submit" value="Search" class="btn btn-primary"/>
			  		</td>
			  </tr>
			</table>
	
	
	</form:form>
	
	<hr>
	
	<table class="table table-striped table-hover">
		<thead>
				<tr>
					<th>Id</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Amount</th>
				</tr>
		</thead>
		</tbody>
				<c:forEach items="${planss}" var="plns" varStatus="index"  >
				 	<tr>
				 		
				 		<td>${index.count}</td>
				 		
				 		<td>${plns.citizenId}</td>
				 		
				 		<td>${plns.citizenName}</td>
				 		
				 		<td>${plns.gender}</td>
				 		
				 		<td>${plns.planName}</td>
				 		
				 		<td>${plns.planStatus}</td>
				 		
				 		<td>${plns.planStartDate}</td>
				 		
				 		<td>${plns.planEndDate}</td>
				 		
				 		<td>${plns.benifitAmount}</td>
				 	</tr>
				 
				</c:forEach>
				<tr>
				<c:if test="${empty planss}">
					<td colspan="8" style="text-align: center;">No Record found</td>
				</c:if>
				</tr>
		</tbody>
	</table>
	
	<hr>
	
	Export: <a href="excel">Excel</a> <a href="pdf">Pdf</a>
		
	</div>
	
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>