package baekjoon.sample;

import java.io.*;
import java.util.StringTokenizer;

public class Sort {
    static int[] tmp;
    static int[] tmp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[T];
        int[] idx = new int[T];
        tmp = new int[T];
        tmp2 = new int[T];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<T; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        mergeSort(arr,idx,0,T-1);
        int cnt = 0;
        int num=arr[0];
        int[] res = new int[T];
        for(int i=0;i<T;i++){
            if(arr[i]==num){
                res[idx[i]]=cnt;
            }else{
                num=arr[i];
                res[idx[i]]=++cnt;
            }
        }

        for(int i=0;i<T;i++){
            bw.append(res[i]+" ");
        }
        bw.flush();
    }

    public static void mergeSort(int[] arr,int[] arr2, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr,arr2,start,mid);
            mergeSort(arr,arr2,mid+1,end);
            merge(arr,arr2,start,mid,end);
        }
    }

    public static void merge(int[] arr, int[] arr2, int start,int mid, int end){
        int left = start;
        int right = mid+1;
        int k = start;
        while(left<=mid&&right<=end){
            if(arr[left]<arr[right]){
                tmp[k]=arr[left];
                tmp2[k]=arr2[left];
                left++;
            } else {
                tmp[k]=arr[right];
                tmp2[k]=arr2[right];
                right++;
            }
            k++;
        }
        while(left<=mid){
            tmp[k]=arr[left];
            tmp2[k]=arr2[left];
            left++;
            k++;
        }
        while(right<=end){
            tmp[k]=arr[right];
            tmp2[k]=arr2[right];
            right++;
            k++;
        }
        for(int i=start;i<=end;i++){
            arr[i]=tmp[i];
            arr2[i]=tmp2[i];
        }
    }
}
