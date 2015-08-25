package webx.struts.config;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.PropertyMessageResourcesFactory;




public class WebxPropertyMessageResourcesFactory extends PropertyMessageResourcesFactory {


    /* (non-Javadoc)
     * @see org.apache.struts.util.PropertyMessageResourcesFactory#createResources(java.lang.String)
     */
    public MessageResources createResources(String config) {

        return new WebxPropertyMessageResources(this, config, this.returnNull);

    }


}
