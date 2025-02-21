package Feb18;
import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, voteMap.get(candidate));
    }

    public void displayResults() {
        System.out.println("Votes in Sorted Order: " + sortedVotes);
        System.out.println("Votes in Order of Casting: " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");

        voting.displayResults();
    }
}
