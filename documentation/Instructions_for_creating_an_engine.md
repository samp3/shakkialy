## What does the template handle?

The template handles communication between your chess engine and either Lichess or XBoard. Instructions for setting up these functionalities can be found
[here](https://github.com/TiraLabra/chess/blob/master/documentation/Beginners_guide.md).

## What does the template not handle?

The template does not provide the rules of chess, those are left for you to handle. The TestBot class uses a library that provides these, but **these are not intended to be used by a student for the project.**

## What does your engine need to do?

Your bot should be an implementation of the ChessBot interface. This means it needs to have an implementation of the method ```String nextMove(GameState gamestate)``` which receives a gamestate instance and requires your bot to output Universal Chess Interface (UCI) formatted String representations of moves, when prompted. In this format, a move is simply the starting square followed by the destination square, for example ```e2e4```.

A notable exception to this move format are promotion moves, which have an additional 5th character representing which piece a pawn is promoted to, for example ```e7e8Q```. An example of how to handle this action can be found in the TestBot class.

Additionally, your bot should be able to keep track of the boardstate so that it can make valid moves. The GameState class keeps track of all of the moves made in the game so far with an ArrayList. You can get the latest move with the method ```getLatestMove()``` and use it to update your own Board, however you choose to implement it. This is all your bot really
needs to do to be able to use the template. 

### What else can your engine do?

The GameState class also keeps track of time (in milliseconds) remaining for each player, as provided by either Lichess or XBoard. This can be accessed with the methods ```getRemainingTime()``` and ```getRemainingTimeOpponent()```. This is not strictly required for writing a bot, but might be useful. 

### Where to write your code

Where you choose to write your code is of course up to you, but our intent is that you will use the ```datastructureproject``` package for all of your code, so that it is clearly separated from the template itself. Thus you will not use the ``TestBot.java `` class in the ``chess.bot `` package.

## IMPORTANT NOTICE!

**You need to place your own chessbot implementation to ``ChessBot bot `` variable located in the ``App.java `` class.**
**Don't change the name of the variable or anything else in ``App.java``to ensure the program stays operational.**
**One exception: you will need to import the ```datastructureproject``` package to ``App.java ``.**