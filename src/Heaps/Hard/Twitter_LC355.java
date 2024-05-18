package Heaps.Hard;

import java.util.*;

public class Twitter_LC355 {
    TweetNode head;
    Map<Integer, Set<Integer>> followersMap;
    public Twitter_LC355() {
        this.head = null;
        this.followersMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        TweetNode node = new TweetNode(userId, tweetId);
        node.next = head;
        head = node;
        if(!followersMap.containsKey(userId)){
            follow(userId, userId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = followersMap.get(userId);
        TweetNode temp = head;
        List<Integer> tweetIds = new ArrayList<>();

        while(temp != null && tweetIds.size() < 10){ // fetch most recent 10 tweetIds
            int followeeId = temp.userId;
            if(following.contains(followeeId)){
                tweetIds.add(temp.tweetId);
            }
            temp = temp.next;
        }
        return tweetIds;
    }

    public void follow(int followerId, int followeeId) {
        if(!followersMap.containsKey(followerId)){
            followersMap.put(followerId, new HashSet<>());
            followersMap.get(followerId).add(followerId); // user follows itself
        }
        followersMap.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        followersMap.get(followerId).remove(followeeId);
    }
}
class TweetNode{
    int userId;
    int tweetId;
    TweetNode next;
    TweetNode(int userId, int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
    }
}