package com.muc.algorithms;

import com.muc.models.Map;
import com.muc.models.Node;
import java.util.*;

public class DijkstraFinder implements PathFinder {
    @Override
    public List<Node> findPath(Map map, Node start, Node target) {
        map.resetNodes();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        start.distance = 0;
        pq.add(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.equals(target)) {
                return tracePath(start, target);
            }

            for (Node neighbor : map.getNeighbors(current)) {
                // S: Sofa (weight 5), others weight 1
                int weight = (neighbor.type == 'S' ? 5 : 1);
                int newDist = current.distance + weight;

                if (newDist < neighbor.distance) {
                    neighbor.distance = newDist;
                    neighbor.parent = current;
                    pq.add(neighbor); // Lazy Removal: re-add to re-sort
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Node> tracePath(Node start, Node target) {
        if (target.parent == null && !target.equals(start)) {
            return Collections.emptyList();
        }
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
