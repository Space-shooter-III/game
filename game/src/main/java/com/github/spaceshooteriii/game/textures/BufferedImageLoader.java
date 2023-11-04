package com.github.spaceshooteriii.game.textures;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BufferedImageLoader {
    private static Logger LOGGER = LogManager.getLogger("BufferedImageLoader");

    private @Getter @Setter BufferedImage image;

    public BufferedImageLoader() {
        this.image = null;
    }

    public BufferedImageLoader(String path) {
        this.image = this.loadImage(path);
    }

    public BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
            BufferedImageLoader.LOGGER.info("Can not load image: {}", path);
        }
        return image;
    }

}
