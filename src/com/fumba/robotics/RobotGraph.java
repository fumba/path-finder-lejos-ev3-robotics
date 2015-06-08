package com.fumba.robotics;
import java.util.ArrayList;

public class RobotGraph {
    
	//north orientation = 0
	//west orientation = 1
	//south orientation = 2
	//east orientation = 3
	
    private static int orientation;
    private int location;
    private int goal;
    private int[][] graph = {{3, -1, 1, 2},
                             {2, 0, -1, 4},
                             {3, 0, 1, -1},
                             {-1, 0, 2, 7},
                             {6, 1, -1, 5},
                             {6, 4, -1, 8},
                             {7, 4, 5, 9},
                             {-1, 3, 6, 10},
                             {9, 5, -1, 10},
                             {10, 6, 8, -1},
                             {-1, 7, 9, 8} };
    
    public RobotGraph(int orientation, int vertex, int goal){
        this.orientation = orientation;
        this.location = vertex;
        this.goal = goal;        
    }
    
    public Integer transpose(Integer spokeNum, int orientation){
        return ((spokeNum+orientation) % 4);
    }
        
    public ArrayList<Integer> findPath(){
        BreadthFirstSearcher searcher = new BreadthFirstSearcher();
        RobotGraphNode node = new RobotGraphNode(orientation, location, goal, graph);
        searcher.search(node);
        
        ArrayList<Integer> backwardsPath = searcher.getGoalPath();

        return backwardsPath;
    }
    
    public ArrayList<Integer> getPath(){
    	//start at vertex 2, facing north
        //RobotGraph test = new RobotGraph(0, 2, 8);
        ArrayList<Integer> testPath = findPath();
        ArrayList<Integer> actualPath = new ArrayList<Integer>();
        //start at 1 to ignore spoke number from initial location
        for(int i = testPath.size(); i > 0; i--){
            actualPath.add(transpose(testPath.get(i-1), orientation));
        	if(testPath.get(i-1) == 0)
        		orientation = 2;
        	else if(testPath.get(i-1) == 2)
        		orientation = 0;
        	else
        		orientation = testPath.get(i-1);
        }
        /*System.out.println("Our view:");
        for(int i = testPath.size(); i > 0; i--){
            System.out.println(testPath.get(i-1));
        }
        System.out.println("Robot view:");
        for(int i : actualPath)
        {
            System.out.println(i);
        }*/
        return actualPath;
        
    }

}
