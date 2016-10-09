window.onload=function(){
	document.getElementById("birthday").addEventListener("click",function(){
		laydate();
	},false) ;  
	document.getElementById("mid").addEventListener("blur",function(){
		validateMid() ;
	},false) ;  
	document.getElementById("name").addEventListener("blur",function(){
		validateName() ;
	},false) ;  
	document.getElementById("age").addEventListener("blur",function(){
		validateAge() ;
	},false) ;  
	document.getElementById("salary").addEventListener("blur",function(){
		validateSalary() ;
	},false) ;
	document.getElementById("note").addEventListener("blur",function(){
		validateNote() ;
	},false) ;
	document.getElementById("myForm").addEventListener("submit",function(e){
		if(!validate()){
			e.preventDefault() ; 
		} 
	},false) ; 
	var trObj = document.all("eleTr") ; 
	for(var x =0 ; x<trObj.length ; x++){
		trObj[x].addEventListener("mouseover",function(){
			BGColor(this,'#ffffff') ; 
		},false) ; 
		trObj[x].addEventListener("mouseout",function(){
			BGColor(this,'#f2f2f2') ;
		},false) ; 
	}
}
function BGColor(obj,color){
	obj.bgColor = color ; 
}
function validate(){
	return validateMid() & validateName() & validateAge() & validateBirthday() & validateSalary() & 
		   validateNote();
}
function validateMid(){   
	return validateRegex("mid",/^\d{4}$/)  ;
}
function validateName(){
	return validateEmpty("name")  ; 
}
function validateAge(){
	return validateRegex("age",/^\d{1,3}$/)  ;
}
function validateBirthday(){
	return validateRegex("birthday",/^\d{4}-\d{2}-\d{2}$/)  ;
}
function validateSalary(){
	return validateRegex("salary",/^\d{1,8}(\.\d{1,2})?$/)  ;
}
function validateNote(){
	return validateEmpty("note")  ;
}