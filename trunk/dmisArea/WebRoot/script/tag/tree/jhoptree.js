 
 

			
		   //load事件开始
		   var loadstart1=function (_tree,id){
			    //var src = "<%=request.getContextPath()%>/themes/themes1/images/tree/loading.gif";
			    if(id!=null){
					var temp = _tree._globalIdStorageFind(id);
					temp.span.innerHTML=_tree.getItemText(id)+"<img src='"+_tree.loadimgpath+"'>";
				}
			}
			
			//load数据的结束事件
			 var loadend1 = function (_tree,id){
				
			    if(id!=null){
					var temp = _tree._globalIdStorageFind(id);
					var ht = temp.span.innerHTML.split("<IMG");
					var ht2 = ht[0];
					temp.span.innerHTML=ht2;
				}
			}
		  
			
			function creTree(divid, width, height, treeid, querypath,imgpath, leaftimg, closeimg, openimg, treedisname, nodedisname, DragFlag,checkboxflag,userdate,onclick,ondrop,loadingimgpath,datasxml)
			{   //alert(querypath);
				var jhoptree = new dhtmlXTreeObject(divid,width,height,treeid);//初始化树对象;
				jhoptree.setImagePath(imgpath);//设置图片的路径
				jhoptree.setStdImages(leaftimg,closeimg,openimg);//设置图片的名称


				if(DragFlag==true)//支持拖拽
				{   
					jhoptree.enableDragAndDrop(true);
				}
				
				if(checkboxflag==1)//支持多选
				{
				    jhoptree.enableCheckBoxes(true);
					//jhoptree.enableThreeStateCheckboxes(true);
				}else if(checkboxflag==2){
					jhoptree.enableCheckBoxes(true);
					jhoptree.enableThreeStateCheckboxes(true);
				}
				
				
				
				//注册点击事件
				if(onclick!=""&&onclick!=''){
					jhoptree.setOnClickHandler(onclick);
				}
				//注册拖拽事件 
				if(ondrop!=""&&ondrop!=''){
					jhoptree.setDragHandler(ondrop);
				}
				
				//设置loading图片路径
				if(loadingimgpath!=""){
					jhoptree.setLoadingImg(loadingimgpath);
				}
				
				jhoptree.setOnLoadingStart(loadstart1);//设置load数据开始事件
				jhoptree.setOnLoadingEnd(loadend1);//设置load数据结束事件
				jhoptree.setXMLAutoLoadingBehaviour("action");//设置load数据的行为

				//jhoptree.setXMLAutoLoading(requestpath+"/treefacade.do?method=getTreeNodes");//设置load数据的固定路径
				jhoptree.setXMLAutoLoading(querypath);//设置load数据的固定路径                if(datasxml&&datasxml!=null&&datasxml!=''){
                	//jhoptree.enableSmartXMLParsing(true);
                	jhoptree.loadXMLString(datasxml);
                }else{
                	
                	var url = querypath+"&id="+treeid+"&info="+treedisname+";;;"+nodedisname+";;;"+userdate;
					//alert(url);
					url = encodeURI(url);
					jhoptree.loadXML(url);
                }
				
				return jhoptree;
				
			}
			
			
			//刷新节点包括子节点

			var refreshItem=function(jhoptree,itemId){

			    if(itemId==null||itemId=="")
			    return false;
				jhoptree.refreshItem(itemId);
			}
			
			
			// 得到节点的名称

			var getItemText= function(jhoptree,itemId){
				return jhoptree.getItemText(itemId);
			}
			
			//得到节点额外属性

			var getUserDate= function(jhoptree,itemId){
				var info = jhoptree.getUserData(itemId,"info");
				var infos = info.split(';;;');
				if(infos.length>2){
					return infos[2];
				}
				return null;
			}
			
			
			//得到选择节点的Id 
			var getSelectedItemId= function(jhoptree){
				return jhoptree.getSelectedItemId();
			}
			
			
			//得到多选的CheckedBranches 返回的是被选中节点的Id 字符串形式以逗号分割例：(-1，1,23,445)
			var getAllCheckedBranches= function(jhoptree){
				return jhoptree.getAllCheckedBranches();
			}
			
			//得到多选的Id 返回的是被选中节点的Id 字符串形式以逗号分割例：(1,23,445)
			var getAllChecked=function(jhoptree){
				return jhoptree.getAllChecked();
			}
			
			//得到父节点ID
			
			var getParentId=function(jhoptree,itemId){
				return jhoptree.getParentId(itemId);
				
			}
			//使节点被选中状态 0：未被选中 1：选中
			var setCheck = function(jhoptree,itemId,state){
				 jhoptree.setCheck(itemId,state);
			}
			//得到子节点的数量
			var  hasChildren = function (jhoptree,itemId){
				return jhoptree.hasChildren(itemId);
			}
			
			
			//删除节点 jhoptree 为传入的tree对象 itemId:节点Id selectParent: true:删除后父节点被选中 false
			var deleteItem = function (jhoptree,itemId,selectParent){
				return  jhoptree.deleteItem(itemId,selectParent);
			}
			
			