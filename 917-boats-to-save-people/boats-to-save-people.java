class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat=0;
        int first =0;
        int last = people.length-1;
        while(first<=last){
         int sum=people[last]+people[first];
          
          if(sum<=limit ){
            first++;
          }
          last--;
          boat++;
        }
        return boat;
    }
}