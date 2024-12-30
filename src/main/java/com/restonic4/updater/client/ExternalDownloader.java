package com.restonic4.updater.client;

import imgui.ImGui;
import imgui.app.Application;
import imgui.app.Configuration;

public class ExternalDownloader extends Application {
    private float progress = 0.0f;

    public static void main(String[] args) {
        launch(new ExternalDownloader());
    }

    @Override
    protected void configure(Configuration config) {
        config.setTitle("Mod Downloader");
    }

    @Override
    public void process() {
        ImGui.begin("Descarga de Mods");

        ImGui.text("Descargando mods del servidor...");
        ImGui.progressBar(progress);

        if (progress < 1.0f) {
            progress += 0.01f;
        } else {
            ImGui.text("¡Descarga completada!");
        }

        ImGui.end();
    }
}
