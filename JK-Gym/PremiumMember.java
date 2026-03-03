/**
 * Represents a premium member of the gym with additional benefits and features.
 * Premium members have access to personal trainers and special discount options.
 * Extends the base GymMember class with premium-specific functionality.
 * @author Kushal Jamarkattel
 */
public class PremiumMember extends GymMember {
    /** Fixed charge for premium membership */
    private final double premiumCharge;
    /** Name of assigned personal trainer */
    private String personalTrainer;
    /** Indicates if full payment has been made */
    private boolean isFullPayment;
    /** Total amount paid so far */
    private double paidAmount;
    /** Calculated discount amount */
    private double discountAmount;

    /**
     * Constructs a new premium member with specified details.
     *
     * @param id Unique identifier for the member
     * @param name Full name of the member
     * @param location Member's residential location
     * @param phone Member's contact number
     * @param email Member's email address
     * @param gender Member's gender
     * @param DOB Member's date of birth
     * @param membershipStartDate Date when membership started
     * @param personalTrainer Name of assigned personal trainer
     */
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, 
                        String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /**
     * @return The fixed premium membership charge
     */
    public double getPremiumCharge() {
        return premiumCharge;
    }

    /**
     * @return Name of the assigned personal trainer
     */
    public String getPersonalTrainer() {
        return personalTrainer;
    }

    /**
     * @return True if full payment has been made, false otherwise
     */
    public boolean isFullPayment() {
        return isFullPayment;
    }

    /**
     * @return Total amount paid so far
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * @return Calculated discount amount
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Records attendance and updates loyalty points for premium member.
     * Premium members get 10 loyalty points per attendance.
     */
    @Override
    public void markAttendance() {
        setAttendance(getAttendance() + 1);
        setLoyaltyPoints(getLoyaltyPoints() + 10);
    }

    /**
     * Processes payment for premium membership.
     * Tracks partial payments and updates payment status.
     *
     * @param paidAmount Amount being paid in current transaction
     * @return Status message indicating payment result
     */
    public String payDueAmount(double paidAmount) {
        if (paidAmount <= 0) {
            return "Payment must be greater than Rs.0";
        }
        if (this.isFullPayment) {
            return "Hello, Your Payment is already complete. No further payment is required.";
        }
    
        if (this.paidAmount > premiumCharge) {
            return "Your payment exceeds the premium charge. Only " + premiumCharge + " is required.";
        }
    
        this.paidAmount += paidAmount;
    
        if (this.paidAmount == premiumCharge) { 
            isFullPayment = true;
            calculateDiscount();
        }
    
        return ("Paid: " + this.paidAmount + ". Remaining: " + (premiumCharge - this.paidAmount));
    }

    /**
     * Calculates applicable discount for premium member.
     * 10% discount is applied if full payment is made.
     */
    public void calculateDiscount() {
        if (this.isFullPayment) {
            this.discountAmount = 0.10 * premiumCharge;
            System.out.println("Calculated Discount: " + this.discountAmount);
        } else {
            this.discountAmount = 0;
            System.out.println("No discount applicable. Payment is not complete.");
        }
    }

    /**
     * Reverts premium membership status.
     * Resets all premium-specific attributes to default values.
     */
    public void revertPremiumMember() {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /**
     * Displays all premium member information including
     * payment status, trainer details, and applicable discounts.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Amount Paid: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount to be Paid: " + remainingAmount);
        if (isFullPayment) {
        System.out.println("Discount Amount: " + discountAmount);
        }
    }
}
