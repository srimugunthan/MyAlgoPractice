
public class LowestCommonAncestorBinaryTree {
     
    public static void main(String args[]) {
        /**
         * Create a sample Binary Tree. A Binary tree does not have to maintain
         * left <root < right relationship.
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
 
        root.right.left = new Node(9);
        root.right.right = new Node(11);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(3);
 
	PrintTree(root,1);
        System.out.println("Lowest Common Ancestor of Node 3 and 9 is: "
                + findLowestCommonAncestor(root, root.right.right.right, root.right.left).value);
         
        System.out.println("Lowest Common Ancestor of Node 3 and null is: "
                + findLowestCommonAncestor(root, root.right.right.right, null).value);
         
        System.out.println("Lowest Common Ancestor of Node 11 and null is: "
                + findLowestCommonAncestor(root, root.right.right, null).value);
 
    }
     


    public static void PrintSpace(int n)
	{
	  for (int i = 0; i < n; ++i)
	            System.out.print(" ");
	}

	    public static void PrintTree(Node root, int level)
	{
	  if (root == null) { return; }
	  PrintTree(root.right, level + 1);
	  PrintSpace(level * 6);
	          System.out.println( root.value);
	  PrintTree(root.left, level + 1);
	}

    /**
     * Recursive approach to find the Lowest Common Ancestor
     * @param root
     * @param a - first Node
     * @param b - second Node
     * @return Node that is lowest common ancestor of both a and b
     */
    public static Node findLowestCommonAncestor(Node root, Node a, Node b) {
 
        Node left = null;
        Node right = null;
 
        if (root == null) {
            return null;
        }
 
        /**
         * If Node a or Node b is also the root, then the root itself is lowest common ancestor
         */
        if (root == a || root == b) {
            return root;
        }
 
        left = findLowestCommonAncestor(root.left, a, b);
        right = findLowestCommonAncestor(root.right, a, b);
 
        /**
         * If Node a and Node b lie in the left, their Lowest Common Ancestor is in the left.
         * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
         *
         * Otherwise, root is the Lowest common ancestor.
         */
        if (left != null && right != null) {
            return root;
        }
	if(left != null)
	{
		return left;
	}
	else
	{
		return right;
	}
 
        //return (left != null) ? left : right;
    }
}
/**
 * Binary Tree representation.
 */
class Node {
    Node left;
    Node right;
    int value;
     
    public Node(int value) {
        left = null;
        right = null;
        this.value = value;
    }
}
