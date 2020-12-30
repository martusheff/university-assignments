public class OnCampusStudent extends Student {

    public static int RESIDENT = 1;
    public static int NON_RESIDENT = 2;
    private int mResident;
    private double mProgramFee;

    OnCampusStudent(String pId, String pFirstName, String pLastName){
        super(pId,pFirstName,pLastName);
    }

    @Override
    void calcTuition() {
        double tuition = 0;
        int credits = getCredits();
        if (getResidency() == RESIDENT){
            tuition += TuitionConstants.ONCAMP_RES_BASE;
        } else {
            tuition += TuitionConstants.ONCAMP_NONRES_BASE;
        }

        tuition += getProgramFee();

        if (credits > TuitionConstants.ONCAMP_MAX_CREDITS){
            tuition += (credits - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }

        setTuition(tuition);

    }

    public double getProgramFee() {
        return mProgramFee;
    }

    public int getResidency() {
        return mResident;
    }

    public void setProgramFee(double pProgramFee){
        mProgramFee = pProgramFee;
    }

    public void setResidency(int pResidency){
        mResident = pResidency;
    }
}
