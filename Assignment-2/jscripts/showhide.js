  $(document).ready(function() {
	$("#hide").click(function() {
		$("span").hide();
		$("#toggle").val("Show");
	});
	$("#show").click(function(){
		$("span").show();
		$("#toggle").val("Hide");
	});
	$("#toggle").click(function(){
		if($("#toggle").val() === "Show"){
			$("#toggle").val("Hide");
		}
		else {
			$("#toggle").val("Show");
		}
		$("span").toggle();
	});
});