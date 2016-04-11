$(document).ready(function() {
	$("#filter").click(function(){
		$(".filter-box").show();
	})
	$("#btn-close").click(function(){
		$(".filter-box").hide();
	})
	
	$(".dropdown-menu .asc").click(function(){
		console.log("asc");
		$("#order").val("asc");
		$("#formfilter").submit();
	})
	$(".dropdown-menu .desc").click(function(){
		console.log("desc");
		$("#order").val("desc");
		$("#formfilter").submit();
	})
});
