import objectdraw.ActiveObject;
import objectdraw.*;
import javax.swing.*;
import java.util.Random;

public class BreakoutGame extends ActiveObject {

    private static FilledRect[] Bricks = new FilledRect[52];
    private static FilledRect[] ColliderTop = new FilledRect[52];
    private static FilledRect[] ColliderLeft = new FilledRect[52];
    private static FilledRect[] ColliderRight = new FilledRect[52];

    private static FilledRect Paddle;
    private static FilledOval Ball;

    public static double numberOfTurns = Breakout.NTURNS;
    public static double score = 0;
    private Text scoreLable;
    private Text livesLable;
    private Text loseGameLabel;
    private Text winGameLabel;

    private Random random;


    public BreakoutGame(FilledRect[] bricks, FilledRect[] collider1, FilledRect[] collider2, FilledRect[] collider3, FilledRect paddle, FilledOval ball,
                        Text sTxt, Text lTxt, Text lgTxt, Text wgTxt) {

            Bricks = bricks;
            ColliderTop = collider1;
            ColliderLeft = collider2;
            ColliderRight = collider3;
            Paddle = paddle;
            Ball = ball;
            scoreLable = sTxt;
            livesLable = lTxt;
            loseGameLabel = lgTxt;
            winGameLabel = wgTxt;

            start();
    }

    public void run() {

        random = new Random();
        while(numberOfTurns > 0) {

            Ball.move(Breakout.NEW_X, Breakout.VELOCITY_Y);
            pause(Breakout.BALL_PAUSE);

            if(Ball.getX() >= Breakout.CANVAS_WIDTH) {

                Breakout.NEW_X = -1;//-7;
            }
            if(Ball.getX() <= Breakout.CANVAS_WIDTH - Breakout.CANVAS_WIDTH) {

                Breakout.NEW_X = 1;//7;
            }
            if(Ball.getY() <= Breakout.CANVAS_HEIGHT - Breakout.CANVAS_HEIGHT) {

                Breakout.VELOCITY_Y = 3;//7;
            }
            if(Ball.overlaps(Paddle)) {

                Breakout.VELOCITY_Y = -3;//-7;
            }
            if(Ball.getY() > Breakout.CANVAS_HEIGHT) {

                numberOfTurns--;
                livesLable.setText("Lives: " + Double.toString(numberOfTurns));
                Ball.moveTo(BreakoutWindow.dropheightX, BreakoutWindow.dropheightY);
            }


            for(int i = 0; i < Breakout.NTOTAL_BRICKS; i++) {

                if(Ball.overlaps(ColliderTop[i]) && Bricks[i].isHidden() == false) {

                    Bricks[i].hide();
                    ColliderTop[i].hide();
                    ColliderLeft[i].hide();
                    ColliderRight[i].hide();
                    Breakout.VELOCITY_Y = -3;//-7;
                    score++;
                    scoreLable.setText("Score: " + Double.toString(score));
                }

            }

            for(int i = 0; i < Breakout.NTOTAL_BRICKS; i++) {

                if(Ball.overlaps(ColliderLeft[i]) && Bricks[i].isHidden() == false) {

                    Bricks[i].hide();
                    ColliderLeft[i].hide();
                    ColliderTop[i].hide();
                    ColliderRight[i].hide();
                    Breakout.NEW_X = -3;//-7;
                    score++;
                    scoreLable.setText("Score: " + Double.toString(score));
                }

            }

            for(int i = 0; i < Breakout.NTOTAL_BRICKS; i++) {

                if(Ball.overlaps(ColliderRight[i]) && Bricks[i].isHidden() == false) {

                    Bricks[i].hide();
                    ColliderLeft[i].hide();
                    ColliderTop[i].hide();
                    ColliderRight[i].hide();
                    Breakout.NEW_X = 3;//7;
                    score++;
                    scoreLable.setText("Score: " + Double.toString(score));
                }

            }

            for(int i = 0; i < Breakout.NTOTAL_BRICKS; i++) {

                if(Ball.overlaps(Bricks[i]) && Bricks[i].isHidden() == false) {

                    Bricks[i].hide();
                    ColliderTop[i].hide();
                    ColliderLeft[i].hide();
                    ColliderRight[i].hide();
                    Breakout.VELOCITY_Y = 3;//7;
                    score++;
                    scoreLable.setText("Score: " + Double.toString(score));
                }

            }

            if(score == Breakout.WIN_GAME_SCORE) {

                Paddle.removeFromCanvas();
                Ball.removeFromCanvas();
                winGameLabel.show();
            }

        }

        if (numberOfTurns == 0) {

            loseGameLabel.show();
            Ball.hide();
            Paddle.hide();
        }
    }
}

























