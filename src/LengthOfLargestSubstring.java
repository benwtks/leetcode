import java.util.Scanner;

/* Given a string, find the length of the longest substring without repeating characters.
   https://leetcode.com/problems/longest-substring-without-repeating-characters/ */

public class LengthOfLargestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] sArray = scanner.nextLine().toCharArray();

        int subsetStart = 0;
        int currentSubsetSize = 0;
        int biggestSubsetSize = 0;

        for (int i = 0; i < sArray.length; i++) {
            for (int j = subsetStart; j < i; j++) {
                if (sArray[i] == sArray[j]) {
                    biggestSubsetSize = Math.max(currentSubsetSize, biggestSubsetSize);
                    currentSubsetSize -= (j - subsetStart) + 1;
                    subsetStart = j + 1;
                    break;
                }
            }

            currentSubsetSize++;
        }

        biggestSubsetSize = Math.max(currentSubsetSize, biggestSubsetSize);
        System.out.println(biggestSubsetSize);
    }
}
