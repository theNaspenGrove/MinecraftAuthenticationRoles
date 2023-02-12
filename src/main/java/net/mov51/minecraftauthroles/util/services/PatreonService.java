package net.mov51.minecraftauthroles.util.services;

import me.minecraftauth.lib.AuthService;
import me.minecraftauth.lib.exception.LookupException;

import java.util.UUID;

import static net.mov51.minecraftauthroles.MinecraftAuthRoles.configHelper;

//extend the service class so that we can store it in the service map and override with an authorize method
public class PatreonService extends Service {
    public PatreonService(String value) {
        super(value);
    }
    public boolean authorize(UUID uuid) {
        try {
            if(value.isEmpty()){
                return AuthService.isSubscribedPatreon(configHelper.getAPIToken(),uuid);
            }else{
                return AuthService.isSubscribedPatreon(configHelper.getAPIToken(),uuid,getValue());
            }
        } catch (LookupException e) {
            //todo log error
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public PatreonService newService(String value) {
        //returns a service of the same type for getting a fresh instance from the map
        return new PatreonService(value);
    }
}