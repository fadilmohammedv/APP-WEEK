interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void fingerprint();
    void faceRecognition();
}

class BankingApplication implements AdvancedSecurity {
    public void login() {
        System.out.println("Login successful");
    }

    public void logout() {
        System.out.println("Logout successful");
    }

    public void fingerprint() {
        System.out.println("Fingerprint authentication successful");
    }

    public void faceRecognition() {
        System.out.println("Face recognition successful");
    }
}

public class bankingsecurity {
    public static void main(String[] args) {
        BankingApplication b = new BankingApplication();

        b.login();
        b.fingerprint();
        b.faceRecognition();
        b.logout();
    }
}
