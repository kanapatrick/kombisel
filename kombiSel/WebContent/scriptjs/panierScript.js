function ajouter(id){
	$.ajax({
		'url':'modPanier',
		'type':'GET',
		'data':{'action' : 'add', 'idArticle' : escape(id)},
		'dataType':'html',
		'success': function(data){
			$('#load_panier').html(data);
		}
	});
	return false;
};

function getSousCat(idCat){	
	$.ajax({
		'url':'ajouterarticle',
		'type':'GET',
		'data':{'action' : 'sous_categorieAjout', 'idCategorie' : escape(idCat)},
		'dataType':'html',
		'success': function(data){
			$('#sous_catAjouter').html(data);
		}
	});
	return false;
};

function remove(idArt){	
	window.alert("remove test");
	$.ajax({
		'url':'modPanier',
		'type':'GET',
		'data':{'action' : 'remove', 'idArticle' : escape(idArt)},
		'dataType':'html',
		'success': function(data){
			$('#load_panier').html(data);
		}
	});
	return false;
};

function getSousCate(idCat){
	window.alert("bonjouvffbvfbfbr");
	$.ajax({
		'url':'souscatacc',
		'type':'GET',
		'data':{'action' : 'souscate', 'idCategorie' : escape(idCat)},
		'dataType':'html',
		'success': function(data){
			$('#sousCat').html(data);
		}
	});
	return false;
};

