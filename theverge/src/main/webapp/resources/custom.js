$(document).ready(function() {
	$(document).keydown(function(evt) {
		if (evt.keyCode == 81) {

			$("#dropdown").trigger("click");
		}
	});
});
