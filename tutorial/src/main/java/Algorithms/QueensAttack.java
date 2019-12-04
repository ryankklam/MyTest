package Algorithms;

import java.util.*;

/**
    https://www.hackerrank.com/challenges/queens-attack-2/problem
*/
public class QueensAttack {

    // Complete the QueensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        List<int []> obstaclesList = new ArrayList<int []>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesList.add(new int[] {obstacles[i][0]-1,obstacles[i][1]-1});
        }

        int availablePos = 0;

        boolean checkNext =true;

        //up , row++
        int next_r=r_q-1;
        int next_c=c_q-1;
        while(checkNext){
            next_r++;
            int[] temp = new int[]{next_r,next_c};
            if(next_r>=n || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))) {
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //down , row--
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_r--;
            int[] temp = new int[]{next_r,next_c};
            if(next_r<0 || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //right , col++
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_c++;
            int[] temp = new int[]{next_r,next_c};
            if(next_c>=n || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //left , col--
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_c--;
            int[] temp = new int[]{next_r,next_c};
            if(next_c<0 || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //left up , row-- , col++
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_r--;
            next_c++;
            int[] temp = new int[]{next_r,next_c};
            if(next_c>=n || next_r<0 ||obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //left down , row-- , col--
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_r--;
            next_c--;
            int[] temp = new int[]{next_r,next_c};
            if(next_c<0 || next_r < 0 ||obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //right up , row++ , col++
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_r++;
            next_c++;
            int[] temp = new int[]{next_r,next_c};
            if(next_c >=n || next_r >= n || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        //right up , row++ , col--
        next_r=r_q-1;
        next_c=c_q-1;
        checkNext = true;//reset loop indicator
        while(checkNext){
            next_r++;
            next_c--;
            int[] temp = new int[]{next_r,next_c};
            if(next_c<0 || next_r >= n || obstaclesList.stream().anyMatch(t -> Arrays.equals(t,temp))){
                checkNext = false;
            }else {
                availablePos++;
                System.out.println(String.valueOf(next_r) + " " + String.valueOf(next_c));
            }
        }

        return availablePos;
    }
}
