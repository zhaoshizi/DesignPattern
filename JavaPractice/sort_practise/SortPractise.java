public class SortPractise{
    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            for(int j = i;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    //选择排序
    public static void selctionSort(int[] arr){
        for(int i=0;i<arr.length;i++ ){
            int minPosition = i;
            for(int j=i;j<arr.length;j++){
                if(arr[minPosition] > arr[j]){
                    minPosition = j;
                }    
            }
            if(minPosition == i)
                break;
            else{
                int temp = arr[minPosition];
                arr[minPosition] = arr[i];
                arr[i] = temp;
            }
        }
    }
    
    //插入排序
    public static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1 ;j>0;j--)
            {
                if(arr[j-1] > arr[j]){
                    int temp=  arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]=temp;
                }
                else
                    break;
            }
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        int step = arr.length;
        while(true){
            step = step /2;
            for(int i= 0; i<arr.length;i++){
                for(int j = i+step;j<arr.length;j=j+step){
                    for(int k=j;k>i;k=k-step){
                        if(arr[k] < arr[k-step]){
                            int temp = arr[k-step];
                            arr[k-step] = arr[k];
                            arr[k]=temp;
                        }
                        else
                            break;
                    }
                }
            }
            if(step == 1)
                break;
        }
    }

    //快速排序
    public static void quickSort1(int[] arr,int l,int r){
        if(l>=r)
            return;
        int mid = l;
        int midvalue = arr[mid];
        for(int i=l+1,j=r;i<=j;){
            if(arr[i]<midvalue && i>mid){
                arr[mid] = arr[i];
                mid = i;
            }
            i++;
            if(arr[j]< midvalue && j>mid){
                arr[mid] = arr[j];
                mid = j;
            }
            j--;
            arr[mid]=midvalue;
        }
        quickSort(arr,l,mid);
        quickSort(arr,mid+1,r);
    }

    //快速排序2
    public static void quickSort2(int[] arr,int l,int r){
        if(l>=r)
            return;
        int i= l,j=r,key=arr[i];
        while(i<j){
            while(i<j && arr[j]>key){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }
            while(i<j && arr[i]<key){
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i] = key;
        quickSort2(arr, l, i-1);
        quickSort2(arr, i+1, r);
    }

    public static void main(String[] args){
        int[] arr = {42,20,17,13,28,14,23,15};
        //bubbleSort(arr);
        //selctionSort(arr);
        //insertionSort(arr);
        //shellSort(arr);
        quickSort2(arr, 0, arr.length-1);
        for(int i : arr)
            System.out.println(i);
    }
}