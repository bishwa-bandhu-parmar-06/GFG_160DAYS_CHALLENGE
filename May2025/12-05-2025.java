// Meeting Rooms III
// Difficulty: HardAccuracy: 64.3%Submissions: 9K+Points: 8
// You are given an integer n representing the number of rooms numbered from 0 to n - 1. Additionally, you are given a 2D integer array meetings[][] where meetings[i] = [starti, endi] indicates that a meeting is scheduled during the half-closed time interval [starti, endi). All starti values are unique.

// Meeting Allocation Rules:

// When a meeting starts, assign it to the available room with the smallest number.
// If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.
// When a room becomes free, assign it to the delayed meeting with the earliest original start time.
// Determine the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.


class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            availableRooms.offer(i);
        }
        // int[] strtcture {Meeting End Time, Room Number}
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        int[] roomCount = new int[n];
        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            int room;
            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                availableRooms.offer(busyRooms.poll()[1]);
            }
            if(!availableRooms.isEmpty()){
                room = availableRooms.poll();
                busyRooms.offer(new int[]{end, room});
            }
            // Wait for room to be free
            else{
                int[] next = busyRooms.poll();
                room = next[1];
                int newEnd = next[0] + duration;
                busyRooms.offer(new int[]{newEnd, room});
            }
            roomCount[room]++;
        }
        int maxCount = roomCount[0];
        int maxRoom = 0;
        for(int i=1; i<n; i++){
            if(roomCount[i]>maxCount){
                maxCount = roomCount[i];
                maxRoom = i;
            }   
        }
        return maxRoom;
    }
}