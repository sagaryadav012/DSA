In interval kind of problems, we have two types of problems. 
Type 1 : find max no.of meetings can be scheduled or max no.of jobs can do.
Type 2 : Find min no.of rooms can be occupied or min no.of platforms required.

Case 1 :
-> When we find problems like, given intervals find max no.of meetings or something that about find max no.of.
-> In that case solve intervals on end time, because instead of doing long length intervals do smaller ones which are ends first.
   For example, Given some intervals of a day, now find how many max no.of jobs a person can do.
   intervals {9,18  10,12  14 16} Here if person do 9-18 job then he can't do other jobs in that period, Instead of that 
   he can do 2 jobs in same interval of time. Similarly problem like max no.of meeting that can be done in one meeting room.

Case 2 : 
-> In this case they given unlimited resources and intervals. Use min no.of resource to perform all intervals. So sort intervals on
   start time, so it is easy to find which are overlapping. We use priority queue to know which interval ends first.
   problem 1 : Given some meetings, find min no.of required to schedule all meetings. 
   problem 2 : Given intervals, find min no.of platforms required.