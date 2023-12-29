package dto;

public class AuthDto {  // Dto - предназначен для передачи данных между подсистемами, чтобы не передавать сущности напрямую
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}