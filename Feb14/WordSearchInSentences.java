package Feb14;

public class WordSearchInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Data structures and algorithms are important.",
            "Linear search is simple but not always efficient."
        };

        String word = "java";
        String result = findSentenceWithWord(sentences, word);

        System.out.println("Sentence containing the word: " + result);
    }
}
