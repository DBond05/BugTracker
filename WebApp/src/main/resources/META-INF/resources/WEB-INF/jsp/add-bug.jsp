		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		<div class="container" onpageshow="resolvedFunction()"> 
			<h3> Enter Details</h3>
			<hr>
			<form:form method ="post" modelAttribute="bug">
				<fieldset class="mb-3">
					<form:label path = "description" > Description: </form:label>
					<br>
					<form:textarea path= "description" required="required" rows="3" cols="50%"/>
					<br>
					<form:errors  path= "description" cssClass= "text-warning"/>
				</fieldset>
				<fieldset class="mb-3">
					<form:label path = "dateStamp" > Reported Date: </form:label> 
					<br>
					<form:input type = "date" path= "dateStamp" required="required"/>
					<br>
					<form:errors  path= "dateStamp" cssClass= "text-warning"/>
					<hr>
				</fieldset >
				<br>
				<h3> Resolve Bug</h3>
				<fieldset id = "resolve" class="mb-3>
					<form:label path="isResolved" > Resolved: </form:label>
					<form:checkbox value="Resolved" path= "isResolved"/>
					<br>
					<form:label path = "resolution" > Resolution: </form:label>
					<br>
					<form:textarea path= "resolution" rows="3" cols="50%" />
					<br>
					<form:errors  path= "resolution" cssClass= "text-warning"/>
				</fieldset>
				<br>
				<form:input type = "hidden" path= "id"/>
				
				<input type = "submit" class = "btn btn-success"/>
				<a href="bugsList" class= "btn btn-warning">Cancel</a>
				
			</form:form> 
			
			<script>
			function resolvedFunction(){
			 document.getElementById("resolve").innerHTML=
			}
			</script>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
			<script src"webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
			<script type = "text/javascript">
			$('#dateStamp').datepicker({
			 format: 'yyyy-mm-dd'
			});
			</script>
		</div>
		<hr>
	</BODY>
</HTML>

