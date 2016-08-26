<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkomacc.css"/>" /> 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/style/designdoc.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />

<title>Bienvenue sur KombiSell plateforme  e-commerce</title>
</head>

<body class="bg-success">
<c:import url="/template/enteteAcc.jsp" />
<div class="container">
	
	<div class="row">
		<div class="col-xs-12 col-sm-3 col-md-2 col-lg-3">
			<div class="collapse navbar-collapse panel panel-default" id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-left nav-pills nav-stacked  panel-body">
					<li> <a href="<c:url value="/touslescategories"/> "  class="list-group-item active" ><span class="glyphicon glyphicon-list"></span>Catégorie</a></li>
					<c:if test="${!empty listcat && !empty listecats }">
					
						<c:forEach items="${ listcat }" var="cate">
						 <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" ><c:out value="${cate.nomCategorie }"/><span class="glyphicon glyphicon-menu-right pull-right"></span></a>
						 	
						 <ul class="dropdown-menu pull-right" id="sousCat" style="top:0;left:100%;margintop:-6px;">
						 	<c:forEach items="${listecats.get(cate)}" var="soutcat">
						 		<li><a href="<c:url value="/consultearticle"> <c:param  name="action" value="${soutcat.idSousCategorie}"/> </c:url>" ><c:out value="${soutcat.nomSousCategorie}" /></a></li>
							</c:forEach>
						 </ul>
						 	
						 </li>
						</c:forEach>
						<li><a href="<c:url value="/touslescategories"/> ">Autres</a></li>
					 </c:if>
					
				</ul>
			</div>
		</div>
	
		<div class="col-xs-12 col-sm-9 col-md-5 col-lg-6">
			<div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; ">
		
		        <!-- Loading Screen -->
		        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
		            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
		                background-color: #000000; top: 0px; left: 0px;width: 100%;height:100%;">
		            </div>
		            <div style="position: absolute; display: block; background: url(img/loading.gif) no-repeat center center;
		                top: 0px; left: 0px;width: 100%;height:100%;">
		            </div>
		        </div>
		
		        <!-- Slides Container -->
		        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
		            <div>
		                <img u="image"src="<c:url value="/img/slide/chemisse.jpg"/>" />
		            </div>
		            <div>
		                <img u="image"src="<c:url value="/img/slide/lap.jpg"/>" />
		            </div>
		            <div>
		                <img u="image"src="<c:url value="/img/slide/tel.jpg"/>" />
		            </div>
		            <div>
		                <img u="image"src="<c:url value="/img/slide/a.jpg"/>" />
		            </div>
		            <div>
		                <img u="image"src="<c:url value="/img/slide/z.jpg"/>" />
		            </div>
		            <div>
		               <a href=""><img u="image"src="<c:url value="/img/slide/s.jpg"/>" /></a> 
		            </div>
		        </div>
		    
		        <style>
		        
		            .jssorb05 {
		                position: absolute;
		            }
		            .jssorb05 div, .jssorb05 div:hover, .jssorb05 .av {
		                position: absolute;
		                /* size of bullet elment */
		                width: 16px;
		                height: 16px;
		                background: url(img/b05.png) no-repeat;
		                overflow: hidden;
		                cursor: pointer;
		            }
		            .jssorb05 div { background-position: -7px -7px; }
		            .jssorb05 div:hover, .jssorb05 .av:hover { background-position: -37px -7px; }
		            .jssorb05 .av { background-position: -67px -7px; }
		            .jssorb05 .dn, .jssorb05 .dn:hover { background-position: -97px -7px; }
		        </style>
		     
		        <div u="navigator" class="jssorb05" style="bottom: 16px; right: 6px;">
		            <!-- bullet navigator item prototype -->
		            <div u="prototype"></div>
		        </div>
		    
		        <style>
		         
		            .jssora12l, .jssora12r {
		                display: block;
		                position: absolute;
		                width: 30px;
		                height: 46px;
		                cursor: pointer;
		                background: url(img/a12.png) no-repeat;
		                overflow: hidden;
		            }
		            .jssora12l { background-position: -16px -37px; }
		            .jssora12r { background-position: -75px -37px; }
		            .jssora12l:hover { background-position: -136px -37px; }
		            .jssora12r:hover { background-position: -195px -37px; }
		            .jssora12l.jssora12ldn { background-position: -256px -37px; }
		            .jssora12r.jssora12rdn { background-position: -315px -37px; }
		        </style>
		     
		        <span u="arrowleft" class="jssora12l" style="top: 123px; left: 0px;">
		        </span>
		     
		        <span u="arrowright" class="jssora12r" style="top: 123px; right: 0px;">
		        </span>
		     </div>
		     <div class="panel panel-default">
				<div class="row panel-body">
				 	<form action="<c:url value="/search"/>" method="get" role="search" >
				 		<label for="new">Newsletter</label>
						<div class="input-group form-group">
						    <input name="recherchearticle" class="form-control" required type="search"  placeholder="Inscrivez-vous aux newsletter.">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit">S'inscrire</button>
			   				</span>
						</div>
					</form>
				</div>
			</div>
	    </div>
		<div  class="col-xs-12 col-sm-12 col-md-5 col-lg-3">
			<div class="panel panel-default">
				<div class="row panel-body">
					<div class="col-sm-12 col-md-12 col-lg-12 ">
			          <a href="example">
			            <span>
			              <b>SIMPLE</b><br/> 
						  Signalez une demande de achats en juste 1 minute 
			            </span>
			          </a>
					</div>
		        </div>
		        
		        <div class="row panel-body">
		        	<div class="panel">
			        	<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 panel-body">
				          <a href="example/">
				            <span>
				              <b>SIMPLE</b><br/>
				              A very simple Wookmark setup.
				            </span>
				          </a>
			         	 </div>
			        	
				  		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 panel-body">
						
								<p><a href="#"><img src="<c:url value="img/icon/spp.jpg"/>" width=70 height=50/></a></p>
						
						</div>
						
						<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 panel-body">
							<p>ici quelque chose</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	<div id="login" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"><a class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></a>
					<h3 class="modal-title">Connectez-vous !!!</h3>
				</div>
				<div class="modal-body">
				
					 <form action="<c:url value="/index"/> " method="post" class="form-group">
					 	<div class="form-group">
				            <label for="un">Username:</label>
				            <input name="pseudo" id="un" value="" class="form-control" placeholder="pseudo" data-theme="a" type="text">
				        </div>
				        <div class="form-group">
				            <label for="pw" >Password:</label>
				            <input name="motpasse" id="pw" value="" class="form-control" placeholder="mot de passe " data-theme="a" type="password">
				        </div>
				         <div class="modal-footer">
				        	<input type="submit" class="btn btn-info" value="connexion" >
				        	<button class="btn btn-info" data-dismiss="modal">cancel</button>
				        </div>
				    </form>
				</div>
			</div>
		</div>
	</div>

<c:import url="/module/mesarticles/mes_articles.jsp" />	
<c:import url="/module/mesarticles/detailarticle.jsp" />	

<c:import url="/template/footer.jsp" />	
		<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/jssor.js" />"></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/jssor.slider.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js"/> "></script>
		<script> 
			$(function(){
					$('.acc').hide();
			});
		</script>
		<script type="text/javascript">
			$(function () {
				
				$('.carousel').carousel({ interval: 20000 });
				
				$('#previous').click(function() {$('.carousel').carousel('prev'); });
				
				$('#next').click(function() { $('.carousel').carousel('next');});
			});
	</script>
		
		<script type="text/javascript" >
		jQuery(document).ready(function ($) {
		
		    var _SlideshowTransitions = [
		               { $Duration: 1200, $Opacity: 2 }
		    ];
		
		    var options = {
		        $AutoPlay: true,                           
		        $AutoPlaySteps: 1,                                 
		        $AutoPlayInterval: 3000,      
		        $PauseOnHover: 1,                              
		        $ArrowKeyNavigation: true,   			        
		        $SlideDuration: 500,                               
		        $MinDragOffsetToSlide: 20,                          
		        //$SlideWidth: 600,                                
		        //$SlideHeight: 300,                                
		        $SlideSpacing: 0, 					                
		        $DisplayPieces: 1,                                  
		        $ParkingPosition: 0,                                
		        $UISearchMode: 1,                                   
		        $PlayOrientation: 1,                                
		        $DragOrientation: 3,                               
		
		        $SlideshowOptions: {                               
		            $Class: $JssorSlideshowRunner$,                 
		            $Transitions: _SlideshowTransitions,            
		            $TransitionsOrder: 1,                           
		            $ShowLink: true                                 
		        },
		
		        $BulletNavigatorOptions: {                                
		            $Class: $JssorBulletNavigator$,                       
		            $ChanceToShow: 2,                               
		            $AutoCenter: 1,                                 
		            $Steps: 1,                                      
		            $Lanes: 1,                                      
		            $SpacingX: 10,                                  
		            $SpacingY: 10,                                  
		            $Orientation: 1                                 
		        },
		
		        $ArrowNavigatorOptions: {
		            $Class: $JssorArrowNavigator$,              
		            $ChanceToShow: 2,                              
		            $Steps: 1                                       
		        }
		    };
		    var jssor_slider1 = new $JssorSlider$("slider1_container", options);
		
		   
		   
		    function ScaleSlider() {
		        var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
		        if (parentWidth)
		            jssor_slider1.$ScaleWidth(Math.min(parentWidth, 600));
		        else
		            window.setTimeout(ScaleSlider, 30);
		    }
		    ScaleSlider();
		
		    $(window).bind("load", ScaleSlider);
		    $(window).bind("resize", ScaleSlider);
		    $(window).bind("orientationchange", ScaleSlider);
		    });
		</script>
</body>
</html>
