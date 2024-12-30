package com.restonic4.updater.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

import java.io.IOException;

public class UpdaterClient implements ClientModInitializer {
    public static final String JAR_NAME = "updater";

    @Override
    public void onInitializeClient() {
        if (!areModsUpdated()) {
            try {
                launchExternalProcess();
                Minecraft.getInstance().stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean areModsUpdated() {
        return false;
    }

    private void launchExternalProcess() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"), ModUpdaterProcess.class.getName()
        );
        processBuilder.start();
    }
}
