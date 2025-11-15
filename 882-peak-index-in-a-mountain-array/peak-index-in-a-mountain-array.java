class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=1;
        int high=arr.length-2;
        if(arr[0]>arr[1]) return 0;
        if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
        while(high>=low){
            int mid = low + (high - low) / 2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
            if(arr[mid]>arr[mid+1]){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return -1;
    }
}