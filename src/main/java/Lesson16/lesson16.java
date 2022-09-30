package Lesson16;

public class lesson16 {
    // Graps
    public static void main(String[] args) {
        MyBinaryTree.Vortex v5 = new MyBinaryTree.Vortex(5);
        MyBinaryTree.Vortex v3 = new MyBinaryTree.Vortex(3);
        MyBinaryTree.Vortex v4 = new MyBinaryTree.Vortex(4);
        MyBinaryTree.Vortex v1 = new MyBinaryTree.Vortex(1, v3, v4);
        MyBinaryTree.Vortex v2 = new MyBinaryTree.Vortex(2, null, v5);
        MyBinaryTree.Vortex v0 = new MyBinaryTree.Vortex(0, v1, v2);

    }
    private static class Vortex {
        Vortex left;
        Vortex right;
        int value;

        public Vortex(int value) {
            this.value = value;
        }

        public Vortex(int value, Vortex left, Vortex right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    private Vortex root;

    public MyBinaryTree(Vortex root) {
        this.root = root;
    }

    public MyBinaryTree()
    {

    }
    public int countVertices()
    {
        return root.countVertices();
    }
    public int countVertices() {
        return 1 +
                (left == null ? 0 : left.countVertices()) +
                (right == null ? 0 : right.countVertices())
                ;
    }


}
