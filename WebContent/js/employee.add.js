// Script to load employee details
$( document ).ready(function() {
	
	//Skill set function
	$('.skills-chips-placeholder').chips({
	    placeholder: 'Enter a skill',
	    secondaryPlaceholder: '+Skill',
	});
	
	//Setting a name attribute to skill set
	$(".skills-chips-placeholder input.input").attr({
		"name": "skillSet",
	});
	
	$(`input#empName, textarea#skillSet`).characterCounter();
	
	$( "#employeeSubmit" ).click(function(event) {
		event.preventDefault();
		let req = {};
		req = $('#employee-add').serializeObject();
		req['skillSet'] = serializeChips(M.Chips.getInstance($('.chips')).chipsData);
		
		let _postUrl = "http://localhost:8080/EasyContact/EmployeeServlet";
		$.post( _postUrl, req)
			.done(function( data ) {
				console.log(JSON.parse(data));
		});
		
		
	});
	
});