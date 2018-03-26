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

// optional controllers

function HomeCtrl($scope, $http) {}

function ProjectCtrl($scope, $http) {}

function MailCtrl($scope, $http, $timeout) {}

function GeneralCtrl($scope, $http, $timeout) {}

function IconsCtrl($scope, $http, $timeout) {}

function SliderCtrl($scope, $http, $timeout) {}

function MorrisCtrl($scope, $http) {}

function EditorsCtrl($scope, $http) {}

function AboutCtrl($scope, $http, $timeout) {}

function AdvancedCtrl($scope, $http, $timeout) {}

function GeneralElementCtrl($scope, $http, $timeout) {}

function DataTableCtrl($scope, $http, $timeout) {}

function TableCtrl($scope, $http, $timeout) {}

function ButtonCtrl($scope, $http, $timeout) {}

function TyphographyCtrl($scope, $http, $timeout) {}

function CalendarCtrl($scope, $http, $timeout) {}

function InvoiceCtrl($scope, $http, $timeout) {}

function MasonryCtrl($scope, $http, $timeout) {}

function MapCtrl($scope, $http, $timeout) {}

function ErrorCtrl($scope, $http, $timeout) {}

function TimeLineCtrl($scope, $http, $timeout) {}

function BlankCtrl($scope, $http, $timeout) {}

function BlogListCtrl($scope, $http, $timeout) {}

function BlogDetailCtrl($scope, $http, $timeout) {}

function FloatCtrl($scope, $http, $timeout) {}

function ShopCtrl($scope, $http, $timeout) {}

function ShopDetailCtrl($scope, $http, $timeout) {}

function ShopListCtrl($scope, $http, $timeout) {}

function PetaCtrl($scope, $http, $timeout) {}

function BimProjerctCtrl($scope, $http, $timeout ,$routeParams) {
	$scope.pid = $routeParams.id;
	$scope.rid = $routeParams.rid;
}

function BimProjerctEditCtrl($scope, $http, $timeout ,$routeParams) {
	$scope.pid = $routeParams.pid;
	$http({    
        method: "POST",    
        url: "./../project/queryProject.do?pid="+Number($routeParams.pid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }  
	}).success(function (data,status) {
    	$scope.proData = data.data;
    });  
}


function BimModelEditCtrl($scope, $http, $timeout) {
	$scope.pid = $routeParams.id;
	$scope.rid = $routeParams.rid;
	$http({    
        method: "POST",    
        url: "./../model/queryModelInfoByRid.do?rid="+Number($routeParams.rid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }  
	}).success(function (data,status) {
    	$scope.modelData = data.data;
    });  
}


function SpaceAdminCtrl($scope, $http, $timeout ,$routeParams) {

}

function SpaceAdminEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.spaceid = $routeParams.spaceid;
    $http({
        method: "GET",
        url: "./../pspace/queryById.do?spaceid="+Number($scope.spaceid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pDepartment = data.data;
    });
    
    $http({
        method: "GET",
        url: "../pdepartment/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listDepartment = data.data;
    });

}

function DepartmentListCtrl($scope, $http, $timeout ,$routeParams) {

}

function DepartmentListEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.departmentid = $routeParams.departmentid;
    $http({
        method: "GET",
        url: "./../pdepartment/queryById.do?departmentid="+Number($scope.departmentid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pDepartment = data.data;
    });
}


function BimModelEditCtrl($scope, $http, $timeout) {
    $scope.pid = $routeParams.id;
    $scope.rid = $routeParams.rid;
    $http({
        method: "POST",
        url: "./../model/queryModelInfoByRid.do?rid="+Number($routeParams.rid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.modelData = data.data;
    });
}



function UserAdminCtrl($scope, $http, $timeout ,$routeParams,$route) {
	console.log($routeParams);
    console.log($route.current.$$route.activetab);
    $http({
        method: "GET",
        url: "../prole/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });

    $http({
        method: "GET",
        url: "../pdepartment/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listDepartment = data.data;
    });

}
function UserAdminEditCtrl($scope, $http, $timeout ,$routeParams) {
	 $scope.userid = $routeParams.userid;
	 $scope.province = "";
    $scope.listChoose = "";
    $http({
        method: "GET",
        url: "../prole/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });

    $http({
        method: "GET",
        url: "./../puser/queryById.do?userid="+Number($scope.userid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.userData = data.data;
    });

    $http({
        method: "GET",
        url: "../pdepartment/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listDepartment = data.data;
    });



}

function RoleListCtrl($scope, $http, $timeout ,$routeParams) {

}
function RoleListEditCtrl($scope, $http, $timeout ,$routeParams) {
	$scope.roleid = $routeParams.roleid;
	$http({
		method: "GET",
		url: "./../prole/queryById.do?roleId="+Number($scope.roleid),
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function (data,status) {
		$scope.pRole = data.data;
	});
}

function FeatureListCtrl($scope, $http, $timeout ,$routeParams) {
	
}
function SetFeatureList($scope, $http, $timeout ,$routeParams){
    $scope.roleid = $routeParams.roleid;
    $http({
        method: "GET",
        url: "./../prole/queryById.do?roleId="+Number($scope.roleid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pRole = data.data;

        $.ajax({
            method: 'GET',
            url: "../prole/selectFeatureByRoid.do?roleid="+$scope.pRole.roleid,
        }).done(function (response) {
            var arr1 = [];
            for (var i = 0; i < response.data.length; i++) {
                var obj = response.data[i];
                arr1.push(obj.featureid)
            }
            initFeatureRoleListTable($scope,arr1);
        });

    });

    $scope.saveFeature = function(pRole){
        var listData = $("#FeatureRoleListTable").bootstrapTable('getSelections');
        var string = "";
        listData.forEach(function(value,index,arr){
            string +=value.featureid+','
        });
        string = string.substring(0,string.length-1);
        $.ajax({
            method: 'GET',
            url: "../prole/insertFeature.do",
            data:{roleid:pRole.roleid,featureids:string}
        }).done(function (res) {
            var dialog = art.dialog({
                title: '提示',
                content: res.success?'操作成功':res.msg,
                icon: res.success?'succeed':'error',
                follow: document.getElementById('btn2'),
                ok: function(){
                    dialog.close()
                }
            });
        });
    }
}
function FeatureListEditCtrl($scope, $http, $timeout ,$routeParams) {
	$scope.featureid = $routeParams.featureid;
	$http({
		method: "GET",
		url: "./../pfeature/queryById.do?featureid="+Number($scope.featureid),
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function (data,status) {
		$scope.pFeature = data.data;
	});
}

function SysLogCtrl($scope, $http, $timeout ,$routeParams) {

}

function ReportAdminCtrl($scope, $http, $timeout ,$routeParams) {

}

function WxMenuCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.WxMenuData =  [
        {key:1,children:[{num:1},{num:2},{num:3},{num:4},{num:5}]},
        {key:2,children:[{num:1},{num:2},{num:3},{num:4},{num:5}]},
        {key:3,children:[{num:1},{num:2},{num:3},{num:4},{num:5}]}
    ];
}
function WxBindAdminCtrl($scope, $http, $timeout ,$routeParams) {

}
function WxBindAdminEditCtrl($scope, $http, $timeout ,$routeParams) {

}
function WxSendCtrl($scope, $http, $timeout ,$routeParams) {

}