package QueueAndStacks.LeetCodeMSC;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder_LC950 {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing1(deck)));
        System.out.println(Arrays.toString(deckRevealedIncreasing2(deck)));
    }
    public static int[] deckRevealedIncreasing1(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(deck[n-1]);

        for(int i = n-2; i >= 0; i--){
            int back = deque.removeLast();
            deque.addFirst(back);
            deque.addFirst(deck[i]);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = deque.removeFirst();
        }
        return ans;
    }
    public static int[] deckRevealedIncreasing2(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            deque.add(i);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[deque.removeFirst()] = deck[i];
            if(!deque.isEmpty()) deque.addLast(deque.removeFirst());
        }
        return ans;
    }
}

/*

Approach 1 :
Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
-> We have follow above steps until deck gets empty
-> Ex : [17,13,11,2,3,5,7] We have to order deck to get them in increasing order by following above steps.
   Correct order is = 2,13,3,11,5,17,7
   Lets check it :
   Take answer array : int[n]

          deck                   answer array
          3,11,5,17,7,13         2
          5,17,7,13,11           2,3
          7,13,11,17             2,3,5
          11,17,13               2,3,5,7
          13,17                  2,3,5,7,11
          17                     2,3,4,5,7,11,13
          empty                  2,3,5,7,11,13,17

        answer is in increasing order so taken order is correct that gives answer in increasing order

-> So we have to find order of given deck. Here we reveal top, add to array, remove it and remove next one and add at last.
-> We do it in reverse order to simulate same steps. first we remove end, add at front and now add current element from answer array.
-> We get answer array in increasing order. result array is [2,3,5,7,11,13,17], Take p pointer points to n-1 of result array

    step1: remove end, add at front and add current of result array.

        Ordered array           result array
        empty                   2,3,5,7,11,13,17
        17                      2,3,5,7,11,13
        13,17                   2,3,5,7,11        -> Remove 17, add at front and add current of result array at front.
        11,17,13                2,3,5,7
        7,13,11,17              2,3,5
        5,17,7,13,11            2,3
        3,11,5,17,7,13          2
        2,13,3,11,5,17,7 -> This is order that we pass, so we get ans in increasing order.
 */