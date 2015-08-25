import java.util.Iterator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Z {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompositeConfiguration config = new CompositeConfiguration();
		try {
			config.addConfiguration(new PropertiesConfiguration(
					"test.properties"));

		} catch (ConfigurationException e) {
			e.printStackTrace();
			return;
		}
		Iterator i = config.getKeys("test");
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
		System.out.println(config.getString("test.separator.colon", "zhou"));

	}

}
