/*
 * This file is part of Chess Master.
 *
 * Chess Master is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chess Master is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Chess Master. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.nicolasgille.chessmaster.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

/**
 *
 * @author Nicolas GILLE
 * @since Chess Master 0.1
 * @version 1.0
 */
public class View extends Application {
    /**
     * Buttons specifications.
     *
     * @since 1.0
     */
    final static double BUTTONS_SPACE = 50;
    final static double BUTTONS_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    final static double BUTTONS_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 25;
    final static double BUTTON_LEFT_PADDING = 0.225;

    /**
     * Copyright Specifications.
     *
     * @since 1.0
     */
    final static double COPYRIGHT_LEFT_PADDING = 25;
    final static double COPYRIGHT_TOP_PADDING = Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 85;

    /**
     * Title specifications.
     *
     * @since 1.0
     */
    final static int MAIN_TITLE_FONT_SIZE = 24;
    final static double MAIN_TITLE_LEFT_PADDING = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.43;
    final static double MAIN_TITLE_TOP_PADDING = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.05;

    /**
     * Primary stage of the GUI.
     *
     * @since 1.0
     */
    private Stage primaryStage;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Chess Master");

        // Initialize app gui.
        this.initMainMenu();
        this.display();
    }

    /**
     * Initialized the main menu of the app.
     *
     * @since 1.0
     * @version 1.0
     */
    private void initMainMenu() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Initialize root element and scene.
        Group root = new Group();
        Scene scene = new Scene(root, screenSize.getWidth() - 10, screenSize.getHeight() - 10);

        // Build menu
        this.buildMainMenu(root, scene, screenSize);

        this.primaryStage.setMaximized(true);
        this.primaryStage.setScene(scene);
        this.primaryStage.sizeToScene();
    }

    private void buildMainMenu(Group root, Scene scene, Dimension screenSize) {
        // Main title
        Label maintitle = new Label();
        maintitle.setText("Chess Master");
        maintitle.setFont(new Font("Arial", MAIN_TITLE_FONT_SIZE));
        maintitle.setLayoutX(MAIN_TITLE_LEFT_PADDING);
        maintitle.setLayoutY(MAIN_TITLE_TOP_PADDING);
        root.getChildren().add(maintitle);

        // Buttons
        Group buttonsGroup = new Group();

        // Start button.
        Button choiceGameButton = new Button();
        choiceGameButton.setLayoutX(screenSize.getWidth() * BUTTON_LEFT_PADDING);
        choiceGameButton.setLayoutY(maintitle.getLayoutY() * 2);
        choiceGameButton.setPrefSize(BUTTONS_WIDTH, BUTTONS_HEIGHT);
        choiceGameButton.setText("Choose your game");
        buttonsGroup.getChildren().add(choiceGameButton);

        // Setting button.
        Button settingButton = new Button();
        settingButton.setLayoutX(screenSize.getWidth() * BUTTON_LEFT_PADDING);
        settingButton.setLayoutY(choiceGameButton.getLayoutY() + BUTTONS_SPACE);
        settingButton.setPrefSize(BUTTONS_WIDTH, BUTTONS_HEIGHT);
        settingButton.setText("Settings");
        buttonsGroup.getChildren().add(settingButton);

        // Quit button.
        Button quitButton = new Button();
        quitButton.setLayoutX(screenSize.getWidth() * BUTTON_LEFT_PADDING);
        quitButton.setLayoutY(settingButton.getLayoutY() + BUTTONS_SPACE);
        quitButton.setPrefSize(BUTTONS_WIDTH, BUTTONS_HEIGHT);
        quitButton.setText("Quit game");
        quitButton.setOnAction(handle -> closeApp());
        buttonsGroup.getChildren().add(quitButton);
        root.getChildren().add(buttonsGroup);

        // Copyright
        Label copyright = new Label();
        copyright.setText("All rights reserved, Nicolas GILLE, 2017");
        copyright.setFont(new Font("Arial", 12));
        copyright.setLayoutX(COPYRIGHT_LEFT_PADDING);
        copyright.setLayoutY(COPYRIGHT_TOP_PADDING);
        root.getChildren().add(copyright);
    }

    /**
     * Display the app on the screen.
     *
     * @since 1.0
     * @version 1.0
     */
    private void display() {
        this.primaryStage.show();
    }


    /**
     * Close the application.
     *
     * @since 1.0
     * @version 1.0
     */
    private void closeApp() {
        this.primaryStage.close();
    }
}
