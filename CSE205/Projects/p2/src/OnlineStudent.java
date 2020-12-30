public class OnlineStudent extends Student {
    private boolean mTechFee;

    OnlineStudent(String pId, String pFirstName, String pLastName){
        super(pId,pFirstName,pLastName);
    }

    @Override
    void calcTuition() {
        double tuition = 0;

        tuition += getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

        if(getTechFee() == true) {
            tuition += TuitionConstants.ONLINE_TECH_FEE;
        }

        setTuition(tuition);
    }

    public boolean getTechFee(){
        return mTechFee;
    }

    public void setTechFee(boolean pTechFee){
        mTechFee = pTechFee;
    }
}
