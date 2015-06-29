define(function(require, exports, module) {
	if (window.T == null) {
		window.T = new Object();
	}

	// 依赖模块
	// T.common = require('./common');

	T.common = require('./test');

	var user = {
		userList : null,

		init : function() {
			var params = {
				username : "test",
				passwd : "passwd",
				test:"2",
			};

			// T.test.init();
			T.common.requestBlock('user/list2', params, false, function(jsonstr, data, code, msg) {
				user.userList = data;
				$('#index_list_user').bind('click', user.showlist);
				$('#index_add_user').bind('click', user.userAdd);
			});
		},

		showlist : function() {
			//显示列表
			var tpl = T.common.getTemplate('user', 'tpl_index_userlist');
			var html = juicer(tpl, user.userList);
			$('#context_tpl').html(html);
		},

		userAdd : function() {
			var tpl = T.common.getTemplate('user', 'tpl_index_userAdd');
			var html = juicer(tpl, user.userList);
			$('#context_tpl').html(html);
			//绑定事件
			$('#user_add_button').bind('click', user.userAddCommit);
		},

		userAddCommit : function() {
			
		}
	};

	module.exports = {
		init : function() {
			user.init();
		},
	};

})
