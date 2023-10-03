package net.craftcitizen.imagemaps;

import net.craftcitizen.imagemaps.clcore.command.SubCommand;

public abstract class ImageMapSubCommand extends SubCommand {

    public ImageMapSubCommand(String permission, ImageMaps plugin, boolean console) {
        super(permission, plugin, console);
    }

    @Override
    public ImageMaps getPlugin() {
        return (ImageMaps) super.getPlugin();
    }
}
