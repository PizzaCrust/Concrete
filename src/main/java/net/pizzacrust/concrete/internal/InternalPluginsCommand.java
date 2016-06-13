package net.pizzacrust.concrete.internal;

import net.minecraft.server.*;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class InternalPluginsCommand implements ICommand {
    @Override
    public String getCommand() {
        return "plugins";
    }

    @Override
    public String getUsage(ICommandListener iCommandListener) {
        return null;
    }

    @Override
    public List<String> b() {
        return Arrays.asList("pl", "plugin");
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandListener iCommandListener, String[] strings) throws CommandException {
        StringBuilder pluginBuilder = new StringBuilder();
        for (Object plugin : Fountain.getServer().getPluginManager().getPlugins()) {
            Plugin annt = plugin.getClass().getAnnotation(Plugin.class);
            pluginBuilder.append(annt.name() + ", ");
        }
        iCommandListener.sendMessage(new ChatComponentText("Plugins: " + EnumChatFormat.GREEN + remove(remove(pluginBuilder.toString()))));
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
