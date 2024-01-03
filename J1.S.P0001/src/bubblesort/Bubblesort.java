package bubblesort;
import java.util.Scanner;
import java.util.Random;
public class Bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Enter number of array:");
        int choose = sc.nextInt();
        int[] arr = new int[choose];
        System.out.print("Unsorted array: [");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
            if(i == arr.length - 1) System.out.println(arr[i] + "]");
            else System.out.print(arr[i] + ", ");
        }
        //bubblesort
        boolean check = false;
        while(check == false){
            int count = 0;
            for (int i = 0; i < arr.length -1; i++){
                if(arr[i] > arr[i+1]){
                    int tam = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tam;
                    count++;
                }
            }
            if(count > 0) check = false;
            else check = true;
        }
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) System.out.print(arr[i] + "]");
            else System.out.print(arr[i] + ", ");
        }
    }
}