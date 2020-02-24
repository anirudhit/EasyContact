// Script to load employee details
$( document ).ready(function() {
	$.get("http://localhost:8080/EasyContact/EmployeeServlet", function(responseText) {
		
		let employeeDetails = JSON.parse(responseText);
		if(employeeDetails){
			for(employee of employeeDetails){
				
				let eachEmployee = `
					<div class="col s12 m4">
					  <div class="card blue-grey darken-1">
						<div class="card-content white-text">
						  <span class="card-title">${employee.empName}</span>
						  <ul>
						  	<li>
					  			Id : ${employee.empId}
					  		</li>
					  		<li>
					  			Date of joining : ${employee.dateOfJoining}
					  		</li>
					  		<li>
					  			Date of birth : ${employee.dateOfBirth}
					  		</li>
					  		<li>
					  			Skillset : ${employee.skillSet}
					  		</li>
					  	</ul>
						</div>
						<div class="card-action">
						  <a class="cursor-pointer emp-update" data-update-id="${employee.empId}">Update</a>
						  <a class="cursor-pointer emp-delete" data-delete-id="${employee.empId}">Delete</a>
						</div>
					  </div>
					</div>
				`;
				
				$("#employees-list").append(eachEmployee);
				
			}
		}
    });
});