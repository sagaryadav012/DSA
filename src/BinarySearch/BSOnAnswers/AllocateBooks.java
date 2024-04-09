package BinarySearch.BSOnAnswers;

public class AllocateBooks {
    public static void main(String[] args) {
       int[] books = {12, 34, 67, 90};
       int students = 2;
        System.out.println(minOfMaxPages(books, students));
    }
    public static int minOfMaxPages(int[] books, int students){ // TC - ONlogN) SC - O(1)
        int minPages = books[0];
        int maxPages = 0;
        for (int book : books) {
            minPages = Math.min(maxPages, book);
            maxPages += book;
        }

        int left = minPages, right = maxPages;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(books, students, mid)){
               ans = mid;
               right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] books, int students, int minPages){
        int pagesCount = 0;
        int assignedStudents = 0;
        for (int book : books) {
            pagesCount += book;
            if(pagesCount > minPages){
                assignedStudents += 1;
                pagesCount = book;
            }
        }
        assignedStudents += 1;
        return assignedStudents <= students; // assigned students must be <= students
    }
}
/*
-> We can assign all books to one student, remaining student can have nothing.
 */