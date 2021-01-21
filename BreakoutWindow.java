import objectdraw.*;

import java.awt.*;


public class BreakoutWindow extends WindowController {

    private FilledRect[] Bricks = new FilledRect[Breakout.NTOTAL_BRICKS];
    private FilledRect[] ColliderTop = new FilledRect[Breakout.NTOTAL_BRICKS];
    private FilledRect[] ColliderLeft = new FilledRect[Breakout.NTOTAL_BRICKS];
    private FilledRect[] ColliderRight = new FilledRect[Breakout.NTOTAL_BRICKS];

    private double BrickSepX = Breakout.BRICK_SEP;
    private double BrickSepY = Breakout.BRICK_Y_OFFSET;

    private double ColliderTopSepX = Breakout.BRICK_SEP;
    private double ColliderTopSepY = Breakout.COLLIDER_TOP_OFFSET;

    private double ColliderLeftSepX = Breakout.BRICK_SEP;
    private double ColliderLeftSepY = Breakout.COLLIDER_TOP_OFFSET;

    private double ColliderRightSepX = Breakout.BRICK_SEP + Breakout.BRICK_WIDTH;
    private double ColliderRightSepY = Breakout.COLLIDER_TOP_OFFSET;

    public FilledRect Paddle;

    public static FilledOval Ball;
    public static int dropheightX = (Breakout.CANVAS_WIDTH / 2);          //couldn't get these to work
    public static int dropheightY = (Breakout.CANVAS_HEIGHT / 2) + 25;    //couldn't get these to work

    public Text scoreLabel;
    public Text livesLabel;
    public Text loseGameLabel;
    public Text winGameLabel;

    public void onMouseMove(Location location) {

        Paddle.moveTo(location.getX() - (Breakout.PADDLE_WIDTH  / 2), canvas.getHeight() - Breakout.PADDLE_Y_OFFSET);

        if(Paddle.getX() + Breakout.PADDLE_WIDTH >= Breakout.CANVAS_WIDTH) {

            Paddle.moveTo(Breakout.CANVAS_WIDTH - Breakout.PADDLE_WIDTH, canvas.getHeight() - Breakout.PADDLE_Y_OFFSET);
        }
        if(Paddle.getX() <= Breakout.CANVAS_WIDTH - Breakout.CANVAS_WIDTH) {

            Paddle.moveTo(Breakout.CANVAS_WIDTH - Breakout.CANVAS_WIDTH, canvas.getHeight() - Breakout.PADDLE_Y_OFFSET);
        }

    }
    public void begin() {

        scoreLabel = new Text("Score: " + BreakoutGame.score, Breakout.SCORE_LABEL_X_COORD, Breakout.LABEL_Y_COORD, canvas);
        livesLabel = new Text("Lives: " + BreakoutGame.numberOfTurns, Breakout.LIVES_LABEL_X_COORD, Breakout.LABEL_Y_COORD, canvas);
        loseGameLabel = new Text("Game Over", Breakout.LOSE_LABEL_X_COORD, Breakout.LOSE_LABEL_Y_COORD, canvas);
        winGameLabel = new Text("You Win", Breakout.LOSE_LABEL_X_COORD, Breakout.LOSE_LABEL_Y_COORD, canvas);

        loseGameLabel.setFontSize(Breakout.LOSE_LABEL_SIZE);
        loseGameLabel.hide();

        winGameLabel.setFontSize(Breakout.LOSE_LABEL_SIZE);
        winGameLabel.hide();

        Ball = new FilledOval(dropheightX, dropheightY, Breakout.BALL_RADIUS, Breakout.BALL_RADIUS, Color.black, canvas);

        for(int i = 0; i < (Breakout.NTOTAL_BRICKS); i++) {

            Bricks[i] = new FilledRect(BrickSepX, BrickSepY, Breakout.BRICK_WIDTH, Breakout.BRICK_HEIGHT, Color.black, canvas);
            ColliderTop[i] = new FilledRect(ColliderTopSepX, ColliderTopSepY, Breakout.COLLIDER_TOP_WIDTH, Breakout.COLLIDER_TOP_HEIGHT, Color.black, canvas);
            ColliderLeft[i] = new FilledRect(ColliderLeftSepX, ColliderLeftSepY, Breakout.COLLIDER_LEFT_WIDTH, Breakout.COLLIDER_LEFT_HEIGHT, Color.black, canvas);
            ColliderRight[i] = new FilledRect(ColliderRightSepX, ColliderRightSepY, Breakout.COLLIDER_RIGHT_WIDTH, Breakout.COLLIDER_RIGHT_HEIGHT, Color.black, canvas);

            if(i >= 0 && i < (Breakout.NTOTAL_BRICKS / 5)) {
                Bricks[i].setColor(Color.RED);
                ColliderTop[i].setColor(Color.BLACK);  //ColliderTop[i].setColor(Color.RED);
                ColliderLeft[i].setColor(Color.BLACK);
                ColliderRight[i].setColor(Color.BLACK);
            }
            if(i >= (Breakout.NTOTAL_BRICKS / 5) && i < (Breakout.NTOTAL_BRICKS / 5) * 2) {
                Bricks[i].setColor(Color.ORANGE);
                ColliderTop[i].setColor(Color.BLACK); //ColliderTop[i].setColor(Color.ORANGE);
                ColliderLeft[i].setColor(Color.BLACK);
                ColliderRight[i].setColor(Color.BLACK);
            }
            if(i >= (Breakout.NTOTAL_BRICKS / 5) * 2 && i < (Breakout.NTOTAL_BRICKS / 5) * 3) {
                Bricks[i].setColor(Color.YELLOW);
                ColliderTop[i].setColor(Color.BLACK); //ColliderTop[i].setColor(Color.YELLOW);
                ColliderLeft[i].setColor(Color.BLACK);
                ColliderRight[i].setColor(Color.BLACK);
            }
            if(i >= ((Breakout.NTOTAL_BRICKS / 5) * 3) && i < (Breakout.NTOTAL_BRICKS / 5) * 4) {
                Bricks[i].setColor(Color.GREEN);
                ColliderTop[i].setColor(Color.BLACK); //ColliderTop[i].setColor(Color.GREEN);
                ColliderLeft[i].setColor(Color.BLACK);
                ColliderRight[i].setColor(Color.BLACK);
            }
            if(i >= ((Breakout.NTOTAL_BRICKS / 5) * 4) && i < (Breakout.NTOTAL_BRICKS / 5) * 5) {
                Bricks[i].setColor(Color.CYAN);
                ColliderTop[i].setColor(Color.BLACK); //ColliderTop[i].setColor(Color.CYAN);
                ColliderLeft[i].setColor(Color.BLACK);
                ColliderRight[i].setColor(Color.BLACK);
            }

            if(Breakout.BRICK_ROW_BOOL(i)) {

                BrickSepY += Bricks[i - Breakout.NBRICK_ROWS].getHeight() + Breakout.BRICK_SEP;
                BrickSepX = Bricks[Breakout.ROW_ZERO_INDEX].getX();
                Bricks[i].moveTo(BrickSepX, BrickSepY);
            }

            if(Breakout.COLLIDER_TOP_ROW_BOOL(i)) {

                ColliderTopSepY += Bricks[i - Breakout.NBRICK_ROWS].getHeight() + Bricks[i].getHeight() - Breakout.BRICK_SEP;    //this is correct
                ColliderTopSepX = ColliderTop[Breakout.ROW_ZERO_INDEX].getX();
                ColliderTop[i].moveTo(ColliderTopSepX, ColliderTopSepY);
            }

            if(Breakout.COLLIDER_LEFT_ROW_BOOL(i)) {

                ColliderLeftSepY += Bricks[i - Breakout.NBRICK_ROWS].getHeight() + Bricks[i].getHeight() - Breakout.BRICK_SEP;
                ColliderLeftSepX = ColliderLeft[Breakout.ROW_ZERO_INDEX].getX();
                ColliderLeft[i].moveTo(ColliderLeftSepX, ColliderLeftSepY);
            }

            if(Breakout.COLLIDER_RIGHT_ROW_BOOL(i)) {

                ColliderRightSepY += Bricks[i - Breakout.NBRICK_ROWS].getHeight() + Bricks[i].getHeight() - Breakout.BRICK_SEP;
                ColliderRightSepX = ColliderRight[Breakout.ROW_ZERO_INDEX].getX();
                ColliderRight[i].moveTo(ColliderRightSepX,ColliderRightSepY);
            }


            BrickSepX = (Bricks[i].getX() + Bricks[i].getWidth() + Breakout.BRICK_SEP);
            ColliderTopSepX = (ColliderTop[i].getX() + ColliderTop[i].getWidth() + Breakout.BRICK_SEP);
            ColliderLeftSepX = (ColliderLeft[i].getX() + Bricks[i].getWidth() + Breakout.BRICK_SEP);
            ColliderRightSepX = (ColliderRight[i].getX() + Bricks[i].getWidth() + Breakout.BRICK_SEP);

        }

        Paddle = new FilledRect(Breakout.CANVAS_WIDTH - Breakout.CANVAS_WIDTH, canvas.getHeight() - Breakout.PADDLE_Y_OFFSET, Breakout.PADDLE_WIDTH,
                Breakout.PADDLE_HEIGHT, Color.black, canvas);

        new BreakoutGame(Bricks, ColliderTop, ColliderLeft, ColliderRight, Paddle, Ball, scoreLabel, livesLabel, loseGameLabel, winGameLabel);

    }

    public static void main(String[] args) {

        new BreakoutWindow().startController(Breakout.CANVAS_WIDTH, Breakout.CANVAS_HEIGHT);
    }

}

































