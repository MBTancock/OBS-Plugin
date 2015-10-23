package PACKAGE;

import com.avid.central.configuration.api.ConfigurationService;
import com.avid.central.configuration.api.Factory;
import com.avid.central.configuration.api.UserData;
import com.avid.central.services.authentication.um.UserInfo;
import com.avid.central.services.authentication.um.UserSession;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

// Url: /api/VIEW_TYPE/usersettings
@Path("VIEW_TYPE/usersettings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserSettingsResource {

    private final ConfigurationService service;

    public UserSettingsResource(ConfigurationService service) {
        this.service = service;
    }

    @GET
    public Map<String, String> getUserSettings(UserInfo userInfo) {
        UserSession session = userInfo.getUserSession();
        UserData userData = service.getUserData(session.getSessionId(), session.getUserName());
        Map<String, String> result = defaultValues();
        result.putAll(userData.asMap());
        return result;
    }

    @POST
    public void setUserSettings(UserInfo userInfo, Map<String, String> values) {
        UserSession session = userInfo.getUserSession();
        UserData userData = Factory.createUserData(session.getUserName(), values);
        service.addUserData(session.getSessionId(), userData);
    }

    private Map<String, String> defaultValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("combobox", "first");
        map.put("password", "myPassword");
        map.put("textfield", "Hello World");
        return map;
    }
}
