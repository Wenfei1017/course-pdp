package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.List;

public class Recommend1 {
    private UsersGraph usersGraph;

    public List<Users> recommend1(UserVertex[] vex,List<int[]> edge) throws IOException {
        usersGraph = new UsersGraph();
        usersGraph.createGraph1(vex, edge);
        int largest = 0;
        for(int i = 0; i < userVertices.length; i++){
            //List<Integer> followed
            int numbers = usersGraph.countFollowers(userVertices[i]).size();
            if(numbers > largest){
                largest = numbers;
            }
        }
    }
}
