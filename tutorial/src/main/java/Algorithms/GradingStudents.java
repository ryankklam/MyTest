package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
public class GradingStudents {

    // Complete the gradingStudents function below.
    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < grades.size(); i++) {
            Integer t = grades.get(i);

            if (t < 38) {
                result.add(i, t);
                continue;
            }

            int odd = t%5 > 0 ? 1 :0;
            int mod = (t /5+odd) *5 - t;
            if (mod < 3) {
                result.add(i, t + mod);
            } else {
                result.add(i, t);
            }

        }

        return result;
    }
}
