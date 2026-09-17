import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;

    public Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    public int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class CandidatePlacementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of candidates and number to select:");
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n <= 0 || k < 0 || k > n) {
            System.out.println("Invalid input: k must be between 0 and n.");
            sc.close();
            return;
        }

        Candidate[] candidates = new Candidate[n];

        System.out.println("Enter each candidate: ID name aptitude technical communication");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();
            candidates[i] = new Candidate(id, name, aptitude, technical, communication);
        }

        // Sort by total score descending; if tie, smaller Candidate ID first
        Arrays.sort(candidates, new Comparator<Candidate>() {
            public int compare(Candidate a, Candidate b) {
                if (b.getTotalScore() != a.getTotalScore()) {
                    return b.getTotalScore() - a.getTotalScore();
                }
                return a.candidateId - b.candidateId;
            }
        });

        for (int i = 0; i < k; i++) {
            Candidate c = candidates[i];
            System.out.println(c.candidateId + " " + c.name + " " + c.getTotalScore());
        }

        sc.close();
    }
}

// INPUT OUTPUT 

Enter each candidate: ID name aptitude technical communication
101 Arun 80 90 70
102 Priya 90 85 80
103 Ravi 70 95 75
104 Divya 85 85 85
105 Kiran 80 80 70
102 Priya 255
104 Divya 255
101 Arun 240