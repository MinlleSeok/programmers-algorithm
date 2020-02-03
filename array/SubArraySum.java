/*package whatever //do not write package name here */
package array;

import java.util.*;
import java.lang.*;
import java.io.*;

class SubArraySum {
	public static void main (String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = scan.nextInt();
        // List<int[]> queue = new ArrayList<>();
        // List<int[]> list = new ArrayList<>();

		// input cycle
		for(int i = 0; i < num; i++) {
            // String[] a_array = a.split(" ");
            int a1 = scan.nextInt();
            int a2 = scan.nextInt();
            int[] array_set = new int[]{a1, a2};

            // String b = br.readLine();
            // StringTokenizer b = new StringTokenizer(br.readLine());
            // String[] arr = b.split(" ");
            
            int[] int_arr = new int[a1];

            for(int j = 0; j < int_arr.length; j++) {
                int_arr[j] = scan.nextInt(); // Integer.parseInt(b.nextToken().trim());
            }

            // list.add(int_arr);

            int[] result = new int[]{-1, -1};
            // int size = 0;

            // while(!queue.isEmpty()) {
                int[] a = array_set; // queue.get(0);
                // queue.remove(0);
                int[] arr = int_arr; // list.get(0);
                // list.remove(0);
                int sum = 0;
                int left = 0;
                int right = 0;

                while (right < arr.length) {
                    while (sum < a[1] && right < arr.length) {
                        sum += arr[right++];
                    }
                    while (sum > a[1]) {
                        sum -= arr[left++];
                    }
                    if(sum == a[1]) {
                        result = new int[]{left + 1, right};
                        break;
                    }
                }
                // if(result[size][0] == 0 && result[size][1] == 0) {
                //     result[size] = new int[]{-1, -1};
                // }

                String abc = result[1] > -1 ? result[0] + " " + result[1] : result[0] + "";
                System.out.println(abc);
                
            }
            
            
        // }

        scan.close();
		
		//code
		
		// int [][] result = new int[num][2];
       
    }
    
    // public static void main (String[] args) {
    //     Scanner scan = new Scanner(System.in);
    //     int testCount = scan.nextInt();

    //     for(int t=0; t<testCount; t++){
    //         int arraySize = scan.nextInt();
    //         int sum = scan.nextInt();
    //         int[] array = new int[arraySize];
    //         for(int k=0; k<arraySize; k++)
    //             array[k] = scan.nextInt();   
    //         getPosition(sum, array);
    //     }
	// }
	
	// public static void getPosition(int sum, int[] array){
	//     int count = 0;
	//     Boolean flag = false;

    //     for (int i=0; i<array.length; i++){
    //         if(flag)
    //             break;
    //         count = array[i];
    //         if(count == sum){
    //                 System.out.println(++i + " " + i);
    //                 flag=true;
    //                 break;
    //             }
            
    //         for(int j=i+1; j<array.length; j++){
    //             count += array[j];

    //             if(count == sum){
    //                 System.out.println(++i + " " + ++j);
    //                 flag=true;
    //                 break;
    //             }
    //             if(count > sum){
    //                 break;
    //             }
    //         }
    //     }
    //     if(!flag){
    //         System.out.println("-1");
    //     }
	// } 
}