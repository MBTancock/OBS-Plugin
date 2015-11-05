package com.avid.central.obsplugin;

import com.avid.central.services.rest.resource.provider.SingletonsProvider;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Broadcast Media Solutions on 02/10/2015.
 */
@Component(name = "cuesheetResourceProvider", immediate = true)
@Service(SingletonsProvider.class)
public class cuesheetResourceProvider implements SingletonsProvider {
    private cuesheetResource _cuesheetResource;

    @Activate
    public void activate () {
        _cuesheetResource = new cuesheetResource();
    }

    @Deactivate
    public void deactivate () {
        _cuesheetResource = null;
    }

    @Override
    public Set<?> getSingletons() {
        return Collections.singleton(_cuesheetResource);
    }
}
