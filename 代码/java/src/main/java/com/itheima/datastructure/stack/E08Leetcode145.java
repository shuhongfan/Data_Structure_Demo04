package com.itheima.datastructure.stack;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.List;

/**
 * 二叉树后序遍历(左,右,父)
 */
public class E08Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(
//                new TreeNode(
//                        2
//                ),
//                1,
//                new TreeNode(
//                        3
//                )
//        );
        TreeNode root = new TreeNode(
                new TreeNode(null, 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        /*
                  1
                 / \
                2   3

                2 3 1
         */

        LinkedListStack<TreeNode> stack = new LinkedListStack<>();

        TreeNode curr = root;
        TreeNode lastPop = null;


        /*
                第一次循环, curr=1     栈 [] -> [1]           处理1, 下次处理1左
                第二次循环, curr=2     栈 [1] -> [2,1]        处理2, 下次处理2左
                第三次循环, curr=null  栈 [2,1] -> [1]        2左完成, 处理2右, 2没有右 pop=2 lastPop=2
                第四次循环, curr=null  栈 [1] -> [1]          2右完成, 处理1右, 1有右但没处理, 暂不 pop
                第五次循环, curr=3     栈 [1] -> [3,1]        处理3, 下次处理3左
                第六次循环, curr=null  栈 [3,1] -> [1]        3左完成, 处理3右, 3没有右 pop=3 lastPop=3
                第七次循环, curr=null  栈 [1] -> []           3右完成, 1右处理完成, pop=1 lastPop=1
                第八次循环, curr=null  栈 [], 退出
         */

        while (!stack.isEmpty() || curr != null) {
            System.out.println("stack:" + stack + " curr:" + curr + " last:" + lastPop);
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != lastPop) {
                    curr = peek.right;
                } else {
                    lastPop = stack.pop();
                    System.out.println(lastPop);
                }
            }

        }
    }
}
