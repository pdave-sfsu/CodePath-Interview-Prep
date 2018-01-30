
/*
 * Complete the function below.
 */
static String firstRepeatedWord(String s) {
        s = s.substring(0, s.length() - 1);
        String[] words = s.split(" ");
        HashSet<String> contains = new HashSet<String>();

        for (String word: words) {
                if (word.length() == 0)
                        continue;

                if (!Character.isLetter(word.charAt(word.length() - 1)))
                        word = word.substring(0, word.length() - 1);

                if (contains.contains(word))
                        return word;
                else
                        contains.add(word);
        }
        return "";
}



/*
 * Complete the function below.
 */
static String firstRepeatedWord(String s) {
        String[] words = s.split("\\s+");
        HashSet<String> contains = new HashSet<String>();

        for (String word: words) {
                if (contains.contains(word))
                        return word;
                else
                        contains.add(word);
        }
        return "";
}
