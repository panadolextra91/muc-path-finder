# 🌸 KẾ HOẠCH PROJECT DSA: MỰC PATH FINDER (JAVA EDITION)

## 📋 Tổng quan
- **Mục tiêu**: Tìm đường đi ngắn nhất cho Mực (M) tới bát Pate (P) trong một mê cung đầy vật cản (Apu, Sofa, Tường).
- **Công nghệ**: Java (Hệ Console/Terminal).
- **DSA trọng tâm**: 2D Array, Graph (Adjacency List), Queue/PriorityQueue, Thuật toán BFS/Dijkstra.

---

## 🟢 GIAI ĐOẠN 1: XÂY DỰNG BỘ KHUNG (DATA STRUCTURES)
Con AI coder phải định nghĩa được "thế giới" của Mực trước.

- **Task 1.1: Tạo class Node (hoặc Point)**
    - Lưu tọa độ $(x, y)$.
    - Lưu các thông tin như `distance`, `parent` (để truy vết đường đi).

- **Task 1.2: Tạo class Map**
    - Chứa một mảng 2D `char[][]`.
    - Các ký hiệu:
        - `#`: Tường/Vật cản.
        - `.`: Đường đi trống.
        - `M`: Vị trí Mực.
        - `P`: Vị trí Pate.

- **Task 1.3: Viết hàm loadMap()**
    - Đọc bản đồ từ một file `.txt` (để khoe kỹ năng File I/O với giảng viên).

---

## 🟡 GIAI ĐOẠN 2: LUYỆN NÃO CHO MỰC (CORE ALGORITHM)
Đây là phần mẹ cần "ép" con AI code chuẩn nhất để ăn điểm DSA.

- **Task 2.1: Triển khai thuật toán BFS (Breadth-First Search)**
    - Dành cho bản đồ không trọng số (mọi bước đi đều tốn sức như nhau).
    - Sử dụng `java.util.Queue`.

- **Task 2.2: Triển khai thuật toán Dijkstra (Nâng cao - Điểm A+)**
    - Thêm khái niệm "độ khó của địa hình" (ví dụ: đi qua bãi cát thì chậm hơn đi trên sàn gỗ).
    - Sử dụng `java.util.PriorityQueue`.

- **Task 2.3: Viết hàm tracePath()**
    - Lưu lại danh sách các bước đi từ `P` ngược về `M` sau khi đã tìm thấy đường.

---

## 🔴 GIAI ĐOẠN 3: HIỂN THỊ "VÔ TRI" (TERMINAL VISUALIZATION)
Làm cho project trông giống một cái game thực thụ.

- **Task 3.1: Viết hàm render()**
    - In mảng 2D ra console.

- **Task 3.2: Tạo hiệu ứng Animation**
    - Dùng vòng lặp chạy qua danh sách đường đi đã tìm được.
    - Mỗi bước đi:
        1. Cập nhật vị trí `M`.
        2. Xóa màn hình (`System.out.print("\033[H\033[2J")`).
        3. In lại map.
    - Dùng `Thread.sleep(200)` để Mực di chuyển từ từ.

---

## 🟣 GIAI ĐOẠN 4: TÍNH NĂNG "CẠP ĐẦU" (BONUS FEATURES)
Thêm mắm muối cho project mang đậm phong cách mẹ Thư.

- **Task 4.1: Vật cản Apu**
    - Random một vài vị trí chữ `A` trên map.
    - Nếu Mực chạm vào `A`, in ra: *"Mẹ Thư cứu con, Apu bế con đi tắm rồi!"* -> **Game Over**.

- **Task 4.2: Chế độ "Quạu"**
    - Nếu không tìm thấy đường đi (Pate bị bao vây bởi tường), in ra ASCII Art cái mặt Mực quạu đeo mà mẹ mới cài làm hình nền iTerm2 đó!
