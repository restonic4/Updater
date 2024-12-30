package com.restonic4.updater.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModUpdaterProcess {
    public static void main(String[] args) {
        try {
            File modsDir = new File("mods");
            if (modsDir.exists() && modsDir.isDirectory()) {
                for (File file : modsDir.listFiles()) {
                    if (!file.getName().equals(UpdaterClient.JAR_NAME)) {
                        deleteRecursively(file);
                    }
                }

                deleteSelf();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteRecursively(subFile);
            }
        }

        Files.delete(file.toPath());
    }

    private static void deleteSelf() throws IOException {
        String jarPath = ModUpdaterProcess.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        File selfFile = new File(jarPath);
        if (selfFile.exists()) {
            Files.delete(Paths.get(jarPath));
        }
    }
}
