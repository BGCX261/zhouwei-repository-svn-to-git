package com.techstar.framework.service.workflow.bus.dto;

import java.util.List;

public class NodeDto {
	
	public String node_name="";
	public int nodeType = 0;
	public long nodeId;
	
	public static int NODE_TASK = 0;
	public static int NODE_DECISION=1;
	public static int NODE_ENDSTATE=2;
	public static int NODE_FORK=3;
	public static int NODE_INTERlEAVEEND=4;
	public static int NODE_INTERlEAVESTART=5;
	public static int NODE_JOIN=6;
	public static int NODE_MERGE=7;
	public static int NODE_MILESTONENODE=8;
	public static int NODE_PARALLELSPLIT=9;
	public static int NODE_PROCESSSTATE=10;
	public static int NODE_STARTSTATE=11;
	public static int NODE_STATE=12;
	public static int NODE_SUPERSTATE=13;
	public static int NODE_TASKNODE=14;
	
	public static int NODE_SELF=15;
	public static int WF_SELF=10000;
	public static int WF_SELF_NODEID=-1;
	
	public List tasks;

	
	public List getTasks() {
		return tasks;
	}
	public void setTasks(List tasks) {
		this.tasks = tasks;
	}
	public long getNodeId() {
		return nodeId;
	}
	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public int getNodeType() {
		return nodeType;
	}
	public void setNodeType(int nodeType) {
		this.nodeType = nodeType;
	}
	
	

}
