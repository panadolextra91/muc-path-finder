package com.muc.models;

public class Node implements Comparable<Node> {
    public int x, y;
    public int distance;
    public Node parent;
    public char type;

    public Node(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
