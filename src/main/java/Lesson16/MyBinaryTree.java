package Lesson16;

public class MyBinaryTree {
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

    public int depth (){
        return root.depth();
    }

    static class Vortex {
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

        public int countVertices() {
            return 1 +
                    (left == null ? 0 : left.countVertices()) +
                    (right == null ? 0 : right.countVertices()
                    );
        }
        //Если дерево пусто, выведите -1.
        //В противном случае выполните следующие действия:
        //Рекурсивно вычислить высоту левого поддерева.
        //Рекурсивно вычислить высоту правого поддерева.
        //Обновите высоту текущего узла, добавив 1 к максимальной из двух высот, полученных на предыдущем шаге. Сохраните высоту в переменной, скажем, ans .
        //Если текущий узел равен заданному узлу K, выведите значение ans в качестве требуемого ответа.
        public int depth()
        {
            // вернуть глубину дерева
            return 1 + Math.max(
                    (left == null ? 0 : left.depth()),
                    (right == null ? 0 : right.depth())
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
    } // окончание класса Vortex

    private Vortex addRecursive(Vortex current, int value){
        if(current == null)
            return new Vortex(value);

        // value == current.value - возвращаем current вершину
        // value < current.value - добавляем вершину куда-то слева
        // value > current.value - добавляем вершину куда-то справа
        if(value < current.value)
        {
            current.left = addRecursive(current.left, value);
        }
        else if(value > current.value)
        {
            current.right = addRecursive(current.right, value);
        }
//        else { // value == current.value
//            return current;
//        }
        return current;
    }

    public void add (int value){
    root = addRecursive(root, value);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}



