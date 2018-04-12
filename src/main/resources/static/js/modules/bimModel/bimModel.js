

/**
 * 模型树与模型的控制
 */

/**
 * 以模型的某构件为中心，放大并聚焦
 * @param token     调用 CarsView() 后由图形引擎返回的引擎对象
 * @param modelId   从 treeNode.id 获取的 rbimid
 */
var bimModelFocus = function(token, modelId){
    if (modelId == null)
        resetFocus(token);
    else {
        var guids = new Array();
        guids.push(modelId);
        token.zoomFitActor(guids, 500);
        token.setSelection(guids, 0);
    }
};

/**
 * 与上面的 bimModelFocus 效果一样，支持多个构件
 * @param token     调用 CarsView() 后由图形引擎返回的引擎对象
 * @param arrGuids  构件 ID 数组，包含从 treeNode.id 获取的 rbimid
 */
var bimModelFocusArr = function(token, arrGuids){
    if (arrGuids == null || arrGuids.length == 0)
        resetFocus(token);
    else {
        token.zoomFitActor(arrGuids, 500);
        token.setSelection(arrGuids, 0);
    }
};
/**
 * 将模型区域的高亮选择项清除，并完整显示模型
 * @param token
 */
var resetFocus = function(token) {
    token.hwv.getSelectionManager().clear();
    token.zoomFitAll();
};

/**
 * Collapse easyui's south panel, 最大化模型区域
 * @param winObj	window 对象，如：this.window
 * @constructor
 */
function MaximizeModelArea(winObj) {
    if (winObj == null) return;
    var collapseSouthBtn = winObj.frameElement;
    if (collapseSouthBtn == null) return;
    collapseSouthBtn = collapseSouthBtn.parentElement;
    if (collapseSouthBtn == null) return;
    collapseSouthBtn = collapseSouthBtn.parentElement;
    if (collapseSouthBtn == null) return;
    collapseSouthBtn = collapseSouthBtn.childNodes[0];
    if (collapseSouthBtn == null) return;
    collapseSouthBtn = collapseSouthBtn.childNodes[1];
    if (collapseSouthBtn == null) return;
    collapseSouthBtn = collapseSouthBtn.childNodes[2];
    if (collapseSouthBtn == null) return;
    collapseSouthBtn.click();
}



/**
 * [Undocumented]
 * 设置模型初始化后的视点
 * @param token	图形引擎接口对象
 */
var setInitViewpoint = function (token) {
    var vpt = token.getViewPoint();
    // /* 以下针对模型 yanweiyanshiyong */
    // vpt.width = 66.55773138591744;
    // vpt.height = 66.55773138591744;
    // vpt.nearLimit = 0.01;
    // vpt.projection = 0;
    // vpt.pos.x = 148.46260207933977;
    // vpt.pos.y = 30.07505882196328;
    // vpt.pos.z = 7.872046900617249;
    // vpt.tar.x = 81.94208041381762;
    // vpt.tar.y = 32.30021799871898;
    // vpt.tar.z = 7.850339180102641;
    // vpt.up.x = 0.0011769745316862201;
    // vpt.up.y = 0.04493105190234877;
    // vpt.up.z = 0.998989396993732;
    // token.setViewPoint(vpt);

    /* 以下针对模型 20_1 */
    vpt.width = 65.3336237009299;
    vpt.height = 65.3336237009299;
    vpt.nearLimit = 0.01;
    vpt.projection = 0;
    vpt.pos.x = 212.2885308927864;
    vpt.pos.y = -73.1476510804451;
    vpt.pos.z = -16.147266628710994;
    vpt.tar.x = 173.59019856076364;
    vpt.tar.y = -123.90864362722132;
    vpt.tar.z = -30.084378821761888;
    vpt.up.x = -0.07963522385070979;
    vpt.up.y = -0.20701350067091748;
    vpt.up.z = 0.9750916068053399;
    token.setViewPoint(vpt);
};

/**
 * [Undocumented]
 * 修改图形引擎的超时时间
 * @param token	图形引擎接口对象
 * @param minute	超时分钟数
 */
var setTimeoutMinute = function (token, minute) {
	if (token == null) return;
    token.hwv._timeoutMonitor._timeoutDurationMinutes = parseInt(minute) + 1;
    token.hwv._timeoutMonitor._timeoutWarningMinutes = parseInt(minute);
};

