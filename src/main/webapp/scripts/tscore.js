$(document).ready(function(){
	$(".input-score").blur(function(){
		$.ajax({
			type:"POST",
			url:"test",
			data:{
				sno:$(".sno").val(),
				score:$(".input-score").val(),
			},
			success:function(data){
				if(data.success){
					$(".thin-width").html(data.msg);
				}else{
					$(".input-score").hide();
					$(".thin-width").html("出现错误："+data.msg);
				}
			},
			error:function(jqXHR){
				alert("发生错误："+jqXHR.status);
			}
		});
	});
});