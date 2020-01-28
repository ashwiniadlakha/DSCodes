
public class Solution {


    public static void main(String a[]){
        int arr[] = { 2, 4, 6, 8, 16 };
        int n = arr.length;
        System.out.println(generalizedGCD(n, arr));
    }

    static public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i = 1; i < num; i++){
            result = gcd(arr[i], result);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
