package tk.zytekaron.spigot.commando.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tk.zytekaron.spigot.commando.BaseCommand;
import tk.zytekaron.spigot.commando.SenderType;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends BaseCommand {
    
    public HelpCommand() {
        super("help", "View the help", "/help", new ArrayList<>());
    }
    
    @Override
    public void run(@NotNull CommandSender sender, @NotNull String alias, @NotNull List<String> args) {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Hi there!");
    }
    
    @Override
    public int getAllowedTypes() {
        return SenderType.PLAYER; // SenderType.PLAYER & SenderType.CONSOLE & SenderType.REMOTE_CONSOLE
    }
}