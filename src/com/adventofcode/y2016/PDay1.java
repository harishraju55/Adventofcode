package com.adventofcode.y2016;

import java.util.Arrays;
import java.util.List;

public class PDay1 {

	static Direction current;
	static boolean reVisit;
	
	static int x;
	static int y;

	static int eastLength;
	static int westLength;
	static int southLength;
	static int northLength;
	
	public static void main(String[] args) {
		
		// simple tests.
		testDistanceInBlocks("R2, L3", 5);
		testDistanceInBlocks("R2, R2, R2", 2);
		testDistanceInBlocks("R5, L5, R5, R3", 12);
		testDistanceInBlocks("R8, R4, R4, R8", 8);
		
		//  R8, R4, R4, R8, the first location you visit twice is 4 blocks away
		firstLocationVisitedTwice("R8, R4, R4, R8");
		
		String inputString = "R1, R3, L2, L5, L2, L1, R3, L4, R2, L2, L4, R2, L1, R1, L2, R3, L1, L4, R2, L5, R3, R4, L1, "
				+ "R2, L1, R3, L4, R5, L4, L5, R5, L3, R2, L3, L3, R1, R3, L4, R2, R5, L4, R1, L1, L1, R5, L2, R1, L2, R188, "
				+ "L5, L3, R5, R1, L2, L4, R3, R5, L3, R3, R45, L4, R4, R72, R2, R3, L1, R1, L1, L1, R192, L1, L1, L1, L4, R1, "
				+ "L2, L5, L3, R5, L3, R3, L4, L3, R1, R4, L2, R2, R3, L5, R3, L1, R1, R4, L2, L3, R1, R3, L4, L3, L4, L2, L2, "
				+ "R1, R3, L5, L1, R4, R2, L4, L1, R3, R3, R1, L5, L2, R4, R4, R2, R1, R5, R5, L4, L1, R5, R3, R4, R5, R3, L1, "
				+ "L2, L4, R1, R4, R5, L2, L3, R4, L4, R2, L2, L4, L2, R5, R1, R4, R3, R5, L4, L4, L5, L5, R3, R4, L1, L3, R2, "
				+ "L2, R1, L3, L5, R5, R5, R3, L4, L2, R4, R5, R1, R4, L3";
		
		
		distanceInBlocks(inputString);
		firstLocationVisitedTwice(inputString);
	}
	
	static void testDistanceInBlocks(String input, int expectedDistance) {
		int distance = distanceInBlocks(input);
		if(distance == expectedDistance) {
			System.out.println("Test passed : When the input is --> " + input + ", then expect distance of --> " + expectedDistance);
		}
	}
	
	static void easterBunnyHqLog(int distance) {
		System.out.println("Easter Bunny HQ --> " + (distance) + " Blocks away..!!");
	}
	
	static int distanceInBlocks(String navInput) {
		List<String> navSteps = Arrays.asList(navInput.split("\\s*,\\s*"));
		current = Direction.N;
		eastLength = 0;
		westLength = 0;
		southLength = 0;
		northLength = 0;
		
		for (String step : navSteps) {
			moveOn(step.trim());
		}
		int distance = Math.abs(eastLength - westLength) + Math.abs(southLength - northLength);
		easterBunnyHqLog(distance);
		return distance;
	}
	
	static void firstLocationVisitedTwice(String navInput) {
		List<String> navSteps = Arrays.asList(navInput.split("\\s*,\\s*"));
		current = Direction.N;
		eastLength = 0;
		westLength = 0;
		southLength = 0;
		northLength = 0;
		reVisit = false;
		
		for (String step : navSteps) {
			moveOn(step.trim());
		}
		
		// find a revisit.
		// maze size needs some optimized.. but works for the current input..!
		current = Direction.N;
		int mazeSize = eastLength+westLength+southLength+northLength;
		mazeSize = (mazeSize % 2) == 0 ? mazeSize + 1 : mazeSize;
		int[][] maze = new int[mazeSize][mazeSize];
		int fx, fy;
		fx = fy = x = y = mazeSize/2;
		
		maze[x][y] = 7; // for the maze console visual.
		for (String step : navSteps) {
			moveOnMaze(step, maze);
			if(reVisit) {
				break;
			}
		}
		if(reVisit) {
			System.out.println("Easter Bunny HQ Original Location is --> " + (Math.abs(x - fx) + Math.abs(y - fy)) + " Blocks away...!!");
		} else {
			System.out.println("Easter Bunny HQ Original Location is not found..! revisit never occured,,!!!");
		}
		// console maze visual.. enabled for small navigation inputs.
		if(mazeSize < 40) {
			System.out.println(Arrays.deepToString(maze).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		}
	}
	
	static void moveOn(String nextMove) {
		Turn nextStep;
		int length = Integer.parseInt(nextMove.substring(1));
		if (nextMove.startsWith("R")) {
			nextStep = Turn.R;
		} else {
			nextStep = Turn.L;
		}
		if (current == Direction.N) {
			if (nextStep == Turn.R) {
				current = Direction.E;
				eastLength += length;
			} else {
				current = Direction.W;
				westLength += length;
			}
			return;
		}
		if (current == Direction.S) {
			if (nextStep == Turn.R) {
				current = Direction.W;
				westLength += length;
			} else {
				current = Direction.E;
				eastLength += length;
			}
			return;
		}
		if (current == Direction.E) {
			if (nextStep == Turn.R) {
				current = Direction.S;
				southLength += length;
			} else {
				current = Direction.N;
				northLength += length;
			}
			return;
		}
		if (current == Direction.W) {
			if (nextStep == Turn.R) {
				current = Direction.N;
				northLength += length;
			} else {
				current = Direction.S;
				southLength += length;
			}
			return;
		}
	}
	
	static void moveOnMaze(String nextMove, int[][] maze) {
		Turn nextStep;
		int length = Integer.parseInt(nextMove.substring(1));
		if (nextMove.startsWith("R")) {
			nextStep = Turn.R;
		} else {
			nextStep = Turn.L;
		}
		if (current == Direction.N) {
			if (nextStep == Turn.R) {
				current = Direction.E;
				for(int i=0; i<length; i++) {
					y += 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			} else {
				current = Direction.W;
				for(int i=0; i<length; i++) {
					y -= 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			}
			return;
		}
		if (current == Direction.S) {
			if (nextStep == Turn.R) {
				current = Direction.W;
				for(int i=0; i<length; i++) {
					y -= 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			} else {
				current = Direction.E;
				for(int i=0; i<length; i++) {
					y += 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			}
			return;
		}
		if (current == Direction.E) {
			if (nextStep == Turn.R) {
				current = Direction.S;
				for(int i=0; i<length; i++) {
					x += 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			} else {
				current = Direction.N;
				for(int i=0; i<length; i++) {
					x -= 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			}
			return;
		}
		if (current == Direction.W) {
			if (nextStep == Turn.R) {
				current = Direction.N;
				for(int i=0; i<length; i++) {
					x -= 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			} else {
				current = Direction.S;
				for(int i=0; i<length; i++) {
					x += 1;
					if( maze[x][y] == 1) {
						reVisit = true;
						return;
					}
					maze[x][y] = 1;
				}
			}
			return;
		}
	}

	enum Direction {
		N, S, E, W
	}

	enum Turn {
		R, L
	}
}
