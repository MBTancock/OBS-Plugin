package PACKAGE;

import com.avid.central.configuration.api.ConfigurationService;
import com.avid.central.services.rest.resource.provider.SingletonsProvider;
import org.apache.felix.scr.annotations.*;

import java.util.HashSet;
import java.util.Set;

@Component
@Service(SingletonsProvider.class)
public class ResourceProvider implements SingletonsProvider {

    /**
     * Holds all resource instances.
     */
    private final Set<Object> resources = new HashSet<Object>();

    @Reference(bind = "setConfigurationService",
            unbind = "unsetConfigurationService",
            cardinality = ReferenceCardinality.MANDATORY_UNARY,
            policy = ReferencePolicy.STATIC)
    private ConfigurationService configurationService;


    protected void setConfigurationService(ConfigurationService service) {
        configurationService = service;
    }

    protected void unsetConfigurationService(ConfigurationService service) {
        configurationService = null;
    }

    @Activate
    protected void activate() {
        assert configurationService != null : "ConfigurationService must be set before activate can be called";
        resources.add(new UserSettingsResource(configurationService));
    }

    @Deactivate
    protected void deactivate() {
        resources.clear();
    }

    @Override
    public Set<?> getSingletons() {
        return resources;
    }
}
