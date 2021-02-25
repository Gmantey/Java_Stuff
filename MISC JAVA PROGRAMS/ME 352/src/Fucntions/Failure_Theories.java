package Fucntions;

import java.io.*;

public class Failure_Theories {
    double sigmaX;
    double sigmaY;
    double sigmaZ;
    double txy;
    double tyz;
    double txz;

    public Failure_Theories() {
    }
    public Failure_Theories(double sigmaX, double sigmaY, double sigmaZ, double txy, double tyz, double txz) {
        this.sigmaX = sigmaX;
        this.sigmaY = sigmaY;
        this.sigmaZ = sigmaZ;
        this.txy = txy;
        this.tyz = tyz;
        this.txz = txz;
    }

    public void mssThoery_TauMax(double yieldStrength) {

        double sigma_Average = (getSigmaX() + getSigmaY()) / 2;
        double radius = Math.pow((getSigmaX() - getSigmaY()) / 2, 2) + (txy * txy);
        radius = Math.sqrt(radius);
        double p_stress1 = sigma_Average + radius;
        double p_stress2 = sigma_Average - radius;
        double p_stress3 = 0;
        double t_max = 0;

        if (p_stress1 > 0 && p_stress2 > 0) {
            p_stress3 = 0;
            t_max = Math.max(p_stress1, p_stress2) / 2;
            t_max = Math.abs(t_max);
        } else if (p_stress1 < 0 && p_stress2 < 0) {
            p_stress3 = 0;
            t_max = Math.min(p_stress1, p_stress2) / 2;
            t_max = Math.abs(t_max);
        } else if (p_stress1 > 0 && p_stress2 < 0) {
            t_max = radius;
        } else if (p_stress1 < 0 && p_stress2 > 0) {
            t_max = radius;
        } else if (p_stress1 == 0 || p_stress2 == 0) {
            t_max = radius;
        }

        System.out.println("==========Maximum Shear Stress==========");
        System.out.printf("Yield Strength: %7.2f\n", yieldStrength);
        System.out.printf("Tmax:      %7.2f[MPA]\nSigmaP1:   %7.2f[MPA]\nSigmaP2:   %7.2f\nSigmaP3:   %7.2f[MPA]\n",
                t_max, p_stress1, p_stress2, p_stress3);
        System.out.printf("Factor of Saftey (MSS)  : %.4f\n", (yieldStrength / (2 * t_max)));
    }

    public void deTheory(double yieldStrength) {

        double sigmaPrime = Math.pow(getSigmaX() - getSigmaY(), 2) + Math.pow(getSigmaY() - getSigmaZ(), 2) +
                Math.pow(getSigmaX() - getSigmaZ(), 2);
        sigmaPrime = sigmaPrime + (6 * Math.pow(getTxy(), 2) + Math.pow(getTyz(), 2) + Math.pow(getTxz(), 2));
        sigmaPrime = Math.sqrt(sigmaPrime / 2);
        System.out.println("==========Distortion Energy Theory==========");
        System.out.printf("With a Yield Strength of: %7.2f [MPA]\n", yieldStrength);
        System.out.printf("SigmaPrime              : %7.2f\n", sigmaPrime);
        System.out.printf("Factor of Saftey (DE)   : %.4f\n", yieldStrength / sigmaPrime);

    }

    public void materialProperties_HR(String type) throws IOException {
        FileReader fr = new FileReader("ME 352.txt");
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            }
            String[] readline = line.split(" ");
            if (readline[0].equals(type)) {
                System.out.println("AISI No.    Processing     ---Tensile Stress---      ---Yield Stress---");
                System.out.printf(" %s           %s          %s[MPA] %s[Kpsi]       %s[MPA] %s[Kpsi]\n", readline[0],
                        readline[1], readline[2], readline[3], readline[4], readline[5], readline[6]);
            }
        }
    }

    public void materialProperties_CD(String type) throws IOException {
        FileReader fr = new FileReader("ME 352_CD.txt");
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            }
            String[] readline = line.split(" ");
            if (readline[0].equals(type)) {
                System.out.println("AISI No.    Processing     ---Tensile Stress---      ---Yield Stress---");
                System.out.printf(" %s           %s          %s[MPA] %s[Kpsi]        %s[MPA] %s[Kpsi]\n", readline[0],
                        readline[1], readline[2], readline[3], readline[4], readline[5], readline[6]);
            }
        }
    }

    // Getters and setters
    public double getSigmaX() {
        return sigmaX;
    }

    public double getSigmaY() {
        return sigmaY;
    }

    public double getSigmaZ() {
        return sigmaZ;
    }

    public double getTxy() {
        return txy;
    }

    public double getTyz() {
        return tyz;
    }

    public double getTxz() {
        return txz;
    }
}
