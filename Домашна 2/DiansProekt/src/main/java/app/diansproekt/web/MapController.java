package app.diansproekt.web;

import app.diansproekt.model.Lokal;
import app.diansproekt.service.LokalService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {

    private final LokalService lokalService;

    public MapController(LokalService lokalService) {
        this.lokalService = lokalService;
    }

    @GetMapping("/")
    public String indexPage()
    {
        return "index";
    }

    @PostMapping("/")
    public String postIndexPage(@RequestParam String name, Model model)
    {
        Lokal l = lokalService.findByName(name);
        if(l!=null)
        {
            model.addAttribute("lokal", l);
            model.addAttribute("x", l.getXCoordinates());
            model.addAttribute("y", l.getYCoordinates());
        }

        return "index";
    }

}
