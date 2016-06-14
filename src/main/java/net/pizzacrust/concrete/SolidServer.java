package net.pizzacrust.concrete;

import com.google.common.collect.ImmutableList;
import net.minecraft.server.MinecraftServer;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Material;
import org.fountainmc.api.Server;
import org.fountainmc.api.command.CommandManager;
import org.fountainmc.api.plugin.PluginManager;

import java.lang.reflect.Field;

public class SolidServer extends SolidInfo implements Server {
    private final MinecraftServer server;

    public static final PluginManager PLUGIN_MANAGER = new PluginManager();
    public static final CommandManager COMMAND_MANAGER = new CommandManager();


    public SolidServer(MinecraftServer server) {
        super(server);
        this.server = server;
    }

    @Override
    public PluginManager getPluginManager() {
        return PLUGIN_MANAGER;
    }

    @Override
    public CommandManager getCommandManager() {
        return COMMAND_MANAGER;
    }

    @Override
    public ImmutableList<String> getLaunchArguments() {
        return ImmutableList.copyOf(Concrete.LAUNCH_ARGS);
    }

    @Override
    public Material getMaterial(String s) {
        try {
            Class<?> blocks = BlockType.class;
            for (Field field : blocks.getDeclaredFields()) {
                if (field.getName().equals(s.toUpperCase())) {
                    return (Material) field.get(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
