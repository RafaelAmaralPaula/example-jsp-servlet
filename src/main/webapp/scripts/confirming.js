function confirmation(id){
	var resposta = confirm("Do you confirm the deletion of this person?");
	if(resposta == true){
		//alert(id)
		window.location.href = "delete?id="+id;
		
	}
	
}