var demo = function(){
	
	var northPanel = new Ext.BoxComponent({region:'north', el:"header", height:74});

	var westPanel = new Ext.Panel({title:"Menu",
			xtype:'panel',
			layout:"accordion",
			region:"west",
			width:215,
			split:true,
			layoutConfig:{animate:true},
			collapsible:true
			
	});

	var centerPanel = new Ext.Panel({
		region:"center",
		title:'Main Page',
		contentEl: 'frame1'
	});
	
	function addMenu(menu){
		$.each(menu,function(i,o){
			var html = '<img class="bn" name="'+o.name+'" src="'+o.imgPath+'" />';
			$("#header").append(html);
		});
	}
	
	function showPage(e){
		Ext.get("frame1").dom.src = e.target.name;
		/*
		centerPanel.load({
			url:e.target.name,
			text: "Loading...",
			scripts: true,
			nocache: true
		});
		*/
	    
		centerPanel.setTitle(e.target.alt);
	}	

	return {
	
		init:function(menu){
			var viewport = new Ext.Viewport({
				enableTabScroll:true,
				layout:"border",
				items:[northPanel,westPanel,centerPanel]
			});
			addMenu(menu);
			$(".bn").click(getAccordion).css("cursor","hand");
			
		},

		updateMenu:function (data){
			var panArray = westPanel.findByType("panel");
			$.each(panArray,function(i,o){
				
				westPanel.remove(panArray[i]);
			});
			
			westPanel.add.apply(westPanel,data);
			westPanel.doLayout();
			$(".show").click(showPage).css("cursor","hand");
		},
	
		buildDatas:function (jsonData){
	
			var leafDatas = [];
		
			$.each(jsonData,function(i,o){
				var leafData = {xtype:"panel"};
				leafData.title = o.title;
				leafData.html = "";
				
				$.each(o.imgPath,function(j,s){
					leafData.html += "<p><img class='show' alt='"+o.pageName[j]+"' src='"+s+"' name='"+o.url[j]+"'></img></p><hr>";
				});
			
				leafDatas[i] = leafData;
			});
	
			return leafDatas;
		}
		
	}

}();


