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

    public static void mergeSort(int[] arr, int l,int r){
        if(l<r){
            mergeSort(arr,l,l+(r-l)/2);
            mergeSort(arr,l+(r-l)/2+1,r);
            merge(arr, l, l+(r-l)/2, r);
        }
    }

    public static void merge(int[] arr,int l1,int r1,int r2){
        int[] temp = new int[r2-l1+1];
        int i = 0,l =l1;
        int l2 = r1+1;
        while(l1<=r1 && l2<=r2){
            if(arr[l1] < arr[l2]){
                temp[i] = arr[l1];
                l1++;
            }
            else{
                temp[i] = arr[l2];
                l2++;
            }
            i++;
        }
        if(l1<=r1){
            for(int k=l1; k<=r1;k++,i++){
                temp[i]=arr[k];
            }
        }
        if(l2<=r2){
            for(int k=l2; k<=r2; k++,i++){
                temp[i]=arr[k];
            }
        }

        for(int k=0;l<=r2;k++,l++){
            arr[l] = temp[k];
        }
    }

    //堆排序
    //构建最小堆
    public static void MakeMinHeap(int a[], int n){
        for(int i=(n-1)/2 ; i>=0 ; i--){
            MinHeapFixdown(a,i,n);
        }
    }
    //从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2  
    public static void MinHeapFixdown(int a[],int i,int n){
    
        int j = 2*i+1; //子节点
        int temp = 0;
    
        while(j<n){
            //在左右子节点中寻找最小的
            if(j+1<n && a[j+1]<a[j]){   
                j++;
            }
    
            if(a[i] <= a[j])
                break;
    
            //较大节点下移
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    
            i = j;
            j = 2*i+1;
        }
    }

    public static void MinHeap_Sort(int a[],int n){
        int temp = 0;
        MakeMinHeap(a,n);
      
        for(int i=n-1;i>0;i--){
            temp = a[0];
            a[0] = a[i];
            a[i] = temp; 
            MinHeapFixdown(a,0,i);
        }     
      }
    public static void main(String[] args){
        int[] arr = {42,20,17,13,28,14,23,15};
        //bubbleSort(arr);
        //selctionSort(arr);
        //insertionSort(arr);
        //shellSort(arr);
        //quickSort1(arr, 0, arr.length-1);
        //quickSort2(arr, 0, arr.length-1);
        //mergeSort(arr, 0, arr.length-1);
        MinHeap_Sort(arr,arr.length);
        for(int i : arr)
            System.out.println(i);
    }
}