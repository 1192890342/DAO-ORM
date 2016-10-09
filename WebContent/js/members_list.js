window.onload = function(){
	var trObj = document.all("eleTr") ; 
	for(var x =0 ; x<trObj.length ; x++){
		trObj[x].addEventListener("mouseover",function(){
			BGColor(this,'#ffffff') ; 
		},false) ; 
		trObj[x].addEventListener("mouseout",function(){
			BGColor(this,'#f2f2f2') ;
		},false) ; 
	}
	document.getElementById("selall").addEventListener("click",function(){
		selectAll("mid","selall") ; 
	},false) ;
	document.getElementById("deleteBut").addEventListener("click",function(){
		deleteHandle("mid","members_remove_do.jsp") ; 
	},false) ; 
}
function BGColor(obj,color){
	obj.bgColor = color ;  
}