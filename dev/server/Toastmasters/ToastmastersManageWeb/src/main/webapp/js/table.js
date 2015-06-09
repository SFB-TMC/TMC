var _Divid;// 记录divId
var _url;// 记录Action
var _columnNames;// 记录列名
var _columnWidth;// 记录各列宽度 百分比
var _columnData;// 对应实体名 可实现格式化输出 列名设置为方法名称
var _pageNum = 1;// 当前页
var _pageCount = 20;// 显示行数
var _clickMethod = null;// 记录点击时间方法
var _pageCountArray = [ 5, 10, 20, 50, 100 ];// 每页显示条数
var _total;// 总数
var _tData = null;// 总数据
var _userParm = null;
var parm = null;
var _index;
var _searchCondition = null; // 搜索条件

// createTable("id","url","['列名1','列名2']",'['50%','50%']',['id','name'],"");
function initTableNow(divId, url, searchCondition, columnNames, columnWidth, columnData,
		clickMethod) {
	_Divid = divId;
	_url = url;
	_columnNames = columnNames;
	_columnWidth = columnWidth;
	_columnData = columnData;
	_clickMethod = clickMethod;
	_searchCondition = searchCondition;
	createInitParm();
	createTable();
}

// createTable("id","url","['列名1','列名2']",'['50%','50%']',['id','name'],"");
function initTableByCondition(divId, url, columnNames, columnWidth, columnData,
		clickMethod) {
	_Divid = divId;
	_url = url;
	_columnNames = columnNames;
	_columnWidth = columnWidth;
	_columnData = columnData;
	_clickMethod = clickMethod;
	createInitParm();
}

function createInitParm() {
	parm = {
		"pageNum" : _pageNum,
		"pageCount" : _pageCount,
		"searchCondition" : _searchCondition
	};// 初始化分页参数
}

// 添加参数并查询数据构造Table
function setParmAndSelect(obj) {
	_pageNum = 1;
	_userParm = obj;
	createInitParm();
	$.extend(parm, _userParm);
	createTable();
}

function createTable() {
	_index = 1;
	$("#" + _Divid).html("");
	var table = "";
	
	// 构造分页数据
	$.ajax({
		url : _url,
		type : 'POST',
		dataType : 'json',
		data : parm,
		async : false,
		error : function() {
			alert('加载数据错误！');
		},
		success : function(data) {
			_pageNum = data.pageNum;
			_pageCount = data.pageCount;
			_total = data.total;
			_tData = data.list;
		}
	});

	// 构造数据
	if (_tData != null && _tData.length > 0) {
		table += "<div class=\"table-header button-height\">";
		table += "<div class=\"float-right\">";
		table += "Search&nbsp;<input type=\"text\" name=\"searchCondition\" id=\"searchCondition\" value=\"\" class=\"input mid-margin-left\">";
		table += "</div>";
		table += "With selected:";
		table += "<select name=\"select90\" class=\"select blue-gradient glossy mid-margin-left\">";
		table += "<option value=\"0\">Delete</option>";
		table += "<option value=\"1\">Send Email</option>";
		table += "</select>";
		table += "<button type=\"submit\" class=\"button blue-gradient glossy\">Go</button>";
		table += "</div>";
		table += "<table class='table responsive-table' id='dataTable' width='100%' border='0' cellspacing='0' cellpadding='0' ><thead>";// table构造开始
		table += "<tr >";// 构造列表头
		for ( var i in _columnNames) {
			if (_columnWidth[i] == null || _columnWidth[i] == "") {
				table += "<th scope=\"col\">" + _columnNames[i]
				+ "</th>";
				continue;
			}
			table += "<th scope=\"col\" width='" + _columnWidth[i] + "' class=\"hide-on-tablet\">" + _columnNames[i]
					+ "</th>";
		}
		table += "</tr></thead>";// 构造列表头结束
		table += "<tbody>";
		for ( var i in _tData) {
			var row = "";
			if (_clickMethod != null) {

				row = "<tr onclick='" + _clickMethod + "(_tData[" + i + "])'>";
			} else {
				row = "<tr >";
			}
			for (var j = 0; j < _columnData.length; j++) {
				try {
					row += "<td scope=\"row\">"
							+ eval("" + _columnData[j] + "(_tData[i])")
							+ "</td>";
				} catch (error) {
					row += "<td scope=\"row\">"
							+ ((_tData[i][_columnData[j]] == null) ? ""
									: _tData[i][_columnData[j]]) + "</td>";
				}
			}

			row += "</tr>";
			table += row;
		}
		table += "</tbody></table>";// table构造结束
		table += "<form method=\"post\" action=\"\" class=\"table-footer button-height large-margin-bottom\">";
		table += "<div class=\"float-right\">";
		table += "<div class=\"button-group\">";
		table += "<a href=\"#\" title=\"First page\" class=\"button blue-gradient glossy\"  onclick=\"toPage(1);\"><span class=\"icon-previous\"></span></a>";
		table += "<a href=\"#\" title=\"Previous page\" class=\"button blue-gradient glossy\"onclick=\"toPage(" + Previous() + ")\"><span class=\"icon-backward\"></span></a>";
		table += "</div>";
		table += "<div class=\"button-group\">";
		table += showOtherPage();
		table += "</div>";
		table += "<div class=\"button-group\">";
		table += "<a href=\"#\" title=\"Next page\" class=\"button blue-gradient glossy\" onclick=\"toPage(" + Next() + ")\"><span class=\"icon-forward\"></span></a>";
		table += "<a href=\"#\" title=\"Last page\" class=\"button blue-gradient glossy\" onclick=\"toPage(" + getLastPageNum() + ")\"><span class=\"icon-next\"></span></a>";
		table += "</div>";
		table += "</div>";
		table += "Show&nbsp;<select name=\"range\" class=\"select blue-gradient glossy\" onchange=\"changePageCount(this);\">";
		table += getPageCount() + "</select> entries";
		table += "</form>";
	} else {
		table += "<div class=\"table-header button-height\">";
		table += "<div class=\"float-right\">";
		table += "Search&nbsp;<input type=\"text\" name=\"searchCondition\" id=\"searchCondition\" value=\"\" class=\"input mid-margin-left\">";
		table += "</div>";
		table += "With selected:";
		table += "<select name=\"select90\" disabled=\"disabled\" class=\"select blue-gradient glossy mid-margin-left\">";
		table += "<option value=\"0\">Delete</option>";
		table += "<option value=\"1\">Send Email</option>";
		table += "</select>";
		table += "<button type=\"submit\" disabled=\"disabled\" class=\"button blue-gradient glossy\">Go</button>";
		table += "</div>";
		table += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		table += "<tr>";
		table += "<td width='50%' style='padding-top: 50px; padding-bottom: 50px;' height='100' align='right'><img width='100' src='../img/100.png' /></td>";
		table += "<td width='50%' style='vertical-align: middle; font-size:20px; line-height: 45px; padding-left: 20px;' align='left'>没有搜索到结果!</td>";
		table += "</tr>";
		table += "</table>";
		table += "<form method=\"post\" action=\"\" class=\"table-footer button-height large-margin-bottom\">&nbsp;";
		table += "Show&nbsp;<select name=\"range\" class=\"select blue-gradient glossy\" disabled=\"disabled\">";
		table += getPageCount() + "</select> entries";
		table += "</form>";
	}

	$("#" + _Divid).append(table);

	$(".tabStyle5 tr").mouseover(function() { // 如果鼠标移到class为tabStyle的表格的tr上时，执行函数
		$(this).addClass("over");
	}).mouseout(function() { // 给这行添加class值为over，并且当鼠标一出该行时执行函数
		$(this).removeClass("over");
	}); // 移除该行的class
	$(".tabStyle5 tr:odd").addClass("alt"); // 给class为tabStyle的表格的偶数行添加class值为alt

}

function showOtherPage() {
	var showString = "";
	var totalPageNum = getLastPageNum();
	if (totalPageNum <= 5) {
		for (var i = 1; i <= totalPageNum; i++) {
			showString += "<a class=\"button blue-gradient glossy\" style='cursor: pointer;' onclick='toPage(" + i + ")'>" + i + "</a>";
		}		// <a href=\"#\" title=\"Page 1\" class=\"button blue-gradient glossy\">1</a>
	} else {
		var show = 0;
		if (_pageNum - 2 >= -1 && _pageNum + 2 <= 5) {
			for (var i = 1; i <= _pageNum; i++) {
				show++;
				showString += "<a style='cursor: pointer;' onclick='toPage(" + i + ")'>" + i + "</a>";
			}
			for (var i = 1; i <= (5 - show); i++) {
				showString += "<a style='cursor: pointer;' onclick='toPage(" + (_pageNum + i) + ")'>"
						+ (_pageNum + i) + "</a>";
			}
		} else if (totalPageNum <= _pageNum + 2 && _pageNum > 3) {
			show = totalPageNum - _pageNum;
			for (var i = (5 - show); i >= 1; i--) {
				showString += "<a style='cursor: pointer;' onclick='toPage(" + (_pageNum - i + 1)
						+ ")'>" + (_pageNum - i + 1) + "</a>";
			}
			for (var i = 1; i <= show; i++) {
				showString += "<a style='cursor: pointer;' onclick='toPage(" + (_pageNum + i) + ")'>"
						+ (_pageNum + i) + "</a>";
			}
		} else {
			for (var i = 3; i >= 1; i--) {
				showString += "<a style='cursor: pointer;' onclick='toPage(" + (_pageNum - i + 1)
						+ ")'>" + (_pageNum - i + 1) + "</a>";
			}
			for (var i = 1; i <= 2; i++) {
				showString += "<a style='cursor: pointer;' onclick='toPage(" + (_pageNum + i) + ")'>"
						+ (_pageNum + i) + "</a>";
			}
		}
	}

	return showString;
}

function getLastPageNum() {
	var last = 0;
	if ((_total % _pageCount) != 0) {
		last = parseInt(_total / _pageCount) + 1;
	} else {
		last = _total / _pageCount;
	}
	return last;
}
// 上一页
function Previous() {
	if (_pageNum > 1) {
		return _pageNum - 1;
	} else {
		return 1;
	}
}
// 下一页
function Next() {
	if (_pageNum < getLastPageNum()) {
		return _pageNum + 1;
	} else {
		return getLastPageNum();
	}
}
// 跳转指定页面
function toPage(pageNum) {
	if (pageNum == _pageNum) {
		return;
	}
	_pageNum = pageNum;
	createInitParm();
	if (_userParm != null) {
		$.extend(parm, _userParm);
	}
	createTable();
}

function getPageCount() {
	var option = "";

	for (var i = 0; i < _pageCountArray.length; i++) {
		if (_pageCount == _pageCountArray[i]) {
			option += "<option selected='selected' value='"
					+ _pageCountArray[i] + "'>" + _pageCountArray[i]
					+ "</option>";
		} else {
			option += "<option value='" + _pageCountArray[i] + "'>"
					+ _pageCountArray[i] + "</option>";
		}

	}

	return option;
}

function changePageCount(obj) {
	_pageCount = obj.value;

	refresh();
}

function refresh() {
	createInitParm();
	if (_userParm != null) {
		$.extend(parm, _userParm);
	}
	createTable();

}