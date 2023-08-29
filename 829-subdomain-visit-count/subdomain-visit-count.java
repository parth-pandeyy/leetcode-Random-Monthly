class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
       Map<String,Integer> count = new HashMap<>();
       
       for(String domains : cpdomains){
           int i = domains.indexOf(' ');
           int rep = Integer.valueOf(domains.substring(0,i));
           String s = domains.substring(i+1);
           for(i=0 ; i<s.length() ; ++i){
               if(s.charAt(i)=='.'){
                   String d = s.substring(i+1);
                   count.put(d,count.getOrDefault(d,0) + rep);
               }
           }
           count.put(s,count.getOrDefault(s,0) + rep);
       }
       ArrayList<String> ans = new ArrayList<>();
       for(String d : count.keySet()) ans.add(count.get(d) + " " + d);
       return ans;
    }
}