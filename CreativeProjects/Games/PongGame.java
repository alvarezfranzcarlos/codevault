import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class PongGame extends Application {
    private static final int WIDTH = 800, HEIGHT = 500;
    private static final int PADDLE_WIDTH = 20, PADDLE_HEIGHT = 100;
    private static final int BALL_SIZE = 20;

    private double playerY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private double aiY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private double ballX = WIDTH / 2 - BALL_SIZE / 2, ballY = HEIGHT / 2 - BALL_SIZE / 2;
    private double ballSpeedX = 4, ballSpeedY = 4;
    private int playerScore = 0, aiScore = 0;

    private boolean upPressed = false, downPressed = false;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(canvas.getParent(), WIDTH, HEIGHT, Color.BLACK);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W)
                upPressed = true;
            if (e.getCode() == KeyCode.S)
                downPressed = true;
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W)
                upPressed = false;
            if (e.getCode() == KeyCode.S)
                downPressed = false;
        });

        stage.setScene(scene);
        stage.setTitle("Pong Game - JavaFX");
        stage.show();

        new AnimationTimer() {
            public void handle(long now) {
                updateGame();
                render(gc);
            }
        }.start();
    }

    private void updateGame() {
        // Move Player Paddle
        if (upPressed && playerY > 0)
            playerY -= 5;
        if (downPressed && playerY < HEIGHT - PADDLE_HEIGHT)
            playerY += 5;

        // AI Paddle Logic (follows the ball)
        if (aiY + PADDLE_HEIGHT / 2 < ballY)
            aiY += 4;
        else if (aiY + PADDLE_HEIGHT / 2 > ballY)
            aiY -= 4;

        // Move Ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Ball Collision with Top/Bottom Walls
        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE)
            ballSpeedY *= -1;

        // Ball Collision with Player Paddle
        if (ballX <= PADDLE_WIDTH && ballY > playerY && ballY < playerY + PADDLE_HEIGHT) {
            ballSpeedX *= -1;
            ballSpeedX *= 1.05; // Increase speed after each hit
        }

        // Ball Collision with AI Paddle
        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE && ballY > aiY && ballY < aiY + PADDLE_HEIGHT) {
            ballSpeedX *= -1;
            ballSpeedX *= 1.05;
        }

        // Check for Scoring
        if (ballX <= 0) {
            aiScore++;
            resetBall();
        } else if (ballX >= WIDTH - BALL_SIZE) {
            playerScore++;
            resetBall();
        }
    }

    private void resetBall() {
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        ballSpeedX = 4 * (Math.random() > 0.5 ? 1 : -1);
        ballSpeedY = 4 * (Math.random() > 0.5 ? 1 : -1);
    }

    private void render(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(Color.WHITE);
        gc.fillRect(10, playerY, PADDLE_WIDTH, PADDLE_HEIGHT);
        gc.fillRect(WIDTH - PADDLE_WIDTH - 10, aiY, PADDLE_WIDTH, PADDLE_HEIGHT);
        gc.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        gc.fillText("Player: " + playerScore, 20, 20);
        gc.fillText("AI: " + aiScore, WIDTH - 80, 20);
    }

    public static void main(String[] args) {
        launch();
    }
}
