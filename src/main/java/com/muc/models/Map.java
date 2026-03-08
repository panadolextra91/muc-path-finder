package com.muc.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private Node[][] grid;
    private int rows;
    private int cols;
    private Node startNode;
    private Node targetNode;

    public Map() {}

    public void loadMap(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            if (firstLine == null) throw new IOException("Empty map file");
            
            String[] dims = firstLine.trim().split("\\s+");
            this.rows = Integer.parseInt(dims[0]);
            this.cols = Integer.parseInt(dims[1]);
            this.grid = new Node[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = br.readLine();
                if (line == null) break;
                // Remove spaces if map is formatted with spaces
                String cleanLine = line.replaceAll("\\s+", "");
                for (int j = 0; j < cols; j++) {
                    char type = cleanLine.charAt(j);
                    Node node = new Node(i, j, type);
                    grid[i][j] = node;
                    if (type == 'M') startNode = node;
                    else if (type == 'P') targetNode = node;
                }
            }
        }
    }

    public void resetNodes() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j].distance = Integer.MAX_VALUE;
                grid[i][j].parent = null;
            }
        }
    }

    public List<Node> getNeighbors(Node n) {
        List<Node> neighbors = new ArrayList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up
        for (int[] d : dirs) {
            int nx = n.x + d[0];
            int ny = n.y + d[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                if (grid[nx][ny].type != '#') {
                    neighbors.add(grid[nx][ny]);
                }
            }
        }
        return neighbors;
    }

    public void render() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].type + " ");
            }
            System.out.println();
        }
    }

    public Node getStartNode() { return startNode; }
    public Node getTargetNode() { return targetNode; }
    public Node[][] getGrid() { return grid; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
