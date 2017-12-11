package mazeRunner.model.mapBuilder;

import java.util.Arrays;
import java.util.Collections;

import mazeRunner.model.levels.MapSize;

public class MazeGenerator {

	MapSize size;
	private  int x;
	private  int y;
	private  int[][] maze;
	public void MazeGenerator(int x, int y) {
		this.x = x;
		this.y = y;
		maze = new int[this.x][this.y];
		generateMaze(0, 0);
	}

	private void generateMaze(int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y)
					&& (maze[nx][ny] == 0)) {
				maze[cx][cy] |= dir.bit;
				maze[nx][ny] |= dir.opposite.bit;
				generateMaze(nx, ny);
			}
		}
	}

	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}

	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;

		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}

		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	};
	public MazeGenerator(MapSize size){
		this.size = size;
	}
	public void display() {
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < x; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

	public boolean[][] generateMaze() {
		MazeGenerator(size.getWidth(), size.getHeight());
		boolean[][] boolMaze = new boolean[size.getWidth()*2][size.getHeight()*2+1];
		display();
		int u = 0;
		int z = 0;
		for(int i = 0; i < maze.length; i++) {
			z = 0;
			for (int j = 0; j < maze[0].length; j++) {
				boolMaze[u][z++] = true;
				if((maze[j][i] & 1) == 0)
					boolMaze[u][z++] = true ;
				else
					boolMaze[u][z++] = false;

			}
			boolMaze[u][z] = true;
			u++;
			z = 0;
			for(int j = 0; j < maze[0].length; j++) {

				if ((maze[j][i] & 8) == 0 )
					boolMaze[u][z++] = true;
				else
					boolMaze[u][z++] =false;
				boolMaze[u][z++] = false;
			}
			boolMaze[u][z] = true;
			u++;
		}
		return boolMaze;
	}

}
