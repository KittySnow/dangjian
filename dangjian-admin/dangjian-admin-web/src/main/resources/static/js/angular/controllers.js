﻿/**
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
        url: "./project/queryProject.do?pid="+Number($routeParams.pid),
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
        url: "./model/queryModelInfoByRid.do?rid="+Number($routeParams.rid),
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
        url: "./pspace/queryById.do?spaceid="+Number($scope.spaceid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pDepartment = data.data;
    });
    
    $http({
        method: "GET",
        url: "./pdepartment/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listDepartment = data.data;
    });

}

function SectionListCtrl($scope, $http, $timeout ,$routeParams) {

    $http({
        method: "GET",
        url: "./ppartymember/queryAreaList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listSection = data.data;
    });
}

function SectionListEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.id = $routeParams.id;
    console.log($routeParams);
    console.log($route.current.$$route.activetab);
    $http({
        method: "GET",
        url: "./pSection/queryById.do?id="+Number($scope.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pSection = data.data;
    });
    
}

function DepartmentListCtrl($scope, $http, $timeout ,$routeParams) {

}

function DepartmentListEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.departmentid = $routeParams.departmentid;
    $http({
        method: "GET",
        url: "./pdepartment/queryById.do?departmentid="+Number($scope.departmentid),
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
        url: "./model/queryModelInfoByRid.do?rid="+Number($routeParams.rid),
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
        url: "./prole/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });

    $http({
        method: "GET",
        url: "./pdepartment/getList.do",
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
        url: "./prole/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });

    $http({
        method: "GET",
        url: "./puser/queryById2.do?userid="+Number($scope.userid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.userData = data.data;
    });

    $http({
        method: "GET",
        url: "./pdepartment/getList.do",
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
		url: "./prole/queryById.do?roleId="+Number($scope.roleid),
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
        url: "./prole/queryById.do?roleId="+Number($scope.roleid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pRole = data.data;

        $.ajax({
            method: 'GET',
            url: "./prole/selectFeatureByRoid.do?roleid="+$scope.pRole.roleid,
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
            url: "./prole/insertFeature.do",
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
		url: "./pfeature/queryById.do?featureid="+Number($scope.featureid),
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).success(function (data,status) {
		$scope.pFeature = data.data;
	});
}


function ScoreLevelCtrl($scope, $http, $timeout ,$routeParams) {

}
function ScoreLevelEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.scoreid = $routeParams.scoreid;
    $http({
        method: "GET",
        url: "./pscorelevel/queryById.do?scoreid="+Number($scope.scoreid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pScorelevel= data.data;
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

function ScoreProjectCtrl($scope, $http, $timeout ,$routeParams) {
    
}
function ScoreProjectEditCtrl($scope, $http, $timeout ,$routeParams) {
    $http({
        method: "GET",
        url: "./pscoreproject/queryById.do?id="+Number($routeParams.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pScoreProject = data.data;
    });
}
function ScoreDetailCtrl($scope, $http, $timeout ,$routeParams) {

}
function ScoreDetailAddCtrl($scope, $http, $timeout ,$routeParams) {
    $http({
        method: "GET",
        url: "./pscoreproject/getList.do",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    }).success(function (data, status) {
        $scope.listChoose = data.data;
    });
    $http({
        method: "GET",
        url: "./prole/getList.do",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    }).success(function (data, status) {
        $scope.roleChoose = data.data;
    });
}
function ScoreDetailEditCtrl($scope, $http, $timeout ,$routeParams) {
    $http({
        method: "GET",
        url: "./pscoreproject/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });
    $http({
        method: "GET",
        url: "./prole/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.roleChoose = data.data;
    });

    $http({
        method: "GET",
        url: "./pscoredetail/queryById.do?id="+Number($routeParams.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pScoreDetail = data.data;
    });
}
function ScorePartyCtrl($scope, $http, $timeout ,$routeParams) {

}
function ScorePartyAddCtrl($scope, $http, $timeout ,$routeParams) {
    $http({
        method: "GET",
        url: "./pscoredetail/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });
}
function ScorePartyEditCtrl($scope, $http, $timeout ,$routeParams) {
    $http({
        method: "GET",
        url: "./pscoredetail/getList.do",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.listChoose = data.data;
    });

    $http({
        method: "GET",
        url: "./pscoreparty/queryById.do?id="+Number($routeParams.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pScoreParty = data.data;
    });
}
function ActiveCtrl($scope, $http, $timeout ,$routeParams) {
}
function ActiveEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.id = $routeParams.id;
    $http({
        method: "GET",
        url: "./pactive/queryById.do?id="+Number($scope.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pActive= data.data;
    });
}
function PartyMemberCtrl($scope, $http, $timeout ,$routeParams) {
}
function PartyMemberEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.id = $routeParams.id;
    $http({
        method: "GET",
        url: "./ppartymember/queryById.do?id="+Number($scope.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pPartymember= data.data;
    });
}

function PartymemberDuesCtrl($scope, $http, $timeout ,$routeParams) {
}
function PartymemberDuesEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.dues_id = $routeParams.dues_id;
    $http({
        method: "GET",
        url: "./ppartymemberdues/queryById.do?dues_id="+Number($scope.dues_id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pPartymemberDues= data.data;
    });
}
function StudyModuleCtrl($scope, $http, $timeout ,$routeParams) {
}
function StudyModuleEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.studyid = $routeParams.studyid;
    $http({
        method: "GET",
        url: "./pstudy/queryById.do?studyid="+Number($scope.studyid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pStudy= data.data;
    });
}
function PartyScoreItemCtrl($scope, $http, $timeout ,$routeParams) {
}
function PartyScoreItemEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.itemid = $routeParams.itemid;
    $http({
        method: "GET",
        url: "./ppartymembergetscoreitem/queryById.do?itemid="+Number($scope.itemid),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pPartymemberGetScoreItem= data.data;
    });
}

function StudyPicCtrl($scope, $http, $timeout ,$routeParams) {
}
function StudyPicEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.id = $routeParams.id;
    $http({
        method: "GET",
        url: "./pstudypicture/queryById.do?id="+Number($scope.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pStudyPicture= data.data;
    });
}

function WxUserCtrl($scope, $http, $timeout ,$routeParams) {
}
function WxUserEditCtrl($scope, $http, $timeout ,$routeParams) {
    $scope.id = $routeParams.id;
    $http({
        method: "GET",
        url: "./pwxuser/queryById.do?id="+Number($scope.id),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).success(function (data,status) {
        $scope.pWxUser= data.data;
    });
}
