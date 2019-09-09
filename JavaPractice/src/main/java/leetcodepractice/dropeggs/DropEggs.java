//https://github.com/Shellbye/Shellbye.github.io/issues/42
package leetcodepractice.dropeggs;
public class DropEggs{

    public static int superEggDrop(int K, int N){
        int[] m = new int[K+1];
        //一个鸡蛋只移动0次
        for(int i =1;i<=K;i++)
            m[i] =0;
        int i;
        for(i =0;m[K] < N;i++)
            for(int j=K;j>0;j--)
                m[j] = m[j] + m[j-1] +1;

        return i;
    }

    public static void main(String[] args){
        System.out.println(superEggDrop(3,14));
    }
}