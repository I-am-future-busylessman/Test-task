public class Task2 {

    public static void main(String[] args) {
        System.out.println(sumOfNumbers(192837465));
    }

    public static long sumOfNumbers(long num) {
        if (num < 0){
            num = num * -1;
        }
        if (num < 10) {
            return num;
        }
        return num % 10 + sumOfNumbers(num / 10);
    }
}
