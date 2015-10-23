package com.avid.central.example.todo;

import com.avid.central.services.rest.resource.provider.SingletonsProvider;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Set;

/**
 * Created by volodymyr.shugaiev on 7/23/2015.
 */
@Component(name = "TodoResourceProvider", immediate = true)
@Service(SingletonsProvider.class)
public class TodoResourceProvider implements SingletonsProvider {
    private TodoResource todoResource;

    @Activate
    public void activate () {
        todoResource = new TodoResource();
    }

    @Deactivate
    public void deactivate () {
        todoResource = null;
    }

    @Override
    public Set<?> getSingletons() {
        return Collections.singleton(todoResource);
    }
}
