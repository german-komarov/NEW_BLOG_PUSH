package com.blog.average;

public class AverageCounterL1S1 {
    //COMMON
    //math
    private double math_first;
    private double math_second;
    private double math_final;

    //Physics
    private double mechanics;
    private double thermodynamics;
    private double electrostatic;

    //Chemistry
    private double AoM_notebook;
    private double AoM_first;
    private double AoM_final;
    private double ToM_notebook;
    private double ToM_first;
    private double ToM_final;
    private double exp_chem_PW;
    private double exp_chem_average;


    //Comp Common
    private double comp_part;
    private double comp_report;
    private double comp_final;

    //Humanities
    private double humanities_report;
    private double humanities_final;

    //French
    private double fr_first;
    private double fr_speaking;
    private double fr_final;

    //English
    private double en_first;
    private double en_speaking;
    private double en_final;


    //SPEC
    //CS
    private double OOP_first;
    private double OOP_practical;
    private double OOP_final;

    public double math()
    {
        return math_first/30*1.5+math_second/30*1.5+math_final/30*3;
    }
    public double phys()
    {
        return mechanics/30*2+thermodynamics/30*2+electrostatic/30*2;
    }
    public double chem()
    {
        return AoM_notebook/30*0.5+AoM_first/30*0.5+AoM_final/30*1+
                ToM_notebook/30*0.5+ToM_first/30*0.5+ToM_final/30*1+
                exp_chem_PW/30*1+exp_chem_average/30*1;
    }

    public double comp()
    {
        return comp_part/30*0.3+comp_report/30*1.2+comp_final/30*1.5;
    }

    public double humanities()
    {
        return humanities_report/30*1+humanities_final/30*1;
    }

    public double french()
    {
        return fr_first/30*0.5+fr_speaking/30*0.75+fr_final/30*0.75;
    }

    public double english()
    {
        return en_first/30*0.5+en_speaking/30*0.75+en_final/30*0.75;
    }

    public double OOP()
    {
        return OOP_first/30*0.6+OOP_practical/30*1.2+OOP_final/30*1.2;
    }


    public double averageCounter()
    {
        return math()+phys()+chem()+comp()+humanities()+french()+english()+OOP();
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

    public double getMechanics() {
        return mechanics;
    }

    public void setMechanics(double mechanics) {
        this.mechanics = mechanics;
    }

    public double getThermodynamics() {
        return thermodynamics;
    }

    public void setThermodynamics(double thermodynamics) {
        this.thermodynamics = thermodynamics;
    }

    public double getElectrostatic() {
        return electrostatic;
    }

    public void setElectrostatic(double electrostatic) {
        this.electrostatic = electrostatic;
    }

    public double getAoM_notebook() {
        return AoM_notebook;
    }

    public void setAoM_notebook(double aoM_notebook) {
        AoM_notebook = aoM_notebook;
    }

    public double getAoM_first() {
        return AoM_first;
    }

    public void setAoM_first(double aoM_first) {
        AoM_first = aoM_first;
    }

    public double getAoM_final() {
        return AoM_final;
    }

    public void setAoM_final(double aoM_final) {
        AoM_final = aoM_final;
    }

    public double getToM_notebook() {
        return ToM_notebook;
    }

    public void setToM_notebook(double toM_notebook) {
        ToM_notebook = toM_notebook;
    }

    public double getToM_first() {
        return ToM_first;
    }

    public void setToM_first(double toM_first) {
        ToM_first = toM_first;
    }

    public double getToM_final() {
        return ToM_final;
    }

    public void setToM_final(double toM_final) {
        ToM_final = toM_final;
    }

    public double getExp_chem_PW() {
        return exp_chem_PW;
    }

    public void setExp_chem_PW(double exp_chem_PW) {
        this.exp_chem_PW = exp_chem_PW;
    }

    public double getExp_chem_average() {
        return exp_chem_average;
    }

    public void setExp_chem_average(double exp_chem_average) {
        this.exp_chem_average = exp_chem_average;
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

    public double getHumanities_report() {
        return humanities_report;
    }

    public void setHumanities_report(double humanities_report) {
        this.humanities_report = humanities_report;
    }

    public double getHumanities_final() {
        return humanities_final;
    }

    public void setHumanities_final(double humanities_final) {
        this.humanities_final = humanities_final;
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

    public AverageCounterL1S1() {
    }

    public AverageCounterL1S1(double math_first, double math_second, double math_final,
                              double mechanics, double thermodynamics, double electrostatic,
                              double aoM_notebook, double aoM_first, double aoM_final,
                              double toM_notebook, double toM_first, double toM_final,
                              double exp_chem_PW, double exp_chem_average,
                              double comp_part, double comp_report, double comp_final,
                              double humanities_report, double humanities_final,
                              double fr_first, double fr_speaking, double fr_final,
                              double en_first, double en_speaking, double en_final,
                              double OOP_first, double OOP_practical, double OOP_final) {
        this.math_first = math_first;
        this.math_second = math_second;
        this.math_final = math_final;
        this.mechanics = mechanics;
        this.thermodynamics = thermodynamics;
        this.electrostatic = electrostatic;
        AoM_notebook = aoM_notebook;
        AoM_first = aoM_first;
        AoM_final = aoM_final;
        ToM_notebook = toM_notebook;
        ToM_first = toM_first;
        ToM_final = toM_final;
        this.exp_chem_PW = exp_chem_PW;
        this.exp_chem_average = exp_chem_average;
        this.comp_part = comp_part;
        this.comp_report = comp_report;
        this.comp_final = comp_final;
        this.humanities_report = humanities_report;
        this.humanities_final = humanities_final;
        this.fr_first = fr_first;
        this.fr_speaking = fr_speaking;
        this.fr_final = fr_final;
        this.en_first = en_first;
        this.en_speaking = en_speaking;
        this.en_final = en_final;
        this.OOP_first = OOP_first;
        this.OOP_practical = OOP_practical;
        this.OOP_final = OOP_final;
    }
}
