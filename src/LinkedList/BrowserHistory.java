package LinkedList;

public class BrowserHistory {
    DLNode curr;
    public BrowserHistory(String homepage) {
        curr = new DLNode(homepage);
    }

    public void visit(String url) {
        if(curr.next != null){
            DLNode next = curr.next;
            curr.next = null;
            next.prev = null;
        }
        DLNode newUrl = new DLNode(url);
        curr.next = newUrl;
        newUrl.prev = curr;
        curr = curr.next;
    }

    public String back(int steps) {
        int count = 1;
        while(curr.prev != null && count <= steps){
            curr = curr.prev;
            count += 1;
        }
        return curr.siteName;
    }

    public String forward(int steps) {
        int count = 1;
        while(curr.next != null && count <= steps){
            curr = curr.next;
            count += 1;
        }
        return curr.siteName;
    }
}
class DLNode{
    String siteName;
    DLNode prev;
    DLNode next;

    public DLNode(String siteName) {
        this.siteName = siteName;
    }
}
