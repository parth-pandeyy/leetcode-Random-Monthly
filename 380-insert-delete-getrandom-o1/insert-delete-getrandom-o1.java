class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int removeIndex = map.get(val);
        map.remove(val);

        if(removeIndex == list.size()-1){ // if get exact index then remove
            list.remove(list.size()-1);
            return true;
        }

        // if don't get exact index then swap & remove 
        list.set(removeIndex,list.get(list.size()-1)); //.set method is used to replace the 
        list.remove(list.size()-1); // element at specified position

        map.put(list.get(removeIndex), removeIndex);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = r.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */