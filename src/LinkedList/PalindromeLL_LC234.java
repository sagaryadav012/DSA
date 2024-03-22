package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromeLL_LC234 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,2,1,5,7,5,3,8,9,0,6,5,9,6,9,2,1,3,0,8,8,4,8,9,0,3,5,6,8,9,0,1,3,2,1,0,9,8,6,5,3,0,9,8,4,8,8,0,3,1,2,9,6,9,5,6,0,9,8,3,5,7,5,1,2,2,1);
        ListNode head = ListNode.construct(nums);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
      //  System.out.println(nums.get(24));

    }

    // This approach will not work as mul can store max 10^9, but size of LL can 10^5 that leads mul to 1^10^5
    public static boolean isPalindrome(ListNode head) {
        int num = 0;
        int rev = 0;
        int mul = 1;
        ListNode curr = head;
        while(curr != null){
            num =  num * 10 + curr.val;
            rev = curr.val * mul + rev;
            mul *= 10;
            curr = curr.next;
        }
        return num == rev;
    }
    public static boolean isPalindrome1(ListNode head){
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            nums.add(curr.val);
            curr = curr.next;
        }
        int size = nums.size();
        int len = size - 1;
        for(int i = 0; i < size/2; i++){
            if(!nums.get(i).equals(nums.get(len--))) return false;
        }
        return true;
    }
    public static boolean isPalindrome2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode curr1 = prev;
        curr = head;
        while(curr1 != null){
            if(curr.val != curr1.val) return false;
            curr = curr.next;
            curr1 = curr1.next;
        }
        return true;
    }
}
/*
-> Can do this copy values to array and perform palindrome operation.
 */
