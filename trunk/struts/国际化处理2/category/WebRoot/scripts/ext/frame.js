var frame = function(){
	
	var northPanel = new Ext.BoxComponent({region:'north', el:"header", height:60});

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
			///alert("name="+o.name+",image="+o.image);
			var html = '<img class="menu_pic" title="'+o.name+'" name="'+o.id+'" src="'+o.image+'" /><a href="javascript:eval()" class="menu" name="'+o.id+'">'+o.name+'</a>&nbsp;';
			$("#menubar").append(html);
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
			//$(".bn").click(getAccordion).css("cursor","hand");
			$(".menu").click(getFrameMenuNode).css("cursor","hand");
			$(".menu_pic").click(getFrameMenuNode).css("cursor","hand");
		},

		updateMenu:function (data){
			var panArray = westPanel.findByType("panel");
			$.each(panArray,function(i,o){
				
				westPanel.remove(panArray[i]);
			});
			westPanel.add.apply(westPanel,data);
			westPanel.doLayout();
			$(".menu_node").click(showPage).css("cursor","hand");
		},
	
		buildDatas:function (jsonData){
	
			//var leafDatas = new Array(jsonData.length);
			var leafDatas = [];
			$.each(jsonData,function(i,o){
				//alert("buildDatas o.title="+o.name+"---"+o.id);
				
				frame_service.getFrameMenuLeaf(o.id,function(leafElements){
					var leafData = {xtype:"panel"};
					leafData.id = o.id;
					leafData.title = o.name;
					//alert(j+":"+leafElements[j].id+","+leafElements[j].name);
					leafData.html = "";
					for(var j=0;j<leafElements.length;j++){		
						leafData.html += "<p>&nbsp;<img class='menu_node' alt='"+leafElements[j].name+"' src='"+leafElements[j].image+"' name='"+leafElements[j].url+"'></img>"
										 +"<a href='javascript:eval()' class='menu_node' name='"+leafElements[j].url+"'>"+leafElements[j].name+"</a></p><hr>";
					}
					leafDatas[i] = leafData;
				});
				
				/*
				$.each(o.imgPath,function(j,s){
					leafData.html += "<p><img class='show' alt='"+o.pageName[j]+"' src='"+s+"' name='"+o.url[j]+"'></img></p><hr>";
				});
			
				leafDatas[i] = leafData;
				*/
			});
			//alert("leafDatas.length="+leafDatas.length);
			return leafDatas;
		}
		
	}

}();


