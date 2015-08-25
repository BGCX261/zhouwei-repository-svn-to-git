/*********************************** 
������ 
by chb 
************************************/ 
function createTree(n){ 

	Ext.QuickTips.init(); 
	var mytree=new Ext.tree.TreePanel({ 
		el:"container", 
		animate:true, 
		title:"Extjs��̬��", 
		collapsible:true, 
		enableDD:true, 
		enableDrag:true, 
		rootVisible:true, 
		autoScroll:true, 
		autoHeight:true, 
		width:"30%"
		
	}); 
	//���ڵ� 
	var root=new Ext.tree.TreeNode({ 
		id:"root", 
		text:"���Ź�˾", 
		expanded:true 
	}); 

	for(var i=0;i<n;i++){ 
		var sub1=new Ext.tree.TreeNode({ 
				id:i+1, 
				text:"�ӹ�˾"+(i+1), 
				singleClickExpand:true, 
				listeners:{ 
					//���������¼� 
					"click":function(node){ 
						myExpand(node); 
					}, 
					//�����Ҽ� 
					"contextmenu":function(node,e){ 
						//�г��Ҽ��˵� 
						menu=new Ext.menu.Menu([ 
							{ 
								text:"�򿪵�ǰ�ڵ�", 
								icon:"list.gif", 
								handler:function(){ 
									myExpand(node); 
								} 
							}, 
							{ 
								text:"�༭��ǰ�ڵ�", 
								icon:"list.gif", 
								handler:function(){ 
									alert(node.id); 
								} 
							}, 
							{ 
								text:"ɾ����ǰ�ڵ�", 
								icon:"list.gif", 
								handler:function(){ 
									alert(node.id); 
								} 
							}
						]); 
						//��ʾ�ڵ�ǰλ�� 
						menu.showAt(e.getPoint()); 
					} 
				} 
		}); 
		root.appendChild(sub1); 
	} 
	mytree.setRootNode(root);//���ø��ڵ� 
	mytree.render();//��Ҫ����render()��,��Ȼ����ʾŶ 
} 

function myExpand(node){ 
	if(node.id=='1'){ 
		if(node.item(0)==undefined){ 
			node.appendChild(new Ext.tree.TreeNode({ 
				id:node.id+'1', 
				text:node.text+"�ĵ�һ������", 
				hrefTarget:"mainFrame", 
				listeners:{//���� 
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
			text:node.text+"�ĵ�һ������", 
			hrefTarget:"mainFrame", 
			listeners:{//���� 
				"click":function(node){ 
					alert(3);
				} 
			} 
		})); 
	}else{ 
		alert(node.id+"û���Ӳ�����"); 
	} 
} 
