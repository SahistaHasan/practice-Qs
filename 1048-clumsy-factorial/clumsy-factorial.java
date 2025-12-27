class Pair {
    char operator;
    int num;

    Pair(char operator, int num) {
        this.operator = operator;
        this.num = num;
    }
}

    class Solution {
    public int clumsy(int n) {
        int soln=n;
        char [] arr = {'*','/','+','-'};
        List<Pair> list = new ArrayList<>();
        int i=4;
        while(n-1!=0){
            n--;
           if(arr[i%arr.length]=='*'){
            soln=soln*n;
           }
           else if(arr[i%arr.length]=='/'){
            soln=soln/n;
           }
           else if(arr[i%arr.length]=='+'){
            list.add(new Pair('+',soln));
            soln=n;
           }
           else if(arr[i%arr.length]=='-'){
            list.add(new Pair('-',soln));
            soln=n;
           }
           i++;
           
        }
        list.add(new Pair('+',soln));
        int ans=list.get(0).num;;
        for(int j=0;j<list.size()-1;j++){
            if(list.get(j).operator=='+'){
                ans=ans+list.get(j+1).num;
            }
            else if(list.get(j).operator=='-'){
                ans=ans-list.get(j+1).num;
            }
        }
        return ans;
    }
}