package com.techstar.framework.service.messaging.client;

import javax.xml.messaging.ProviderMetaData;
/**
 * 
 * @author yangjun
 *
 */
public class MetaDataImpl
    implements ProviderMetaData
{

    public MetaDataImpl()
    {
    }

    public String getName()
    {
        return "TSSP";
    }

    public int getMajorVersion()
    {
        return 1;
    }

    public int getMinorVersion()
    {
        return 0;
    }

    public String[] getSupportedProfiles()
    {
        return (new String[] {
            "TSS{"
        });
    }
}
