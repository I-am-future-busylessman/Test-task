import java.util.Arrays;

public class Task1 {
    public  void find_three_max(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Arrays.sort(arrayCopy);
        System.out.printf("max nums: %d %d %d\n", arrayCopy[array.length - 1], arrayCopy[array.length - 2], arrayCopy[array.length - 3]);
    }
}
