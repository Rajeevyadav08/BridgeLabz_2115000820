package Feb18;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    Date expiryDate;

    Policy(String policyNumber, String policyHolder, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return policyNumber + " - " + policyHolder + " (Expiry: " + expiryDate + ")";
    }
}

public class InsurancePolicySystem {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<Date, Policy> expirySortedMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        expirySortedMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon(int days) {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date targetDate = cal.getTime();

        for (Map.Entry<Date, Policy> entry : expirySortedMap.headMap(targetDate, true).entrySet()) {
            expiringPolicies.add(entry.getValue());
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyHolder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(policyHolder)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        Iterator<Map.Entry<Date, Policy>> iterator = expirySortedMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, Policy> entry = iterator.next();
            if (entry.getKey().before(currentDate)) {
                policyMap.remove(entry.getValue().policyNumber);
                orderedPolicyMap.remove(entry.getValue().policyNumber);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        Calendar cal = Calendar.getInstance();
        
        cal.set(2025, Calendar.MARCH, 10);
        Policy p1 = new Policy("P123", "Alice", cal.getTime());

        cal.set(2025, Calendar.FEBRUARY, 20);
        Policy p2 = new Policy("P456", "Bob", cal.getTime());

        cal.set(2024, Calendar.DECEMBER, 28);
        Policy p3 = new Policy("P789", "Alice", cal.getTime());

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);

        System.out.println("Policy by Number (P123): " + system.getPolicyByNumber("P123"));
        System.out.println("Policies expiring in 30 days: " + system.getPoliciesExpiringSoon(30));
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + system.policyMap);
    }
}
