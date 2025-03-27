package org.pk.hackerrank.datastructure;

import java.util.*;


enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        //implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
        //implement this
        //node.accept(this);
        //sum = sum + node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        //leaf.accept(this);
        sum += leaf.getValue();

    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1000000007;
    private long product = 1;

    public int getResult() {
        //implement this
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNodeSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        //implement this
        return Math.abs(evenDepthNodeSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            evenDepthNodeSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}


public class TreeVisitorPatternSolution {

    private static Tree buildTree(int nodeId, int[] values, Color[] colors, Map<Integer, List<Integer>> treeMap, boolean[] visited, int depth) {
        visited[nodeId] = true;
        List<Integer> children = treeMap.getOrDefault(nodeId, Collections.emptyList());
        if (children.isEmpty() || (children.size() == 1 && visited[children.get(0)])) {
            return new TreeLeaf(values[nodeId], colors[nodeId], depth);
        } else {
            TreeNode node = new TreeNode(values[nodeId], colors[nodeId], depth);
            for (int childId : children) {
                if (!visited[childId]) {
                    node.addChild(buildTree(childId, values, colors, treeMap, visited, depth + 1));
                }
            }
            return node;
        }
    }

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner in = new Scanner(System.in);
        int noOfNodes = Integer.parseInt(in.next());
        int[] values = new int[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            values[i] = Integer.parseInt(in.next());
        }
        Color[] colors = new Color[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            int colorValue = Integer.parseInt(in.next());
            colors[i] = (colorValue == 0) ? Color.RED : Color.GREEN;
        }
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        for (int i = 0; i < noOfNodes - 1; i++) {
            int u = Integer.parseInt(in.next()) - 1;
            int v = Integer.parseInt(in.next()) - 1;
            treeMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            treeMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        in.close();
        Tree root = buildTree(0, values, colors, treeMap, new boolean[noOfNodes], 0);
        return root;
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}



