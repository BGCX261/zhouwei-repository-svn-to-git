package com.sitechasia.webx.core.web.i18n;

import java.util.Locale;
import java.util.Properties;

public interface MessageProvider {
	public Properties getProperties(Locale locale);
}
