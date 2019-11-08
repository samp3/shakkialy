# Architecture documentation

This document describes the architecture of this project template and gives a general overview of
each part of the software and about how these parts interact with each other.

The project package hierarchy is as follows:

- chess
    - App.java
- chess.bot
    - ChessBot.java
    - TestBot.java
- chess.engine
    - GameState.java
- chess.connection
    - HTTPIO.java
    - HTTPIOFactory.java
    - HTTPStream.java
    - HTTPStreamFactory.java
    - LichessAPI.java
    - XBoardHandler.java
- chess.model
    - Event.java
    - EventType.java
    - Profile.java 
    - Side.java
- datastructureproject
    - PerformanceTest.java
- logging
    - Logger.java 

![Class diagram](https://raw.githubusercontent.com/TiraLabra/chess/architecture-docs/documentation/pics/Architecture.png)

## Top level package (chess.*)

The top level package contains the code that initializes the Chess bot and connects to
either XBoard or Lichess.org for playing.

### App.java

The App.java class contains the program entry-point and is responsible for reading in
commandline arguments and initializing the rest of the program. App.java is also
where the desired Chess bot should be initialized and submitted to the LichessAPI
or the XBoardHandler.

## Bot package (chess.bot.*)

This package contains classes and intefaces relevant to defining bots.

### ChessBot.java

ChessBot.java contains the Java interface for defining chess bots. LichessAPI and XBoardHandler
both accept Java objects that implement this interface.

For Data Structures and Algorithms project this interface is the central point of focus, since
it represents how the bot will talk with the selected chess communication layer (LichessAPI or XBoardHandler).
In order to make your own bots, your bot's class should implement the interface and then override the 
getNextMove() function. The TestBot.java class contains an example implementation, which picks random moves.

The getNextMove() function takes in a GameState.java object which has been initialized by the chess
communication layer with the current state of the game. The function must return either a String containing a valid
chess move in [the UCI format](https://en.wikipedia.org/wiki/Universal_Chess_Interface) or null if
the bot cannot find a legitimate move or wants to forfeit the game.

### TestBot.java

TestBot.java is an implementation of the ChessBot interface and is used for testing the APIs.
It also serves as an example implementation of a simple Chess bot.

The TestBot does not contain its own Chess logic, but instead uses the chesslib library to
pick a random move in a given game state. This also means that the TestBot generally plays
very poorly.

**Data Structures and Algorithms projects may not use chesslib in this manner.**

## Chess engine and gamestate package (chess.engine.*)

The engine package deals with the state of a Chess game.

### GameState.java

The GameState class tracks the moves, turn count and amount of time left on the players.
The Chess bots determine their actions based on this data.

The GameState stores the game state mainly as a list of moves in UCI format. A full board state
can be constructed from these moves.

## Connection package (chess.connection.*)

The connection package provides the communication layers for connecting to Chess games, either locally
or over the Internet. The communication layers provide constructors and functions that accept ChessBot
objects and connect to the relevant Chess platform for playing.

### LichessAPI.java

LichessAPI class is an implementation of a subset of the Lichess.org HTTP API and allows playing Chess over
the Internet. The API only implements the bare essentials that allow Chess bots to play games.

**In order to use the LichessAPI, a Lichess Token needs to be first generated. Refer to [the Beginner's Guide](https://github.com/TiraLabra/chess/blob/architecture-docs/documentation/Beginners_guide.md)
for instructions.**

The LichessAPI provides a constructor that takes a ChessBot as an argument. After constructing a LichessAPI
object, you can call the beginEventLoop() method, which will cause the API to query events from Lichess.org
and start accepting and playing challenges.

### XBoardHandler.java

The XBoardHandler class provides a communication layer with the XBoard Chess program. It communicates to
a local instance of XBoard via a String pipe.

To use the XBoardHandler, you need to create an XBoardHandler object and supply the constructor with a
ChessBot and a BufferedReader over the standard input. You can then call the run() method on the
XBoardHandler object to begin playing.

When using the XBoardHandler, XBoard will be configured to execute the program and XBoard will be
executed, instead of running the program independently.

## Models (chess.model.*)

The models package contains a number of data types for modeling data in the connection layers and GameState.

**These models are irrelevant to the Data Structures and Algorithms project.**

### Event.java

Represents a Lichess.org event. Indicates either a received challenge or a game start.
Also provides access to the event ID and a function to parse Events from JSON.

### EventType.java

Enum associated with the Event.java class.

### Profile.java

Represents a Lichess.org profile. Stores the profile ID and nickname.
Also contains a function to parse the profile from JSON.

### Side.java

Simple enum for representing the sides of a Chess game (WHITE and BLACK).

### Project package (datastructureproject.*)

This package is set up to be the initial location for your code. Ultimately, where you choose to write your code is completely up to you, as long as it is clearly separated from this project template. 

## PerformanceTest.java

This class provides a basic setup for performance testing. See [Documentation for testing](https://github.com/TiraLabra/chess/blob/master/documentation/testing.md).

## Logging package (logging.*)

The logging package provides access to a Logger class for writing log messages to standard output or log files.
### Logger.java

The Logger class provides a simple way to log messages and errors to standard output or a file.

The Logger uses a builder pattern for configuring and has methods for configuring the functionality of the logger. The useStdOut() and useLogFile() enable logging to standard output and to a log file respectively. The alternatePath() method allows defining an alternative path for the log file. If a log file already exists, the messages will be appended to the end of the that file.

Messages can be logged using the logMessage() function and errors can be logged using logError().
A timestamp will be included along with the given message.
