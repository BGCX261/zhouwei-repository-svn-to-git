package com.sitechasia.webx.core.jmx;

import junit.framework.TestCase;

import com.sitechasia.webx.components.jmx.Agent;
import com.sitechasia.webx.components.jmx.AgentFactory;
import com.sitechasia.webx.components.jmx.AgentType;

public class AgentFactoryTest extends TestCase {

	public void testGetAgent() {
		Agent agent1 = AgentFactory.getAgent();
		
		assertTrue(agent1 != null);
		
		Agent anotherAgent1 = AgentFactory.getAgent();
		
		assertTrue(anotherAgent1 != null);
		
		assertSame(anotherAgent1, agent1);
		
		
		
		Agent agent2 = AgentFactory.getAgent(AgentType.EmptyServer);
		
		assertTrue(agent2 != null);
		
		Agent anotherAgent2 = AgentFactory.getAgent(AgentType.EmptyServer);
		
		assertTrue(anotherAgent2 != null);
		
		assertSame(anotherAgent2, agent2);
		
		assertTrue(agent2 != agent1);

	}
}
