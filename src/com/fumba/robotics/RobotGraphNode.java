package com.fumba.robotics;
import java.util.ArrayList;

public class RobotGraphNode extends SearchNode {

    private int orientation;
    private int location;
    private int goal;
    private int spokeNum;
    private int[][] graph;

    public RobotGraphNode(int orientation, int location, int goal, int[][] graph){
        this.orientation = orientation;
        this.location = location;
        this.goal = goal; 
        this.graph = graph;
    }
    
    public int getSpokeNum()
    {
        return spokeNum;
    }

    public ArrayList<SearchNode> expand() {
        ArrayList<SearchNode> children = new ArrayList<SearchNode> ();
        for(int i = 0; i < graph[location].length; i++){
            if(graph[location][i] != -1){
                if(i == 1 || i == 3){
                    RobotGraphNode child = (RobotGraphNode)this.childClone();
                    child.orientation = i;
                    child.spokeNum = i;
                    child.location = graph[location][i];
                    children.add(child);
                }
                else if(i == 0 || i == 2){
                    RobotGraphNode child = (RobotGraphNode)this.childClone();
                    child.orientation = (i+2)%4;
                    child.location = graph[location][i];
                    child.spokeNum = i;
                    children.add(child);
                }
            }
        }
        return children;
    }

    public boolean isGoal() {
        return (location == goal);
    }
    
    public Integer getOrientation(){
        return orientation;
    }
    
    public String toString(){
        return ""+spokeNum;
    }
    
    public Object clone()
    {
        RobotGraphNode child = (RobotGraphNode) super.clone();
        return child;
    }
}
