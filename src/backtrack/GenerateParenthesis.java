package backtrack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        dfs(n, 0, 0, res, stack);

        return res;

    }

   private  static void dfs(int n, int o, int c, List<String> res, Stack<String> stack) {

        if(o==c &&c==n) {
            Iterator i = stack.iterator();
            String temp = "";
            while (i.hasNext()) {
                temp = temp + i.next();
            }
            res.add(temp);
            return;
        }

        if(o>=c && o<=n){
            stack.push("(");
            dfs(n,o+1,c, res, stack);
            stack.pop();
        }

        if(c<=o && c<=n){
            stack.push(")");
            dfs(n,o,c+1,res, stack);
            stack.pop();
        }



    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

}
