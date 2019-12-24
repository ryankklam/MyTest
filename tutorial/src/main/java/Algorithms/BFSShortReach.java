package Algorithms;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 */
public class BFSShortReach {
    
    static LinkedList[] adjency;
    static int[] depth;
    static boolean[] visited;

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

        //n:the number of nodes
        //m:edges in the graph
        //edges: a 2D array of start and end nodes for edges
        //s: the node to start traversals from

        //initial adjency map
        depth = new int[n+1];
        visited = new boolean[n+1];
        adjency = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            adjency[i] = new LinkedList<Integer>();
        }

        //fill edges to node adjency map
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];

            adjency[from].add(to);
            adjency[to].add(from);
        }

        //
        Queue nodeQueue = new LinkedList<>();
        nodeQueue.add(s);
        visited[s] = true;
        depth[s] = 0;

        while(!nodeQueue.isEmpty()){
           int parent = (int) nodeQueue.poll();
           int parentSize = adjency[parent].size();
           for(int i=0;i<parentSize;i++){//can't use adjency[parent].size() for loop as each time poll the size got changed
               int node = (int) adjency[parent].poll();

               if(!visited[node]){
                   depth[node] =   depth[parent] +6;
                   visited[node] = true;
                   nodeQueue.add(node);
               }
           }
        }

        //rearrange the last result , remove 0 , and s element
        int[] finalResult = new int[n-1];
        for(int i=0;i<n-1;i++){
            if(i>=s-1){
                finalResult[i] = depth[i+2]==0 ? -1:depth[i+2];
            }else {
                finalResult[i] = depth[i+1]==0 ? -1:depth[i+1];
            }
        }
        return finalResult;


//        Map<Integer,List> graph = new HashMap<Integer,List>();
//
//        for(int i=0;i<edges.length;i++){
//            int from = edges[i][0];
//            int to = edges[i][1];
//
//            if(graph.get(Integer.valueOf(from))==null) {
//                List temp = new ArrayList();
//                graph.put(from, temp);
//            }
//            graph.get(Integer.valueOf(from)).add(to);
//
//            if(graph.get(Integer.valueOf(to))==null) {
//                List temp = new ArrayList();
//                graph.put(to, temp);
//            }
//            graph.get(Integer.valueOf(to)).add(from);
//        }
//
//        LinkedList graphList = new LinkedList();
//        graphList.offer(s);
//
//        int[] result= new int[n];
//
//        Set checkedSet = new HashSet();
//        boolean toNextLevel = true;
//        LinkedList nextLevelList = new LinkedList();
//
//        int step=-1;
//        while(!graphList.isEmpty()){
//
//            int node = (int)graphList.poll();
//
//            if(toNextLevel) {
//                step++;
//                toNextLevel=false;
//            }
//
//            //skip checked node
//            if(checkedSet.contains(node)) continue;
//
////            addNodesToList(graphList,graph.getOrDefault(node,new ArrayList()));
//            nextLevelList.addAll(graph.getOrDefault(node,new ArrayList()));
//
//            result[node-1] = step*6 ==0 ? -1: step*6;
//
//            checkedSet.add(node);
//
//            if(graphList.isEmpty()){
//                graphList.addAll(nextLevelList);
//                nextLevelList.clear();
//                toNextLevel = true;
//            }
//        }
//
//        //rearrange the last result , remove 0 , and s element
//        int[] finalResult = new int[n-1];
//        for(int i=0;i<finalResult.length;i++){
//            if(i>=s-1){
//                finalResult[i] = result[i+1]==0 ? -1:result[i+1];
//            }else {
//                finalResult[i] = result[i]==0 ? -1:result[i];
//            }
//        }
//        return finalResult;
    }
}
