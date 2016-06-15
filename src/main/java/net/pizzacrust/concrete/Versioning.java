package net.pizzacrust.concrete;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Versioning {
    public static final String JAR_JSON_PATH = "version.json";

    public static InputStream getJarJsonStream() {
        return Versioning.class.getClassLoader().getResourceAsStream(JAR_JSON_PATH);
    }

    public static String getShortenedShaCommitVersion() {
        try {
            return new Gson().fromJson(new InputStreamReader(getJarJsonStream()), JarJsonFormat.class).currentVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRemoteShaCommitVersion() {
        try {
            return new Gson().fromJson(new InputStreamReader(new URL("https://cdn.rawgit.com/PizzaCrust/Concrete/master/version.json").openStream()), RemoteJsonFormat.class).recommendedVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static class RemoteJsonFormat {
        public String recommendedVersion;
    }

    public static class JarJsonFormat {
        public String currentVersion;
    }
}
