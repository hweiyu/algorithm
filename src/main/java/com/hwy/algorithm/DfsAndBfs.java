package com.hwy.algorithm;

import java.util.*;

/**
 * 二叉树的深度优先遍历（DFS）与广度优先遍历（BFS）
 * 深度优先遍历：从根节点出发，沿着左子树方向进行纵向遍历，
 *               直到找到叶子节点为止。然后回溯到前一个节点，
 *               进行右子树节点的遍历，直到遍历完所有可达节点为止。
 * 广度优先遍历：从根节点出发，在横向遍历二叉树层段节点的基础上纵
 *               向遍历二叉树的层次。
 *
 *           A
 *         /  \
 *        B    C
 *       / \  / \
 *      D  E F  G
 *
 * DFS:ABDECFG
 * BFS:ABCDEFG
 *
 * DFS实现：
 * 数据结构：栈
 * 父节点入栈，父节点出栈，先右子节点入栈，后左子节点入栈。递归遍历全部节点即可
 *
 *  BFS实现：
 * 数据结构：队列
 * 父节点入队，父节点出队列，先左子节点入队，后右子节点入队。递归遍历全部节点即可
 *
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/17 9:40
 **/
public class DfsAndBfs {

    public static void main(String[] args) {

        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> e = new TreeNode<>("E");
        TreeNode<String> f = new TreeNode<>("F");
        TreeNode<String> g = new TreeNode<>("G");
        TreeNode<String> b = new TreeNode<>("B", d, e);
        TreeNode<String> c = new TreeNode<>("C", f, g);
        TreeNode<String> a = new TreeNode<>("A", b, c);

        System.out.println("dfs:" + listToString(dfs(a)));
        System.out.println("bfs:" + listToString(bfs(a)));
    }

    private static<T> List<T> dfs(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        TreeNode<T> curNode;
        while (!stack.isEmpty()) {
            curNode = stack.peek();
            stack.pop();
            if (null != curNode) {
                result.add(curNode.getData());
                if (null != curNode.getRight()) {
                    stack.push(curNode.getRight());
                }
                if (null != curNode.getLeft()) {
                    stack.push(curNode.getLeft());
                }
            }
        }
        return result;
    }

    private static<T> List<T> bfs(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        //add element
        queue.offer(root);
        TreeNode<T> curNode;
        while (!queue.isEmpty()) {
            //get first element and remove from queue;
            curNode = queue.poll();
            if (null != curNode) {
                result.add(curNode.getData());
                if (null != curNode.getLeft()) {
                    queue.offer(curNode.getLeft());
                }
                if (null != curNode.getRight()) {
                    queue.offer(curNode.getRight());
                }
            }
        }
        return result;
    }

    private static<T> String listToString(List<T> list) {
        StringBuilder buf = new StringBuilder();
        for (T t : list) {
            buf.append(t);
        }
        return buf.toString();
    }

    private static class TreeNode<T> {

        private T data;

        private TreeNode<T> left;

        private TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }

        TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public TreeNode<T> getRight() {
            return right;
        }
    }
}
