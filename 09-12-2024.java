// Insert Interval
// Difficulty: Medium     Accuracy: 50.61%        Submissions: 19K+        Points: 4
// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).


class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> al=new ArrayList<>();
        boolean added=false;
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]<newInterval[0]&&intervals[i][1]<newInterval[0])
            {
                al.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]&&intervals[i][1]>newInterval[1])
            {
                if(added==false)
                {
                    al.add(newInterval);
                    added=true;
                }
                al.add(intervals[i]);
            }
            else
            {
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
        }
        if(added==false)
        {
            al.add(newInterval);
        }
        return al;
    }
}