<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<div class="navbar navbar-static-top masthead navbar-top " role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#top-nav">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">MultiPlex <sup>Cinema</sup></a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse" id="top-nav">
            <ul class="nav navbar-nav">
                <li ><a href="./index.jsp"><i class="fa fa-home "></i> Home</a></li>
                <li ><a href="#"><i class="fa fa-play"></i> Movies</a></li>
                <li ><a href="#"><i class="fa fa-search"></i> Search</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle profile-image" data-toggle="dropdown">
                        <img src="http://i.imgur.com/hznr4JE.png" class="img-circle special-img"> User Options <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li ><a href="#"><i class="fa fa-user"></i> View Profile</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa fa-cog"></i> Change Details</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-shopping-cart"></i> Purchase History</a></li>
                        <li class="divider"></li>
                        <li><a href="./logout.jsp"><i class="fa fa-key"></i> Log out</a></li>                                               
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>	
