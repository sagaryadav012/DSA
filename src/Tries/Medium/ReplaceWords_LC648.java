package Tries.Medium;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords_LC648 {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        Triee trie = new Triee();
        for(String root : dictionary){
            trie.insert(root);
        }

        String[] derivatives = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String derivative : derivatives){
            String root = trie.getRoot(derivative);
            sb.append(root+" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
class Triee{
    Triee[] children;
    boolean endOfWord;
    Triee(){
        this.children = new Triee[26];
        this.endOfWord = false;
    }

    public void insert(String word){
        Triee curr = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Triee();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }
    public String getRoot(String derivative){
        Triee curr = this;
        StringBuilder sb = new StringBuilder();

        for(char c : derivative.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return derivative;
            }
            sb.append(c);
            if(curr.children[index].endOfWord) return sb.toString();
            curr = curr.children[index];
        }
        return sb.toString();
    }
}
