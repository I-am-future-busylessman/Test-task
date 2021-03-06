import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    private int sumOfArray(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum = sum + i;
        }
        return sum;
    }

    private int sumOfList(ArrayList<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum = sum + i;
        }
        return sum;
    }

    private int findBiggest(List<ArrayList<Integer>> list) {
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (sumOfList(list.get(i)) > sumOfList(list.get(index))) {
                index = i;
            }
        }
        return index;
    }

    private int findSmallest(List<ArrayList<Integer>> list) {
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (sumOfList(list.get(i)) < sumOfList(list.get(index))) {
                index = i;
            }
        }
        return index;
    }

    private List<ArrayList<Integer>> findBalanced(List<ArrayList<Integer>> list, int requiredSum) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> a:list) {
            if (sumOfList(a) == requiredSum) {
                result.add(a);
            }
        }
        list.removeIf(a->sumOfList(a) == requiredSum);
        return result;
    }

    private int findNearestNum(ArrayList<Integer> forBalance, int requiredSum) {
        int excess = 0;
        for (int num : forBalance) {
            if (sumOfList(forBalance) - num >= requiredSum && num > excess)
                excess = num;
        }
        return excess;
    }

    private void balance(List<ArrayList<Integer>> groups, int requiredSum) {
        ArrayList<Integer> biggest = groups.get(findBiggest(groups));
        ArrayList<Integer> smallest = groups.get(findSmallest(groups));
        int nearestNum = findNearestNum(biggest, requiredSum);
        biggest.remove((Object)nearestNum);
        smallest.add(nearestNum);
    }

    private boolean isAbleToBalance ( int[] nums, int amount) {
        return !(sumOfArray(nums) % amount != 0 || nums.length < amount);
    }

    private boolean stillAbleToBalance(List<ArrayList<Integer>> groups, int requiredSum) {
        ArrayList<Integer> biggest = groups.get(findBiggest(groups));
        return findNearestNum(biggest, requiredSum) != 0;
    }

    public void divideInGroups(int[] nums, int amount) {
        Arrays.sort(nums);
        if (!isAbleToBalance(nums, amount)) {
            System.out.println("???????????????????? ?????????????????? ???? ?????????????????? ???????????????????? ??????????");
        } else {
            int requiredSum = sumOfArray(nums) / amount;
            List<ArrayList<Integer>> groups = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                groups.add(new ArrayList<>());
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                groups.get(i % amount).add(nums[i]);
            }
            List<ArrayList<Integer>> result = findBalanced(groups, requiredSum);
            while (groups.size() > 0 && stillAbleToBalance(groups, requiredSum)) {
                balance(groups, requiredSum);
                result.addAll(findBalanced(groups, requiredSum));
            }
            if (groups.size() > 0) {
                System.out.println("???????????????????? ?????????????????? ???? ?????????????????? ???????????????????? ??????????");

            }else {
                System.out.println("?? ???????????????????? ???????????????????? ???????????????????? ?????????????????? ????????????:");
                for (ArrayList<Integer> list : result) {
                    System.out.println(list.toString());
                }
            }
        }
    }
}

