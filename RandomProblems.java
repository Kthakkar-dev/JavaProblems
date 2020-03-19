import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomProblems {

    public static void main(String args[]) {
        int[] groupSizes = new int[]{4, 4, 4, 4};
        //System.out.println(groupThePeople(groupSizes));
        //System.out.println(isUnique("kaant"));
        //System.out.println(numOfStepsToZero(14));
        int[] input = {3, 4, 2, 3};
        //printArray(smallerNumbersThanCurrent(input));
        //System.out.println(checkPossibility(input));
        //System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
        System.out.println(replaceSpace("Hello World "));
        //System.out.println(replaceSpace("H W K"));


    }



    /**
     * Given a string this method replaces space in a given string with '%20'
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        int spaces = 0;
        //Get total number of spaces
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                spaces++;
        }

        char[] resultChrArray = new char[s.length() + spaces * 2];
        // Find spaces and then replace them with '%20'
        for (int i = 0, j = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                resultChrArray[j] = '%';
                resultChrArray[j + 1] = '2';
                resultChrArray[j + 2] = '0';
                j = j + 3;

            } else {
                resultChrArray[j] = s.charAt(i);
                j++;
            }
        }

        return new String(resultChrArray);
    }

    /**
     * This method checks if two strings are anagram or not.
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");
        char[] c1 = s1.toLowerCase().toCharArray();
        char[] c2 = s2.toLowerCase().toCharArray();
        System.out.print(c1);
        System.out.println("");

        Arrays.sort(c1);

        System.out.println("After Sort");
        System.out.println(c1);
        Arrays.sort(c2);

        String s_1 = new String(c1);
        String s_2 = new String(c2);

        if (s_1.equals(s_2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];           //modify nums[i-1] of a priority
                else nums[i] = nums[i - 1];                                                //have to modify nums[i]
            }
        }
        return cnt <= 1;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

//    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
//
//        List<List<Integer>> solutionList = new ArrayList<>();
//
//        int[] peopleId = new int[groupSizes.length];
//        List<Integer> g1 = new ArrayList<Integer>();
//
//        for (int i = 0; i < groupSizes.length; i++) {
//            if (groupSizes[0] == groupSizes.length) {
//                g1.add(i);
//            } else {
//                // if varying size.
//            }
//        }
//
//        solutionList.add(g1);
//        return solutionList;
//    }

    /**
     * This method checks if all the character in a given string are unique;
     * @param s
     * @return
     */
    public static boolean isUnique(String s) {
        boolean[] charset = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charset[val]) return false;
            charset[val] = true;
        }
        return true;
    }



    /**
     * This method finds number of steps to get to zero.
     * See https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     * @param num
     * @return Number of steps in integer.
     */
    public static int numOfStepsToZero(int num) {
        int steps = 0;
        while (num != 0) {
            steps++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
        }

        return steps;
    }

    /**
     * This method find total number of smaller number than current number.
     * See https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smallerNum = new int[nums.length];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[j] < nums[i]) {
                    counter++;
                }
                smallerNum[i] = counter;
            }
        }
        return smallerNum;
    }
}
