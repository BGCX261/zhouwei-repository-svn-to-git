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

import net.sf.dozer.util.mapping.DozerBeanMapper;
import net.sf.dozer.util.mapping.MapperIF;

import org.christianschenk.beanmapping.beans.A;
import org.christianschenk.beanmapping.beans.B;
import org.junit.Before;

public class DozerTest extends AbstractJavaBeanTest {

	private MapperIF mapper;

	@Before
	public void setUp() {
		this.mapper = new DozerBeanMapper();
	}

	@Override
	protected void copy(final A a1, final A a2) {
		this.mapper.map(a1, a2);
	}

	@Override
	protected void fillBiggerWithSmallerBean(final B b, final A a) {
		this.mapper.map(b, a);
	}

	@Override
	protected void fillSmallerWithBiggerBean(final A a, final B b) {
		this.mapper.map(a, b);
	}
}