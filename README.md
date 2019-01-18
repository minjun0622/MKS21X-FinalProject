
# MKS21X-FinalProject

1/4/19 The first half of the period was spent on branching tutorials. We were successfully able to create a branch and then merge it to master again. Then, we laid the foundations for the project by creating the files that we would need. There was a mistake of making a branch before making the files so it was fixed.

1/7/19 Minjun worked on the board class, where the board was made and plans to randomize the keys that will be printed out on the terminal. Chong worked on the Tiles class and set it up, establishing methods and boolean.

1/8/19 Chong reached further progress with the Tiles class. However, we came up with a class issue in Tiles. We debated whether a method was needed (toString), to change the values of the x in the 2D array. Minjun needed clarification on how we are going to know where the boolean (isBomb) is going to be used. We figured out that every x is going to have a boolean that predetermines whether it is a bomb or not.

1/9/19 Made further progress on the Tiles function. The board class was improved with extra tweaks. Mainly worked on the Tiles class because we realized that was the class with the most methods. Ran into a problem with class structure. Not sure if it extends or not.

1/10/19 Chong finished the Tiles class and merged it into the master branch. However, due to branching problems we weren't able to commit due to conflicts, so we pushed our conflicts and committed late. Also we forgot to update the dev log, which is updated now. (1/12/19).

1/12/19 We thought the Tiles class was done but it wasn't. Chong edited the Tiles class heavily by changing instance variable names (bombs -> mines), adding new variables, deleting unnecessary/repetitive variables, and adding/editing methods according to new variables. Chong also edited the Board class extensively by adding/changing/deleting variables, and changing the constructor for board from the old constructor. Methods that create/initialize the board are added and there is also a main method that tests whether the calculateNearbyMines method works or not, and it works! The main method is commented out now because we confirmed that the calculateNearbyMines method works. Also, the old code is now commented out at the bottom. It seems like both the Tiles class and Board class are finished, but Tiles class might need more work for the setFlag method. If they are not done, we can always add more/delete/edit necessary methods when we work on the main method for the MineSweeper class. Chong added comments for both Tiles and Board classes to explain what the code is doing at each methods.

1/13/19 The lanterna code sample was studied and Minjun figured out how the code works and the logistics of it. He is implementing the necessities that are involved with the main method. Still has a question on the class structure and how we are going to implement methods from the Board class. Will discuss with Chong later in the day. Also, due to time constraints, the flag feature will be removed for the demo. Possibly will add later on if more time is allotted. Minjun realized the Tiles class will be edited due to the fact that it shares some of the methods with Board. Board is more suited to take those methods, therefore it will be commented out. Chong edited the Board class to finalize. Chong is working on the main. Decided to not use the Lanterna and use a coordinates system because of the difficulty that the lanterna had. The main method is done and the minimum project for the demo is created. The player is able to type in coordinates of the tile he/she wants to reveal and does so in the terminal directly. No flagging feature is implemented yet, but will be added later for the final version. As of 1/13, a working demo version is completed.
Directions for the Code:
You can play the game by selecting two coordinates,
the first number is the x direction of the board and the second digit is the y direction.
The board goes up to 0 - 6 in both x and y direcitons.

The Monkey branch was created by Minjun and the Yur branch was created by Chong.

The board goes up to 0 - 6 in both x and y directions.

1/14/19
Looked at other people's demos and thought they were good.

1/15/19
Chong started to edit the toString. Minjun started the difficulty input through the args.

1/16/19
Minjun realized a critical mistake and that args.length and arg[int] are different! Chong has gotten started in the Flags method in the Board/Tiles class.

1/17/19

Chong finished implementing the flag method in the board class and flag boolean of the tiles class to finaly create the flagging part of the game. It works properly and now we need to fix just a few more methods for the game to be completely functional.

Chong ran into a problem with the Yur class. While adding new code, there has been issue with branching and changing. That issue has been fixed.

1/18/19
The difficulty has been implemented. However, there was a problem because the rows and columns, when it becomes a two digit number, it will push some numbers out of the way. Looking to fix that. 

