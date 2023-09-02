# VMinimumVertexCover [DRAFTED-VERSION] [TESTING-ONGOING]
#                              Copyright (C) 2023 Vivek Mangla
 To solve minimum vertex cover problem in minimal time complexity
 
       VMinimumVertexCover : Finds a minimum vertex cover for a given graph with exact algorithm in minimal time complexity.
                                 Copyright (C) 2023 Vivek Mangla
       This program is free software: you can redistribute it and/or modify
       it under the terms of the GNU General Public License as published by
       the Free Software Foundation, either version 3 of the License, or
       (at your option) any later version.
       This program is distributed in the hope that it will be useful,
       but WITHOUT ANY WARRANTY; without even the implied warranty of
       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
       GNU General Public License for more details.
       You should have received a copy of the GNU General Public License
       along with this program. If not, see https://www.gnu.org/licenses/.
       Contact me at vivek.funeesh@gmail.com for queries


Time Complexity for both variations of algorithm:    
    
       Best Case : O(nlogn), where n is no. of vertices    
       Worst Case : O(n^2 logn)    
      
  For variation1 :    
    
	 worst case time is Sum(x log x), for x = [V, 1]; 
	 			= O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
	 			= O ( (V^2) * (log V) ) 
	 Best Case = O (V log V)    
    
For variation2 :    
    
    worst case time is Sum(x log x + c log x), for x = [V, 1] and c <= x at any time;
 			  = O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
 			  = O ( (V^2) * (log V) ) 
    Best Case = O (V log V)    


Algo for variation 1:    

    for a particular state of graph,    
    select a node (N) with minimum degree (total = in + out )    
    if { node has 0 degree -> remove it and discard it -or- put into not-required set. }
    else {    
      select the parent/neighbour (P) of that node    
      update degree of all neighbours of P    
      remove P from Main-Set and put into required-set    
    }
    
    

Algo for variation 2:    

    for a particular state of graph,    
    select a node (N) with minimum degree (total = in + out )    
    if { node has 0 degree -> discard it -or- put into not-required set. }
    else {    
      for all such candidate nodes C from the graph having same degree as N    
        { select parent/neighbour (P) of any C with maximum degree }    
      update degree of all neighbours of P    
      remove P from Main-Set and put into required-set    
    }
    
  
Both of these variations work on basic principle that, select that node whose child is either a leaf or by removing that node we go 1 or more steps closer to obtaining a leaf node by selecting the node-to-remove only from the neighbours of lowest degree node.    
    
`
Variation 1 says :- I can select any such neighbour of the lowest degree node because in every upcoming step, that particular node will become leaf first.    
`    
    `
Variation 2 says :- Let's select that parent/neighbour of lowest degree ones which has maximum connections to render the graph state into less cycles.    
`    
    
Understanding till now, variation 2 might remove edges faster but it should give same info as variation 1.    

There is another variation, i.e. variation 3 for which it's even more complex but let's stick to these 2 for initial testing because for 3rd variation implementation, a new & more complex data structure will have to be designed. Just like d.s. for variation 2 is complex than for variation 1.    


  Algo for variation 3:    

    for a particular state of graph,    
    select a node (N) with minimum degree (total = in + out )    
    if { node has 0 degree -> discard it -or- put into not-required set. }
    else {    
      for all such candidate nodes C from the graph having same degree as N    
        { select that parent/neighbour (P) of any C by removing which (P) 	
	      we get maximum number of leaf nodes or a state of graph to yield maximum leaf nodes				 
        }    
      update degree of all neighbours of P    
      remove P from Main-Set and put into required-set    
    }    
    
In other way,    
    
    START :    
        select node (X) with maximum number of lowest degree connected nodes    
        Put (X) into required-set     
        Update degrees of connected nodes by -1    
    END :    

    Note:- To check max lowest connected ones, modify d.s. s.t.    
    Heap will have data for keeping count of occurrence of    
    a particular degree nodes. Should be achievable using    
    hasp map just like reference inside heap is tracked in 2nd variation in O(1).
