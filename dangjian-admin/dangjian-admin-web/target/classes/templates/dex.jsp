<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="themesmile" />
    <title>东链博服务管理平台</title>
    <meta name="description" content="Responsive website using AngularJS - demo page">
	<meta http-equiv="Cache-Control"content="max-age=0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

    <!-- add styles -->
    <!-- bootstrap 3.2.0 Latest compiled and minified CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/slicknav.css">
    <!-- font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <link href="css/icons-payment.css" rel="stylesheet" type="text/css" />
    <link href="css/flag-icon.css" rel="stylesheet" type="text/css" />
    <link href="css/typicons.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- fullCalendar -->
    <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <!-- Flag -->
    <link href="css/bonanzooka.css" rel="stylesheet" type="text/css" />
    <link href="css/mail.css" rel="stylesheet" type="text/css" />

    <link type="text/css" rel="stylesheet" id="theme" href="css/theme2.css" />
    <!--  Mansory -->
    <link rel="stylesheet" href="css/masonry/main.css">
    <!-- fullCalendar -->
    <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
    <link href="css/fullcalendar/fullcalendar.print.css" rel="stylesheet" type="text/css" media='print' />
    <!-- daterange picker -->
    <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="css/iCheck/all.css" rel="stylesheet" type="text/css" />
    <!-- Bootstrap Color Picker -->
    <link href="css/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet" />
    <!-- Bootstrap time Picker -->
    <link href="css/timepicker/bootstrap-timepicker.min.css" rel="stylesheet" />
    <!-- Editor -->
    <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
    <!-- DATA TABLES -->
    <link href="css/datatables/bootstrap-table.css" rel="stylesheet" type="text/css" />
    <!-- Morris charts -->
    <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
	
	<link href="js/plugins/artDialog/skins/default.css" rel="stylesheet" />
    <!-- Less Style -->
    <!--   <link rel="stylesheet/less" href="less/sidebar.less" type="text/css" />
  <link rel="stylesheet/less" href="less/main.less" type="text/css" />
  <script src="js/less-1.7.3.min.js"></script> -->
    <!-- add javascripts -->
    <!-- jQuery 2.0.2 -->
    <!--   <script src="js/jquery-2.0.3.min.js"></script>  -->
    <script src="js/jquery-2.0.3.min.js"></script>
    <script src="js/angular/angular.min.js"></script>
    <script src="js/angular/angular-menu.js"></script>
    <script src="js/angular/controllers.js"></script>


    <script>
        var puser  = {
        };

        var featureList = [];

    </script>


</head>

<body ng-app="bonanzooka" class="main-theme fixed">


    <header class="header" ng-include src="'views/header.html'">
        <!-- header content -->
    </header>


    <div class="wrapper row-offcanvas row-offcanvas-left">
        <!-- Left Side Column. Contains Sidebar -->
        <aside class="hidden-xs leftmenu sidebar-offcanvas" ng-include src="'views/sidebar1.html'">
            <!-- side bar content -->
        </aside>
        <!-- End of Left Side Column. Contains Sidebar -->
        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
            <!-- MAIN CONTENT -->
            <section class="content">

                <div style="position:relative">
                    <div style="width:100%" ng-view ng-animate="{enter: 'view-enter', leave: 'view-leave'}"></div>

                </div>
                <!-- ./Modal profile pop up -->
                <div ng-include src="'views/profile.html'"></div>

            </section>
            <!-- ./MAIN CONTENT -->
            <footer id="footer" ng-include src="'views/footer.html'">
                <!-- footer content -->
            </footer>
        </aside>
        <!-- /.right-side -->
    </div>
    <!-- ./wrapper -->


    <!-- jQuery UI 1.10.3 -->
    <script src="js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <!-- Bootstrap -->
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- Morris.js charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
    <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script type="text/javascript" src="js/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- iCheck -->
    <script type="text/javascript" src="js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/plugins/weather/skycons.js"></script>
    <!-- Bonanzooka App -->
    <script type="text/javascript" src="js/bonanzooka/app.js"></script>
    <!-- Bonanzooka dashboard demo (This is only for demo purposes) -->
    <script type="text/javascript" src="js/bonanzooka/dashboard.js"></script>
    <script type="text/javascript" src="js/jquery.slicknav.js"></script>
    <script type="text/javascript" src="js/jquery.style-switcher.js"></script>
    <!-- Mansory -->
    <script type="text/javascript" src="js/plugins/masonry/jquery.imagesloaded.js"></script>
    <script type="text/javascript" src="js/plugins/masonry/jquery.wookmark.js"></script>
    
   <!--  <script type="text/javascript" src="js/plugins/artDialog/doc.js"></script> -->
    
    <!-- fullCalendar -->
    <script src="js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
    <!-- InputMask -->
    <script src="js/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
    <script src="js/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
    <script src="js/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
    <!-- bootstrap color picker -->
    <script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js" type="text/javascript"></script>
    <!-- bootstrap time picker -->
    <script src="js/plugins/timepicker/bootstrap-timepicker.min.js" type="text/javascript"></script>
    <!-- Editor -->
    <script src="js/plugins/ckeditor/ckeditor.js" type="text/javascript"></script>
    <script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
    <!-- DATA TABES SCRIPT -->
    <script src="js/plugins/datatables/bootstrap-table.js" type="text/javascript"></script>
    <script src="js/plugins/datatables/bootstrap-table-zh-CN.js" type="text/javascript"></script>
    <!-- FLOT -->
    <script src="js/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
    <script src="js/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
    <script src="js/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
    <script src="js/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
	<!-- H5V -->
	<script src="js/html5validate.js" type="text/javascript"></script>
	<script src="js/ajax.js"></script>
	
	<!-- dialog -->
	<script src="js/plugins/artDialog/artDialog.js"></script>
	<script>
	angular.element(document).ready(function () {
		 var keySession = sessionStorage.getItem('sessionStatus');
		 var userName= sessionStorage.getItem('userName');
		 if(keySession){
			 $(document).keydown(function () {
                if ((event.keyCode == 116) || //屏蔽 F5 刷新键
                    (event.ctrlKey && event.keyCode == 82)) { //Ctrl + R
                    event.keyCode = 0;
                    event.returnValue = false;
                }
             });
		}
	});
	</script>

</body>

</html>
