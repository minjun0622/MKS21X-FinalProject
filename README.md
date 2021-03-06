
# MKS21X-FinalProject
Fall APCS 2018 final project MineSweeper by Chong Lee and Minjun Seo pd 3.

# Instructions

HOW TO COMPILE : javac MineSweeper.java

HOT TO RUN : java MineSweeper "easy/medium/hard"

# Development Log

1/4/19 The first half of the period was spent on branching tutorials. We were successfully able to create a branch and then merge it to master again. Then, we laid the foundations for the project by creating the files that we would need. There was a mistake of making a branch before making the files so it was fixed.

1/7/19 Minjun worked on the board class, where the board was made and plans to randomize the keys that will be printed out on the terminal. Chong worked on the Tile class and set it up, establishing methods and boolean.

1/8/19 Chong reached further progress with the Tile class. However, we came up with a class issue in Tile. We debated whether a method was needed (toString), to change the values of the x in the 2D array. Minjun needed clarification on how we are going to know where the boolean (isBomb) is going to be used. We figured out that every x is going to have a boolean that predetermines whether it is a bomb or not.

1/9/19 Made further progress on the Tile function. The board class was improved with extra tweaks. Mainly worked on the Tile class because we realized that was the class with the most methods. Ran into a problem with class structure. Not sure if it extends or not.

1/10/19 Chong finished the Tile class and merged it into the master branch. However, due to branching problems we weren't able to commit due to conflicts, so we pushed our conflicts and committed late. Also we forgot to update the dev log, which is updated now. (1/12/19).

1/12/19 We thought the Tile class was done but it wasn't. Chong edited the Tile class heavily by changing instance variable names (bombs -> mines), adding new variables, deleting unnecessary/repetitive variables, and adding/editing methods according to new variables. Chong also edited the Board class extensively by adding/changing/deleting variables, and changing the constructor for board from the old constructor. Methods that create/initialize the board are added and there is also a main method that tests whether the calculateNearbyMines method works or not, and it works! The main method is commented out now because we confirmed that the calculateNearbyMines method works. Also, the old code is now commented out at the bottom. It seems like both the Tile class and Board class are finished, but Tile class might need more work for the setFlag method. If they are not done, we can always add more/delete/edit necessary methods when we work on the main method for the MineSweeper class. Chong added comments for both Tile and Board classes to explain what the code is doing at each methods.

1/13/19 The lanterna code sample was studied and Minjun figured out how the code works and the logistics of it. He is implementing the necessities that are involved with the main method. Still has a question on the class structure and how we are going to implement methods from the Board class. Will discuss with Chong later in the day. Also, due to time constraints, the flag feature will be removed for the demo. Possibly will add later on if more time is allotted. Minjun realized the Tile class will be edited due to the fact that it shares some of the methods with Board. Board is more suited to take those methods, therefore it will be commented out. Chong edited the Board class to finalize. Chong is working on the main. Decided to not use the Lanterna and use a coordinates system because of the difficulty that the lanterna had. The main method is done and the minimum project for the demo is created. The player is able to type in coordinates of the tile he/she wants to reveal and does so in the terminal directly. No flagging feature is implemented yet, but will be added later for the final version. As of 1/13, a working demo version is completed.

The Monkey branch was created by Minjun and the Yur branch was created by Chong.

The board goes up to 0 - 6 in both x and y directions.

1/14/19
Looked at other people's demos and thought they were good.

1/15/19
Chong started to edit the toString. Minjun started the difficulty input through the args.

1/16/19
Minjun realized a critical mistake and that args.length and arg[int] are different! Chong has gotten started in the Flags method in the Board/Tile class.

1/17/19

Chong finished implementing the flag method in the board class and flag boolean of the Tile class to finally create the flagging part of the game. It works properly and now we need to fix just a few more methods for the game to be completely functional.

Chong ran into a problem with the Yur branch. While adding new code, there has been issue with branching and changing. That issue has been fixed. Minjun worked on the difficulty and also the placeMines method.

1/18/19
The difficulty has been implemented. However, there was a problem because the rows and columns, when it becomes a two digit number, it will push some numbers out of the way. Looking to fix that.

1/20/19
Chong worked on the board class by adding variables that keeps track of how many mined Tile there are, how many are revealed, and if the board is completed (it is completed if number of numbered of revealed Tile equals the number of total Tile minus the number of mined Tile). Chong also edited the MineSweeper class (the main method) so when the board is fully revealed without revealing any mined Tile, the user gets a win message and the scanner closes. As of now, the user only needs to reveal every non mine tile instead of doing so and flagging all non mine tile as well, so we need to add another variable that keeps track of flags that are on mine Tile. The placeMines method still needs to be worked on. Minjun worked on simplifying the code with more comments, however he did not get much done due to the fact that he was busy that day.

1/21/19
There was a problem with the placeMines method. Minjun figured out that there was a problem with the placeMines method. The problem with it was that the xcor and the ycor randomization was outside of the loop, making it so that the same random x and y coordinate that went in the loop. Also, the Tile class was changed with Tile. This was because there was only one tile.

# A couple of things that we wished we knew before the project

:How to branch and merging. Learning that process took a lot of time. and definitely did not work out great.

:How to plan the class structures nicely. I feel like our class structure was poorly designed. We ended up changing it up multiple times to get it.

:Not to cram! As you can see the README comments get larger as it approaches a significant date, although we were busy, maybe we both could have worked on it slowly and maturely.

Thank you for playing our game!!
