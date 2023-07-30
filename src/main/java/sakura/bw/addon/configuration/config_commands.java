package sakura.bw.addon.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import sakura.bw.addon.main;

import java.io.File;

public class config_commands {
    private main plugin = main.getInstance();
    private FileConfiguration file = plugin.getConfig();

    public String getcommands(){
        String commands = file.getString("setting.commands.name");
        return commands;
    }

    public String getReturnMessage(){
        String rm = file.getString("setting.commands.return_message");
        return rm;
    }
}
