define(function(require, exports, module) {
	if (window.T == null) {
		window.T = new Object();
	}

	//依赖模块
	// T.common = require('./test');
	// alert(require("./user"));
	T.user = require("./user");
	T.user.init();

});
