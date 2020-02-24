// Global method to serialize the form input

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function serializeChips(chipsData){
	var chips = null;
	for(chip of chipsData){
		if(chips)
			chips = chips + ","+ chip['tag'];
		else
			chips = chip['tag'];
	}
	return chips?chips:"";
}

// Initialize Materialize date picker
$(document).ready(function(){
	var today			=	new Date();
	var currentDay		=	today.getDate();
	var currentMonth	=	today.getMonth()+1;
	var currentYear		=	today.getFullYear();
	$(".datepicker").datepicker({
	    defaultDate: new Date(),
	    maxDate: new Date(currentYear,currentMonth,currentDay),
	    yearRange: [1928, currentYear],
	    format: "mmm dd, yyyy"    
	});
});

// Initialize $put and $delete
jQuery.each( [ "put", "delete" ], function( i, method ) {
  jQuery[ method ] = function( url, data, callback, type ) {
    if ( jQuery.isFunction( data ) ) {
      type = type || callback;
      callback = data;
      data = undefined;
    }

    return jQuery.ajax({
      url: url,
      type: method,
      dataType: type,
      data: data,
      success: callback
    });
  };
});