function validar(){
	
	var name  = form.name
	var email = form.email
	
	if(name.value == ""){
		alert("Preencha campo name");
		name.focus()
		
		return false
	}else if(email.value == ""){
		alert("Preencha campo e-mail");
		email.focus()
		
		return false
	}else{
		alert("Data send with sucess")
	}
	
	
}

