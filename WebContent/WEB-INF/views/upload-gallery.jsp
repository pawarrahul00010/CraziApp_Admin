<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Blank</title>

  <!-- Custom fonts for this template-->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../css/sb-admin-2.min.css" rel="stylesheet">

<style>
	#imagePreview img {
    margin: 10px;
    width: 20%;
    border: 2px solid #333;
}
</style>

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dash">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="dash">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Interface
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Components</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Components:</h6>
            <a class="collapse-item" href="../buttons.html">Buttons</a>
            <a class="collapse-item" href="../cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="../utilities-color.html">Colors</a>
            <a class="collapse-item" href="../utilities-border.html">Borders</a>
            <a class="collapse-item" href="../utilities-animation.html">Animations</a>
            <a class="collapse-item" href="../utilities-other.html">Other</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Addons
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item active">
        <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Pages</span>
        </a>
        <div id="collapsePages" class="collapse show" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login Screens:</h6>
            <a class="collapse-item" href="login">Login</a>
            <a class="collapse-item" href="register">Register</a>
            <a class="collapse-item" href="forgot">Forgot Password</a>
    <!--         <div class="collapse-divider"></div>
            <h6 class="collapse-header">Other Pages:</h6>
            <a class="collapse-item" href="404">404 Page</a>
            <a class="collapse-item active" href="blank">Blank Page</a> -->
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="../charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="users">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
		<%@include file="navbar.jsp" %>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
      
        <div class="container-fluid">
          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">Create Gallery</h1>
            
            <div class="row">
                
                <div class="col-lg-12">
                    <div class="card shadow mb-4">
                    <div class="card-header py-3">
                     
                      <h6 class="m-0 font-weight-bold text-primary">Upload Images</h6>
                    </div>
                    <div class="card-body">
                      <p>Upload multiple images to the gallery.</p>
                      
                      <div class="row">
                        <div class="col-sm-6">
		                     <form method="POST" action="uploadCard" enctype="multipart/form-data"> 
	                        
	                            <div class="pb-2 pt-2">
	                            <div id="imagePreview"></div>
	                            	<input type="file" id="file" name="file" accept="image/*" required />
			                        <input type="hidden" name="answer" id="answer" />
			                        
	                            </div>
	                            <div class="pb-2">
		                            <input type="text"  name="categoryName" placeholder="Enter Category Name" style="width:100%;">
	                            </div>
	                            <div class="pb-2">                            
	                            <input type="hidden" class="btn btn-primary btn-icon-split"  name="adminId" value="${loggeduser.adminId}">
				                </div>
	                            <div class="pb-2">			                
				                <select name="categoryType" style="width:100%;">
				                	<option >--Select Category Type--</option>
									  <option value="volvo">Volvo</option>
									  <option value="saab">Saab</option>
									  <option value="mercedes">Mercedes</option>
									  <option value="audi">Audi</option>
										</select>
								</div>		
	                            <div class="pb-2">			                
				                <select name="editable" style="width:100%;">
				                	<option >--Select Category Type--</option>
									  <option value="Y">Yes</option>
									  <option value="N">No</option>
										</select>
								</div>		
			                    <div class="pt-2">
				                  	<input type="submit" value="Upload" class="btn btn-primary btn-user">
				                </div>
		                             
		                    </form>
                        </div>
                      
                        <div class="col-sm-6">
	                  	</div>
	                  </div>
                        
                    </div>
                    </div>
                  </div>
                </div>

            </div>

        </div>
        
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Craziapp 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../js/sb-admin-2.min.js"></script>
<script>
        
        var inputLocalFont = document.getElementById("file");
inputLocalFont.addEventListener("change",previewImages,false);

function previewImages(){
  var fileList = this.files;
  var anyWindow = window.URL || window.webkitURL;
  for(var i = 0; i < fileList.length; i++){
    var objectUrl = anyWindow.createObjectURL(fileList[i]);
    $('#imagePreview').append('<img src="' + objectUrl + '" />');
    window.URL.revokeObjectURL(fileList[i]);
  }
}

$('#imagePreview').on('click', 'img', function() {
  var images = $('#imagePreview img').removeClass('selected'),
      img = $(this).addClass('selected');
  
  $('#answer').val(images.index(img));
});

/* $('form').submit(function(e) {
  e.preventDefault();
  alert($('form').serialize());
}); */
        
    </script>
</body>

</html>
