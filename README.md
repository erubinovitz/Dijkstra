# Dijkstra's Algorithm


## Introduction

This class takes an input from a text file named "in1.txt" of the number of problems to solve. Then, for each problem:

  - size of the graph matrix, aka number of nodes in the graph

  - starting node

  - ending node

  - cost matrix

The class then outputs the minimum cost, along with the assosciated path.

## Running the program

The code for this project is in Java and can be run on any Java IDE such as Netbeans or Eclipse.

The input file is to be located in the class folder.

## Testing

Consider the following testcase of two problems:

2

7

0	5

0	2	0	1	0	0	0

0	0	0	3	10	0	0

4	0	0	0	0	5	0

0	0	2	0	2	8	4	

0	0	0	0	0	0	6

0	0	0	0	0	0	0

0	0	0	0	0	1	0

5

0	2

0	10 0	5	0

0	0	1	2	0

0	0	0	0	4

0	3	9	0 2

7	0	6	0	0


The output of this input should be the following:

6

0 -> 3 -> 6 -> 5

9

0 -> 3 -> 1 -> 2



## Authors:

**Evan Rubinovitz**

## Acknowledgements:

**Professor Shebuti Rayana**
