package QueueAndStacks.LeetCodeMSC;

public class StudentsUnableToEat_LC1700 {
    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
    }
    // TC - O(N) SC - O(1)
    public static int countStudents(int[] students, int[] sandwiches) {
        // count[0] = no.of students who eats circular shape sandwich.
        // count[1] = no.of students who eats square shape sandwich.
        int[] count = new int[2];
        for(int student : students){
            count[student]++;
        }

        for(int sandwich : sandwiches){
            // if sandwich is circular and no one is there to eat circular return count of people(who eats square) who left
            if(count[sandwich] == 0) return count[(sandwich + 1)%2];
            count[sandwich]--;
        }
        return 0;
    }
}
/*
Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3

-> First dry run above example.
-> Now check who will eat sandwich instead of who will not eat.
-> Sandwich at index eaten by :
        index           eatenBy
        sandwich[0]     students[0]
        sandwich[1]     students[3]
        sandwich[2]     students[4]
        sandwich[3]     now no one is there to eat 0 shape sandwich so return how many are left.
-> First count of students who will eat 0 and 1 sandwiches
-> Iterate over sandwiches, and decrement count of students who will current sandwich.
-> If no one is left to eat current sandwich then return remaining students count;

For the best explanation watch this : https://www.youtube.com/watch?v=AGNg0nXRw2k
 */
