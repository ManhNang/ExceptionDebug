import java.util.Scanner;

class IllegalTriangleException extends RuntimeException {
    IllegalTriangleException() {
        super("Ba cạnh nhập vào không tạo thành một tam giác hợp lệ!");
    }

    IllegalTriangleException(String message) {
        super(message);
    }
}

public class TriangleCheck {
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Giá trị các cạnh phải lớn hơn 0!");
        }

        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập vào cạnh thứ nhất: ");
            double side1 = scanner.nextDouble();
            System.out.print("Nhập vào cạnh thứ hai: ");
            double side2 = scanner.nextDouble();
            System.out.print("Nhập vào cạnh thứ ba: ");
            double side3 = scanner.nextDouble();

            checkTriangle(side1, side2, side3);
            System.out.println("Ba cạnh " + side1 + ", " + side2 + ", " + side3 + " tạo thành một tam giác hợp lệ.");
        } catch (IllegalTriangleException e) {
            System.err.println("Lỗi hình học: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi nhập dữ liệu: Vui lòng chỉ nhập số thực!");
        } finally {
            scanner.close();
        }
    }

}
