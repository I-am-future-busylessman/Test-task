import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i ++) {
            array[9 -i] = i;
        }
        find_three_max(array);
    }

    public static void find_three_max(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Arrays.sort(arrayCopy);
        System.out.printf("max nums: %d %d %d\n", arrayCopy[array.length - 1], arrayCopy[array.length - 2], arrayCopy[array.length - 3]);
    }
}
