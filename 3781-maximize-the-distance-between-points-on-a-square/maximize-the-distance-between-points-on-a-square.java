import java.util.*;

class Solution {
    public int maxDistance(int side,int[][] points,int k){
        int n=points.length;
        long[] arr=new long[n];
        long per=4L*side;

        // map 2D → 1D perimeter
        for(int i=0;i<n;i++){
            int x=points[i][0],y=points[i][1];

            if(y==0) arr[i]=x;
            else if(x==side) arr[i]=side+(long)y;
            else if(y==side) arr[i]=3L*side-x;
            else arr[i]=4L*side-y;
        }

        Arrays.sort(arr);

        // duplicate for circular handling
        long[] ext=new long[2*n];
        for(int i=0;i<n;i++){
            ext[i]=arr[i];
            ext[i+n]=arr[i]+per;
        }

        long low=0,high=per,ans=0;

        while(low<=high){
            long mid=(low+high)/2;

            if(can(ext,n,k,mid,per)){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }

        return (int)ans;
    }

    private boolean can(long[] ext,int n,int k,long dist,long per){
        for(int i=0;i<n;i++){
            int count=1;
            long first=ext[i];
            long last=first;
            int idx=i;

            while(count<k){
                int next=lowerBound(ext,idx+1,i+n,last+dist);
                if(next>=i+n) break;

                last=ext[next];
                idx=next;
                count++;
            }

            if(count==k && last-first<=per-dist){
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] arr,int l,int r,long target){
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]>=target) r=mid;
            else l=mid+1;
        }
        return l;
    }
}