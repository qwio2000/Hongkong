var jei = {
	getprintChart:function(domain, data, width,height){
		var chart = jui.include("chart.builder");
		chart("#chart", {
		    width: width,
		    height : height,
		    theme : "jennifer",
		    axis : {
		        x : {
		            type : "block",
		            domain : domain
		        },
		        y : {
		            type : "range",
		            domain : [0,100],
		            step : 10,
					nice : true
			   },
		        c : {
		            /**type : "grid3d",**/
					type : "log",
		            domain : [ "나의성취율", "전체회원평균" ]
		        },
		        data : data
		    },
		    brush : {
		        type : "column",
		        outerPadding : 10,
		        innerPadding : 5,
				/*display : 'all',*/
				colors : [ "#FF3636", "#FAE0D4" ]
		    },
		    style : {
		        gridAxisBorderColor : "black",
		        gridBorderColor : "#dcdcdc"
		    },
			widget : [
				/**{ type : "title", text : "Column Sample" },**/
				/**{ type : "tooltip" },**/
				{ type : "legend" }
			]
		});
		
			
	}
}
