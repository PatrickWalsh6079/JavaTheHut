package com.mycompany.intelligentagentai;

public class Sensor {
    
    public enum Breed {BoxTurtle, EasternBoxTurtle, MudTurtle, Diamondback, PeninsulaCooter}
    
    public int preception(int turtleBreed, int turtleAge)
    {
        int action = 0;
        
        // check with agent
        Agent a = new Agent();
        // return what agent suggests       
        return a.suggestTankSize(turtleBreed, turtleAge);
    }
}
