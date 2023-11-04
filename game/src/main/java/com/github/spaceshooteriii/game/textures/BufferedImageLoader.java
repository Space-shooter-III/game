package com.github.spaceshooteriii.game.textures;

import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BufferedImageLoader {
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
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
