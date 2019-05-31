package leecodepractice.dropeggs;
import java.lang.Math;
public class DropEggs{

    public static  int  dropEggs(int K,int N){
        if(K>N)
            K = N;
        if(K == 1)
            return N;
        if(K == 0 || N == 0 )
            return 0;
        int min=N,max=0;
        for(int i=1;i<=N;i++){
            max = Math.max(dropEggs(K-1,i-1),dropEggs(K,N-i));
            min = min>max?max:min;
        }
        return min + 1;
    }

    public static void main(String[] args){
        System.out.println(dropEggs(3,25));
    }
}