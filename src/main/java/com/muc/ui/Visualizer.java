package com.muc.ui;

import com.muc.models.Map;
import com.muc.models.Node;
import java.util.List;

public class Visualizer {
    private static final String ANSI_PINK = "\u001B[35m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_EMERGENCY = "\u001B[41;37m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CLEAR = "\033[H\033[2J";

    public void showGrouchyMuc() {
        System.out.println(ANSI_PINK + "|\\__/,|   (`\\");
        System.out.println(" _.|o o  |_   ) )");
        System.out.println("-(((---(((--------");
        System.out.println("  MUC DANG QUAU!!!" + ANSI_RESET);
    }

    public void renderWithEmojis(Map map, Node currentMuc) {
        Node[][] grid = map.getGrid();
        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {
                Node node = grid[i][j];
                if (node.equals(currentMuc)) {
                    System.out.print(ANSI_PINK + "🐱 " + ANSI_RESET);
                } else if (node.type == 'P') {
                    System.out.print(ANSI_YELLOW + "🍱 " + ANSI_RESET);
                } else if (node.type == 'S') {
                    System.out.print("🛋️ ");
                } else if (node.type == '#') {
                    System.out.print("🧱 ");
                } else if (node.type == 'A') {
                    System.out.print("👿 ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void animate(Map map, List<Node> path) {
        if (path.isEmpty()) {
            System.out.println("No path found for Mực!");
            showGrouchyMuc();
            return;
        }

        try {
            for (Node step : path) {
                System.out.print(ANSI_CLEAR);
                System.out.flush();
                System.out.println("🌸 MỰC ĐANG ĐI TÌM PATE... 🌸");
                renderWithEmojis(map, step);
                
                if (step.type == 'A') {
                    Thread.sleep(100); // Đứng hình!
                    System.out.println("\n" + ANSI_EMERGENCY + "[!] EMERGENCY: Apu bế Mực đi tắm rồi mẹ Thư ơi!!! 😭🚿" + ANSI_RESET);
                    return; // Game Over
                }
                
                Thread.sleep(250);
            }
            System.out.println("\n🎉 Mực đã tìm thấy Pate rồi! Chúc Mực ngon miệng! 🐱🍱");
        } catch (InterruptedException e) {
            System.err.println("Animation bị gián đoạn: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
