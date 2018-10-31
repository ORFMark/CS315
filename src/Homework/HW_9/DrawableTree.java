package Homework.HW_9;

public class DrawableTree extends Tree {

    public DrawableTree() {
    }

    private int getDepthOfMin(Node node) {
        if (node == null)
            return 0;
        else
            return getDepthOfMin(node.left) + 1;
    }

    private int getDepthOfTree(Node node) {
        if (node == null)
            return 0;
        else {
            int leftDepth = getDepthOfTree(node.left);
            int rightDepth = getDepthOfTree(node.right);
            if (leftDepth >= rightDepth)
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }
    }
 
    private void markNode(Node node, int depth, int spacing, int leftOffset) {
        if (node != null) {
            node.depth = depth;
            spacing /= 2;
            node.leftOffset = leftOffset;
            markNode(node.left, depth + 1, spacing, leftOffset - spacing);
            markNode(node.right, depth + 1, spacing, leftOffset + spacing);
        }
    }
    
    private void spaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    
    public void displayTree() {
        IterableDblLinkList q = new IterableDblLinkList();
        // int depthOfTree = getDepthOfTree(root);
        markNode(root, 0, 16, 16);
        q.insertAtTail(new DblLink(root));
        GoFIterator iter = q.getGoFIterator();
        for (iter.first(); !iter.isDone(); iter.next()) {
            Node node = iter.currentItem();
            if (node.left != null)
                q.insertAtTail(new DblLink(node.left));
            if (node.right != null)
                q.insertAtTail(new DblLink(node.right));
        }
        int depth = 0;
        int offset = 0;
        int spacing = 0;
        System.out.println();
        for (iter.first(); !iter.isDone(); iter.next()) {
            Node node = iter.currentItem();
            if (node.depth > depth) {
                depth = node.depth;
                System.out.println();
                offset = 0;
            }
            spacing = node.leftOffset - offset;
            offset = node.leftOffset;
            spaces(2 * spacing - 2);
            System.out.format("%2d", node.data);
        }
        System.out.println("\n");
    }

}
