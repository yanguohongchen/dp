var Index = function()
{

	return {
		//main function to initiate the module
		init : function()
		{

			App.addResponsiveHandler(function()
			{
				jQuery('.vmaps').each(function()
				{
					var map = jQuery(this);
					map.width(map.parent().width());
				});
			});
		}
	}

}();
