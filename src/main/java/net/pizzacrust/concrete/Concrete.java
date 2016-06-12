package net.pizzacrust.concrete;

import net.minecraft.server.MinecraftServer;

import java.io.File;

public class Concrete {

    public static String[] LAUNCH_ARGS;

    public static File PLUGINS_DIR = new File(System.getProperty("user.dir"), "plugins");

    public static void main(String... args) {
        System.out.println("Loading libraries, please wait...");
        LAUNCH_ARGS = args;
        MinecraftServer.main(args);
    }
}
