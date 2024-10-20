class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int[] target=times[targetFriend];
        Arrays.sort(times,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> availableChairs=new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs=new PriorityQueue<>( (a,b )->Integer.compare(a[0],b[0]) );
        for(int i=0;i<n;i++){
            availableChairs.offer(i);
        }

        for(int[] time:times){
            while(!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time[0]){
                availableChairs.offer(occupiedChairs.poll()[1]);
            }

            int res=availableChairs.poll();
            if(Arrays.equals(target,time)){
                return res;
            }

            occupiedChairs.offer(new int[]{time[1],res});
        }

        return -1;

    }
}