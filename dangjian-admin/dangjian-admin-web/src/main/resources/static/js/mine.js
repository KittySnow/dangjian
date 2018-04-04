// 【漫画】 光标定位插件
$.fn.extend({
    insertContent : function(myValue, t) {
        var $t = $(this)[0];
        if (document.selection) {
            this.focus();
            var sel = document.selection.createRange();
            sel.text = myValue;
            this.focus();
            sel.moveStart('character', -l);
            var wee = sel.text.length;
            if (arguments.length == 2) {
                var l = $t.value.length;
                sel.moveEnd("character", wee + t);
                t <= 0 ? sel.moveStart("character", wee - 2 * t	- myValue.length) : sel.moveStart("character", wee - t - myValue.length);
                sel.select();
            }
        } else if ($t.selectionStart || $t.selectionStart == '0') {
            var startPos = $t.selectionStart;
            var endPos = $t.selectionEnd;
            var scrollTop = $t.scrollTop;
            $t.value = $t.value.substring(0, startPos) + myValue + $t.value.substring(endPos,$t.value.length);
            this.focus();
            $t.selectionStart = startPos + myValue.length;
            $t.selectionEnd = startPos + myValue.length;
            $t.scrollTop = scrollTop;
            if (arguments.length == 2) {
                $t.setSelectionRange(startPos - t,$t.selectionEnd + t);
                this.focus();
            }
        } else {
            this.value += myValue;
            this.focus();
        }
    }
});

function textAreaCount(textarea, numScope, options){
    var defaults = {
        maxCharacterSize: 600,
        originalStyle: 'originalTextareaInfo',
        warningStyle: 'warningTextareaInfo',
        warningNumber: 20
    };
    var options = $.extend(defaults, options);
    var container = $(textarea);
    var charLeftInfo = $(numScope);
    var numInput = 0;
    var maxCharacters = options.maxCharacterSize;
    var numLeft = 0;
    var numWords = 0;

    function limitTextAreaByCharacterCount() {
        charLeftInfo.html(countByCharacters());
        return true;
    }
    function countByCharacters() {
        var content = container.val();
        var contentLength = content.length;
        //Start Cut
        if (options.maxCharacterSize > 0) {
            //If copied content is already more than maxCharacterSize, chop it to maxCharacterSize.
            if (contentLength >= options.maxCharacterSize) {
                content = content.substring(0, options.maxCharacterSize);
            }
            var newlineCount = getNewlineCount(content);

            // newlineCount new line character. For windows, it occupies 2 characters
            var systemmaxCharacterSize = options.maxCharacterSize - newlineCount;

            if (!isWin()) {
                systemmaxCharacterSize = options.maxCharacterSize
            }
            if (contentLength > systemmaxCharacterSize) {
                //avoid scroll bar moving
                container.val(content.substring(0, systemmaxCharacterSize));
                //var originalScrollTopPosition = this.scrollTop;
                //this.scrollTop = originalScrollTopPosition;
            }
            charLeftInfo.removeClass(options.warningStyle);
            if (systemmaxCharacterSize - contentLength <= options.warningNumber) {
                charLeftInfo.addClass(options.warningStyle);
            }
            numInput = container.val().length + newlineCount;
            if (!isWin()) {
                numInput = container.val().length;
            }

            numWords = countWord(getCleanedWordString(container.val()));

            numLeft = maxCharacters - numInput;
        } else {
            //normal count, no cut
            var newlineCount = getNewlineCount(content);
            numInput = container.val().length + newlineCount;
            if (!isWin()) {
                numInput = container.val().length;
            }
            numWords = countWord(getCleanedWordString(container.val()));
        }
        return numLeft;
    }
    function isWin() {
        var strOS = navigator.appVersion;
        if (strOS.toLowerCase().indexOf('win') != -1) {
            return true;
        }
        return false;
    }
    function getNewlineCount(content) {
        var newlineCount = 0;
        for (var i = 0; i < content.length; i++) {
            if (content.charAt(i) == '\n') {
                newlineCount++;
            }
        }
        return newlineCount;
    }
    function getCleanedWordString(content){
        var fullStr = content + " ";
        var initial_whitespace_rExp = /^[^A-Za-z0-9]+/gi;
        var left_trimmedStr = fullStr.replace(initial_whitespace_rExp, "");
        var non_alphanumerics_rExp = /[^A-Za-z0-9]+/gi;
        var cleanedStr = left_trimmedStr.replace(non_alphanumerics_rExp, " ");
        var splitString = cleanedStr.split(" ");
        return splitString;
    }
    function countWord(cleanedWordString) {
        var word_count = cleanedWordString.length - 1;
        return word_count;
    }
    container.on('keyup',function(event) {limitTextAreaByCharacterCount();})
        .on('mouseover',function(event) {setTimeout(function() {limitTextAreaByCharacterCount();},10);}).on('paste',function(event) {setTimeout(function() {limitTextAreaByCharacterCount();},10);})

}

//button表情按钮的id或类，scope所属表单id名， textArea内容插入的文本框的id或类
function emotionsCreate(button,scope,textArea,htmlString){
    var switches = scope+" "+button;
    var wrap = scope+" .emotions-wrap";
    var container = $(switches);
    console.log(container);
    var emotions = [{cname:"微笑"},{cname:"撇嘴"},{cname:"色"},{cname:"发呆"},{cname:"得意"},{cname:"流泪"},{cname:"害羞"},{cname:"闭嘴"},{cname:"睡"},{cname:"大哭"},{cname:"尴尬"},{cname:"发怒"},{cname:"调皮"},{cname:"呲牙"},{cname:"惊讶"},{cname:"难过"},{cname:"酷"},{cname:"冷汗"},{cname:"抓狂"},{cname:"吐"},{cname:"偷笑"},{cname:"可爱"},{cname:"白眼"},{cname:"傲慢"},{cname:"饥饿"},{cname:"困"},{cname:"惊恐"},{cname:"流汗"},{cname:"憨笑"},{cname:"大兵"},{cname:"奋斗"},{cname:"咒骂"},{cname:"疑问"},{cname:"嘘"},{cname:"晕"},{cname:"折磨"},{cname:"衰"},{cname:"骷髅"},{cname:"敲打"},{cname:"再见"},{cname:"擦汗"},{cname:"抠鼻"},{cname:"鼓掌"},{cname:"糗大了"},{cname:"坏笑"},{cname:"左哼哼"},{cname:"右哼哼"},{cname:"哈欠"},{cname:"鄙视"},{cname:"委屈"},{cname:"快哭了"},{cname:"阴险"},{cname:"亲亲"},{cname:"吓"},{cname:"可怜"},{cname:"菜刀"},{cname:"西瓜"},{cname:"啤酒"},{cname:"篮球"},{cname:"乒乓"},{cname:"咖啡"},{cname:"饭"},{cname:"猪头"},{cname:"玫瑰"},{cname:"凋谢"},{cname:"示爱"},{cname:"爱心"},{cname:"心碎"},{cname:"蛋糕"},{cname:"闪电"},{cname:"炸弹"},{cname:"刀"},{cname:"足球"},{cname:"瓢虫"},{cname:"便便"},{cname:"月亮"},{cname:"太阳"},{cname:"礼物"},{cname:"拥抱"},{cname:"强"},{cname:"弱"},{cname:"握手"},{cname:"胜利"},{cname:"抱拳"},{cname:"勾引"},{cname:"拳头"},{cname:"差劲"},{cname:"爱你"},{cname:"NO"},{cname:"OK"},{cname:"爱情"},{cname:"飞吻"},{cname:"跳跳"},{cname:"发抖"},{cname:"怄火"},{cname:"转圈"},{cname:"磕头"},{cname:"回头"},{cname:"跳绳"},{cname:"挥手"},{cname:"激动"},{cname:"街舞"},{cname:"献吻"},{cname:"左太极"},{cname:"右太极"}];
    var emotionsLength = emotions.length;

    function mgrEmotion(){
        //创建表情框
        if(!htmlString){
            for(i=1;i<61;i++) htmlString+='<li><a href="javascript:void(0)"><img src="assets/images/qq/'+i+'.gif" title="'+emotions[i-1].cname+'"/></a></li>';
            $(scope+" .emotions").append(htmlString).find("li img").die().click(function(){
                $(textArea).die().insertContent("["+$(this).attr("title")+"]");
            });
        }
        $(wrap).toggle();
        $(document).bind("click",function(e){
            e=e||window.event;
            var target = $(e.target);
            if(target.closest(wrap).length==1 || target.closest(switches).length==1){
                e.stopPropagation();
            }else if(!target.closest(wrap).length){
                $(wrap).hide();
                $(document).unbind("click");
            }
        });
    }

    container.on("click",function(event){mgrEmotion();});
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")   ==> 2006-7-2 8:9:4.18
Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "D+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(Y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}