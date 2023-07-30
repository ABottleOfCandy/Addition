package sakura.bw.addon.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import sakura.bw.addon.main;

public class config_mysql {
    private main plugin = main.getInstance();
    private String address;
    private String username;
    private String password;

    private FileConfiguration file = plugin.getConfig();

    public String getaddress(){
        address = file.getString("mysql.address");
        return address;
    }

    public String getusername(){
        username = file.getString("mysql.username");
        return username;
    }

    public String getPassword(){
        password = file.getString("mysql.password");
        return password;
    }


}
