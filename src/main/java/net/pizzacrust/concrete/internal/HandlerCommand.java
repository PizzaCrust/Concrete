package net.pizzacrust.concrete.internal;

import net.minecraft.server.*;
import net.pizzacrust.concrete.SolidSender;
import net.pizzacrust.concrete.entity.SolidEntityPlayer;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.command.CommandManager;
import org.fountainmc.api.command.CommandSender;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class HandlerCommand implements ICommand {
    private final CommandManager.CommandHandler cmdHandler;

    public HandlerCommand(CommandManager.CommandHandler cmdHandler) {
        this.cmdHandler = cmdHandler;
    }

    @Override
    public String getCommand() {
        return cmdHandler.getCommand().name();
    }

    @Override
    public String getUsage(ICommandListener iCommandListener) {
        return cmdHandler.getCommand().usage();
    }

    @Override
    public List<String> b() {
        return Arrays.asList(cmdHandler.getCommand().aliases());
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandListener iCommandListener, String[] strings) throws CommandException {
        CommandSender commandSender = new SolidSender();
        if (iCommandListener instanceof EntityPlayer) {
            commandSender = new SolidEntityPlayer((EntityPlayer) iCommandListener);
        }
        Fountain.getServer().getCommandManager().fireCommand(cmdHandler, strings, commandSender);
    }

    @Override
    public boolean canUse(MinecraftServer minecraftServer, ICommandListener iCommandListener) {
        return true;
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
