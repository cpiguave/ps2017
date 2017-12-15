






	function nuevo_usuario(){
		var tabla = $.ajax({
				type: 'POST',
				url: './../Protegido/nuevo_cliente.xhtml',
				async:false
			}).responseText;
			
			document.getElementById("contenido").innerHTML = tabla;
		}

	
		
		
