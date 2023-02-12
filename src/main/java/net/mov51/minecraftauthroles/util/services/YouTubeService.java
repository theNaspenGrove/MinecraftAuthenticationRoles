package net.mov51.minecraftauthroles.util.services;

import me.minecraftauth.lib.AuthService;
import me.minecraftauth.lib.exception.LookupException;

import java.util.UUID;

import static net.mov51.minecraftauthroles.MinecraftAuthRoles.configHelper;

public class YouTubeService extends Service {
    public YouTubeService(String value) {
        super(value);
    }
    public boolean authorize(UUID uuid) {
        try {
            AuthService.isSubscribedYouTube(configHelper.getAPIToken(),uuid);
        } catch (LookupException e) {
            //todo log error
            e.printStackTrace();
            return false;
        }
        return false;
    }
    @Override
    public YouTubeService newService(String value) {
        return new YouTubeService(value);
    }
}