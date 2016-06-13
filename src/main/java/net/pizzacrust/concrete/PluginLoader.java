package net.pizzacrust.concrete;

import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.fountainmc.api.Fountain;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {
    public static void loadPlugins(File dir) throws Exception {
        File[] jarFiles = dir.listFiles((dir1, name) -> name.endsWith(".jar"));
        for (File jarFile : jarFiles) {
            JarFile jar = new JarFile(jarFile);
            String[] allClasses = getAllClasses(jar);
            LaunchClassLoader currentLaunchCL = (LaunchClassLoader) Thread.currentThread().getContextClassLoader();
            currentLaunchCL.addURL(jarFile.toURI().toURL());
            for (String className : allClasses) {
                Class<?> theClass = currentLaunchCL.findClass(className);
                Object instance = theClass.newInstance();
                Fountain.getServer().getPluginManager().getPlugins().add(instance);
                Fountain.getServer().getPluginManager().registerListener(instance);
            }
        }
    }

    private static String[] getAllClasses(JarFile jarFile) {
        Enumeration<JarEntry> entryEnumeration = jarFile.entries();
        ArrayList<String> reflectCompatibleClassNames = new ArrayList<>();
        while (entryEnumeration.hasMoreElements()) {
            JarEntry currentEntry = entryEnumeration.nextElement();
            if (currentEntry == null) {
                break;
            }
            if (currentEntry.getName().endsWith(".class")) reflectCompatibleClassNames.add(FilenameUtils.removeExtension(currentEntry.getName()).replace('/', '.'));
        }
        return reflectCompatibleClassNames.toArray(new String[reflectCompatibleClassNames.size()]);
    }
}
