
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author Evan Rubinovitz
 */

/*This class takes an input from a text file of:

-number of problems to solve. Then, for each problem:
-size of the graph matrix, aka number of nodes in the graph
-starting node
-ending node
-cost matrix

The class then outputs the minimum cost, along with the assosciated path.
*/

public class Djikstra {
    /*Gets user input and calls helper method*/
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(new File("in1.txt"));
        int cases = sc.nextInt();
        for (int k=0; k<cases; k++){
            int size = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            int[][] nums = new int[size][size];
            for (int i=0;i<size; i++){
                for (int j=0; j<size; j++){
                    nums[i][j]=sc.nextInt();
                }
            }        
            computeDijkstra(nums, start, end);
        }
    }
        catch (IOException e){
            e.printStackTrace();
        }
          
    }
    
    /* Creates necessary info (visited array, costs array) and then finds 
    the minimum costs from all calculated costs, then prints the 
    minimum cost and assosciated path.
    */
    public static void computeDijkstra(int[][] nums, int start, int end){
        boolean[][] visited = new boolean[nums.length][nums.length];
        for (int i=0; i<nums.length; i++){
            
            visited[i][start]=true;
        }
        int[] costs = new int[(int)Math.pow(nums.length,2)];
        String[] paths = new String[(int)(Math.pow(nums.length,2))];
        for (int i=0; i<paths.length; i++)
            paths[i]="";
        /*Call computation method*/
        int[] arr= computeDijkstra(nums, start, end, visited, new int[nums.length],1, costs,paths);
        int minCost=Integer.MAX_VALUE;
        int minCostIndex=0;
        for (int i=0; i<costs.length; i++){
            if (costs[i]<minCost&&costs[i]!=0){
                minCost = costs[i];
                minCostIndex=i;
            }
        }
        
       try {
           System.out.println(minCost);
           int c=5;
           paths[minCostIndex]=paths[minCostIndex].substring(paths[minCostIndex].indexOf(">")+2,paths[minCostIndex].length()-1);
           paths[minCostIndex]=start+" -> " +paths[minCostIndex].substring(0,paths[minCostIndex].length()-3);
           if (paths[minCostIndex].substring(paths[minCostIndex].lastIndexOf(">")+2,paths[minCostIndex].length()).equals(Integer.toString(end))){
               c=0;
           }
            System.out.print(start+" -> " +paths[minCostIndex].substring( paths[minCostIndex].indexOf(">")+2,paths[minCostIndex].length()-c));
       }
       catch (Exception e){
           System.out.println("The path cannot be reached.");
       }
        
        System.out.println();
    }
    
    /*Computes all costs and associated paths*/
    public static int[] computeDijkstra(int[][] nums, int current, int end, boolean visited[][], int[] arr,int step, int[] costs, String[] paths){
        if (current==end){ 
            for (int i=0; i<costs.length; i++){
                if (costs[i]==0){
                    costs[i]=arr[0];                    
                    for (int j=0; j<arr.length; j++){
                        paths[i]+=arr[j]+" -> ";
                        if (j==arr.length-1||arr[j]==arr[j+1]) break;
                    }
                    break;                   
                }               
            }
            return arr;
        }
            for (int i=0; i<nums[current].length; i++){
                if (nums[current][i]>0&&!visited[current][i]){
                    arr[0]+=nums[current][i];
                    visited[current][i]=true;
                    visited[i][current]=true;
                    arr[step]=i;
                    
                    arr=computeDijkstra(nums,i,end,visited,arr,step+1,costs,paths);
                    arr[0]-=nums[current][i];
                    visited[current][i]=false;
                    visited[i][current]=false;
                    arr[step]=0;
                }
            }
            return arr;        
    }
}
