package tk.zytekaron.spigot.commando;

public class SenderType {
    public static final int PLAYER = 0x0;
    public static final int CONSOLE = 0x1;
    public static final int REMOTE_CONSOLE = 0x2;
    public static final int ALL = PLAYER & CONSOLE & REMOTE_CONSOLE;
}