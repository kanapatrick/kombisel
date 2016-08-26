<!doctype>

<html>
	<head>
		<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
		<link href="style/submenu.css" rel="stylesheet" /> 
	</head>
	
<body>
	
<nav class="navbar navbar-default" role="navigation">
  <div class="collapse navbar-collapse" id="oNavigation">
    <ul class="nav navbar-nav">
      <li><a href="#">Accueil</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Section A <b class="caret"></b> </a>
        <ul class="dropdown-menu">
          <li><a href="#">Deuxième niveau</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Section B <b class="caret"></b> </a>
        <ul class="dropdown-menu">
          <li class="dropdown-submenu">
            <a tabindex="-1" href="#">Sous-section</a>
            <ul class="dropdown-menu">
              <li><a href="#">Troisième niveau</a></li>
              <li><a href="#">Troisième niveau</a></li>
              <li class="dropdown-submenu">
                <a href="#">Sous-section</a>
                <ul class="dropdown-menu">
                  <li><a href="#">Quatrième niveau</a></li>
                  <li class="dropdown-submenu">
                    <a href="#">Sous-section</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Cinquième niveau</a></li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li><a href="#">Deuxième niveau</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

<div class="row">
	
<div class="col-lg-12">		
<div class="carousel-inner">
<div class="col-md-push-1 col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/imgad/userU.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>les user ici....</p>
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      </div>
    </div>
 </div>
 
 <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/imgad/groupeU.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>les user icci</p>
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-6 col-md-4 col-md-pull-1">
    <div class="thumbnail">
      <img src="img/imgad/categorie.jpg" alt="categorie">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>tous les categories son presenter ici</p>
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      </div>
    </div>
  </div>
		
  <a class="left carousel-control" href="#carousel" data-slide="prev">
<span class="icon-prev"></span>
</a>
<a class="right carousel-control" href="#carousel" dataslide="next">
<span class="icon-next"></span>
</a>
</div>
	
	</div>

</div>
</div>

</div>
		
<script type="text/javascript" src="scriptjs/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>