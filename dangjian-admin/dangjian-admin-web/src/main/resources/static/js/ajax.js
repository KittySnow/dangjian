function validateCallback(form, callback, confirmMsg,frontCall) {
	var $form = $(form);
	var bool = false;
	function onprogress(evt){
		 var loaded = evt.loaded;     //已经上传大小情况 
		 var tot = evt.total;      //附件总大小 
		 var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
	}

	if ($.html5Validate.isAllpass($form)) {
        if(typeof frontCall === "function"){
            var bool = frontCall();
            if(bool == false){
                return false;
			}
        }
		if(!$form.find('input[type="file"]').length){
			$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
			    data: $form.serialize()
			}).done(function(res) {
				var dialog = art.dialog({
				    title: '提示',
				    content: res.success?'操作成功':res.msg,
				    icon: res.success?'succeed':'error',
				    follow: document.getElementById('btn2'),
				    ok: function(){
				    	dialog.close();
                        if(typeof callback === "function"){
                            callback();
                        }
				    }
				});
			}).fail(function(res) {
				var dialog = art.dialog({
				    title: '提示',
				    content: res.msg || '网络连接失败',
				    icon: 'error',
				    follow: document.getElementById('btn2'),
				    ok: function(){
				    	dialog.close()
				    }
				});
				setTimeout(function(){dialog.close();dialog=null},2000);
			})
		}else{
			var formData = new FormData(form);
			$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
			    cache: false,
			    data: formData,
			    processData: false,
			    contentType: false,
			    xhr:function(){
		  　　　		var xhr = $.ajaxSettings.xhr();
		  　　　　　 if(onprogress && xhr.upload) {
		  　　　　　 xhr.upload.addEventListener("progress" , onprogress, false);
		  　　　　　 return xhr;
		  　　　		}
		  　　　 }
			}).done(function(res) {
				var dialog = art.dialog({
				    title: '提示',
				    content: '操作成功',
				    icon: 'succeed',
					zIndex:9999,
				    follow: document.getElementById('btn2'),
				    ok: function(){
				    	dialog.close();
                        if(typeof callback === "function"){
                            callback();
                        }
				    }
				});
				setTimeout(function(){dialog.close();dialog=null},2000);

			}).fail(function(res) {
				var dialog = art.dialog({
				    title: '提示',
				    content: res.msg || '网络连接失败',
				    icon: 'error',
				    follow: document.getElementById('btn2'),
				    ok: function(){
				    	dialog.close()
				    }
				});
				setTimeout(function(){dialog.close();dialog=null},2000);
			});
		}
    }
	return false;
	
}

/*bootStrap辅助方法*/
function fmtIdx(value, row, index) {
    return index+1;
}



function deleteAjax(row,url,idName,method,tableName){
	var data = {};
	data[idName] = row[idName];
    if(confirm('是否确认删除')){
        $.ajax({
            type: method||'delete',
            url:url,
            data: data
        }).done(function(res) {
            $('#'+tableName).bootstrapTable('removeByUniqueId', row[idName]);
            var dialog = art.dialog({
                title: '提示',
                content: res.success?'删除成功':res.msg,
                icon: res.success?'succeed':'error',
                ok: function(){
                    dialog.close()
                }
            });
            setTimeout(function(){dialog.close();dialog=null},2000);
        }).fail(function(res) {
            var dialog = art.dialog({
                title: '提示',
                content: '网络连接失败',
                icon: 'error',
                ok: function(){
                    dialog.close()
                }
            });
            setTimeout(function(){dialog.close();dialog=null},2000);
        });
    }
}