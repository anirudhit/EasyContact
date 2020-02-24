// Script to delete employee details
$( document ).ready(function() {
	
	 $(document).on("click", ".emp-delete" , function() {
        let empId = $(this).attr("data-delete-id");
        let _deleteUrl = `http://localhost:8080/EasyContact/EmployeeServlet?empId=${empId}`;
	    $.delete(_deleteUrl,null, function(result){
	    	console.log(result);
	    	location.reload();
	    });
        
     });
	
	
});