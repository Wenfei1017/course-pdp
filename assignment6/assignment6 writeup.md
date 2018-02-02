##assignment 6 writeup

###main relations between classes
1. UserVertex is the node contains all information including users and the edge adjacent to this user. By this way we can find the edges quickly.
2. Building two graphs to solve this problem, one is follower and anthoer is followed. Then according to these two graphs, develop the recommend system for users.
3. GetUserInfo class get all the information from csv file. 
4. GenerateFile calss is responsible for generating new file to save the recommend output.
5. recommendation system recommend friends use four menthod from recommend class.

###how are you encoding and accessing the information about the social network
In this assignment, we save he users information in the vertex and by instantiation users and vertex, wo get the information for users. And then wo build the graphs, using hashset to save all the freinds and folloers of each users. 

### pros and cons
1. pros: very simple, and easy to understand. If someone want to add some classes, it's easy because the expandability is good.
2. cons: some code might be reduplicative.and the time complexity is not good.