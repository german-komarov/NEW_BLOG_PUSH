package com.blog.controllers;

import com.blog.average.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AverageController {


    @GetMapping("/average")
    public String average()
    {
        return "average";
    }

    @GetMapping("/average/L01")
    public String L01()
    {
        return "L01";
    }

    @PostMapping("/average/L01")
    public String countL01(@ModelAttribute AverageCounterL0S1 averageCounterL0S1,Model model)
    {
        double math=averageCounterL0S1.math();
        double phys=averageCounterL0S1.phys();
        double chem=averageCounterL0S1.chem();
        double comp=averageCounterL0S1.comp();
        double french=averageCounterL0S1.french();
        double english=averageCounterL0S1.english();
        double wmp=averageCounterL0S1.wmp_count();
        double average=averageCounterL0S1.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("chem",chem);
        model.addAttribute("comp",comp);
        model.addAttribute("french",french);
        model.addAttribute("english",english);
        model.addAttribute("wmp",wmp);
        model.addAttribute("average",average);

        return "resultL01";


    }

    @GetMapping("/average/L02")
    public String L02()
    {
        return "L02";
    }

    @PostMapping("/average/L02")
    public String countL02(@ModelAttribute AverageCounterL0S2 averageCounterL0S2, Model model)
    {
        double math=averageCounterL0S2.math();
        double phys=averageCounterL0S2.phys();
        double chem=averageCounterL0S2.chem();
        double comp=averageCounterL0S2.comp();
        double french=averageCounterL0S2.french();
        double english=averageCounterL0S2.english();
        double wmp=averageCounterL0S2.humanities();
        double average=averageCounterL0S2.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("chem",chem);
        model.addAttribute("comp",comp);
        model.addAttribute("french",french);
        model.addAttribute("english",english);
        model.addAttribute("humanities",wmp);
        model.addAttribute("average",average);

        return "resultL02";


    }


    @GetMapping("/average/L1S1_CS")
    public String L1S1()
    {
        return "L1S1_CS";
    }

    @PostMapping("/average/L1S1_CS")
    public String
    countL1S1(@ModelAttribute AverageCounterL1S1 averageCounterL1S1, Model model)
    {
        double math=averageCounterL1S1.math();
        double phys=averageCounterL1S1.phys();
        double chem=averageCounterL1S1.chem();
        double comp=averageCounterL1S1.comp();
        double humanities=averageCounterL1S1.humanities();
        double french=averageCounterL1S1.french();
        double english=averageCounterL1S1.english();
        double oop=averageCounterL1S1.OOP();
        double average=averageCounterL1S1.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("chem",chem);
        model.addAttribute("comp",comp);
        model.addAttribute("humanities",humanities);
        model.addAttribute("french",french);
        model.addAttribute("english",english);
        model.addAttribute("OOP",oop);
        model.addAttribute("average",average);

        return "resultL1S1_CS";


    }

    @GetMapping("/average/L1S2_CS")
    public String L1S2()
    {
        return "L1S2_CS";
    }

    @PostMapping("/average/L1S2_CS")
    public String
    countL1S2(@ModelAttribute AverageCounterL1S2 averageCounterL1S2, Model model)
    {
        double math=averageCounterL1S2.math();
        double phys=averageCounterL1S2.phys();
        double comp=averageCounterL1S2.comp();
        double french=averageCounterL1S2.french();
        double english=averageCounterL1S2.english();
        double humanities=averageCounterL1S2.humanities();
        double DSaA=averageCounterL1S2.DSaA();
        double Arch=averageCounterL1S2.Arch();
        double average=averageCounterL1S2.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("comp",comp);
        model.addAttribute("french",french);
        model.addAttribute("english",english);
        model.addAttribute("humanities",humanities);
        model.addAttribute("DSaA",DSaA);
        model.addAttribute("Arch",Arch);
        model.addAttribute("average",average);

        return "resultL1S2_CS";
    }


    @GetMapping("/average/L2S1_CS")
    public String L2S1()
    {
        return "L2S1_CS";
    }

    @PostMapping("/average/L2S1_CS")
    public String
    countL2S1(@ModelAttribute AverageCounterL2S1 averageCounterL2S1, Model model)
    {
        double math=averageCounterL2S1.math();
        double phys=averageCounterL2S1.phys();
        double comp=averageCounterL2S1.comp();
        double french=averageCounterL2S1.french();
        double humanities=averageCounterL2S1.humanities();
        double DSaA2=averageCounterL2S1.DSaA2();
        double system_programming=averageCounterL2S1.System_Programming();
        double network_protocols=averageCounterL2S1.Network_Protocols();

        double average=averageCounterL2S1.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("comp",comp);
        model.addAttribute("french",french);
        model.addAttribute("humanities",humanities);
        model.addAttribute("DSaA2",DSaA2);
        model.addAttribute("system_programming",system_programming);
        model.addAttribute("network_protocols",network_protocols);
        model.addAttribute("average",average);

        return "resultL2S1_CS";
    }

    @GetMapping("/average/L2S2_CS")
    public String L2S2()
    {
        return "L2S2_CS";
    }

    @PostMapping("/average/L2S2_CS")
    public String
    countL2S2(@ModelAttribute AverageCounterL2S2 averageCounterL2S2, Model model)
    {
       double math=averageCounterL2S2.math();
       double phys=averageCounterL2S2.phys();
       double french=averageCounterL2S2.french();
       double software_engineering=averageCounterL2S2.Software_Engineering();
       double oop2=averageCounterL2S2.OOP2();
       double signal_processing=averageCounterL2S2.Signal_Processing();
       double development_techniques=averageCounterL2S2.Development_Techniques();
       double osa=averageCounterL2S2.OSA();
       double average=averageCounterL2S2.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("phys",phys);
        model.addAttribute("french",french);
        model.addAttribute("software_engineering",software_engineering);
        model.addAttribute("oop2",oop2);
        model.addAttribute("signal_processing",signal_processing);
        model.addAttribute("development_techniques",development_techniques);
        model.addAttribute("osa",osa);
        model.addAttribute("average",average);

        return "resultL2S2_CS";
    }

    @GetMapping("/average/L3S1_CS")
    public String L3S1()
    {
        return "L3S1_CS";
    }

    @PostMapping("/average/L3S1_CS")
    public String
    countL3S1(@ModelAttribute AverageCounterL3S1 averageCounterL3S1, Model model)
    {
        double math=averageCounterL3S1.math();
        double comp=averageCounterL3S1.comp();
        double phys=averageCounterL3S1.phys();
        double humanities=averageCounterL3S1.humanities();
        double parallel_programming=averageCounterL3S1.Parallel_Programming();
        double AI=averageCounterL3S1.AI();
        double network_algorithms=averageCounterL3S1.Network_Algorithms();
        double CPS=averageCounterL3S1.CPS();
        double average=averageCounterL3S1.averageCounter();

        model.addAttribute("math",math);
        model.addAttribute("comp",comp);
        model.addAttribute("phys",phys);
        model.addAttribute("humanities",humanities);
        model.addAttribute("parallel_programming",parallel_programming);
        model.addAttribute("AI",AI);
        model.addAttribute("network_algorithms",network_algorithms);
        model.addAttribute("CPS",CPS);
        model.addAttribute("average",average);

        return "resultL3S1_CS";
    }




    @GetMapping("/average/L3S2_CS")
    public String L3S2()
    {
        return "L3S2_CS";
    }

    @PostMapping("/average/L3S2_CS")
    public String
    countL3S2(@ModelAttribute AverageCounterL3S2 averageCounterL3S2, Model model)
    {
        double humanities=averageCounterL3S2.humanities();
        double internship=averageCounterL3S2.internship();
        double project=averageCounterL3S2.project();
        double certification=averageCounterL3S2.certification();
        double security=averageCounterL3S2.security();
        double average=averageCounterL3S2.averageCounter();



        model.addAttribute("humanities",humanities);
        model.addAttribute("internship",internship);
        model.addAttribute("project",project);
        model.addAttribute("certification",certification);
        model.addAttribute("security",security);
        model.addAttribute("average",average);

        return "resultL3S2_CS";
    }




}
