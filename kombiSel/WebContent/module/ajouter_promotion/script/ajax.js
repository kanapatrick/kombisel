function getSousCatPromotion(idCat){	
	$.ajax({
		'url':'modPromotion',
		'type':'GET',
		'data':{'action' : 'sous_categoriePromotion', 'idCategorie' : escape(idCat)},
		'dataType':'html',
		'success': function(data){
			$('#sous_catPromotion').html(data);
		}
	});
	return false;
};

function getArticle(idCat){	
	$.ajax({
		'url':'modPromotion',
		'type':'GET',
		'data':{'action' : 'sous_article', 'idArticle' : escape(idCat)},
		'dataType':'html',
		'success': function(data){
			$('#promotioned_article').html(data);
		}
	});
	return false;
};