package com.muc;

import com.muc.models.Map;
import com.muc.models.Node;
import com.muc.algorithms.*;
import com.muc.ui.Visualizer;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Visualizer visualizer = new Visualizer();
        
        // --- TEST 1: WINNING PATH ---
        runScenario("src/main/resources/maps/weighted_map.txt", new DijkstraFinder(), "DIJKSTRA - SOFA SURVIVAL", visualizer);

        // --- TEST 2: APU TRAP ---
        runScenario("src/main/resources/maps/apu_trap.txt", new DijkstraFinder(), "DIJKSTRA - APU TRAP", visualizer);

        // --- TEST 3: NO PATH (GROUCHY MUC) ---
        runScenario("src/main/resources/maps/no_path.txt", new BFSFinder(), "BFS - NO PATH FOUND", visualizer);
    }

    private static void runScenario(String mapPath, PathFinder finder, String title, Visualizer visualizer) {
        Map map = new Map();
        try {
            System.out.println("\n--- 🌸 SCENARIO: " + title + " ---");
            map.loadMap(mapPath);
            Node start = map.getStartNode();
            Node target = map.getTargetNode();
            
            if (start != null && target != null) {
                List<Node> path = finder.findPath(map, start, target);
                visualizer.animate(map, path);
                Thread.sleep(1500); // Chờ xíu trước khi sang scenario mới
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
