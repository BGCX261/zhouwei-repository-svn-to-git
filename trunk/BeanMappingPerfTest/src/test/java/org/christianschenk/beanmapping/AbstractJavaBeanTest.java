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

import org.christianschenk.beanmapping.beans.A;
import org.christianschenk.beanmapping.beans.B;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public abstract class AbstractJavaBeanTest {

	protected abstract void copy(A a1, A a2);

	protected abstract void fillBiggerWithSmallerBean(B b, A a);

	protected abstract void fillSmallerWithBiggerBean(A a, B b);

	@Test
	public void copy() {
		final A a1 = new A(1, 2);
		final A a2 = new A();
		this.copy(a2, a1);
		assertEquals(a1.getI(), a2.getI());
		assertEquals(a1.getJ(), a2.getJ());
	}

	@Test
	public void fillBiggerWithSmallerBean() {
		final A a = new A(1, 2);
		final B b = new B();
		this.fillBiggerWithSmallerBean(b, a);
		assertEquals(a.getI(), b.getI());
		assertEquals(a.getJ(), b.getJ());
		assertNull(b.getStr());
	}

	@Test
	public void fillSmallerWithBiggerBean() {
		final A a = new A();
		final B b = new B(1, 2);
		this.fillSmallerWithBiggerBean(a, b);
		assertEquals(a.getI(), b.getI());
		assertEquals(a.getJ(), b.getJ());
		assertNull(b.getStr());
	}
}