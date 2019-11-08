package chess.model;

public class Testdata {

    public static String gameStateFullJson = "{\n"
            + "\n"
            + "    \"type\": \"gameFull\",\n"
            + "    \"id\": \"NCCbuaQM\",\n"
            + "    \"rated\": true,\n"
            + "    \"variant\": \n"
            + "\n"
            + "{\n"
            + "\n"
            + "    \"key\": \"standard\",\n"
            + "    \"name\": \"Standard\",\n"
            + "    \"short\": \"Std\"\n"
            + "\n"
            + "},\n"
            + "\"clock\": \n"
            + "{\n"
            + "\n"
            + "    \"initial\": 1200000,\n"
            + "    \"increment\": 10000\n"
            + "\n"
            + "},\n"
            + "\"speed\": \"classical\",\n"
            + "\"perf\": \n"
            + "{\n"
            + "\n"
            + "    \"name\": \"Classical\"\n"
            + "\n"
            + "},\n"
            + "\"createdAt\": 1523825103562,\n"
            + "\"white\": \n"
            + "{\n"
            + "\n"
            + "    \"id\": \"lovlas\",\n"
            + "    \"name\": \"lovlas\",\n"
            + "    \"provisional\": false,\n"
            + "    \"rating\": 2500,\n"
            + "    \"title\": \"IM\"\n"
            + "\n"
            + "},\n"
            + "\"black\": \n"
            + "{\n"
            + "\n"
            + "    \"id\": \"leela\",\n"
            + "    \"name\": \"leela\",\n"
            + "    \"rating\": 2390,\n"
            + "    \"title\": null\n"
            + "\n"
            + "},\n"
            + "\"initialFen\": \"startpos\",\n"
            + "\"state\": \n"
            + "\n"
            + "    {\n"
            + "        \"type\": \"gameState\",\n"
            + "        \"moves\": \"e2e4 c7c5 f2f4 d7d6 g1f3 b8c6 f1c4 g8f6 d2d3"
            + " g7g6 e1g1 f8g7\",\n"
            + "        \"wtime\": 7598040,\n"
            + "        \"btime\": 8395220,\n"
            + "        \"winc\": 10000,\n"
            + "        \"binc\": 10000\n"
            + "    }\n"
            + "\n"
            + "}";
    public static String gameStateJson = "{\n"
            + "\n"
            + "    \"type\": \"gameState\",\n"
            + "    \"moves\": \"e2e4 c7c5 f2f4 d7d6 g1f3 b8c6 f1c4 g8f6 d2d3 g7g6"
            + " e1g1 f8g7 b1c3\",\n"
            + "    \"wtime\": 7598040,\n"
            + "    \"btime\": 8395220,\n"
            + "    \"winc\": 10000,\n"
            + "    \"binc\": 10000\n"
            + "\n"
            + "}";

    public static String gameStateJsonShort = "{\"id\":\"NCCbuaQM\","
            + "\"variant\":{\"key\":\"standard\",\"name\":\"Standard\","
            + "\"short\":\"Std\"},\"clock\":null,\"speed\":\"correspondence\","
            + "\"perf\":{\"name\":\"Correspondence\"},\"rated\":false,"
            + "\"createdAt\":1568371854075,\"white\":{\"id\":\"samsai\","
            + "\"name\":\"samsai\",\"title\":\"BOT\",\"rating\":1500,"
            + "\"provisional\":true},\"black\":{\"aiLevel\":1},"
            + "\"initialFen\":\"startpos\",\"type\":\"gameFull\","
            + "\"state\":{\"type\":\"gameState\",\"moves\":\"\","
            + "\"wtime\":2147483647,\"btime\":2147483647,"
            + "\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}}";

    public static String profileJson = "{\n"
            + "\n"
            + "    \"id\": \"leela\",\n"
            + "    \"username\": \"leela\",\n"
            + "    \"title\": \"NM\",\n"
            + "    \"online\": true,\n"
            + "    \"playing\": true,\n"
            + "    \"streaming\": false,\n"
            + "    \"createdAt\": 1290415680000,\n"
            + "    \"seenAt\": 1522636452014,\n"
            + "    \"profile\": \n"
            + "\n"
            + "{\n"
            + "\n"
            + "    \"bio\": \"Free bugs!\",\n"
            + "    \"country\": \"EC\",\n"
            + "    \"firstName\": \"Thibault\",\n"
            + "    \"lastName\": \"Duplessis\",\n"
            + "    \"links\": \"github.com/ornicar\\r\\ntwitter.com/ornicar\",\n"
            + "    \"location\": \"On the road\"\n"
            + "\n"
            + "},\n"
            + "\"nbFollowers\": 2735,\n"
            + "\"nbFollowing\": 299,\n"
            + "\"completionRate\": 97,\n"
            + "\"language\": \"en-GB\",\n"
            + "\"count\": \n"
            + "{\n"
            + "\n"
            + "    \"ai\": 531,\n"
            + "    \"all\": 9265,\n"
            + "    \"bookmark\": 71,\n"
            + "    \"draw\": 340,\n"
            + "    \"drawH\": 331,\n"
            + "    \"import\": 66,\n"
            + "    \"loss\": 4480,\n"
            + "    \"lossH\": 4207,\n"
            + "    \"me\": 0,\n"
            + "    \"playing\": 6,\n"
            + "    \"rated\": 7157,\n"
            + "    \"win\": 4440,\n"
            + "    \"winH\": 4378\n"
            + "\n"
            + "},\n"
            + "\"perfs\": \n"
            + "{\n"
            + "\n"
            + "    \"blitz\": \n"
            + "\n"
            + "{},\n"
            + "\"bullet\": \n"
            + "{},\n"
            + "\"chess960\": \n"
            + "{},\n"
            + "\"puzzle\": \n"
            + "\n"
            + "    {}\n"
            + "\n"
            + "},\n"
            + "\"patron\": true,\n"
            + "\"disabled\": false,\n"
            + "\"engine\": false,\n"
            + "\"booster\": false,\n"
            + "\"playTime\": \n"
            + "\n"
            + "    {\n"
            + "        \"total\": 3296897,\n"
            + "        \"tv\": 12134\n"
            + "    }\n"
            + "\n"
            + "}";
    
    public static String gameStartJSON = "{\"type\":\"gameStart\","
            + "\"game\":{\"id\":\"NCCbuaQM\"}}";

    /*
    Player id: leela Lichess AI level 8
     */
    public static String[] testGameJSON = {
        "{\"id\":\"NCCbuaQM\",\"variant\":{\"key\":\"standard\",\"name\":\"Standard\",\"short\":\"Std\"},\"clock\":null,\"speed\":\"correspondence\",\"perf\":{\"name\":\"Correspondence\"},\"rated\":false,\"createdAt\":1569232053391,\"white\":{\"aiLevel\":8},\"black\":{\"id\":\"leela\",\"name\":\"leela\",\"title\":\"BOT\",\"rating\":1500,\"provisional\":true},\"initialFen\":\"startpos\",\"type\":\"gameFull\",\"state\":{\"type\":\"gameState\",\"moves\":\"e2e4\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5 f1b5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5 f1b5 d8d7\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5 f1b5 d8d7 b5d7\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5 f1b5 d8d7 b5d7 e8d7\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5 e4d5 c7c5 b1c3 b7b5 f1b5 d8d7 b5d7 e8d7 g1f3\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n"};

    /*
    Player id: testUser1 Lichess AI level 8, stops after 1 computer move for "notmyturn" testing
     */
    public static String[] testGameJSONStops = {
        "{\"id\":\"NCCbuaQM\",\"variant\":{\"key\":\"standard\",\"name\":\"Standard\",\"short\":\"Std\"},\"clock\":null,\"speed\":\"correspondence\",\"perf\":{\"name\":\"Correspondence\"},\"rated\":false,\"createdAt\":1569232053391,\"white\":{\"aiLevel\":8},\"black\":{\"id\":\"testiUser1\",\"name\":\"ohtukayttaja1\",\"title\":\"BOT\",\"rating\":1500,\"provisional\":true},\"initialFen\":\"startpos\",\"type\":\"gameFull\",\"state\":{\"type\":\"gameState\",\"moves\":\"e2e4\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}}\n",
        "{\"type\":\"gameState\",\"moves\":\"e2e4 d7d5\",\"wtime\":2147483647,\"btime\":2147483647,\"winc\":0,\"binc\":0,\"bdraw\":false,\"wdraw\":false}\n"};

    public static String[] gameNotStartedJSON = {"{\"type\":\"challenge\",\"challenge\":{\"id\":\"7pGLxJ4F\",\"status\":\"created\",\"challenger\":{\"id\":\"lovlas\",\"name\":\"Lovlas\",\"title\":\"IM\",\"rating\":2506,\"patron\":true,\"online\":true,\"lag\":24},\"destUser\":{\"id\":\"thibot\",\"name\":\"thibot\",\"title\":null,\"rating\":1500,\"provisional\":true,\"online\":true,\"lag\":45},\"variant\":{\"key\":\"standard\",\"name\":\"Standard\",\"short\":\"Std\"},\"rated\":true,\"timeControl\":{\"type\":\"clock\",\"limit\":300,\"increment\":25,\"show\":\"5+25\"},\"color\":\"random\",\"perf\":{\"icon\":\"#\",\"name\":\"Rapid\"}}}"};
}
