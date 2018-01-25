// https://www.interviewbit.com/problems/substring-concatenation/

public class Solution {

public static int[] findSubstring(String A, final String[] B) {
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        int sizeOfWord = B[0].length();
        int sizeOfSubString = sizeOfWord * B.length;

        HashMap<String, Integer> original = new HashMap<String, Integer>();
        for (int i = 0; i < B.length; i++) {
                if (original.containsKey(B[i])) {
                        original.put(B[i], original.get(B[i]) + 1);
                } else {
                        original.put(B[i], 1);
                }
        }

        for (int i = 0; i <= A.length() - sizeOfSubString; i++) {
                HashMap<String, Integer> frequency = new HashMap<String, Integer>(original);
                int startPointer = i;
                int endPointer = i + sizeOfWord;
                while (endPointer <= i + sizeOfSubString) {
                        String word = A.substring(startPointer, endPointer);
                        if (frequency.containsKey(word) && frequency.get(word) > 0) {
                                frequency.put(word, frequency.get(word) - 1);
                        } else {
                                break;
                        }
                        if (endPointer == i + sizeOfSubString) {
                                rtn.add(i);
                        }
                        startPointer += sizeOfWord;
                        endPointer += sizeOfWord;
                }
        }

        int[] starts = new int [rtn.size()];
        for (int i = 0; i < starts.length; i++) {
                starts[i] = rtn.get(i);
        }
        return starts;
}

}
