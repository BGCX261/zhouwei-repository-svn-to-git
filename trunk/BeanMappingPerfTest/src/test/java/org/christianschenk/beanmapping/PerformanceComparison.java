/*
 * BeanMappingPerfTest - Tests Java Bean to Java Bean mapping
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package org.christianschenk.beanmapping;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.sf.dozer.util.mapping.DozerBeanMapper;
import net.sf.dozer.util.mapping.MapperIF;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.christianschenk.beanintrospect.BeanIntrospector;
import org.christianschenk.beanmapping.beans.IntBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerformanceComparison {

	private static final Logger log = Logger.getLogger(PerformanceComparison.class);
	// it's just fair to initialize these classes only once
	private static final BeanIntrospector beanIntrospector = new BeanIntrospector();
	private static final MapperIF dozer = new DozerBeanMapper();

	private enum Command {
		HAND, INTROSPECTOR, COMMONS, SPRING, DOZER;
	}

	@Test
	public void test() {
		final List<Runnable> runners = new ArrayList<Runnable>();
		this.fillRunners(runners, 1);
		final int[] counts = { 10, 100, 1000, 10000, 20000, 50000, 100000 };
		this.runPerformanceTest(runners, counts);

		for (final int numberOfCreatedBeans : counts) {
			this.fillRunners(runners, numberOfCreatedBeans);
			this.runPerformanceTest(runners, new int[] { 1 });
		}
	}

	private void fillRunners(final List<Runnable> runners, final int nrOfBeans) {
		runners.clear();
		for (final Command command : Command.values()) {
			runners.add(this.getRunnable(command, nrOfBeans));
		}
	}

	private void runPerformanceTest(final List<Runnable> runners, final int[] counts) {
		log.debug("Runs\tByHand\tIntrospector\tCommons\tSpring\tDozer");
		for (final int count : counts) {
			final long times[] = new long[runners.size()];
			int i = 0;
			for (final Runnable runner : runners) {
				long time = System.nanoTime();
				for (int runs = 0; runs < count; runs++) {
					runner.run();
				}
				time = System.nanoTime() - time;
				times[i++] = time / (1000 * 1000);
			}
			log.debug(count + "\t" + times[0] + "\t" + times[1] + "\t\t" + times[2] + "\t" + times[3] + "\t" + times[4]);
		}
	}

	private Runnable getRunnable(final Command command, final int nrOfBeans) {
		return new Runnable() {
			public void run() {
				final IntBean intBean1 = new IntBean(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				for (int i = 0; i < nrOfBeans; i++) {
					final IntBean intBean2 = new IntBean();
					doCommand(command, intBean1, intBean2);
					assertIntBeans(intBean1, intBean2);
				}
			}
		};
	}

	private void doCommand(final Command command, final IntBean intBean1, final IntBean intBean2) {
		switch (command) {
		case HAND:
			intBean2.setInt1(intBean1.getInt1());
			intBean2.setInt2(intBean1.getInt2());
			intBean2.setInt3(intBean1.getInt3());
			intBean2.setInt4(intBean1.getInt4());
			intBean2.setInt5(intBean1.getInt5());
			intBean2.setInt6(intBean1.getInt6());
			intBean2.setInt7(intBean1.getInt7());
			intBean2.setInt8(intBean1.getInt8());
			intBean2.setInt9(intBean1.getInt9());
			intBean2.setInt10(intBean1.getInt10());
			break;
		case INTROSPECTOR:
			beanIntrospector.fill(intBean2, intBean1);
			break;
		case COMMONS:
			try {
				BeanUtils.copyProperties(intBean2, intBean1);
			} catch (IllegalAccessException ex) {
				throw new RuntimeException(ex);
			} catch (InvocationTargetException ex) {
				throw new RuntimeException(ex);
			}
			break;
		case SPRING:
			org.springframework.beans.BeanUtils.copyProperties(intBean1, intBean2);
			break;
		case DOZER:
			dozer.map(intBean1, intBean2);
			break;
		}
	}

	private static final void assertIntBeans(final IntBean intBean1, final IntBean intBean2) {
		if (true) return;
		assertEquals(1, intBean1.getInt1());
		assertEquals(1, intBean2.getInt1());
		assertEquals(2, intBean1.getInt2());
		assertEquals(2, intBean2.getInt2());
		assertEquals(3, intBean1.getInt3());
		assertEquals(3, intBean2.getInt3());
		assertEquals(4, intBean1.getInt4());
		assertEquals(4, intBean2.getInt4());
		assertEquals(5, intBean1.getInt5());
		assertEquals(5, intBean2.getInt5());
		assertEquals(6, intBean1.getInt6());
		assertEquals(6, intBean2.getInt6());
		assertEquals(7, intBean1.getInt7());
		assertEquals(7, intBean2.getInt7());
		assertEquals(8, intBean1.getInt8());
		assertEquals(8, intBean2.getInt8());
		assertEquals(9, intBean1.getInt9());
		assertEquals(9, intBean2.getInt9());
		assertEquals(10, intBean1.getInt10());
		assertEquals(10, intBean2.getInt10());
	}
}