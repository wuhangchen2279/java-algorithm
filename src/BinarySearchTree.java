import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BSTNode insert(BSTNode root, int data) {
        if(root == null) {
            root = new BSTNode(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public BSTNode search(BSTNode root, int data) {
        if(root == null) {
            return null;
        } else if(root.data == data) {
            return root;
        } else if(data <= root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    public int findMin(BSTNode root) {
        if(root == null) {
            System.out.println("Empty tree");
            return -1;
        }
        BSTNode current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public int findHeight(BSTNode root) {
        if(root == null) {
            return -1;
        }
        int leftHeigt = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
        return max(leftHeigt, rightHeight) + 1;

    }

    private int max(int firstVal, int secondVal) {
        if(firstVal >= secondVal) {
            return firstVal;
        } else {
            return secondVal;
        }
    }

    public int findMax(BSTNode root) {
        if(root == null) {
            System.out.println("Empty tree");
            return -1;
        } else if(root.right == null) {
            return root.data;
        }
        return findMax(root.right);
        
    }

    public void levelOrderTraversal(BSTNode root) {
        if(root == null) {
            return;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            BSTNode current = q.peek();
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
            q.pop();
        }
    }
    
    public void preOrderTravasel(BSTNode root) {
        if(root == null) return;
        System.out.println(root.data);
        preOrderTravasel(root.left);
        preOrderTravasel(root.right);
    }

    public boolean isBinarySearchTree(BSTNode root) {
        if(root == null) return true;
        if(isSubtreeGreater(root.left, root.data)
            && isSubtreeGreater(root.right, root.data)
            && isBinarySearchTree(root.left)
            && isBinarySearchTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSubtreeLesser(BSTNode root, int value) {
        if(root == null) return true;
        if(root.data <= value
            && isSubtreeLesser(root.left, value))
            && isSubtreeLesser(root.right, value)) {
                return true;
            } else {
                return false;
            }
    }

    public boolean isSubtreeGreater(BSTNode root, int value){
        if(root == null) return true;
        if(root.data <= value
            && isSubtreeGreater(root.left, value))
            && isSubtreeGreater(root.right, value)) {
                return true;
            } else {
                return false;
            }
    }

    private boolean isBstUtil(BSTNode root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.data >= minValue
            && root.data < maxValue
            && isBstUtil(root.left, minValue, root.data)
            && isBstUtil(root.right, root.data, maxValue)) {
                return true;
            } else {
                return false;
            }
    }

    public boolean isBinarySearchTree(BSTNode root) {
        return isBstUtil(root, INT_MIN, INT_MAX)
    }

    public BSTNode delete(BSTNode root, int data) {
        if(root == null) {
            return root;
        } else if(data < root.data) {
            root.left = delete(root.left, data);
        } else if(data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // found the node
            //case 1: no child
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }

            //case 2: one child
            else if(root.left == null) {
                root = root.right;
                return root;
            }
            else if(root.right == null) {
                root = root.left;
                return root;
            }
            //case 3: 2 children
            else {
                BSTNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
                return root;
            }
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode root = null;
        root = bst.insert(root, 20);
        root = bst.insert(root, 15);
        root = bst.insert(root, 22);
        root.displayNode();
        bst.search(root, 22).displayNode();
        System.out.println(bst.findHeight(root));
    }

}

class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println("data: " + data);
    }
}

class Queue {
    public int[] items;
    public int numOfItems;


}