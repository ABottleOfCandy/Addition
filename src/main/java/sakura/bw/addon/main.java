package sakura.bw.addon;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sakura.bw.addon.commands.DefalutCommands;
import sakura.bw.addon.configuration.config_commands;

import java.util.HashMap;
import java.util.Objects;

public class main extends JavaPlugin {
    public static HashMap<Player,String> PlayerMaps;
    private static main instance = null;
    public static main getInstance(){
        return instance;
    }
    @Override
    public void onEnable(){
        //==******************==
        //以下为commands
        //==******************==
        if (Objects.nonNull(new config_commands().getcommands())){
            getCommand(new config_commands().getcommands()).setExecutor(new DefalutCommands());
        }


        //==******************==
        //以下为初始化信息
        //==******************==
        instance = this;
        this.init_maps();
        saveDefaultConfig();
        getLogger().info("The plugin has already enabled");
    }

    @Override
    public void onDisable(){
        getLogger().info("The plugin has already disabled");
        this.init_maps();
    }


    //init players' maps
    public void init_maps(){
        //==******************==
        //初始化 不用修改
        //==******************==
        saveDefaultConfig();
        PlayerMaps = new HashMap<>();
        HashMap pm = PlayerMaps;
        pm.clear();
        PlayerMaps = pm;
        getLogger().info("PlayerMaps->Have already cleared");
    }
}
