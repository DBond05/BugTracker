
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		<div class="container"> 
			<H1> Bug List </H1>
			<hr>
			<div> 
				<table class="table">
					<thead>
						<tr>

						<th>Description </th>
						<th> Date</th>
						<th> Is Resolved? </th>
						<th> </th>
						<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bugs}" var="bug">
							<tr>

							<td>${bug.description}</td>
							<td>${bug.dateStamp}</td>
							<td>${bug.isResolved}</td>
							<td><a href="delete-bug?id=${bug.id}" class= "btn btn-danger">Delete</a></td>
							 <td><a href="modify-bug?id=${bug.id}" class= "btn btn-info">Update</a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="add-bug" class = "btn btn-success"> Add Bug</a>
			<%@ include file="common/footer.jspf" %>