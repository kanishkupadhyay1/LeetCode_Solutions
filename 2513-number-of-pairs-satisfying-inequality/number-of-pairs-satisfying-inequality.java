class Solution {
    public long numberOfPairs(int[] nums1,int[] nums2,int diff){
        int n=nums1.length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=nums1[i]-nums2[i];
        }

        return mergeSort(arr,0,n-1,diff);
    }

    private long mergeSort(int[] arr,int l,int r,int diff){
        if(l>=r)return 0;

        int mid=(l+r)/2;
        long count=mergeSort(arr,l,mid,diff)+mergeSort(arr,mid+1,r,diff);

        int j=mid+1;

        for(int i=l;i<=mid;i++){
            while(j<=r && arr[i]>arr[j]+diff){
                j++;
            }
            count+=r-j+1;
        }

        merge(arr,l,mid,r);
        return count;
    }

    private void merge(int[] arr,int l,int m,int r){
        int[] temp=new int[r-l+1];
        int i=l,j=m+1,k=0;

        while(i<=m && j<=r){
            if(arr[i]<=arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }

        while(i<=m) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];

        for(int x=0;x<temp.length;x++){
            arr[l+x]=temp[x];
        }
    }
}