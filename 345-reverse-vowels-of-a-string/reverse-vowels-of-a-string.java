class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left=0;
        int right=s.length()-1;

        while(left<right){
            while(left<right && vowels.indexOf(ch[left])==-1){
                left++;
            }
            while(left<right && vowels.indexOf(ch[right])==-1){
                right--;
            }
            if(left<right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}