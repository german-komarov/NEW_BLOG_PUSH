package com.blog.average;

public class AverageCounterL2S1 {
    //Math
    private double math_homework;
    private double math_first;
    private double math_final;

    //Phys
    private double phys_solid_first;
    private double phys_solid_second;
    private double phys_el_first;
    private double phys_el_second;

    //Web Prog Com
    private double comp_part;
    private double comp_report;
    private double comp_final;

    //French
    private double fr_homework;
    private double fr_speaking;
    private double fr_final;

    //Humanities
    private double humanities_homework;
    private double humanities_final;

    //Data Structure
    private double DSaA_first;
    private double DSaA_practical;
    private double DSaA_final;

    //System Programming
    private double system_homework;
    private double system_practical;
    private double system_final;

    //Network
    private double net_homework;
    private double net_first;
    private double net_final;

    public double math()
    {
        return math_homework/30*1+math_first/30*1.5+math_final/30*2.5;
    }

    public double phys()
    {
        return phys_solid_first/30*1+phys_solid_second/30*2+phys_el_first/30*0.5+phys_el_second/30*1.5;
    }

    public double comp()
    {
        return comp_part/30*0.3+comp_report/30*1.2+comp_final/30*1.5;
    }

    public double french()
    {
        return fr_homework/30*1+fr_speaking/30*1+fr_final/30*1;
    }

    public double humanities()
    {
        return humanities_homework/30*1+humanities_final/30*1;
    }

    public double DSaA2()
    {
        return DSaA_first/30*1.2+DSaA_practical/30*1.8+DSaA_final/30*3;
    }

    public double System_Programming()
    {
        return system_homework/30*1+system_practical/30*1+system_final/30*1;
    }

    public double Network_Protocols()
    {
        return net_homework/30*0.75+net_first/30*0.75+net_final/30*1.5;
    }

    public double averageCounter()
    {
        return math()+phys()+comp()+french()+humanities()+DSaA2()+System_Programming()+Network_Protocols();
    }





    public AverageCounterL2S1() {
    }

    public AverageCounterL2S1(double math_homework, double math_first, double math_final,
                              double phys_solid_first, double phys_solid_second,
                              double phys_el_first, double phys_el_second,
                              double comp_part, double comp_report, double comp_final,
                              double fr_homework, double fr_speaking, double fr_final,
                              double humanities_homework, double humanities_final,
                              double DSaA_first, double DSaA_practical, double DSaA_final,
                              double system_homework, double system_practical, double system_final,
                              double net_homework, double net_first, double net_final) {
        this.math_homework = math_homework;
        this.math_first = math_first;
        this.math_final = math_final;
        this.phys_solid_first = phys_solid_first;
        this.phys_solid_second = phys_solid_second;
        this.phys_el_first = phys_el_first;
        this.phys_el_second = phys_el_second;
        this.comp_part = comp_part;
        this.comp_report = comp_report;
        this.comp_final = comp_final;
        this.fr_homework = fr_homework;
        this.fr_speaking = fr_speaking;
        this.fr_final = fr_final;
        this.humanities_homework = humanities_homework;
        this.humanities_final = humanities_final;
        this.DSaA_first = DSaA_first;
        this.DSaA_practical = DSaA_practical;
        this.DSaA_final = DSaA_final;
        this.system_homework = system_homework;
        this.system_practical = system_practical;
        this.system_final = system_final;
        this.net_homework = net_homework;
        this.net_first = net_first;
        this.net_final = net_final;
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

    public double getPhys_solid_first() {
        return phys_solid_first;
    }

    public void setPhys_solid_first(double phys_solid_first) {
        this.phys_solid_first = phys_solid_first;
    }

    public double getPhys_solid_second() {
        return phys_solid_second;
    }

    public void setPhys_solid_second(double phys_solid_second) {
        this.phys_solid_second = phys_solid_second;
    }

    public double getPhys_el_first() {
        return phys_el_first;
    }

    public void setPhys_el_first(double phys_el_first) {
        this.phys_el_first = phys_el_first;
    }

    public double getPhys_el_second() {
        return phys_el_second;
    }

    public void setPhys_el_second(double phys_el_second) {
        this.phys_el_second = phys_el_second;
    }

    public double getComp_part() {
        return comp_part;
    }

    public void setComp_part(double comp_part) {
        this.comp_part = comp_part;
    }

    public double getComp_report() {
        return comp_report;
    }

    public void setComp_report(double comp_report) {
        this.comp_report = comp_report;
    }

    public double getComp_final() {
        return comp_final;
    }

    public void setComp_final(double comp_final) {
        this.comp_final = comp_final;
    }

    public double getFr_homework() {
        return fr_homework;
    }

    public void setFr_homework(double fr_homework) {
        this.fr_homework = fr_homework;
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

    public double getHumanities_homework() {
        return humanities_homework;
    }

    public void setHumanities_homework(double humanities_homework) {
        this.humanities_homework = humanities_homework;
    }

    public double getHumanities_final() {
        return humanities_final;
    }

    public void setHumanities_final(double humanities_final) {
        this.humanities_final = humanities_final;
    }

    public double getDSaA_first() {
        return DSaA_first;
    }

    public void setDSaA_first(double DSaA_first) {
        this.DSaA_first = DSaA_first;
    }

    public double getDSaA_practical() {
        return DSaA_practical;
    }

    public void setDSaA_practical(double DSaA_practical) {
        this.DSaA_practical = DSaA_practical;
    }

    public double getDSaA_final() {
        return DSaA_final;
    }

    public void setDSaA_final(double DSaA_final) {
        this.DSaA_final = DSaA_final;
    }

    public double getSystem_homework() {
        return system_homework;
    }

    public void setSystem_homework(double system_homework) {
        this.system_homework = system_homework;
    }

    public double getSystem_practical() {
        return system_practical;
    }

    public void setSystem_practical(double system_practical) {
        this.system_practical = system_practical;
    }

    public double getSystem_final() {
        return system_final;
    }

    public void setSystem_final(double system_final) {
        this.system_final = system_final;
    }

    public double getNet_homework() {
        return net_homework;
    }

    public void setNet_homework(double net_homework) {
        this.net_homework = net_homework;
    }

    public double getNet_first() {
        return net_first;
    }

    public void setNet_first(double net_first) {
        this.net_first = net_first;
    }

    public double getNet_final() {
        return net_final;
    }

    public void setNet_final(double net_final) {
        this.net_final = net_final;
    }
}
