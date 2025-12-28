/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
     Map<Integer,Integer> map = new HashMap<>();
    public int dfs(List<Employee> list, int id){
        if(list.get(map.get(id)).subordinates.size()==0) return list.get(map.get(id)).importance;
        int sum=0;
        for(int i=0;i<list.get(map.get(id)).subordinates.size();i++){
           sum=sum+ dfs(list,list.get(map.get(id)).subordinates.get(i));
        }
        return sum+list.get(map.get(id)).importance;
    }
    public int getImportance(List<Employee> employees, int id) {
       
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id,i);
        }
       return  dfs(employees,id);

    }
}