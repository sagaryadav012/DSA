package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class WordLadder_LC127 {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> setWordList = new HashSet<>(wordList);
        if(!setWordList.contains(endWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;
            List<String> adjacentWords = getAdjacentWords(word, setWordList);
            for (String adjacentWord : adjacentWords) {
                if(adjacentWord.equals(endWord)) return level + 1;
                queue.add(new Pair(adjacentWord, level + 1));
            }
        }
        return 0;
    }
    public static List<String> getAdjacentWords(String word, Set<String> setWordList){
        int n = word.length();
        List<String> adjacentWords = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] c = word.toCharArray();
            for(int j = 0; j < 26; j++){
                c[i] = (char)(j+'a');
                String generatedWord = new String(c);
                if(setWordList.contains(generatedWord)){
                    adjacentWords.add(generatedWord);
                    setWordList.remove(generatedWord);
                }
            }
        }
        return adjacentWords;
    }
}
class Pair{
    String word;
    int level;

    public Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
/*
-> Find the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
-> Start from beginWord, check each possible word, then check that word exists in wordList.
-> For each word replace each character with a to z, then check that string exists in wordList.
-> To compare all strings with list it takes lot of time. so, add all words to set to minimize time complexity
   when compare strings.
-> This can be solved by BFS since travelling level by level. In BFS we use visited array to do not visit node
   again and again. Here to make sure to not visit word again and again remove the word from set once it visited.
-> TC - O(N * N * 26) -> (wordList.lenght * word[i].length * 26)
 */