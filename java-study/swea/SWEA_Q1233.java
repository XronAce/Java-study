package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q1233 {
    public static class Node {
        private String data;
        private int leftNodeNum = 0;
        private int rightNodeNum = 0;

        public Node() {
        }

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, int LeftNodeNum) {
            this.data = data;
            this.leftNodeNum = leftNodeNum;
        }

        public Node(String data, int leftNodeNum, int rightNodeNum) {
            this.data = data;
            this.leftNodeNum = leftNodeNum;
            this.rightNodeNum = rightNodeNum;
        }

        public String getData() {
            return data;
        }

        public int getLeftNodeNum() {
            return leftNodeNum;
        }

        public int getRightNodeNum() {
            return rightNodeNum;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", leftNodeNum=" + leftNodeNum + ", rightNodeNum=" + rightNodeNum + "]";
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Node[] Nodes;
        int[] data;
        StringBuilder answer = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            Nodes = new Node[T + 1];
            data = new int[T + 1];

            for (int i = 1; i < T + 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                if (st.countTokens() == 2) {
                    @SuppressWarnings("unused")
                    int currentNodeNum = Integer.parseInt(st.nextToken());
                    Node node = new Node(st.nextToken());
                    Nodes[i] = node;
                } else if (st.countTokens() == 4) {
                    @SuppressWarnings("unused")
                    int currentNodeNum = Integer.parseInt(st.nextToken());
                    Node node = new Node(st.nextToken(), Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()));
                    Nodes[i] = node;
                } else {
                    @SuppressWarnings("unused")
                    int currentNodeNum = Integer.parseInt(st.nextToken());
                    Node node = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
                    Nodes[i] = node;
                }
            }

            boolean isPossible = true;

            for (int i = T; i >= 1; i--) {
                if (Nodes[i].getLeftNodeNum() == 0) { // if Nodes[i] is a leaf node
                    try {
                        data[i] = Integer.parseInt(Nodes[i].getData());
                    } catch (NumberFormatException e) {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (Nodes[i].getData() == "+") {
                        data[i] = data[Nodes[i].getLeftNodeNum()] + data[Nodes[i].getRightNodeNum()];
                    } else if (Nodes[i].getData() == "-") {
                        data[i] = data[Nodes[i].getLeftNodeNum()] - data[Nodes[i].getRightNodeNum()];
                    } else if (Nodes[i].getData() == "*") {
                        data[i] = data[Nodes[i].getLeftNodeNum()] * data[Nodes[i].getRightNodeNum()];
                    } else if (Nodes[i].getData() == "/") {
                        data[i] = data[Nodes[i].getLeftNodeNum()] / data[Nodes[i].getRightNodeNum()];
                    }
                }
            }

            if (isPossible) {
                answer.append("#" + test_case + " " + 1 + "\n");
            } else {
                answer.append("#" + test_case + " " + 0 + "\n");
            }

        }
        System.out.println(answer);

    }
}
