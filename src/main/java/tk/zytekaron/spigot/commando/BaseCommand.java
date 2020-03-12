package tk.zytekaron.spigot.commando;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCommand extends Command {
    
    protected BaseCommand(@NotNull String name, @NotNull String description, @NotNull String usage, @NotNull List<String> aliases) {
        super(name, description, usage, aliases);
    }
    
    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] arguments) {
        if (this.getPermission() == null) return true;
        List<String> args = Arrays.stream(arguments).collect(Collectors.toList());

        if (sender instanceof Player) {
            if (!canUse(SenderType.PLAYER)) {
                sender.sendMessage("You are not allowed to use this command!");
                return true;
            }
            if (!sender.hasPermission(this.getPermission())) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return true;
            }
            run(sender, alias, args);
        } else if (sender instanceof ConsoleCommandSender) {
            if (!canUse(SenderType.CONSOLE)) {
                sender.sendMessage("You are not allowed to use this command!");
                return true;
            }
            run(sender, alias, args);
        } else if (sender instanceof RemoteConsoleCommandSender) {
            if (!canUse(SenderType.REMOTE_CONSOLE)) {
                sender.sendMessage("You are not allowed to use this command!");
                return true;
            }
            run(sender, alias, args);
        } else {
            sender.sendMessage("You are not allowed to use this command (Unhandled CommandSender)");
        }
        return true;
    }
    
    public abstract void run(@NotNull CommandSender sender, @NotNull String alias, @NotNull List<String> args);
    
    public abstract int getAllowedTypes();
    
    private boolean canUse(int type) {
        return type == (type & getAllowedTypes());
    }
}