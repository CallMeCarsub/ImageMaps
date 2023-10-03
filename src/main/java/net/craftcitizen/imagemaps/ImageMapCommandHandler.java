package net.craftcitizen.imagemaps;

import net.craftcitizen.imagemaps.clcore.command.CommandHandler;

public class ImageMapCommandHandler extends CommandHandler {
    public ImageMapCommandHandler(ImageMaps plugin) {
        super(plugin);
        registerSubCommand("download", new ImageMapDownloadCommand(plugin));
        registerSubCommand("delete", new ImageMapDeleteCommand(plugin));
        registerSubCommand("place", new ImageMapPlaceCommand(plugin));
        registerSubCommand("info", new ImageMapInfoCommand(plugin));
        registerSubCommand("list", new ImageMapListCommand(plugin));
        registerSubCommand("reload", new ImageMapReloadCommand(plugin));
        registerSubCommand("cleanup", new ImageMapCleanupCommand(plugin));
        registerSubCommand("debuginfo", new ImageMapDebugInfoCommand(plugin));
        registerSubCommand("help", new ImageMapHelpCommand(plugin, getCommands()), "?");
    }
}
