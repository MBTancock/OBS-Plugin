package com.avid.central.obsplugin;

import com.avid.central.services.rest.resource.provider.SingletonsProvider;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Administrator on 02/10/2015.
 */
@Component(name = "inewsResourceProvider", immediate = true)
@Service(SingletonsProvider.class)
public class inewsResourceProvider implements SingletonsProvider {
    private inewsResource _inewsResource;

    @Activate
    public void activate () {
        _inewsResource = new inewsResource();
    }

    @Deactivate
    public void deactivate () {
        _inewsResource = null;
    }

    @Override
    public Set<?> getSingletons() {
        return Collections.singleton(_inewsResource);
    }
}
