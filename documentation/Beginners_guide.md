# Beginner's guide for chess bot setup

This template provides two ways for your bots to interact with other bots or players. You can either play online on [Lichess](https://lichess.org) chess server or you can play locally using the [XBoard](https://www.gnu.org/software/xboard/) program.

Below you can find the instructions to configure your project to work with either of these options.

## Forking the project

To begin working on the project, you need to clone the Git repository to your own computer.

    $ git clone https://github.com/TiraLabra/chess.git

You can then create your own GitHub repository but remember to create it without a README file.
Then you can push the template to your GitHub repository with the following commands:

    $ git remote rename origin old-origin 
    $ git remote add origin https://github.com/<YourUserName>/<YourRepositoryName>
    $ git push -u origin master

Remember to replace the README.md file with your own information. You can now begin to make your own changes to the program.

## Enabling Travis CI and Codecov

The project comes with a pre-configured .travis.yml file. This means that if you have registered to Travis CI continuous integration service with your GitHub account, Travis should start automatically when you build your project. By default, Travis should also ask
Codecov.io to generate test coverage reports.

## Playing on Lichess

The following minimum actions are necessary to run the Tiralabra chess bot app with the Lichess.org application program interface (API). See [Lichess API](https://lichess.org/api) for the full API Reference. 

By no means, this guideline will not replace the API Reference. We hope that this guideline will save your valuable time when getting started.

1. Download, clone or pull the app from *git@<span></span>github.com:TiraLabra/chess.git* into your /chess folder or other suitable location.

2. Register to [Lichess](https://lichess.org/signup). Here, you need to agree to the four given points.

**Note:** If you have played even a single game as a human player and now want to try playing as a bot, you will have to DELETE your [token](https://lichess.org/account/oauth/token) and also close your account to register it as a bot.

3. Create [New personal API access token](https://lichess.org/account/oauth/token/create) and choose all the scopes.

**Note:** Never put your personal token on github or other public files.

**Note:** if you copy your access token to a Word document (or another similar text processing document), and from there to your chess bot program, a hidden character may be added in the end of your token. If your token does not work, check with backspace if a hidden character was added.

4. Upgrade your account to a bot:

    $ curl -d '' https<span></span>://lichess.org/api/bot/account/upgrade -H "Authorization: Bearer INSERT YOUR TOKEN HERE"

5. Select your way to pass your token to the Tiralabra chess bot. 

    a) you can pass token as a commandline parameter or
    
    b) you can supply the token via the LICHESS_TOKEN environment variable

6. Now you can try the Tiralabra chess bot. One possible way to start the bot: after login, select “PLAY WITH THE COMPUTER” at https<span></span>://lichess.org/. 
Then choose which pieces you want to play. Finally, at the command line, type 
    *$ ./gradlew build*, 
then if you inserted your token as environment variable:
    *./gradlew run --args="--lichess"* 
or, if you didn't, 
    *./gradlew run --args="--lichess --token=put_token_here"* .

7. Your chess bot will start playig with random moves, that is, very poorly. Your task is now to create a real A.I. bot!

**Note:** By default, program keeps running as it waits for new challenges from Lichess. To close the program use CTRL+C.


## XBoard Setup

XBoard is a graphical user interface chessboard for chess engines. Xboard can be connected to your tira chess engine.

1. Download the tar.gz file of the latest stable version of [XBoard](https://www.gnu.org/software/xboard/#download)

Uncompress it, for example, under the same directory where the chess directory is.

    $ tar xvzf xboard-4.9.0.tar.gz

2. Start XBoard:

    $ xboard

3. Make sure that you have a jar file for your engine:

    $ ./gradlew build

4. Under Engine tab, select Edit Engine List..

5. Add the path of the chess engine's jar file in the list

    "tira-chess" -fcp "java -jar /home/local/ ..your path.. /chess/build/libs/chess-all.jar"

You can replace "tira-chess" with any unique name.
Then click 'commit changes' and 'OK'.

6. Under Engine tab, select Load New 1st Engine..

Just select your engine from the list and click 'OK'.

7. Make your first move (as white) and your engine should respond with its move.

You can also select 'Machine White' under the Mode tab. In this case, your engine will play white pieces and make its move first.

With the "Two Machines" mode, you can also get two bots playing against each other.

**Note:** How to start a new XBoard game after one has ended? First under Edit, select New Game. Then just select the Mode.

**Note:** When developing your AI engine, you may want to modify the way how XBoard communicates with your chess engine. The [Chess Engine Communication Protocol](https://www.gnu.org/software/xboard/engine-intf.html) has the details.




