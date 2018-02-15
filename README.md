# Conway's Game of Life

Originally I programmed this as a code test for a job I did not end up getting, but I enjoyed coding it and thought that the code was rather well written and as such feel confident in adding it to my git portfolio. Please feel free to use it as you see fit.

## Build Instructions

In order to build and run my software, first you need to compile it. 

To compile it on a unix system, navigate to the folder where you unzipped to, and run: javac -cp "lib/*" -d ./bin ./src/*.java

Once this is complete, you can play the game by running: java -cp ./bin/ GameOfLife

In order to run the jUnit tests, simply run: java -cp ./lib/junit-4.8.jar:./bin org.junit.runner.JUnitCore CellTest BoardTest
