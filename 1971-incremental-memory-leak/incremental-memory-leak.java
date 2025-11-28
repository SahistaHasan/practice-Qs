class Solution {
    public int[] memLeak(int memory1, int memory2) {
        boolean crash = false;
        int reqmem=1;
        while(crash==false){
            if(memory1>memory2 && memory1>=reqmem){
                memory1=memory1-reqmem;
                reqmem=reqmem+1;
            }
            else if(memory1<memory2 && memory2>=reqmem){
                memory2=memory2-reqmem;
                reqmem=reqmem+1;
            }
            else if(memory1==memory2 && memory1>=reqmem){
                memory1=memory1-reqmem;
                reqmem++;
            }
            else{
                crash=true;
            }
        }
        return new int[]{reqmem,memory1,memory2};
    }
}