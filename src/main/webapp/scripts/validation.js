function validar(){
	
	var name  = form.name
	var email = form.email
	
	if(name.value == ""){
		alert("Fill in the name field");
		name.focus()
		
		return false
	}else if(email.value == ""){
		alert("Fill in the email field");
		email.focus()
		
		return false
	}else{
		alert("Data send with sucess")
	}
	
	
}

