import java.io.*;
import java.util.*;

/**
 * This is the basic setup for loading data to then attempt to solve Problem 18 (and 67)
 * from Project Euler (https://projecteuler.net/problem=18)
 *
 * TODO: implement the loadTriangle method as described below
 *
 * Extra: Solve problems 18 and 67 [not for credit]
 *
 */
public class Problem18 {

    public static void main(String[] args) {
        try {
            NumberTriangle mt = loadTriangle("week3git/input_tree.txt");

            // you can add code here if you want to try to solve
            // Problem 18 from project Euler [not for credit]

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // and you can also try Problem 67 [not for credit]
    }

    /** Reads in the NumberTriangle structure from a file.
     *
     * You may assume that it is a valid format with a height of at least 1,
     * so there is at least one line with a number on it to start the file.
     *
     * See input_tree.txt for an example NumberTriangle format.
     *
     * The first row is the root of the NumberTriangle (call it 0).
     * The second line contains the two children of the root (call them 1L and 1R).
     * The third line contains the three numbers corresponding to:
     *      - the left child of 1L, call it (2LL)
     *      - the right child of 1L, call it (2LR)
     *      - the left child of 1R, call it (2RL)
     *      - the right child of 1R, call it (2RR)
     *   NOTE: 2RL and 2LR will correspond to the same underlying NumberTriangle object.
     *
     *   Hint 0: Start by making a plan and scaffolding what you plan to do; if you
     *           are still finding it hard to "think in Java", write some comments describing
     *           what you want to do or try implementing some of the logic in Python.
     *
     *   Hint 1: Base your file reading code off what was shown in lecture last
     *           week for reading a csv file line by line and splitting strings.
     *
     *   Hint 2: Think about what you need to keep track of on each iteration of the loop and
     *           make appropriate variables to store those things.
     *
     *   Hint 3: Related to 2, think about how to connect NumberTriangle objects between layers in the
     *           structure.
     *
     *   Hint 4: If you are still stuck, it might help to think of a sub problem you can solve,
     *           then design the logic of your solution around that helper, which you can
     *           implement separately. This kind of decomposition of a problem can make it much
     *           more manageable.
     *
     * @param fname the file to load the NumberTriangle structure from
     * @return the topmost NumberTriangle object in the NumberTriangle structure read from the specified file
     * @throws IOException may occur if an issue reading the file occurs
     */
    public static NumberTriangle loadTriangle(String fname) throws IOException {
        File f = new File(fname);

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

            List<NumberTriangle> parents = new ArrayList<NumberTriangle>();
            String row;
            NumberTriangle root = new NumberTriangle(Integer.parseInt(reader.readLine()));
            parents.add(root);
            List<NumberTriangle> children = new ArrayList<>();
            String[] values = reader.readLine().split(" ");

            int i = 0;
            for(String value: values) {
                int num = Integer.parseInt(value);
                NumberTriangle newNum = new NumberTriangle(num);
                if (i == 0) {
                    root.setLeft(newNum);
                    i++;
                } else {
                    root.setRight(newNum);
                }
                parents.add(newNum);
            }
            parents.remove(0);

            while ((row = reader.readLine()) != null) {
                values = row.split(" ");

                for(String value: values){
                    int num = Integer.parseInt(value);
                    NumberTriangle newNum = new NumberTriangle(num);
                    children.add(newNum);

                    if (children.size() == 2) {

                        // set child nodes as new parent nodes
                        parents.add(children.get(0));
                        parents.add(children.get(1));
                        // set child nodes
                        parents.get(0).setLeft(children.get(0));
                        parents.get(0).setRight(children.get(1));

                        // remove child and parent
                        parents.remove(0);
                        children.remove(0);
                    }
                }


                }
            return root;
            }
        }
    }

