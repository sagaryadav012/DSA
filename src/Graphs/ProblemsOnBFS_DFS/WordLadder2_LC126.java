package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class WordLadder2_LC126 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();

        Set<String> setWordList = new HashSet<>(wordList);
        if(!setWordList.contains(endWord)) return ladders;

        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        ladders.add(ladder);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String word = queue.poll();
                List<String> adjacentWords = getAdjacentWords(word, setWordList);
//            int size = adjacentWords.size();
//            if(ladders.size() < size){
//                ladders.add(new ArrayList<>(ladder.get(size-1)));
//            }
//            for (String adjacentWord : adjacentWords) {
//                if(adjacentWord.equals(endWord)) return ladders;
//                queue.add(adjacentWord);
//            }

                if(ladders.size() < adjacentWords.size()){
                    int n = ladders.size();
                    int diff = adjacentWords.size() - ladders.size();
                    while(diff > 0){
                        ladders.add(new ArrayList<>(ladders.get(n-1)));
                        diff = -1;
                    }
                }
                for(int i = 0; i < adjacentWords.size(); i++){
                    ladders.get(i).add(adjacentWords.get(i));
                    queue.add(adjacentWords.get(i));
                }
                size--;
            }
        }
        return ladders;
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
    }}
