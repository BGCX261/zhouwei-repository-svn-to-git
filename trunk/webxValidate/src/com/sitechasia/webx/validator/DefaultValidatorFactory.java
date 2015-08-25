package com.sitechasia.webx.validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorResources;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

/**
 * 
 * 默认ValidatorFactory工厂实现类
 * 
 * @author zhou wei
 * @version 1.0
 */
public class DefaultValidatorFactory implements ValidatorFactory, InitializingBean {



    private static Log log = LogFactory.getLog(DefaultValidatorFactory.class);

    /**
     *  Validator <code>ValidatorResources</code> 通过它load validation configuration文件.
     */
    private ValidatorResources validatorResources;

    /**
     * 检查validatorResources
     *
     * @throws org.springframework.beans.FatalBeanException if <code>setValidationConfigLocations()</code> has not been called.
     */
    public void afterPropertiesSet() throws Exception {
        if (this.validatorResources == null) {
            throw new FatalBeanException("Unable to locate validation configuration. Property [validationLocations] is required.");
        }
    }

   
    /**
     * 
     * 加载validation configLocation文件
     * 
     * @param validationConfigLocations
     */
    public void setValidationConfigLocations(Resource[] validationConfigLocations) {

        if (DefaultValidatorFactory.log.isInfoEnabled()) {
            DefaultValidatorFactory.log.info("Loading validation configurations from [" + StringUtils.arrayToCommaDelimitedString(validationConfigLocations) + "]");
        }

        try {
            InputStream[] inputStreams = new InputStream[validationConfigLocations.length];

            for (int i = 0; i < inputStreams.length; i++) {
                inputStreams[i] = validationConfigLocations[i].getInputStream();
            }

            this.validatorResources = new ValidatorResources(inputStreams);
        }
        catch (IOException e) {
            throw new FatalBeanException("Unable to read validation configuration due to IOException.", e);
        }
        catch (SAXException e) {
            throw new FatalBeanException("Unable to parse validation configuration XML", e);
        }
    }

 
    /* (non-Javadoc)
     * @see com.sitechasia.webx.validator.ValidatorFactory#getValidator(java.lang.String, java.lang.Object)
     */
    public Validator getValidator(String beanName, Object bean) {
        Validator validator = new Validator(validatorResources, beanName);
        validator.setParameter(Validator.BEAN_PARAM, bean);
        return validator;
    }



    /* (non-Javadoc)
     * @see com.sitechasia.webx.validator.ValidatorFactory#hasRulesForBean(java.lang.String, java.util.Locale)
     */
    public boolean hasRulesForBean(String beanName, Locale locale) {
        Form form = validatorResources.getForm(locale, beanName);
        return (form != null);
    }


    /* (non-Javadoc)
     * @see com.sitechasia.webx.validator.ValidatorFactory#getValidatorResources()
     */
    public ValidatorResources getValidatorResources() {
        return validatorResources;
    }

}
