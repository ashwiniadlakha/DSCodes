import java.util.Arrays;
import java.util.List;

public class BinarySearch {


    public static void main(String[] a) {
        int ar[] = {2, 4, 6, 8, 9, 20, 27, 35};
        int index = binarySearch(ar, 0, ar.length, 10);
        System.out.println("index of searched : " + index + " value : " + ar[index]);
    }


    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        int[] previousStates = states.clone();

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < states.length; j++) {
                computeNewState(j, states, previousStates);
            }
            previousStates = states.clone();
        }
        return Arrays.asList( Arrays.stream(states) // IntStream
                .boxed()				// Stream<Integer>
                .toArray(Integer[]::new));
    }

    private void computeNewState(int j, int[] states, int[] previousStates) {

        if(j==0) {
            states[j] = previousStates[j+1];
        }else if(j==states.length -1){
            states[j] = previousStates[j-1];
        }else{
            if(previousStates[j+1] == previousStates[j-1]){
                states[j] = 0;
            }else{
                states[j] = 1;
            }
        }

    }

    private static int binarySearch(int[] ar, int min, int max, int value) {


        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (ar[mid] == value) {
                return mid;
            } else {
                if (ar[mid] > value) {
                    return binarySearch(ar, min, mid - 1, value);
                } else {
                    return binarySearch(ar, mid + 1, max, value);
                }
            }
        }
    }
}
