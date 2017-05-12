package Main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import GameState.Story;
import Handlers.Controls;
import Handlers.Options;
import Handlers.Text;

public class VoidMain extends Application {
	private static Canvas canvas;
	private static GraphicsContext gc;
	private static Group root;
	private static Scene scene;
	private static long ticks = 0;
	private static Stage stage;

	private static void draw() {
    //Story.draw();
  }

	public static Canvas getCanvas() {
		return canvas;
	}

	public static GraphicsContext getGraphicsContext() {
		return gc;
	}

	public static int getTicks() {
		return (int) ticks;
	}

	public static void main(String[] args) {
		final LogicThread main = new LogicThread();
		final Thread thread = new Thread(main);
		thread.start();
		launch();
	}

	public static void println(String s) {
		System.out.println(s);
	}

	private static void update() {
		ticks++;
	}

	@Override
	public void start(Stage initialStage) {
		newWindow();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
				draw();
			}
		}.start();
	}

	private static void newWindow() {
		root = new Group();
		scene = new Scene(root, Options.getRealWidth(), Options.getRealHeight(), Color.BLACK);
		canvas = new Canvas(Options.getRealWidth(), Options.getRealHeight());
		gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Options.getRealWidth(), Options.getRealHeight());
		gc.setFont(Text.getDefaultFont());

		root.getChildren().add(canvas);

		stage = new Stage();

		stage.getIcons().addAll(new Image("/Icons/shortcut.png"));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Void");
		stage.show();

		final double extraWidth = scene.getWidth() - Options.getRealWidth();
		final double extraHeight = scene.getHeight() - Options.getRealHeight();
		stage.setWidth(stage.getWidth() - extraWidth);
		stage.setHeight(stage.getHeight() - extraHeight);

		final EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					Controls.setEnter(true);
				} else {
					Controls.textInput(event);
				}
				if (event.getCode() == KeyCode.UP) {
					Controls.setUp(true);
					Controls.setDown(false);
				} else if (event.getCode() == KeyCode.DOWN) {
					Controls.setDown(true);
					Controls.setUp(false);
				}

				if (event.getCode() == KeyCode.LEFT) {
					Controls.setLeft(true);
					Controls.setRight(false);
				} else if (event.getCode() == KeyCode.RIGHT) {
					Controls.setRight(true);
					Controls.setLeft(false);
				}

				if (event.getCode() == KeyCode.SHIFT) {
					Controls.setShift(true);
				}
				if (event.getCode() == KeyCode.CAPS) {
					Controls.setCaps(!Controls.getCaps());
				}
			}
		};
		stage.getScene().setOnKeyPressed(keyPressed);

		final EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					Controls.setEnter(false);
				}
				if (event.getCode() == KeyCode.UP) {
					Controls.setUp(false);
				}
				if (event.getCode() == KeyCode.DOWN) {
					Controls.setDown(false);
				}
				if (event.getCode() == KeyCode.SHIFT) {
					Controls.setShift(false);
				}
			}
		};
		stage.getScene().setOnKeyReleased(keyReleased);

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	public static void notifySizeUpdate() {
		stage.close();
		newWindow();
	}
}
