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



@Controller
public class MapController {

    private final LokalService lokalService;

    public MapController(LokalService lokalService) {
        this.lokalService = lokalService;
    }

    @GetMapping("/")
    public String indexPage() throws IOException {

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
            model.addAttribute("x", l.getXCoordinates());
            model.addAttribute("y", l.getYCoordinates());
            model.addAttribute("contactInfo", l.getContactInfo());
        }
        return "index";
    }
}
