class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weigh = new PriorityQueue<>((a,b)->b-a);
        for(int i:stones){
            weigh.offer(i);
        }
        while(weigh.size()>1){
            weigh.offer(weigh.poll()-weigh.poll());
        }
        return weigh.poll();
    }
}