package com.muc.algorithms;

import com.muc.models.Map;
import com.muc.models.Node;
import java.util.*;

public class BFSFinder implements PathFinder {
    @Override
    public List<Node> findPath(Map map, Node start, Node target) {
        map.resetNodes();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        start.distance = 0;
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(target)) {
                return tracePath(start, target);
            }

            for (Node neighbor : map.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    neighbor.parent = current;
                    neighbor.distance = current.distance + 1;
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Node> tracePath(Node start, Node target) {
        List<Node> path = new ArrayList<>();
        Node curr = target;
        while (curr != null) {
            path.add(0, curr);
            if (curr.equals(start)) break;
            curr = curr.parent;
        }
        return path;
    }
}
