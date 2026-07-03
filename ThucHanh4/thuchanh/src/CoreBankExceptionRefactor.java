import java.io.File;

class MissingDocumentException extends Exception {
    public MissingDocumentException(String message) {
        super(message);
    }
}

public class CoreBankExceptionRefactor {
    public void registerAccount(String name, int age, String idCardFilePath) throws MissingDocumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Lỗi: Khách hàng chưa đủ 18 tuổi!");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Lỗi: Tên khách hàng không được để trống!");
        }

        File file = new File(idCardFilePath);
        if (!file.exists()) {
            throw new MissingDocumentException("Hệ thống: Không tìm thấy file CCCD trên máy chủ, vui lòng tải lại!");
        }

        System.out.println("Tạo tài khoản thành công cho: " + name);
    }

    public static void main(String[] args) {
        CoreBankExceptionRefactor service = new CoreBankExceptionRefactor();

        try {
            service.registerAccount("Nguyen Van A", 18, "path/to/valid/file.png");
        } catch (MissingDocumentException e) {
            System.out.println("Xử lý ngoại lệ: " + e.getMessage());
        }
    }
}