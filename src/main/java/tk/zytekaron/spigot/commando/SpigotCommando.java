package tk.zytekaron.spigot.commando;

import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class SpigotCommando {
    private JavaPlugin plugin;
    
    public SpigotCommando(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public void registerCommands(BaseCommand... commands) {
        CommandMap commandMap = getCommandMap();
        for (BaseCommand command : commands) {
            commandMap.register(plugin.getName().toLowerCase(), command);
        }
    }
    
    private CommandMap getCommandMap() {
        try {
            Field spigotCommandMap = plugin.getServer().getClass().getDeclaredField("commandMap");
            spigotCommandMap.setAccessible(true);
            return (CommandMap) spigotCommandMap.get(plugin.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}