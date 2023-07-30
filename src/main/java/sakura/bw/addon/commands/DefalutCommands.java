package sakura.bw.addon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sakura.bw.addon.configuration.config_commands;

import java.util.Objects;

public class DefalutCommands implements CommandExecutor {





    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        config_commands cm = new config_commands();

        if (Objects.isNull(cm.getcommands())){
            return true;
        }else {
            if (label.equalsIgnoreCase(cm.getcommands())){
                if (commandSender instanceof Player){
                    Player player = (Player) commandSender;
                    player.sendMessage(cm.getReturnMessage());
                }else {
                    System.out.println("ERROR");
                }
            }
        }
        return true;
    }




}
