package Algorithms;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 */
public class BFSShortReach {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

        //n:the number of nodes
        //m:edges in the graph
        //edges: a 2D array of start and end nodes for edges
        //s: the node to start traversals from

        Map<Integer,List> graph = new HashMap<Integer,List>();

        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];

            if(graph.get(Integer.valueOf(from))==null){
                List temp  = new ArrayList();
                temp.add(to);
                graph.put(from,temp);
            }else {
                graph.get(Integer.valueOf(from)).add(to);
            }
        }

        LinkedList graphList = new LinkedList();
        graphList.offer(s);

        int[] result= new int[n];

        Set checkedSet = new HashSet();
        boolean nextLevel = true;
        LinkedList nextLevelList = new LinkedList();
        nextLevelList.offer(s);

        int step=-1;
        while(!graphList.isEmpty()){
            step++;
            int node = (int)graphList.poll();

            //skip checked node
            if(checkedSet.contains(node)) continue;



            addNodesToList(graphList,graph.getOrDefault(node,new ArrayList()));

            result[node-1] = step*6;

            checkedSet.add(node);
        }

        //rearrange the last result , remove 0 , and s element
        int[] finalResult = new int[n-1];
        for(int i=0;i<n;i++){
            if(i>s){
                finalResult[i-1] = result[i];
            }else {
                finalResult[i] = result[i];
            }
        }
        return finalResult;
    }

    public static void addNodesToList(LinkedList graphList,List tempList){
        for(int i=0;i<tempList.size();i++){
            graphList.offer(tempList.get(i));//Adds the specified element as the tail (last element) of this list.
        }
    }
}
