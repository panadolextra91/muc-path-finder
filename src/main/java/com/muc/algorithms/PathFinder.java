package com.muc.algorithms;

import com.muc.models.Map;
import com.muc.models.Node;
import java.util.List;

public interface PathFinder {
    List<Node> findPath(Map map, Node start, Node target);
}
