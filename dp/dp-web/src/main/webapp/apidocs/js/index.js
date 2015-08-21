var Index = function()
{

	var obtainMethodsInfoMap = function()
	{
		var param = {};

		api.ajax_request("/api/obtainMethodsInfoMap", param, true, function(jsonstr)
		{
			var jsondata=JSON.stringify(jsonstr); 
			alert(jsondata);
		});
	};

	return {
		init : function()
		{
			App.init();
			obtainMethodsInfoMap();
		}
	};

}();
