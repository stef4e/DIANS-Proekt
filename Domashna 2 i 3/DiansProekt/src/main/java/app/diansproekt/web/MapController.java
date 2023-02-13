package app.diansproekt.web;

import app.diansproekt.model.Lokal;
import app.diansproekt.service.LokalService;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MapController {

    private final LokalService lokalService;

    public MapController(LokalService lokalService) {
        this.lokalService = lokalService;
    }

    @GetMapping("/")
    public String indexPage(Model model) throws IOException {

        List<Double> xCoordinates=new ArrayList<>();
        List<Double> yCoordinates=new ArrayList<>();

        for (Lokal l : lokalService.findAll())
        {
            xCoordinates.add(l.getXCoordinates());
            yCoordinates.add(l.getYCoordinates());
        }

        model.addAttribute("xCoordinates", xCoordinates);
        model.addAttribute("yCoordinates", yCoordinates);
        model.addAttribute("count", lokalService.findAll().size()); // adds the number of locales to the model
        return "index";
    }

    @PostMapping("/")
    public String postIndexPage(@RequestParam String name, Model model)
    {
        Lokal l = lokalService.findByName(name);
        if(l!=null)
        {
            model.addAttribute("lokal", l);
            model.addAttribute("name", l.getName());
            model.addAttribute("barOrClub", l.getBarOrClub());
            model.addAttribute("x", l.getXCoordinates()); // adds the coordinate of the geographical X-Axis to the model
            model.addAttribute("y", l.getYCoordinates()); // adds the coordinate of the geographical Y-Axis to the model
            model.addAttribute("contactInfo", l.getContactInfo());
        }
        return "index";
    }
}
