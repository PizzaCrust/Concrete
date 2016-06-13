package net.pizzacrust.concrete.internal;

import net.minecraft.server.*;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class InternalAboutCommand implements ICommand {
    @Override
    public String getCommand() {
        return "about";
    }

    @Override
    public String getUsage(ICommandListener iCommandListener) {
        return "/about <pluginName>";
    }

    @Override
    public List<String> b() {
        return Arrays.asList("abt");
    }

    public Plugin getPlugin(String name) {
        for (Object plugin : Fountain.getServer().getPluginManager().getPlugins()) {
            Plugin annt = plugin.getClass().getAnnotation(Plugin.class);
            if (name.trim().equals(InternalFormatter.stripColor(annt.name()))) {
                return annt;
            }
        }
        return null;
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandListener iCommandListener, String[] strings) throws CommandException {
        if (strings.length < 1) {
            iCommandListener.sendMessage(new ChatComponentText(EnumChatFormat.RED + "/about <pluginName>"));
            return;
        }
        StringBuilder mergeBuilder = new StringBuilder();
        int currentIndex = 0;
        while (currentIndex != strings.length) {
            mergeBuilder.append(strings[currentIndex] + " ");
            currentIndex++;
        }
        Plugin plugin = getPlugin(mergeBuilder.toString());
        if (plugin == null) {
            iCommandListener.sendMessage(new ChatComponentText(EnumChatFormat.RED + "Plugin doesn't exist."));
            return;
        }
        iCommandListener.sendMessage(new ChatComponentText(EnumChatFormat.GREEN + plugin.name() + EnumChatFormat.RESET + " version " + EnumChatFormat.GREEN + plugin.version()));
        iCommandListener.sendMessage(new ChatComponentText(plugin.description()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String author : plugin.author()) {
            stringBuilder.append(EnumChatFormat.GREEN + author + ", ");
        }
        iCommandListener.sendMessage(new ChatComponentText("Authors: " + remove(remove(stringBuilder.toString()))));
    }

    public String remove(String str) {
        return str.substring(0,str.length()-1);
    }

    @Override
    public boolean canUse(MinecraftServer minecraftServer, ICommandListener iCommandListener) {
        return InternalUtils.isPermitted(minecraftServer, iCommandListener, true);
    }

    @Override
    public List<String> tabComplete(MinecraftServer minecraftServer, ICommandListener iCommandListener, String[] strings, @Nullable BlockPosition blockPosition) {
        return null;
    }

    @Override
    public boolean isListStart(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
