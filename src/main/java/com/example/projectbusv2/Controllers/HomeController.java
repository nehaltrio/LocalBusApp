package com.example.projectbusv2.Controllers;

import com.example.projectbusv2.DataManagers.BusData;
import com.example.projectbusv2.DataManagers.dataFetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
public class HomeController {

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("buses", new BusData());
        return "home";
    }

    @PostMapping("/home")
    public String submit(@ModelAttribute BusData busData, Model model) {
        model.addAttribute("buses", busData);
        return "showRes";
    }

    @GetMapping("/location")
    @ResponseBody
    public ArrayList<String> searchLocation(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        dataFetch data = new dataFetch();
        return data.searchLoc(term);
    }



}
