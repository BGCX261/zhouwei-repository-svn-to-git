/*
 * CachingWithProxyInstances
 * Copyright (C) 2008 Christian Schenk
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
package org.christianschenk.reflect.caching.helper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Some helper methods for java.lang.reflect.
 * 
 * @author Christian Schenk
 */
public class ReflectionHelper {

	/**
	 * Creates a string like so: "SomeClassName.getMethodName-Integer-42" for a method with the
	 * signature "SomeClassName.getMethodName(int param)" that was called with the integer "42".
	 */
	public static String getMethodIdentifier(final Method method, final Object[] args) {
		final StringBuilder buf = new StringBuilder();
		buf.append(method.getDeclaringClass().getName() + "." + method.getName() + "(");
		for (final Object obj : args) {
			buf.append(obj.getClass().getSimpleName() + ":" + obj+";");
		}
		buf.append(")");
		return buf.toString().replaceAll("\\[+-]{1}$", "");
	}

	/**
	 * Returns true if this method has got the given Annotation, otherwise false.
	 */
	public static <T extends Annotation> boolean hasAnnotation(final Method method, final Class<T> annotation) {
		if (method.getAnnotation(annotation) != null) return true;
		return false;
	}
}