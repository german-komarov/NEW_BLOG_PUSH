package com.blog.average;

public class AverageCounterL2S2 {
    //Math
    private double math_homework;
    private double math_first;
    private double math_final;

    //Phys
    private double phys_el_first;
    private double phys_el_final;
    private double phys_ther_first;
    private double phys_ther_final;
    private double phys_lab;

    //French
    private double fr_first;
    private double fr_speaking;
    private double fr_final;

    //Software Engineering
    private double soft_first;
    private double soft_practical;
    private double soft_final;

    //OOP2
    private double OOP_first;
    private double OOP_practical;
    private double OOP_final;

    //Signal Processing
    private double signal_first;
    private double signal_second;
    private double signal_final;

    //Development Techniques;
    private double dev_homework_first;
    private double dev_homework_second;
    private double dev_practical;

    //Operating Systems Architectures
    private double OSA_homework_report;
    private double OSA_practical;
    private double OSA_final;


    public double math()
    {
        return math_homework/30*0.67+math_first/30*1.33+math_final/30*2;
    }

    public double phys()
    {
        return phys_el_first/30*0.75+phys_el_final/30*1.25+
                phys_ther_first/30*0.75+phys_ther_final/30*1.25+phys_lab/30*2;
    }

    public double french()
    {
        return fr_first/30*0.5+fr_speaking/30*0.5+fr_final/30*1;
    }

    public double Software_Engineering()
    {
        return soft_first/30*0.75+soft_practical/30*0.75+soft_final/30*1.5;
    }

    public double OOP2()
    {
        return OOP_first/30*1+OOP_practical/30*1+OOP_final/30*1;
    }

    public double Signal_Processing()
    {
        return signal_first/30*0.3+signal_second/30*1.2+signal_final/30*1.5;
    }

    public double Development_Techniques()
    {
        return dev_homework_first/30*1+dev_homework_second/30*1+dev_practical/30*1;
    }

    public double OSA()
    {
        return OSA_homework_report/30*2+OSA_practical/30*2+OSA_final/30*2;
    }

    public double averageCounter()
    {
        return math()+phys()+french()+Software_Engineering()+OOP2()+Signal_Processing()+Development_Techniques()+OSA();
    }










    public AverageCounterL2S2() {
    }

    public AverageCounterL2S2(double math_homework, double math_first, double math_final,
                              double phys_el_first, double phys_el_final,
                              double phys_ther_first, double phys_ther_final, double phys_lab,
                              double fr_first, double fr_speaking, double fr_final,
                              double soft_first, double soft_practical, double soft_final,
                              double OOP_first, double OOP_practical, double OOP_final,
                              double signal_first, double signal_second, double signal_final,
                              double dev_homework_first, double dev_homework_second, double dev_practical,
                              double OSA_homework_report, double OSA_practical, double OSA_final) {
        this.math_homework = math_homework;
        this.math_first = math_first;
        this.math_final = math_final;
        this.phys_el_first = phys_el_first;
        this.phys_el_final = phys_el_final;
        this.phys_ther_first = phys_ther_first;
        this.phys_ther_final = phys_ther_final;
        this.phys_lab = phys_lab;
        this.fr_first = fr_first;
        this.fr_speaking = fr_speaking;
        this.fr_final = fr_final;
        this.soft_first = soft_first;
        this.soft_practical = soft_practical;
        this.soft_final = soft_final;
        this.OOP_first = OOP_first;
        this.OOP_practical = OOP_practical;
        this.OOP_final = OOP_final;
        this.signal_first = signal_first;
        this.signal_second = signal_second;
        this.signal_final = signal_final;
        this.dev_homework_first = dev_homework_first;
        this.dev_homework_second = dev_homework_second;
        this.dev_practical = dev_practical;
        this.OSA_homework_report = OSA_homework_report;
        this.OSA_practical = OSA_practical;
        this.OSA_final = OSA_final;
    }

    public double getMath_homework() {
        return math_homework;
    }

    public void setMath_homework(double math_homework) {
        this.math_homework = math_homework;
    }

    public double getMath_first() {
        return math_first;
    }

    public void setMath_first(double math_first) {
        this.math_first = math_first;
    }

    public double getMath_final() {
        return math_final;
    }

    public void setMath_final(double math_final) {
        this.math_final = math_final;
    }

    public double getPhys_el_first() {
        return phys_el_first;
    }

    public void setPhys_el_first(double phys_el_first) {
        this.phys_el_first = phys_el_first;
    }

    public double getPhys_el_final() {
        return phys_el_final;
    }

    public void setPhys_el_final(double phys_el_final) {
        this.phys_el_final = phys_el_final;
    }

    public double getPhys_ther_first() {
        return phys_ther_first;
    }

    public void setPhys_ther_first(double phys_ther_first) {
        this.phys_ther_first = phys_ther_first;
    }

    public double getPhys_ther_final() {
        return phys_ther_final;
    }

    public void setPhys_ther_final(double phys_ther_final) {
        this.phys_ther_final = phys_ther_final;
    }

    public double getPhys_lab() {
        return phys_lab;
    }

    public void setPhys_lab(double phys_lab) {
        this.phys_lab = phys_lab;
    }

    public double getFr_first() {
        return fr_first;
    }

    public void setFr_first(double fr_first) {
        this.fr_first = fr_first;
    }

    public double getFr_speaking() {
        return fr_speaking;
    }

    public void setFr_speaking(double fr_speaking) {
        this.fr_speaking = fr_speaking;
    }

    public double getFr_final() {
        return fr_final;
    }

    public void setFr_final(double fr_final) {
        this.fr_final = fr_final;
    }

    public double getSoft_first() {
        return soft_first;
    }

    public void setSoft_first(double soft_first) {
        this.soft_first = soft_first;
    }

    public double getSoft_practical() {
        return soft_practical;
    }

    public void setSoft_practical(double soft_practical) {
        this.soft_practical = soft_practical;
    }

    public double getSoft_final() {
        return soft_final;
    }

    public void setSoft_final(double soft_final) {
        this.soft_final = soft_final;
    }

    public double getOOP_first() {
        return OOP_first;
    }

    public void setOOP_first(double OOP_first) {
        this.OOP_first = OOP_first;
    }

    public double getOOP_practical() {
        return OOP_practical;
    }

    public void setOOP_practical(double OOP_practical) {
        this.OOP_practical = OOP_practical;
    }

    public double getOOP_final() {
        return OOP_final;
    }

    public void setOOP_final(double OOP_final) {
        this.OOP_final = OOP_final;
    }

    public double getSignal_first() {
        return signal_first;
    }

    public void setSignal_first(double signal_first) {
        this.signal_first = signal_first;
    }

    public double getSignal_second() {
        return signal_second;
    }

    public void setSignal_second(double signal_second) {
        this.signal_second = signal_second;
    }

    public double getSignal_final() {
        return signal_final;
    }

    public void setSignal_final(double signal_final) {
        this.signal_final = signal_final;
    }

    public double getDev_homework_first() {
        return dev_homework_first;
    }

    public void setDev_homework_first(double dev_homework_first) {
        this.dev_homework_first = dev_homework_first;
    }

    public double getDev_homework_second() {
        return dev_homework_second;
    }

    public void setDev_homework_second(double dev_homework_second) {
        this.dev_homework_second = dev_homework_second;
    }

    public double getDev_practical() {
        return dev_practical;
    }

    public void setDev_practical(double dev_practical) {
        this.dev_practical = dev_practical;
    }

    public double getOSA_homework_report() {
        return OSA_homework_report;
    }

    public void setOSA_homework_report(double OSA_homework_report) {
        this.OSA_homework_report = OSA_homework_report;
    }

    public double getOSA_practical() {
        return OSA_practical;
    }

    public void setOSA_practical(double OSA_practical) {
        this.OSA_practical = OSA_practical;
    }

    public double getOSA_final() {
        return OSA_final;
    }

    public void setOSA_final(double OSA_final) {
        this.OSA_final = OSA_final;
    }
}
