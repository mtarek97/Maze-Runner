package mazeRunner.model.utilities;

public class GameContract {

	public class Direction {
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
        public static final int LEFT = 4;
    }
	public class Difficulty {
        public static final int EASY = 1;
        public static final int MEDIUM = 2;
        public static final int HARD = 3;
    }
	public class Speed {
        public static final int LOW = 1;
        public static final int MEDIUM = 2;
        public static final int HIGH = 3;
    }
	public class GiftsTypes{
        public static final int WEAPON = 1;
        public static final int BULLETS = 2;
        public static final int HEALTH = 3;
        public static final int COIN = 4;

	}
	public class BombsTypes{
        public static final int DECREASES_HEALTH = 1;
        public static final int DECREASES_SCORE = 2;
	}
}
