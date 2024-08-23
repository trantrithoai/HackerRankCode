import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    private static final long modValue = (long)Math.pow(10,9)+7;
     public static int legoBlocks(int n, int m) {
     // Write your code here
         // If the wall is only 1 block high, only a
         // single block would be a solid wall
         if (n==1){
             if(m<5){
                 return 1;
             } else {
                 return 0;
             }
         }
         /* Number of single row configurations of width i
          * We know the first 5 array elements are:
          * rowConfigs[0] = 0 (no way to build row of width 0)
          * rowConfigs[1] = 1 (1 way to build row of width 1: [1])
          * rowConfigs[2] = 2 (2 ways to build row of width 2: [1,1], [2])
          * rowConfigs[3] = 4 (4 ways to build row of width 3: [1,1,1], 
          *                   [2,1], [1,2], [3])
          * rowConfigs[4] = 8 (8 ways to build row of width 4: [1,1,1,1], 
          *                   [2,1,1], [1,2,1], [1,1,2], [2,2], [4], [3,1], 
          *                   [1,3])
          */
         long rowConfigs[] = new long[m+1];
         rowConfigs[0] = 0;
         for (int i=1; i<(m+1);i++){
             if(i<5){
                 rowConfigs[i] = (long)Math.pow(2,i-1);
             } else {
                 /* For each row configuration >= 5 in width, the row can
                  * only end in either a block of width 1, 2, 3 or 4, leaving
                  * a subproblem of i-1, i-2, i-3 and i-4 respectively. Thus,
                  * all of the possible row configurations at that width is
                  * the sum of all those subproblems.
                  */
                  rowConfigs[i] = rowConfigs[i-1]+rowConfigs[i-2]+rowConfigs[i-3]+rowConfigs[i-4];
                  rowConfigs[i] = rowConfigs[i]%modValue;
             }
         }
         /* All wall permutations of height j and width i regardless of solidity
          * allWalls[i] = rowConfigs[i]^j because each row is independent
          */
         long allWalls[] = new long[m+1];
         for(int i=1; i<(m+1);i++){
             allWalls[i] = 1;
             for(int j=1; j<(n+1);j++){
                 allWalls[i] = allWalls[i]*rowConfigs[i]%modValue;
             }
         }
         /*
          * Good (solid) wall permutations, goodWalls[i], of height n and width i 
          * where there is no vertical break across all rows of bricks
          * Start to calculate goodWalls[i] with all wall permutations regardless
          * of solidity, allWalls[i], and subtract the bad wall permutations, 
          * badWalls[i], which contains at least 1 vertical break across all rows 
          * of bricks.
          * badWalls[i] is calculated by considering the following:
          * For each possible break in the wall into left and right sides of width
          * j and i-j respectively, we compute the permutations to build a solid wall
          * on the left (i.e. this is the first possible break from the left) and any
          * wall on the right. badWalls[i] is all the ways to build a non-solid wall
          * of width i so we need to take the sum of all the permutations of left 
          * (good) and right (any) walls where 1<=j<i
          * Thus, goodWalls[i]=allWalls[i]-badWalls[i]; and
          * badWalls[i]=sum(goodWalls[j]*anyWalls(i-j) for 1<=j<i)
          */
          long goodWalls[] = new long[m+1];
          goodWalls[1]=1; // A wall of width 1 and height n has only 1 permutation     
          long badWalls[] = new long[m+1];
          badWalls[1]=0;  // and it's good
          for(int i=2; i<(m+1); i++){
              badWalls[i]=0; // Initialize to 0
              for(int j=1; j<i; j++){
                  badWalls[i]=badWalls[i]+(goodWalls[j]*allWalls[i-j]);
                  badWalls[i]=badWalls[i]%modValue;
              }
              goodWalls[i]=(allWalls[i]-badWalls[i]+modValue)%modValue;
          }
          return (int)goodWalls[m];
     }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
