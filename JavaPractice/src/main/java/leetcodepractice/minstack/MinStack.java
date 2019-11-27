package leetcodepractice.minstack;

class MinStack{
    private int length = 10;
    private int[] stack;
    private int minEle = Integer.MAX_VALUE;
    private int EleNo=-1;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[length];
    }
    
    public void push(int x) {
        if(EleNo >= stack.length-1){
            int[] stack2 = new int[stack.length*2];
            for(int j=0;j<=EleNo;j++)
                stack2[j] = stack[j];
            stack = stack2;
        }
        stack[++EleNo] = x;
        if(minEle > x)
            minEle = x;
    }
    
    public void pop() {
        if (EleNo >=0){
            EleNo--;
            if(minEle == stack[EleNo+1] ){
                if (EleNo >=0){
                    minEle = stack[0];
                    for(int i=1;i<=EleNo;i++)
                        if(minEle > stack[i])
                            minEle = stack[i];
                }
                else
                    minEle = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        if (EleNo >=0)
            return stack[EleNo];
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        if (EleNo >=0)
            return minEle;
        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        // obj.push(5);
        // obj.push(4);
        // obj.pop();
        // obj.push(3);
        // obj.push(6);
        // obj.push(1);
        // int param_3 = obj.top();
        // int param_4 = obj.getMin();

        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);
        int param_2 = minStack.getMin();
        minStack.pop();
        
        
        int param_3 = minStack.top(); 
        int param_4 = minStack.getMin(); 
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    
}