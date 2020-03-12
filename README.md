# spigot-commando
### Minecraft Version: 1.8+
[![](https://jitpack.io/v/tk.zytekaron/spigot-commando.svg)](https://jitpack.io/#tk.zytekaron/spigot-commando)

This package was created to simplify the creation and registration of commands dynamically
<u>You do not need to declare commands in your plugin.yml if you use this</u>

<br/>

## Installation

### Gradle
```groovy
repositories {
    maven { url = 'https://jitpack.io' }
}
```
```groovy
depencencies {
    compile 'com.github.zytekaron:spigot-commando:1.0.0'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>org.github.zytekaron</groupId>
        <artifactId>spigot-commando</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

<br/>

## Usage Example
```java
package tk.zytekaron.spigot.commando;

import org.bukkit.plugin.java.JavaPlugin;
import tk.zytekaron.spigot.commando.commands.HelpCommand;

public class MyPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        SpigotCommando commando = new SpigotCommando(this);
        commando.registerCommands(new HelpCommand());
    }
}
```

```java
package tk.zytekaron.spigot.commando.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tk.zytekaron.spigot.commando.BaseCommand;
import tk.zytekaron.spigot.commando.SenderType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpCommand extends BaseCommand {
    
    public HelpCommand() {
        super("help", "Display this plugin's commands", "/help", Arrays.asList("commands", "cmds"));
    }
    
    @Override
    public void run(@NotNull CommandSender sender, @NotNull String alias, @NotNull List<String> args) {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Hi there!");
    }
    
    @Override
    public int getAllowedTypes() {
        // SenderType.PLAYER & SenderType.CONSOLE & SenderType.REMOTE_CONSOLE
        return SenderType.PLAYER;
    }
}
```

<br/>

## License
<b>spigot-commando</b> is licensed under the [GNU Lesser General Public License Version 3](https://github.com/Zytekaron/spigot-commando/blob/master/LICENSE.txt)