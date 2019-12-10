package Algorithms;

/**
 * https://www.hackerrank.com/challenges/bomber-man/problem
 */
public class BomberMan {

    // Complete the BomberMan function below.
    static String[] bomb(int n, String[] grid) {


        String bomb = "O";
        String field = ".";

        //generate a full bomb grid
        String[] gridFullBomb = new String[grid.length];
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid[i].length();j++){
                sb.append(bomb);
            }
            gridFullBomb[i] = sb.toString();
        }

        String[] gridAfterBomb3s = getGridAfterBomb(gridFullBomb,grid);
        System.out.println("*****************************");
        String[] gridAfterBomb5s = getGridAfterBomb(gridFullBomb,gridAfterBomb3s);


        if(n==1) return grid;
        if(n%4==1) return gridAfterBomb5s;
        if(n%4==2) return gridFullBomb;
        if(n%4==3) return gridAfterBomb3s;
        if(n%4==0) return gridFullBomb;

        return grid;
    }

    public static String replaceTarget(String str,int pos,String value){
        StringBuilder sb = new StringBuilder(str);
        sb.replace(pos,pos+1,value);
        return sb.toString();
    }

    public static String[] getGridAfterBomb(String[] baseGrid, String[] bombGrid){

        String bomb = "O";
        String field = ".";

        String[] gridAfterBomb = baseGrid.clone();
        for(int i=0;i<bombGrid.length;i++){
            for(int j=0;j<bombGrid[i].length();j++){

                String temp = bombGrid[i].substring(j,j+1);
                if(temp.equals(bomb)){

                    StringBuilder sb = new StringBuilder(gridAfterBomb[i]);
                    sb.replace(j,j+1,field);
                    gridAfterBomb[i]=sb.toString();

                    //up , row++
                    int next_r=i-1;
                    if(next_r>=0){
                        sb = new StringBuilder(gridAfterBomb[next_r]);
                        gridAfterBomb[next_r]= sb.replace(j,j+1,field).toString();
                    }

                    //down , row--
                    next_r=i+1;
                    if(next_r<baseGrid.length){
                        sb = new StringBuilder(gridAfterBomb[next_r]);
                        gridAfterBomb[next_r]= sb.replace(j,j+1,field).toString();
                    }

                    //left , col--
                    int next_c=j-1;
                    if(next_c>=0){
                        sb = new StringBuilder(gridAfterBomb[i]);
                        gridAfterBomb[i]= sb.replace(j-1,j,field).toString();
                    }

                    //right , col++
                    if(j+1<gridAfterBomb[i].length()){
                        sb = new StringBuilder(gridAfterBomb[i]);
                        gridAfterBomb[i]= sb.replace(j+1,j+2,field).toString();
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int c=0;c<gridAfterBomb.length;c++){
            System.out.println(gridAfterBomb[c]);
        }

        return gridAfterBomb;
    }


}
