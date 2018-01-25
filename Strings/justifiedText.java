// https://www.interviewbit.com/problems/justified-text/


public class Solution {
public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> rtn = new ArrayList<String>();
        if (A.size() == 0 || B < 1) return rtn;

        int numOfWords = A.size();
        int currPointer = 0;
        int testPointer = 0;
        while (currPointer < numOfWords) {
                int lineLength = -1;
                testPointer = currPointer;
                while (testPointer < numOfWords) {
                        int testSize = A.get(testPointer).length() + 1;
                        if (lineLength + testSize <= B) lineLength += testSize;
                        else break;
                        testPointer++;
                }

                String line = "";
                String spaceLine = "";
                int spacesInLine = testPointer - currPointer - 1;
                int regSpace = 1;
                int extraSpace = 0;
                if (spacesInLine > 0 && testPointer != numOfWords) {
                        extraSpace = B - lineLength;
                        regSpace += extraSpace / spacesInLine;
                        extraSpace %= spacesInLine;
                        for (int i = 0; i < regSpace; i++) spaceLine += " ";
                }

                while (currPointer < testPointer) {
                        line += A.get(currPointer++);
                        if (currPointer != testPointer) {
                                if (testPointer == numOfWords) line += " ";
                                else line += spaceLine;
                                if (extraSpace-- > 0) line += " ";
                        }
                }
                while (line.length() != B) line += " ";
                rtn.add(line);
        }
        return rtn;
}
}
