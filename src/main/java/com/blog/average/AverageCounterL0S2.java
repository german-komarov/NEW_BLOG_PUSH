package com.blog.average;

public class AverageCounterL0S2 {
    //Math
    private double participation;
    private double math_first;
    private double math_final;

    //Phys
    private double phys_copybook;
    private double phys_first;
    private double phys_final;

    //Chemist
    private double chem_first;
    private double chem_copybook;
    private double chem_final;

    //Computer
    private double online;
    private double comp_first;
    private double comp_final;

    //French
    private double fr_first;
    private double fr_speaking;
    private double fr_final;

    //English
    private double en_first;
    private double en_speaking;
    private double en_final;

    //Humanities
    private double humanities_report;
    private double humanities_presentation;

    public double math()
    {
        return participation/20*1+math_first/20*1.25+math_final/20*1.75;
    }

    public double phys()
    {
        return phys_copybook/20*0.75+phys_first/20*0.75+phys_final/20*1.5;
    }

    public double chem()
    {
        return chem_copybook/20*0.75+chem_first/20*0.75+chem_final/20*1.5;
    }

    public double comp()
    {
        return comp_first/20*1.25+online/20*0.25+comp_final/20*1.5;
    }

    public double french()
    {
        return fr_first/20*0.5+fr_speaking/20*0.75+fr_final/20*0.75;
    }

    public double english()
    {
        return en_first/20*1+en_speaking/20*1+en_final/20*1;
    }

    public double humanities()
    {
        return humanities_presentation/20*1+humanities_report/20*1;
    }
    public double averageCounter()
    {
        return math()+phys()+chem()+comp()+french()+english()+humanities();
    }

    public AverageCounterL0S2() {
    }

    public AverageCounterL0S2(double participation, double math_first, double math_final,
                              double phys_copybook, double phys_first, double phys_final,
                              double chem_first, double chem_copybook, double chem_final,
                              double online, double comp_first, double comp_final,
                              double fr_first, double fr_speaking, double fr_final,
                              double en_first, double en_speaking, double en_final,
                              double humanities_report, double humanities_presentation) {
        this.participation = participation;
        this.math_first = math_first;
        this.math_final = math_final;
        this.phys_copybook = phys_copybook;
        this.phys_first = phys_first;
        this.phys_final = phys_final;
        this.chem_first = chem_first;
        this.chem_copybook = chem_copybook;
        this.chem_final = chem_final;
        this.online = online;
        this.comp_first = comp_first;
        this.comp_final = comp_final;
        this.fr_first = fr_first;
        this.fr_speaking = fr_speaking;
        this.fr_final = fr_final;
        this.en_first = en_first;
        this.en_speaking = en_speaking;
        this.en_final = en_final;
        this.humanities_report = humanities_report;
        this.humanities_presentation = humanities_presentation;
    }

    public double getParticipation() {
        return participation;
    }

    public void setParticipation(double participation) {
        this.participation = participation;
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

    public double getPhys_copybook() {
        return phys_copybook;
    }

    public void setPhys_copybook(double phys_copybook) {
        this.phys_copybook = phys_copybook;
    }

    public double getPhys_first() {
        return phys_first;
    }

    public void setPhys_first(double phys_first) {
        this.phys_first = phys_first;
    }

    public double getPhys_final() {
        return phys_final;
    }

    public void setPhys_final(double phys_final) {
        this.phys_final = phys_final;
    }

    public double getChem_first() {
        return chem_first;
    }

    public void setChem_first(double chem_first) {
        this.chem_first = chem_first;
    }

    public double getChem_copybook() {
        return chem_copybook;
    }

    public void setChem_copybook(double chem_copybook) {
        this.chem_copybook = chem_copybook;
    }

    public double getChem_final() {
        return chem_final;
    }

    public void setChem_final(double chem_final) {
        this.chem_final = chem_final;
    }

    public double getOnline() {
        return online;
    }

    public void setOnline(double online) {
        this.online = online;
    }

    public double getComp_first() {
        return comp_first;
    }

    public void setComp_first(double comp_first) {
        this.comp_first = comp_first;
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

    public double getHumanities_report() {
        return humanities_report;
    }

    public void setHumanities_report(double humanities_report) {
        this.humanities_report = humanities_report;
    }

    public double getHumanities_presentation() {
        return humanities_presentation;
    }

    public void setHumanities_presentation(double humanities_presentation) {
        this.humanities_presentation = humanities_presentation;
    }
}


