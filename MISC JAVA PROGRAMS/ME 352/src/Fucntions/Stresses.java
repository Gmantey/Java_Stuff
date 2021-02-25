package Fucntions;

public class Stresses {

    double diameter;
    double moment;
    double torque;

    public Stresses(double diameter, double moment, double torque) {
        this.diameter = diameter;
        this.moment = moment;
        this.torque = torque;
    }

    public Stresses(double diameter) {
        this.diameter = diameter;
    }

    public double find_J() {
        return (Math.PI * Math.pow(getDiameter(), 4)) / 32;
    }

    public double find_I() {
        return (Math.PI * Math.pow(getDiameter(), 4)) / 64;
    }

    public double sigma_o_Moment() {

        double c = getDiameter() / 2;

        return (getMoment() * c) / find_I();
    }

    public double tau_o() {
        double c = getDiameter() / 2;
        return (getTorque() * c) / find_J();
    }

    public void goodmanCriterion_Moment(double max, double min, float k) {

        double sigmaMax = (sigma_o_Moment() / getMoment()) * max * k;
        double sigmaMin = (sigma_o_Moment() / getMoment()) * min * k;
        double sigma_a = Math.abs(sigmaMax - sigmaMin) / 2;
        double sigma_m = (sigmaMax + sigmaMin) / 2;

        System.out.println("==========GoodMan_Repeated Moment==========");
        System.out.printf("SigmaMax =   %6.2e\nSigmaMin =   %6.2e\nSigma_A =   %6.2e\nSigma_M =   %6.2e\n",
                sigmaMax, sigmaMin, sigma_a, sigma_m);
    }

    public void goodmanCriterion_Torque(double max, double min, float k) {

        double tauMax = (tau_o() / getTorque()) * max * k;
        double tauMin = (tau_o() / getMoment()) * min * k;
        double tau_a = Math.abs(tauMax - tauMin) / 2;
        double tau_m = (tauMax + tauMin) / 2;
        System.out.println("==========GoodMan_Repeated Shear==========");
        System.out.printf("Tau_Max =   %6.2e\nTau_Min =   %6.2e\nTau_A =   %6.2e\nTau_M =   %6.2e\n",
                tauMax, tauMin, tau_a, tau_m);


    }

    public double getDiameter() {
        return diameter;
    }

    public double getMoment() {
        return moment;
    }

    public double getTorque() {
        return torque;
    }
}
