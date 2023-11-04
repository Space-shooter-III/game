package com.github.spaceshooteriii.game.textures;

import java.awt.image.BufferedImage;

public class TextraAlice {

    private final BufferedImage textraAlice;

    public TextraAlice(BufferedImage textraAlice) {
        this.textraAlice = textraAlice;
    }

    public BufferedImage getImageFrom(int x, int y, int width, int height) {
        return this.textraAlice.getSubimage(x, y, width, height);
    }
}
