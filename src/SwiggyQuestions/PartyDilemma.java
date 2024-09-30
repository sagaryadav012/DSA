package SwiggyQuestions;

public class PartyDilemma {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 2;
        System.out.println(minTents(a, b, c));
    }
    public static int minTents(int a, int b, int c){
        int tents = a;
        int neededForCommittee = b * 3;

        if(neededForCommittee > (b+c)) return -1;

        tents += b;

        int remainingNonOnCall = b + c - neededForCommittee;

        if(remainingNonOnCall > 0){
            tents += (int)Math.ceil((double) remainingNonOnCall /3);
        }

        return tents;
    }
}
/*
In the upcoming party, the organizing team is planning an event to take teams out for a team-building event.
In the first lot, the organizing team is planning to take software engineers out for a trek.
The team (trek members) will start trekking in the evening, will reach the hilltop around night in tents,
stay on top in the night, and will return in the morning.
The team is planning to have fun the whole night. The only problem is with on- call engineers.
They can come to the trek but with a laptop. In case of any on-call issues, they need to be active.

Consider that there are A on-call engineers, B organizing committee members, and C non-on call engineers.

1. Each on-call engineer wants to stay in the tent alone, in case there is an issue, the engineer can look into it.

2. Each organizing committee member wants to stay in the tent with two other trek members,
   it does not matter if the other two are software engineers or HR.

3. Non-on call engineers are fine with any option (living alone, with one other trek member, or with two others).

Tell us the minimum number of tents needed to be taken so that all trek members can be accommodated according to their preferences.

If it is impossible to accommodate the participants in a way that fulfills all their wishes, output-1.

 */