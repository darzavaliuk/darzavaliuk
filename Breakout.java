import objectdraw.FilledOval;
import objectdraw.FilledRect;

import java.awt.*;
import java.util.Random;

public abstract class Breakout {


    public static final int CANVAS_WIDTH = 420;
    public static final int CANVAS_HEIGHT = 600;

    public static final int NBRICK_COLUMNS = 10;
    public static final int NBRICK_ROWS = 10;
    public static final int NTOTAL_BRICKS = NBRICK_ROWS * NBRICK_COLUMNS;
    public static final int ROW_ZERO_INDEX = 0;

    public static final double BRICK_SEP = 4;

    public static boolean BRICK_ROW_BOOL(int x) {

        if (x == 10) {
            return true;
        } else if (x == 20) {
            return true;
        } else if (x == 30) {
            return true;
        } else if (x == 40) {
            return true;
        } else if (x == 50) {
            return true;
        } else if (x == 60) {
            return true;
        } else if (x == 70) {
            return true;
        } else if (x == 80) {
            return true;
        } else if (x == 90) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean COLLIDER_TOP_ROW_BOOL(int x) {

        if (x == 10) {
            return true;
        } else if (x == 20) {
            return true;
        } else if (x == 30) {
            return true;
        } else if (x == 40) {
            return true;
        } else if (x == 50) {
            return true;
        } else if (x == 60) {
            return true;
        } else if (x == 70) {
            return true;
        } else if (x == 80) {
            return true;
        } else if (x == 90) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean COLLIDER_LEFT_ROW_BOOL(int x) {

        if (x == 10) {
            return true;
        } else if (x == 20) {
            return true;
        } else if (x == 30) {
            return true;
        } else if (x == 40) {
            return true;
        } else if (x == 50) {
            return true;
        } else if (x == 60) {
            return true;
        } else if (x == 70) {
            return true;
        } else if (x == 80) {
            return true;
        } else if (x == 90) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean COLLIDER_RIGHT_ROW_BOOL(int x) {

        if (x == 10) {
            return true;
        } else if (x == 20) {
            return true;
        } else if (x == 30) {
            return true;
        } else if (x == 40) {
            return true;
        } else if (x == 50) {
            return true;
        } else if (x == 60) {
            return true;
        } else if (x == 70) {
            return true;
        } else if (x == 80) {
            return true;
        } else if (x == 90) {
            return true;
        } else {
            return false;
        }
    }

    public static final double BRICK_WIDTH = Math.floor(
            (CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);
    public static final double BRICK_HEIGHT = 8;

    public static final double COLLIDER_TOP_WIDTH = BRICK_WIDTH;
    public static final double COLLIDER_TOP_HEIGHT = 2;

    public static final double COLLIDER_LEFT_WIDTH = 2;
    public static final double COLLIDER_LEFT_HEIGHT = BRICK_HEIGHT + 1;

    public static final double COLLIDER_RIGHT_WIDTH = 2;
    public static final double COLLIDER_RIGHT_HEIGHT = BRICK_HEIGHT + 1;

    public static final double BRICK_Y_OFFSET = 70;
    public static final double COLLIDER_TOP_OFFSET = BRICK_Y_OFFSET - 1;


    public static final double PADDLE_WIDTH = 60;
    public static final double PADDLE_HEIGHT = 10;

    public static final double PADDLE_Y_OFFSET = 30;

    public static final double BALL_RADIUS = 10;

    public static double VELOCITY_Y = 3;//9.0;
    public static double NEW_X = 1;//3.0;

    public static final double VELOCITY_X_MIN = 1.0;
    public static final double VELOCITY_X_MAX = 3.0;


    public static final int DELAY = 1000 / 60;
    public static final int BALL_PAUSE = 30;

    public static final int NTURNS = 300;  //3

    public static final String SCREEN_FONT = "SansSerif-BOLD-18";

    public static final int SCORE_LABEL_X_COORD = 5;
    public static final int LIVES_LABEL_X_COORD = 75;
    public static final int LOSE_LABEL_X_COORD = 150;
    public static final int LOSE_LABEL_Y_COORD = 500;
    public static final int LOSE_LABEL_SIZE = 30;
    public static final int LABEL_Y_COORD = 20;
    public static final int WIN_GAME_SCORE = 100;

}


