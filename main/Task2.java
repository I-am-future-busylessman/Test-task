public class Task2 {
    public long sumOfNumbers(long num) {
        if (num < 0){
            num = num * -1;
        }
        if (num < 10) {
            return num;
        }
        return num % 10 + sumOfNumbers(num / 10);
    }
}
