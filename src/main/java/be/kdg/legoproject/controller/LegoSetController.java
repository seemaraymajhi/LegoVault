package be.kdg.legoproject.controller;

import be.kdg.legoproject.service.LegoSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/legosets")
public class LegoSetController {

    private static final Logger log =
            LoggerFactory.getLogger(LegoSetController.class);

    private final LegoSetService legoSetService;

    public LegoSetController(LegoSetService legoSetService) {
        this.legoSetService = legoSetService;
    }

    // GET /legosets - display all LEGO sets
    @GetMapping
    public String showLegoSets(Model model) {
        log.debug("GET /legosets called");

        model.addAttribute(
                "legoSets",
                legoSetService.getAllLegoSets()
        );

        return "legosets";
    }

    // GET /legosets/search?minPieces=5000 - mandatory filter
    @GetMapping("/search")
    public String searchLegoSets(
            @RequestParam(name = "minPieces") int minPieces,
            Model model
    ) {
        log.debug(
                "GET /legosets/search called with minPieces={}",
                minPieces
        );

        model.addAttribute(
                "legoSets",
                legoSetService.getLegoSetsWithMinimumPieces(minPieces)
        );

        // Preserve the submitted value in the filter form.
        model.addAttribute("minPieces", minPieces);

        return "legosets";
    }
}