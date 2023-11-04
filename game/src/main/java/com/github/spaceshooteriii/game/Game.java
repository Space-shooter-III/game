package com.github.spaceshooteriii.game;

import com.github.spaceshooteriii.game.display.compoments.GamePanel;
import com.github.spaceshooteriii.game.entitys.Entity;
import com.github.spaceshooteriii.game.entitys.EntityHandler;
import com.github.spaceshooteriii.game.entitys.Player;
import com.github.spaceshooteriii.game.state.GameState;
import com.github.spaceshooteriii.game.textures.BufferedImageLoader;
import com.github.spaceshooteriii.game.textures.TextraAlice;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {

    private JFrame frame;
    private GamePanel gamePanel;
    private static @Getter GameState state;

    public static final int WIDTH = 820;
    public static final int HEIGHT = 724;

    public static BufferedImageLoader TEXTRA_ALICE_LOADER = null;
    public static TextraAlice TEXTRA_ALICE = null;
    public static Font GAME_FONT = null;

    private static Logger LOGGER = LogManager.getLogger("Game");

    public Game() {
        Game.LOGGER.info("Starting...");
        this.frame = new JFrame();
        this.gamePanel = new GamePanel();
        Game.state = new GameState();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(Game.WIDTH, Game.HEIGHT);
        this.frame.setTitle("Space shooter III");
        this.frame.setResizable(false);
        this.frame.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.frame.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));

        this.gamePanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.frame.add(this.gamePanel);


        this.frame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.frame.setVisible(true);

        this.gamePanel.startGameLoop();
        Game.LOGGER.info("Started");
    }

}
