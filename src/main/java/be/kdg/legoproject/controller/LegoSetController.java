package be.kdg.legoproject.controller;

import be.kdg.legoproject.domain.Difficulty;
import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import be.kdg.legoproject.web.LegoSetForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/legosets")
public class LegoSetController {

    private static final Logger log =
            LoggerFactory.getLogger(LegoSetController.class);

    private final LegoSetService legoSetService;
    private final LegoPieceService legoPieceService;

    public LegoSetController(
            LegoSetService legoSetService,
            LegoPieceService legoPieceService
    ) {
        this.legoSetService = legoSetService;
        this.legoPieceService = legoPieceService;
    }

    // Dropdown values for the add form, available before every request.
    @ModelAttribute("difficulties")
    public Difficulty[] difficulties() {
        return Difficulty.values();
    }

    // All existing pieces, so the user can choose one in the add form.
    @ModelAttribute("legoPieces")
    public List<LegoPiece> legoPieces() {
        return legoPieceService.getAllLegoPieces();
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

    // GET /legosets/add - show an empty form
    @GetMapping("/add")
    public String showAddLegoSetForm(Model model) {
        log.debug("GET /legosets/add called");

        model.addAttribute(
                "legoSetForm",
                new LegoSetForm()
        );

        return "addlegoset";
    }

    // POST /legosets/add - save the set, link the chosen piece, then redirect (PRG)
    @PostMapping("/add")
    public String processAddLegoSet(
            @ModelAttribute("legoSetForm") LegoSetForm legoSetForm
    ) {
        log.debug(
                "POST /legosets/add called with name='{}', pieceName='{}'",
                legoSetForm.getName(),
                legoSetForm.getPieceName()
        );

        // Convert the form (user input) into a real domain object.
        LegoSet legoSet = new LegoSet(
                legoSetForm.getName(),
                legoSetForm.getPieceCount(),
                legoSetForm.getPrice(),
                legoSetForm.getReleaseDate(),
                legoSetForm.getDifficulty(),
                legoSetForm.isRetired(),
                legoSetForm.getImageUrl()
        );

        legoSetService.addLegoSet(legoSet, legoSetForm.getPieceName());

        log.info(
                "LEGO set '{}' added successfully; redirecting to /legosets",
                legoSetForm.getName()
        );

        return "redirect:/legosets";
    }
}