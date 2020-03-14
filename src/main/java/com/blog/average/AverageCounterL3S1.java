package com.blog.average;


public class AverageCounterL3S1 {

    //Math
    private double math_homework;
    private double math_first;
    private double math_final;

    //Comp for Science
    private double comp_pw_report;
    private double comp_homework;
    private double comp_pw_report_final;

    //Phys
    private double phys_modern_first;
    private double phys_modern_final;
    private double phys_el_first;
    private double phys_el_final;

    //Humanities
    private double humanities_production;
    private double humanities_speaking;
    private double humanities_final;

    //Parallel Programming
    private double parallel_homework_report;
    private double parallel_written_exam;
    private double parallel_practical_exam;

    //Artificial Intelligence
    private double ai_online;
    private double ai_homework_report;
    private double ai_final;

    //Network Algorithms
    private double net_first;
    private double net_second;
    private double net_homework_report;

    //CPS
    private double CPS_first;
    private double CPS_second;
    private double CPS_final;


    public double math()
    {
        return math_homework/30*0.33+math_first/30*0.67+math_final/30*1;
    }

    public double comp()
    {
        return comp_pw_report/30*0.5+comp_homework/30*0.5+comp_pw_report_final/30*1;
    }

    public double phys()
    {
        return phys_modern_first/30*1.5+phys_modern_final/30*2.5+
                phys_el_first/30*1+phys_el_final/30*1;
    }

    public double humanities()
    {
        return humanities_production/30*0.5+humanities_speaking/30*0.5+humanities_final/30*1;
    }

    public double Parallel_Programming()
    {
        return parallel_homework_report/30*1.6+parallel_written_exam/30*0.8+parallel_practical_exam/30*1.6;
    }

    public double AI()
    {
        return ai_online/30*0.5+ai_homework_report/30*1.5+ai_final/30*2;
    }

    public double Network_Algorithms()
    {
        return net_first/30*0.8+net_second/30*1.6+net_homework_report/30*1.6;
    }

    public double CPS()
    {
        return CPS_first/30*1+CPS_second/30*2+CPS_final/30*3;
    }

    public double averageCounter()
    {
        return math()+comp()+phys()+humanities()+Parallel_Programming()+AI()+ Network_Algorithms()+CPS();


    }






    public AverageCounterL3S1() {
    }

    public AverageCounterL3S1(double math_homework, double math_first, double math_final,
                              double comp_pw_report, double comp_homework, double comp_pw_report_final,
                              double phys_modern_first, double phys_modern_final,
                              double phys_el_first, double phys_el_final,
                              double humanities_production, double humanities_speaking, double humanities_final,
                              double parallel_homework_report, double parallel_written_exam, double parallel_practical_exam,
                              double ai_online, double ai_homework_report, double ai_final,
                              double net_first, double net_second, double net_homework_report,
                              double CPS_first, double CPS_second, double CPS_final) {
        this.math_homework = math_homework;
        this.math_first = math_first;
        this.math_final = math_final;
        this.comp_pw_report = comp_pw_report;
        this.comp_homework = comp_homework;
        this.comp_pw_report_final = comp_pw_report_final;
        this.phys_modern_first = phys_modern_first;
        this.phys_modern_final = phys_modern_final;
        this.phys_el_first = phys_el_first;
        this.phys_el_final = phys_el_final;
        this.humanities_production = humanities_production;
        this.humanities_speaking = humanities_speaking;
        this.humanities_final = humanities_final;
        this.parallel_homework_report = parallel_homework_report;
        this.parallel_written_exam = parallel_written_exam;
        this.parallel_practical_exam = parallel_practical_exam;
        this.ai_online = ai_online;
        this.ai_homework_report = ai_homework_report;
        this.ai_final = ai_final;
        this.net_first = net_first;
        this.net_second = net_second;
        this.net_homework_report = net_homework_report;
        this.CPS_first = CPS_first;
        this.CPS_second = CPS_second;
        this.CPS_final = CPS_final;
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

    public double getComp_pw_report() {
        return comp_pw_report;
    }

    public void setComp_pw_report(double comp_pw_report) {
        this.comp_pw_report = comp_pw_report;
    }

    public double getComp_homework() {
        return comp_homework;
    }

    public void setComp_homework(double comp_homework) {
        this.comp_homework = comp_homework;
    }

    public double getComp_pw_report_final() {
        return comp_pw_report_final;
    }

    public void setComp_pw_report_final(double comp_pw_report_final) {
        this.comp_pw_report_final = comp_pw_report_final;
    }

    public double getPhys_modern_first() {
        return phys_modern_first;
    }

    public void setPhys_modern_first(double phys_modern_first) {
        this.phys_modern_first = phys_modern_first;
    }

    public double getPhys_modern_final() {
        return phys_modern_final;
    }

    public void setPhys_modern_final(double phys_modern_final) {
        this.phys_modern_final = phys_modern_final;
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

    public double getHumanities_production() {
        return humanities_production;
    }

    public void setHumanities_production(double humanities_production) {
        this.humanities_production = humanities_production;
    }

    public double getHumanities_speaking() {
        return humanities_speaking;
    }

    public void setHumanities_speaking(double humanities_speaking) {
        this.humanities_speaking = humanities_speaking;
    }

    public double getHumanities_final() {
        return humanities_final;
    }

    public void setHumanities_final(double humanities_final) {
        this.humanities_final = humanities_final;
    }

    public double getParallel_homework_report() {
        return parallel_homework_report;
    }

    public void setParallel_homework_report(double parallel_homework_report) {
        this.parallel_homework_report = parallel_homework_report;
    }

    public double getParallel_written_exam() {
        return parallel_written_exam;
    }

    public void setParallel_written_exam(double parallel_written_exam) {
        this.parallel_written_exam = parallel_written_exam;
    }

    public double getParallel_practical_exam() {
        return parallel_practical_exam;
    }

    public void setParallel_practical_exam(double parallel_practical_exam) {
        this.parallel_practical_exam = parallel_practical_exam;
    }

    public double getAi_online() {
        return ai_online;
    }

    public void setAi_online(double ai_online) {
        this.ai_online = ai_online;
    }

    public double getAi_homework_report() {
        return ai_homework_report;
    }

    public void setAi_homework_report(double ai_homework_report) {
        this.ai_homework_report = ai_homework_report;
    }

    public double getAi_final() {
        return ai_final;
    }

    public void setAi_final(double ai_final) {
        this.ai_final = ai_final;
    }

    public double getNet_first() {
        return net_first;
    }

    public void setNet_first(double net_first) {
        this.net_first = net_first;
    }

    public double getNet_second() {
        return net_second;
    }

    public void setNet_second(double net_second) {
        this.net_second = net_second;
    }

    public double getNet_homework_report() {
        return net_homework_report;
    }

    public void setNet_homework_report(double net_homework_report) {
        this.net_homework_report = net_homework_report;
    }

    public double getCPS_first() {
        return CPS_first;
    }

    public void setCPS_first(double CPS_first) {
        this.CPS_first = CPS_first;
    }

    public double getCPS_second() {
        return CPS_second;
    }

    public void setCPS_second(double CPS_second) {
        this.CPS_second = CPS_second;
    }

    public double getCPS_final() {
        return CPS_final;
    }

    public void setCPS_final(double CPS_final) {
        this.CPS_final = CPS_final;
    }
}
