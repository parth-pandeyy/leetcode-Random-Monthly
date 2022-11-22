class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>(n);
        for(int i=1, Fizz=0, Buzz=0; i<=n; i++){
            Fizz++;
            Buzz++;
            if(Fizz==3 && Buzz==5){
                ans.add("FizzBuzz");
                Fizz=0;
                Buzz=0;
            }
            else if(Fizz==3){
                ans.add("Fizz");
                Fizz=0;
            }
            else if(Buzz==5){
                ans.add("Buzz");
                Buzz=0;
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}