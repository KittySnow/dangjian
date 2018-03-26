/**
 *
 * Responsive website using AngularJS
 * http://www.script-tutorials.com/responsive-website-using-angularjs/
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright 2013, Script Tutorials
 * http://www.script-tutorials.com/
 */

'use strict';

// angular.js main app initialization
var app = angular.module('bonanzooka', []).
config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'pages/dashboard.html',
            activetab: 'dashboard',
            controller: HomeCtrl
        }).
        when('/project/:projectId', {
            templateUrl: function(params) {
                return 'pages/' + params.projectId + '.html';
            },
            controller: ProjectCtrl,
            activetab: 'projects'
        }).
        when('/mail', {
            templateUrl: 'pages/mail.html',
            controller: MailCtrl,
            activetab: 'mail'
        }).
        when('/about', {
            templateUrl: 'pages/about.html',
            controller: AboutCtrl,
            activetab: 'about'
        }).
        when('/general', {
            templateUrl: 'pages/general.html',
            controller: GeneralCtrl,
            activetab: 'general'
        }).
        when('/icons', {
            templateUrl: 'pages/icons.html',
            controller: IconsCtrl,
            activetab: 'icons'
        }).
        when('/slider', {
            templateUrl: 'pages/slider.html',
            controller: SliderCtrl,
            activetab: 'slider'
        }).
        when('/morris', {
            templateUrl: 'pages/morris.html',
            controller: MorrisCtrl,
            activetab: 'morris'
        }).
        when('/editors', {
            templateUrl: 'pages/editors.html',
            controller: EditorsCtrl,
            activetab: 'editors'
        }).
        when('/advanced', {
            templateUrl: 'pages/advanced.html',
            controller: AdvancedCtrl,
            activetab: 'advanced'
        }).
        when('/general-element', {
            templateUrl: 'pages/general-element.html',
            controller: GeneralElementCtrl,
            activetab: 'GeneralElement'
        }).
        when('/table', {
            templateUrl: 'pages/table.html',
            controller: TableCtrl,
            activetab: 'Table'
        }).
        when('/data-table', {
            templateUrl: 'pages/data-table.html',
            controller: DataTableCtrl,
            activetab: 'DataTable'
        }).
        when('/button', {
            templateUrl: 'pages/button.html',
            controller: ButtonCtrl,
            activetab: 'Button'
        }).
        when('/typhography', {
            templateUrl: 'pages/typhography.html',
            controller: TyphographyCtrl,
            activetab: 'Typhography'
        }).
        when('/calendar', {
            templateUrl: 'pages/calendar.html',
            controller: CalendarCtrl,
            activetab: 'Calendar'
        }).
        when('/invoice', {
            templateUrl: 'pages/invoice.html',
            controller: InvoiceCtrl,
            activetab: 'Invoice'
        }).
        when('/masonry', {
            templateUrl: 'pages/masonry.html',
            controller: MasonryCtrl,
            activetab: 'Masonry'
        }).
        when('/404', {
            templateUrl: 'pages/404.html',
            controller: ErrorCtrl,
            activetab: 'Error'
        }).
        when('/timeline', {
            templateUrl: 'pages/timeline.html',
            controller: TimeLineCtrl,
            activetab: 'TimeLine'
        }).
        when('/blank', {
            templateUrl: 'pages/blank.html',
            controller: BlankCtrl,
            activetab: 'Blank'
        }).
        when('/blog-list', {
            templateUrl: 'pages/blog-list.html',
            controller: BlogListCtrl,
            activetab: 'BlogList'
        }).
        when('/blog-detail', {
            templateUrl: 'pages/blog-detail.html',
            controller: BlogDetailCtrl,
            activetab: 'BlogDetail'
        }).
        when('/flot', {
            templateUrl: 'pages/flot.html',
            controller: FloatCtrl,
            activetab: 'Float'
        }).
        when('/shop', {
            templateUrl: 'pages/shop.html',
            controller: ShopCtrl,
            activetab: 'Shop'
        }).
        when('/shop-detail', {
            templateUrl: 'pages/shop-detail.html',
            controller: ShopDetailCtrl,
            activetab: 'ShopDetail'
        }).
        when('/peta', {
            templateUrl: 'pages/peta.html',
            controller: PetaCtrl,
            activetab: 'Peta'
        }).
        when('/shop-list', {
            templateUrl: 'pages/shop-list.html',
            controller: ShopListCtrl,
            activetab: 'ShopList'

        }).
        when('/BimModel/modelList/:id', {
            templateUrl: 'pages/BimModel/modelList.html',
            controller: BimProjerctCtrl,
            activetab: 'BimProject'
        }).
        when('/BimModel/addModel/:id', {
            templateUrl: 'pages/BimModel/addModel.html',
            controller: BimProjerctCtrl,
            activetab: 'BimProject'
        }).
        when('/BimProject/projectList', {
            templateUrl: 'pages/BimProject/projectList.html',
            controller: BimProjerctCtrl,
            activetab: 'BimProject'
        }).
        when('/BimProject/addProject', {
            templateUrl: 'pages/BimProject/addProject.html',
            controller: BimProjerctCtrl,
            activetab: 'BimProject'
        }).
        when('/UserAdmin/userAdmin', {
            templateUrl: 'pages/UserAdmin/userAdmin.html',
            controller: UserAdminCtrl,
            activetab: 'UserAdmin'
        }).
        when('/UserAdmin/addUser', {
            templateUrl: 'pages/UserAdmin/addUser.html',
            controller: UserAdminCtrl,
            activetab: 'UserAdmin'
        }).
        when('/UserAdmin/editUser/:userid', {
            templateUrl: 'pages/UserAdmin/editUser.html',
            controller: UserAdminEditCtrl,
            activetab: 'UserAdmin'
        }).
        when('/DepartmentList/departmentList', {
            templateUrl: 'pages/DepartmentList/departmentList.html',
            controller: DepartmentListCtrl,
            activetab: 'DepartmentList'
        }).
        when('/DepartmentList/addDepartment', {
            templateUrl: 'pages/DepartmentList/addDepartment.html',
            controller: DepartmentListCtrl,
            activetab: 'DepartmentList'
        }).
        when('/DepartmentList/editDepartment/:departmentid', {
            templateUrl: 'pages/DepartmentList/editDepartment.html',
            controller: DepartmentListEditCtrl,
            activetab: 'DepartmentList'
        }).
        when('/SpaceAdmin/spaceAdmin', {
            templateUrl: 'pages/SpaceAdmin/spaceAdmin.html',
            controller: SpaceAdminCtrl,
            activetab: 'SpaceAdmin'
        }).
        when('/SpaceAdmin/addSpace', {
            templateUrl: 'pages/SpaceAdmin/addSpace.html',
            controller: SpaceAdminCtrl,
            activetab: 'SpaceAdmin'
        }).
        when('/SpaceAdmin/editSpace/:spaceid', {
            templateUrl: 'pages/SpaceAdmin/editSpace.html',
            controller: SpaceAdminEditCtrl,
            activetab: 'SpaceAdmin'
        }).    
        when('/RoleList/roleList', {
            templateUrl: 'pages/RoleList/roleList.html',
            controller: RoleListCtrl,
            activetab: 'RoleList'
        }).
        when('/RoleList/addRole', {
            templateUrl: 'pages/RoleList/addRole.html',
            controller: RoleListCtrl,
            activetab: 'RoleList'
        }).
        when('/RoleList/editRole/:roleid', {
            templateUrl: 'pages/RoleList/editRole.html',
            controller: RoleListEditCtrl,
            activetab: 'RoleList'
        }).
        when('/FeatureList/featureList', {
            templateUrl: 'pages/FeatureList/featureList.html',
            controller: FeatureListCtrl,
            activetab: 'FeatureList'
        }).
        when('/FeatureList/addFeature', {
            templateUrl: 'pages/FeatureList/addFeature.html',
            controller: FeatureListCtrl,
            activetab: 'FeatureList'
        }).
        when('/FeatureList/editFeature/:featureid', {
            templateUrl: 'pages/FeatureList/editFeature.html',
            controller: FeatureListEditCtrl,
            activetab: 'FeatureList'
        }).
        when('/FeatureList/setFeature/:roleid', {
            templateUrl: 'pages/FeatureList/setFeature.html',
            controller: SetFeatureList,
            activetab: 'FeatureList'
        }).
        when('/BimModel/setLocation/:id/:rid', {
            templateUrl: 'pages/BimModel/setLocation.html',
            controller: BimProjerctCtrl,
            activetab: 'BimProject'
        }).
        when('/BimProject/editProject/:pid', {
            templateUrl: 'pages/BimProject/editProject.html',
            controller: BimProjerctEditCtrl,
            activetab: 'BimProject'
        }).
        when('/BimModel/editModel/:id/:rid', {
            templateUrl: 'pages/BimModel/editModel.html',
            controller: BimModelEditCtrl,
            activetab: 'BimProject'
        }).
        when('/SysLog/sysLog', {
            templateUrl: 'pages/SysLog/sysLog.html',
            controller: SysLogCtrl,
            activetab: 'SysLog'
        }).
        when('/ReportAdmin/reportAdmin', {
            templateUrl: 'pages/ReportAdmin/reportAdmin.html',
            controller: ReportAdminCtrl,
            activetab: 'ReportAdmin'
        }).
        when('/WxMenu/wxMenu', {
            templateUrl: 'pages/WxMenu/wxMenu.html',
            controller: WxMenuCtrl,
            activetab: 'WxMenu'
        }).
        when('/WxBindAdmin/wxBindAdmin', {
            templateUrl: 'pages/WxBindAdmin/wxBindAdmin.html',
            controller: WxBindAdminCtrl,
            activetab: 'WxBindAdmin'
        }).
        when('/WxBindAdmin/addWxBind', {
            templateUrl: 'pages/WxBindAdmin/addWxBind.html',
            controller: WxBindAdminCtrl,
            activetab: 'WxBindAdmin'
        }).
        when('/WxBindAdmin/editWxBind', {
            templateUrl: 'pages/WxBindAdmin/editWxBind.html',
            controller: WxBindAdminEditCtrl,
            activetab: 'WxBindAdminEditCtrl'
        }).
        when('/WxSend/wxSend', {
            templateUrl: 'pages/WxSend/wxSend.html',
            controller: WxSendCtrl,
            activetab: 'WxSendCtrl'
        }).
        otherwise({
            redirectTo: '/',
            activetab: ''
        })
    }
])
.run(function ($rootScope,$route) {
    $rootScope.$on('$routeChangeSuccess', function(event){
        if($route.current.$$route){
            $rootScope.activeSmall = $route.current.$$route.activetab;
            $rootScope.puser = puser;
            $rootScope.checkMenu = function(val){
                if(featureList.indexOf(val)>-1){
                   return true;
                }else{
                   return false;
                }
            }
        }
    });

});
app.config(['$locationProvider',
    function($location) {
        $location.hashPrefix('!');
    }
]);

app.filter('limitTo',function(){
    return function (h,m){//参数 h 为|之前的数据，m 为过滤器之后的数据，如果数据为多个值，可以用:分开
        return m;
    }
});
