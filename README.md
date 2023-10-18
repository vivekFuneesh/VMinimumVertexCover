# VMinimumVertexCover [Phase 1 complete]  
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


# For anyone willing to go for further analysis :-

<b>So far whatever progress been made till var4 and 5, is there in implementation of var3 (var5 is commented) and for further progress and research, visualisation can be done to check exact properties of graph nodes that are being selected at a particular point and doing comparison with available results to determine those exact properties of nodes selected.</b><br/><br>

<b>But this will take much more time & efforts, so pausing it's development any further.</b><br><br>

<b>Result of var4 is giving 4/5 extra nodes per 200-500 vertices for hardest graph examples of DIMACS and BHOSLIB</b><br><br>

<b>Further optimizations can be done in implementation of variation 3/4/5</b><br>

Time Complexity for variation1 of algorithm:    
    
       Best Case : O(nlogn), where n is no. of vertices    
       Worst Case : O(n^2 logn)    
      
  For variation1 :    
    
	 worst case time is Sum(x log x), for x = [V, 1]; 
	 			= O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
	 			= O ( (V^2) * (log V) ) 
	 Best Case = O (V log V)    
    
For variation2 :    
    
    worst case time is V* Sum(x log x + c log x), for x = [V, 1] and c <= x at any time;
 			  = V* O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
 			  = O ( (V^3) * (log V) ) 
    Best Case = O (V^2 log V)    


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
	if same number of lowest degree neighbours then select anyone.
        Put (X) into required-set     
        Update degrees of connected nodes by -1    
    END :    

    Note:- To check max lowest connected ones, modify d.s. s.t.    
    Heap will have data for keeping count of occurrence of    
    a particular degree nodes. Should be achievable using    
    hasp map just like reference inside heap is tracked in 2nd variation in O(1).    

	--------------------    
 ----------------    
    But if one wish to go 4th variation which is to check lowest     
    degrees of all, then it might go to O(n^3 log n)...    
    
    eg. node N1 has 2 connects with degree {1,2}, node N2 has    
    3 connects with degree{1,2,3}, node N3 has 3 connects with    
    degree {1,1} then we will select N3 first because after 1    
    the lowest degree is 1 again which is lower than others    
    having 2 and if there was no N3, then we will select N2    
    because even though both N1 and N2 have same lower degrees    
    connect for 1st 2 neighbours but N2 has 3rd neighbour too    
    which will yield a state of graph having lesser edges.   

    Similarly, if N1 has 1 degree connects in quantity X,    
    N2 has 1 degree connects un quantity Y s.t. X > Y then    
    we will select N1 using 2nd variation. And if X == Y then    
    we will use above formula recursively for the next lower    
    degree connects.
        
    So, preference is :- 1st preference to lowest degree    
    neighbour, 2nd to maximum number of neighbours, if both    
    are same then select anyone cause at some point either should    
    lead the graph to a same structural state via same number of steps.    

	The same concept which is working in above 3 variations.    


As for the time being I don't have habit, intent, knowledge of proving this via equations so, lastly to say :-    
These variations are not alternatives rather these are s.t. the chances of "success" or "proof of correctness" is var4 > var3 > var2> var1.    
But my observation says that var1 is the minimal required condition to create a minimum vertex cover and var2 is adding 1 more condition, then var3 introducing 1 condition on top of var2 and so does var4.    


A glimpse  -:-  
        
    Var1 :- Select any node having lowest degree connected node OR
	 select parent(Pi) of any lowest degree node(Ni).    

    Var2 :- Select that parent(Pi) of all such lowest degree nodes(Cn Candidate nodes) which    
    has maximum number of neighbours.    

    Var3 :- Select that parent(Pi) of all such lowest degree nodes(Cn) which    
    has maximum number of lowest degree neighbours among all parents(P) of   
    such nodes(Cn), if more than one such parent then select anyone.    
        
    Var4 :- Select that parent(Pi) of all such lowest degree nodes(Cn) which has    
    all the neighbours of lowest degrees among all parents(P), if 2 or    
    more nodes have same such state then select the    
    one having maximum number of neighbours, if this is also same then    
    select any.
	
	 In a way, var4 puts maximum choice on top of lowest connected state of graph
	 
This can also be seen as -:-  
        
    At any point of time, select that state of graph which will either take    
    out the maximum possible leaf nodes or will yield maximum possible    
    lowest degree nodes.    
    And this graph state selection is done by choosing only one node to be removed.    
    


Apart from above solution, one extended class 5 (variation 5) solution is -:-    
    
    When variation 4 has multiple candidate nodes, s.t. Ci, Cj and Ck    
    have same set of degree string (N1M1xN2M2xN3M3..xNtMt),    
    where x is the separator, N1 is the lowest degree, N2 is the 2nd lowest degree,..    
    Nt is the t-th lowest degree of total t neighbours of and C and    
    M1, M2.. Mt is the number of such connected-degree nodes for those    
    candidates then    

         Select that candidate which is not directly connected to any    
	 of the other candidate nodes.    
  
	 That final selected node might contribute to 4th dimension    
         because that is the disjoint candidate from other candidates    
	 and can be treated as external perspective for which all other    
         joint-nodes are same.. just like how 2D plane is same from 3rd    
	 dimensional eye.    

This class 5 is the final solution that this author @vivek can give as of now for this minimum vertex cover game.

Final Update: after testing, var3, var4, var5 .. all algorithms FAIL for DIMACS and BHOSLIB graphs.. these were tested on few of them like test-cases number 20 and 22.    
    
<br><b>Here FAIL means that these variations are giving slightly more (by 4-5 per 200-500 vertices) number of minimum-vertex-cover-set than the one cited on website of DIMACS and BHOSLIB.</b><br><br>

<b>This also means that these are giving nearby optimal solutions involving particular targets with logical reasons instead of selecting any node blindly among possible candidate nodes! ..  <i>difference b/w this and other mvc (minimum vertex cover) algorithms out there on internet & research-papers</i>!!</b><br><br>

