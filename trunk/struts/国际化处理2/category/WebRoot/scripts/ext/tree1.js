/*********************************** 
创建树 
by chb 
************************************/ 
function createTree(n){ 

	Ext.QuickTips.init(); 
	var mytree=new Ext.tree.TreePanel({ 
		el:"container", 
		animate:true, 
		title:"Extjs动态树", 
		collapsible:true, 
		enableDD:true, 
		enableDrag:true, 
		rootVisible:true, 
		autoScroll:true, 
		autoHeight:true, 
		width:"30%"
		
	}); 
	//根节点 
	var root=new Ext.tree.TreeNode({ 
		id:"root", 
		text:"集团公司", 
		expanded:true 
	}); 

	for(var i=0;i<n;i++){ 
		var sub1=new Ext.tree.TreeNode({ 
				id:i+1, 
				text:"子公司"+(i+1), 
				singleClickExpand:true, 
				listeners:{ 
					//监听单击事件 
					"click":function(node){ 
						myExpand(node); 
					}, 
					//监听右键 
					"contextmenu":function(node,e){ 
						//列出右键菜单 
						menu=new Ext.menu.Menu([ 
							{ 
								text:"打开当前节点", 
								icon:"list.gif", 
								handler:function(){ 
									myExpand(node); 
								} 
							}, 
							{ 
								text:"编辑当前节点", 
								icon:"list.gif", 
								handler:function(){ 
									alert(node.id); 
								} 
							}, 
							{ 
								text:"删除当前节点", 
								icon:"list.gif", 
								handler:function(){ 
									alert(node.id); 
								} 
							}
						]); 
						//显示在当前位置 
						menu.showAt(e.getPoint()); 
					} 
				} 
		}); 
		root.appendChild(sub1); 
	} 
	mytree.setRootNode(root);//设置根节点 
	mytree.render();//不要忘记render()下,不然不显示哦 
} 

function myExpand(node){ 
	if(node.id=='1'){ 
		if(node.item(0)==undefined){ 
			node.appendChild(new Ext.tree.TreeNode({ 
				id:node.id+'1', 
				text:node.text+"的第一个儿子", 
				hrefTarget:"mainFrame", 
				listeners:{//监听 
					"click":function(node,e){ 
						alert(3);
					} 
				} 
			})); 
		} 

		node.expand(); 

	}else if(node.id=='2'){ 
		node.appendChild(new Ext.tree.TreeNode({ 
			id:node.id+'2', 
			text:node.text+"的第一个儿子", 
			hrefTarget:"mainFrame", 
			listeners:{//监听 
				"click":function(node){ 
					alert(3);
				} 
			} 
		})); 
	}else{ 
		alert(node.id+"没有子部门了"); 
	} 
} 
