package ds.Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;
/** Constraints: 1. 2 <= asteroids.length <= 10^4
 *  asteroids[i] != 0
 *  */
public class _735 {
    /** 1. find two asteroids moving in the opposite direction
     *  2. compare the size (>0, ==0, <0)
     *  3. remove the smaller one
     * */
    public int[] asteroidCollision_1(int[] aster) {
        int[] stack = new int[aster.length];
        int top = -1;//top pointer of the stack, if top == -1, stack is empty

        for (int i = 0; i < aster.length; i++) {
            if (top == -1 || aster[i] > 0) stack[++top] = aster[i];
            else {//stack is not empty and aster[i] < 0
                while (top >= 0) {
                    if (stack[top] < 0) {
                        stack[++top] = aster[i];
                        break;
                    } else if (stack[top] + aster[i] == 0) {
                        top--;
                        break;
                    } else {
                        if (stack[top] + aster[i] < 0) {
                            top--;
                            if (top == -1) {
                                stack[++top] = aster[i];
                                break;
                            }
                        } else break;
                    }
                }
            }
        }

        int[] res = new int[top+1];
        System.arraycopy(stack,0,res,0,top+1);
        return res;
    }

    /** runtime: 2 ms 99.31%
     *  memory usage: 48.2 MB 57.43% */
    public int[] asteroidCollision_11(int[] aster) {
        int[] stack = new int[aster.length];
        int top = -1;//top pointer of the stack, if top == -1, stack is empty

        for (int a:aster) {
            if (a > 0) stack[++top] = a;
            else {
                while (top != -1 && stack[top] > 0 && stack[top] + a < 0)
                    top--;
                if (top == -1 || stack[top] < 0)
                    stack[++top] = a;
                else if (stack[top] + a == 0)
                    top--;
            }
        }

        int[] res = new int[top+1];
        for (int i = 0; i <= top; i++)
            res[i] = stack[i];
        return res;
    }

    /** runtime: 11 ms 62.79%
     *  memory usage: 43.1 MB 94.90% */
    public int[] asteroidCollision_2(int[] aster) {
        Stack<Integer> stack = new Stack<>();

        for (int a:aster) {
            if (a > 0) stack.push(a);
            else {//a < 0
                while (!stack.empty() && stack.peek() > 0 && stack.peek() + a < 0)//collision
                    stack.pop();
                if (stack.empty() || stack.peek() < 0)
                    stack.push(a);
                else if (stack.peek()+a == 0)
                    stack.pop();
            }
        }

        int i = 0;
        int[] res = new int[stack.size()];
        for (int a:stack)
            res[i++] = a;

        return res;
    }

    @Test
    void test(){
        int[] a = {-2,-1,1,2};
        int[] res = asteroidCollision_11(a);
        for (int i:res) {
            System.out.println(i);
        }
    }
}
