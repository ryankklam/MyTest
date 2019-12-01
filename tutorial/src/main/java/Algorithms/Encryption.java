package Algorithms;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {

        s = s.replaceAll(" ", "");//trim all the blanks
        int count = (int) Math.sqrt(s.length());//2

        int rowCount = count;
        int colunmCount = count;
        int matrix = rowCount * colunmCount;

        while(s.length()>matrix){
            int temp = rowCount;
            rowCount = colunmCount;
            colunmCount = temp+1;
            matrix = rowCount * colunmCount;
        }

        String[][] lineArray = new String[rowCount][colunmCount];//[2][3]
        int index = 0;


        while (index < matrix) {
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colunmCount; j++) {
                    if (index < s.length()) {
                        lineArray[i][j] = s.substring(index, index + 1);
                    } else {
                        lineArray[i][j] = "";
                    }
                    index++;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int c=0;c<colunmCount;c++){
            for(int r=0;r<rowCount;r++){
                str.append(lineArray[r][c]);
            }
            str.append(" ");
        }
        System.out.println(str.toString());
        return str.toString();
    }

}
