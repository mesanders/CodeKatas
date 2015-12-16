#CODE KATA Game of Life
	Authors: 	Justin Boundy 	Mike Sanders
	Date: 		12/3/2015

## NOTE TO PEOPLE WHO MAY READ SAID CODE
We did not use an external testing framework? Why? Because we like pain. But really it's because we wanted to be as lightweight as possible and grow. We will need to update the build script to be more robust in the compilation. But for now, we are just going to start simple and work our way up. Also, this is our first time using ant. Such fun

## Problem Description

This Kata is about calculating the next generation of Conway's game of life, given any starting position. See http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life for background.

You start with a two dimensional grid of cells, where each cell is either alive or dead. In this version of the problme, the grid is finite, and no life can exist off the edges. When calculating the next generation of the grid. Follow these rules:

1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation
2. Any live cell with more than three live neighbors diees as if overcrowding
3. Any live cell with two or three live neighbors lives on to the next generation.
4. Any dead cell with exactly three live neighbors becomes a live cell.


##Project contents
The lib directory contains the few external libraries used in the project. 

Two default files: default_ingest.txt and second_ingest.txt that are used to test Conway Game of Life. 

1. kata.gameoflife.ConwayGameOfLife is a  main method that prints the game to the main server. You can run the console from ant: "ant run_console"
2. kata.gameoflife.SimpleServer starts a Server that serves a websocket. The server launches to localhost:8080 by default. The index.html has a lightweight javascript app that opens a webservice to ConwayGameOfLifeSocket. Which sends messages to the client WebSocket. You can run the server from ant: "ant run_server" 

## Additions: 
Added two libraries to the project: javax servlets and jetty-all.jar... The only reason, is because we wanted a very lightweight web framwework without implementing our own in Java SE. Tried it, but it would be too cumbersome. Jetty without Jersey really isn't too bad, and creating lightweight servlets for REST API is not too bad either.

Created a default javascript file that can handle webserver methods. Once we get more information we can update the index.html.

? Why wouldn't we just write everything in JavaScript? Well, because we want to learn multiple stacks and do some katas. Will be fun.
