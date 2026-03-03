/**
 * Represents a regular member of the gym with basic membership features.
 * Regular members have tiered plans (Basic, Standard, Deluxe) and can upgrade based on attendance.
 * Extends the base GymMember class with regular member-specific functionality.
 * @author Kushal Jamarkattel
 */
public class RegularMember extends GymMember {
    /** Maximum attendance required for plan upgrade eligibility */
    private final int attendanceLimit;
    /** Indicates if member is eligible for plan upgrade */
    private boolean isEligibleForUpgrade;
    /** Reason for membership removal/cancellation */
    private String removalReason;
    /** Source through which member was referred */
    private String referralSource;
    /** Current membership plan type */
    private String plan;
    /** Current plan price */
    private double price;

    /**
     * Constructs a new regular member with specified details.
     *
     * @param id Unique identifier for the member
     * @param name Full name of the member
     * @param location Member's residential location
     * @param phone Member's contact number
     * @param email Member's email address
     * @param gender Member's gender
     * @param DOB Member's date of birth
     * @param membershipStartDate Date when membership started
     * @param referralSource Source of member referral
     * @param plan Initial membership plan
     */
    public RegularMember(int id, String name, String location, String phone, String email, String gender, 
                        String DOB, String membershipStartDate, String referralSource, String plan) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.referralSource = referralSource;
        this.plan = "basic";
        this.price = 6500;
    }

    /**
     * @return Maximum attendance limit for upgrade eligibility
     */
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Records attendance and updates loyalty points.
     * Regular members get 5 loyalty points per attendance.
     * Checks upgrade eligibility based on attendance limit.
     */
    @Override
    public void markAttendance() {
        setAttendance(getAttendance() + 1);
        setLoyaltyPoints(getLoyaltyPoints() + 5);
        if (getAttendance() >= attendanceLimit) {
            isEligibleForUpgrade = true;
        }
    }

    /**
     * Gets the price for a specific membership plan.
     * @param plan Plan type (basic, standard, deluxe)
     * @return Price of the specified plan, -1 if invalid plan
     */
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    /**
     * Updates the upgrade eligibility status.
     * @param isEligibleForUpgrade New eligibility status
     */
    public void setEligibleForUpgrade(boolean isEligibleForUpgrade) {
        this.isEligibleForUpgrade = isEligibleForUpgrade;
    }

    /**
     * Attempts to upgrade member's plan to a new tier.
     * Validates eligibility and plan validity before upgrade.
     *
     * @param newPlan Plan to upgrade to
     * @return Status message indicating upgrade result
     */
    public String upgradePlan(String newPlan) {
        if (newPlan.equalsIgnoreCase(this.plan)) {
            return "You have already subscribed to the " + newPlan + " plan.";
        }
        if (!isEligibleForUpgrade) {
            return "Sorry, You are not eligible for an upgrade yet.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Sorry, Invalid plan selected.";
        }
        
        // ✅ Update the plan and price
        this.plan = newPlan;
        this.price = newPrice;
    
        return "Plan upgraded successfully to " + newPlan + ".";
    }

    /**
     * Reverts member to basic plan and resets membership status.
     * Records reason for membership reversion.
     *
     * @param removalReason Reason for reverting membership
     */
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    /**
     * Displays all regular member information including
     * plan details, price, and removal reason if applicable.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}