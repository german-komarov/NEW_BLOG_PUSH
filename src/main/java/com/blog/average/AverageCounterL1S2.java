package com.blog.average;

public class AverageCounterL1S2 {

    //COMMON
    //math
    private double math_first;
    private double math_second;
    private double math_final;

    //phys
    private double vibrations_waves_optics_first;
    private double vibrations_waves_optics_second;
    private double phys_lab_report;

    //comp
    private double comp_part;
    private double comp_report;
    private double comp_final;

    //French
    private double fr_first;
    private double fr_speaking;
    private double fr_final;

    //English
    private double en_first;
    private double en_speaking;
    private double en_final;

    //humanities
    private double humanities_production;
    private double humanities_final;

    //data struct
    private double DSaA_first;
    private double DSaA_practical;
    private double DSaA_final;

    //CompArch
    private double arch_first;
    private double arch_practical;
    private double arch_final;

    public double math()
    {
        return math_first/30*1.5+math_second/30*1.5+math_final/30*3;
    }

    public double phys()
    {
        return vibrations_waves_optics_first/30*1+vibrations_waves_optics_second/30*2+phys_lab_report/30*3;
    }

    public double comp()
    {
        return comp_part/30*0.3+comp_report/30*1.2+comp_final/30*1.5;
    }


    public double french()
    {
        return fr_first/30*0.5+fr_speaking/30*0.75+fr_final/30*0.75;
    }

    public double english()
    {
        return en_first/30*0.5+en_speaking/30*0.75+en_final/30*0.75;
    }

    public double humanities()
    {
        return humanities_production/30*1+humanities_final/30*1;
    }

    public double DSaA()
    {
        return DSaA_first/30*1.8+DSaA_practical/30*1.8+DSaA_final/30*2.4;
    }

    public double Arch()
    {
        return arch_first/30*0.6+arch_practical/30*0.9+arch_final/30*1.5;
    }

    public double averageCounter()
    {
        return math()+phys()+comp()+french()+english()+humanities()+DSaA()+Arch();
    }







    public AverageCounterL1S2() {
    }

    public AverageCounterL1S2(double math_first, double math_second, double math_final,
                              double vibrations_waves_optics_first, double vibrations_waves_optics_second, double phys_lab_report,
                              double comp_part, double comp_report, double comp_final,
                              double fr_first, double fr_speaking, double fr_final,
                              double en_first, double en_speaking, double en_final,
                              double humanities_production, double humanities_final,
                              double DSaA_first, double DSaA_practical, double DSaA_final,
                              double arch_first, double arch_practical, double arch_final) {
        this.math_first = math_first;
        this.math_second = math_second;
        this.math_final = math_final;
        this.vibrations_waves_optics_first = vibrations_waves_optics_first;
        this.vibrations_waves_optics_second = vibrations_waves_optics_second;
        this.phys_lab_report = phys_lab_report;
        this.comp_part = comp_part;
        this.comp_report = comp_report;
        this.comp_final = comp_final;
        this.fr_first = fr_first;
        this.fr_speaking = fr_speaking;
        this.fr_final = fr_final;
        this.en_first = en_first;
        this.en_speaking = en_speaking;
        this.en_final = en_final;
        this.humanities_production = humanities_production;
        this.humanities_final = humanities_final;
        this.DSaA_first = DSaA_first;
        this.DSaA_practical = DSaA_practical;
        this.DSaA_final = DSaA_final;
        this.arch_first = arch_first;
        this.arch_practical = arch_practical;
        this.arch_final = arch_final;
    }

    public double getMath_first() {
        return math_first;
    }

    public void setMath_first(double math_first) {
        this.math_first = math_first;
    }

    public double getMath_second() {
        return math_second;
    }

    public void setMath_second(double math_second) {
        this.math_second = math_second;
    }

    public double getMath_final() {
        return math_final;
    }

    public void setMath_final(double math_final) {
        this.math_final = math_final;
    }

    public double getVibrations_waves_optics_first() {
        return vibrations_waves_optics_first;
    }

    public void setVibrations_waves_optics_first(double vibrations_waves_optics_first) {
        this.vibrations_waves_optics_first = vibrations_waves_optics_first;
    }

    public double getVibrations_waves_optics_second() {
        return vibrations_waves_optics_second;
    }

    public void setVibrations_waves_optics_second(double vibrations_waves_optics_second) {
        this.vibrations_waves_optics_second = vibrations_waves_optics_second;
    }

    public double getPhys_lab_report() {
        return phys_lab_report;
    }

    public void setPhys_lab_report(double phys_lab_report) {
        this.phys_lab_report = phys_lab_report;
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

    public double getEn_first() {
        return en_first;
    }

    public void setEn_first(double en_first) {
        this.en_first = en_first;
    }

    public double getEn_speaking() {
        return en_speaking;
    }

    public void setEn_speaking(double en_speaking) {
        this.en_speaking = en_speaking;
    }

    public double getEn_final() {
        return en_final;
    }

    public void setEn_final(double en_final) {
        this.en_final = en_final;
    }

    public double getHumanities_production() {
        return humanities_production;
    }

    public void setHumanities_production(double humanities_production) {
        this.humanities_production = humanities_production;
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

    public double getArch_first() {
        return arch_first;
    }

    public void setArch_first(double arch_first) {
        this.arch_first = arch_first;
    }

    public double getArch_practical() {
        return arch_practical;
    }

    public void setArch_practical(double arch_practical) {
        this.arch_practical = arch_practical;
    }

    public double getArch_final() {
        return arch_final;
    }

    public void setArch_final(double arch_final) {
        this.arch_final = arch_final;
    }
}
