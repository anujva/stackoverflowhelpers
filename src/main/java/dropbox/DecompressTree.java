package dropbox;

import com.random.stackoverflow.TreeNode;

public class DecompressTree {

    public static void main(String[] args) {
        TreeNode root = decompressTree("1,2,3,4,5,6,7");
        TreeNode.printTree(root);
    }

    public static TreeNode decompressTree(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArray = str.split(",");
        TreeNode root = null;
        if (strArray[0].equals("*")) {
            return null;
        }

        if (strArray.length > 0) {
            root = new TreeNode(Integer.parseInt(strArray[0]));
            if (strArray.length > 1 && !strArray[1].equals("*")) {
                root.left = new TreeNode(Integer.parseInt(strArray[1]));
            }
            if (strArray.length > 2 && !strArray[2].equals("*")) {
                root.right = new TreeNode(Integer.parseInt(strArray[2]));
            }
        }

        decompressTree(root.left, 1, strArray);
        decompressTree(root.right, 2, strArray);

        return root;
    }

    public static void decompressTree(TreeNode root, int index,
        String[] strArray) {
        if (root == null) {
            return;
        }

        if (index > strArray.length - 1) {
            return;
        }

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = leftChildIndex + 1;
        System.out.println("Root data: " + root.data);
        System.out.println("Index: " + index);
        System.out.println("LeftChildIndex: " + leftChildIndex);
        System.out.println("RightChildIndex: " + rightChildIndex);
        System.out.println();

        if (leftChildIndex < strArray.length &&
            !strArray[leftChildIndex].equals("*")) {
            root.left = new TreeNode(Integer.parseInt(strArray[leftChildIndex]));
        }

        if (rightChildIndex < strArray.length &&
            !strArray[rightChildIndex].equals("*")) {
            root.right = new TreeNode(Integer.parseInt(strArray[rightChildIndex]));
        }

        decompressTree(root.left, leftChildIndex, strArray);
        decompressTree(root.right, rightChildIndex, strArray);
    }
}
