interface Confidential {
}

class PublicDocument {
}

class PrivateDocument implements Confidential {
}

class SecretDocument implements Confidential {
}

public class confidentialdocuments {
    public static void main(String[] args) {
        PublicDocument d1 = new PublicDocument();
        PrivateDocument d2 = new PrivateDocument();
        SecretDocument d3 = new SecretDocument();

        System.out.println("Public Document: " +
                (d1 instanceof Confidential));

        System.out.println("Private Document: " +
                (d2 instanceof Confidential));

        System.out.println("Secret Document: " +
                (d3 instanceof Confidential));
    }
}
