package Lesson28.HomeWork.Tree;

public class GenericBinaryTree <T extends Comparable<T>>{

    private Vortex<T> root;

    public GenericBinaryTree() {
    }

    public GenericBinaryTree(Vortex<T> root) {
        this.root = root;
    }

    public int countVertices() {
        return root.countVertices();
    }

    public int depth() {
        return root.depth();
    }

    static class Vortex<T> {
        Vortex<T> left;
        Vortex<T> right;
        T value;

        public Vortex(T value) {
            this.value = value;
        }

        public Vortex(T value, Vortex<T> left, Vortex<T> right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int countVertices() {
            return 1 +
                    (left == null ? 0 : left.countVertices()) +
                    (right == null ? 0 : right.countVertices());
        }

        public int depth() {
            // ������� �������
            return 1 + Math.max(
                    right == null ? 0 : right.depth(),
                    left == null ? 0 : left.depth()
            );
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("{");
            b.append("\"left\":");
            b.append(left == null ? "{}" : left.toString());
            b.append(", \"value\":");
            b.append(value);
            b.append(",");
            b.append("\"right\":");
            b.append(right == null ? "{}" : right.toString());
            b.append("}");
            return b.toString();
        }


    }  // end of class Vortex

    private Vortex<T> addRecursive(Vortex<T> current, T value) {
        if (current == null) {
            return new Vortex<T>(value);
        }

        // value == current.value - ���������� current �������
        // value < current.value - ��������� ������� ����-�� �����
        // value > current.value - ��������� ������� ����-�� ������

//        if (value < current.value) {
//            current.left = addRecursive(current.left, value);
//        } else if (value > current.value) {
//            current.right = addRecursive(current.right, value);
//        }
//        return current;

        // � �������������� compareTo()
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
