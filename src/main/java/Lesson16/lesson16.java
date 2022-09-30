package Lesson16;
public class lesson16 {
    // Graphs. Trees, Binary Trees, Tree Map.
    // Граф это совокупность вершин (Vortex) и объединящих их ребер (Edge)
    // Ребро это соединение двух вершин
    // Граф называется связным (fully connected) если из любой его вершины можно добраться по
    // ребрам до любой другой вершины

    // Граф циклический если из какой-нибудь его вершины можно в нее попасть по ребрам

    // Граф называется деревом если он является связным и ациклическим

    // лемма = утверждение в дереве количество ребер равно количеству вершин - 1

    // бинарное дерево (binary tree) дерево где у кажой вершины может быть максимум две
    // дочерних вершины
    public static void main(String[] args) {
        MyBinaryTree.Vortex v5 = new MyBinaryTree.Vortex(5);
        MyBinaryTree.Vortex v3 = new MyBinaryTree.Vortex(3);
        MyBinaryTree.Vortex v4 = new MyBinaryTree.Vortex(4);
        MyBinaryTree.Vortex v1 = new MyBinaryTree.Vortex(1, v3, v4);
        MyBinaryTree.Vortex v2 = new MyBinaryTree.Vortex(2, null, v5);
        MyBinaryTree.Vortex v0 = new MyBinaryTree.Vortex(0, v1, v2);

        MyBinaryTree tree = new MyBinaryTree(v0);
        System.out.println(tree.countVertices());

        System.out.println(tree);
        /*
            {
                "name": "Max Kotkov",
                "age": 34,
                "faculty": "physics",
                "friend": {
                    "lastname": "Smith"
                }
            }
         */
        System.out.println(tree.depth());
    }
    }
