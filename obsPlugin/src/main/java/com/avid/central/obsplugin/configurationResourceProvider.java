package com.avid.central.obsplugin;

import com.avid.central.services.rest.resource.provider.SingletonsProvider;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Administrator on 16/10/2015.
 */
@Component(name = "configurationResourceProvider", immediate = true)
@Service(SingletonsProvider.class)
public class configurationResourceProvider  implements SingletonsProvider {
    private configurationResource _configurationResource;

    @Activate
    public void activate () {
        _configurationResource = new configurationResource();
    }

    @Deactivate
    public void deactivate () {
        _configurationResource = null;
    }

    @Override
    public Set<?> getSingletons() {
        return Collections.singleton(_configurationResource);
    }
}
