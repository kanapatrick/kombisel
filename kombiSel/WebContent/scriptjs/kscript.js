/**
 * 
 */
$(function(){

	$('.modif').click(function(){
			
			var i = 0;
			var COCHE = false;
				
			for (i=0;i< document.getElementsByName("categorie").length;i++)
			{
				if(document.getElementsByName("categorie").item(i).checked)
				{
					COCHE = true;
					break;
				}
			}
			
			if(COCHE){
				
			}else{
				alert("Pas de case cochée");
				return
			}	
		
	});
	
	
	
	
});