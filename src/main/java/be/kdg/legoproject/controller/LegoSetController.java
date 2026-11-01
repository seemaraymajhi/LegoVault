package be.kdg.legoproject.controller;

import be.kdg.legoproject.domain.Difficulty;
import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import be.kdg.legoproject.session.SessionHistory;
import be.kdg.legoproject.web.LegoSetViewModel;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/legosets")
public class LegoSetController {

    private static final Logger log =
            LoggerFactory.getLogger(LegoSetController.class);

    private final LegoSetService legoSetService;
    private final LegoPieceService legoPieceService;

    private final SessionHistory sessionHistory;

    public LegoSetController(
            LegoSetService legoSetService,
            LegoPieceService legoPieceService,
            SessionHistory sessionHistory
    ) {
        this.legoSetService = legoSetService;
        this.legoPieceService = legoPieceService;
        this.sessionHistory = sessionHistory;

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
        sessionHistory.addVisit("/legosets");

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
        sessionHistory.addVisit("/legosets/search?minPieces=" + minPieces);

        model.addAttribute(
                "legoSets",
                legoSetService.getLegoSetsWithMinimumPieces(minPieces)
        );

        // Preserve the submitted value in the filter form.
        model.addAttribute("minPieces", minPieces);

        return "legosets";
    }

    // GET /legosets/{id} - show all details of one LEGO set
    @GetMapping("/{id}")
    public String showLegoSetDetails(@PathVariable UUID id, Model model
    ) {
        log.debug(
                "GET /legosets/{} called",
                id
        );
        sessionHistory.addVisit("/legosets/" + id);

        Optional<LegoSet> legoSet = legoSetService.getLegoSetById(id);
        if (legoSet.isEmpty()
        ) {
            log.warn("LEGO set with id {} not found; redirecting to /legosets",
                    id
            );
            return "redirect:/legosets";
        }

        model.addAttribute("legoSet",
                legoSet.get()
        );
        return "legosetdetails";
    }

    // GET /legosets/add - show an empty form
    @GetMapping("/add")
    public String showAddLegoSetForm(Model model) {
        log.debug("GET /legosets/add called");
        sessionHistory.addVisit("/legosets/add");

        model.addAttribute(
                "legoSetForm",
                new LegoSetViewModel()
        );

        return "addlegoset";
    }

    // POST /legosets/add - save the set, link the chosen piece, then redirect (PRG)
    @PostMapping("/add")
    public String processAddLegoSet(
            @Valid @ModelAttribute("legoSetForm") LegoSetViewModel legoSetViewModel,
            BindingResult errors
    ) {
        if (errors.hasErrors()) {
            errors.getAllErrors()
                    .forEach(error -> log.warn("Validation error: {}", error)
                    );
            return "addlegoset";
        }
        log.debug(
                "POST /legosets/add called with name='{}', pieceName='{}'",
                legoSetViewModel.getName(),
                legoSetViewModel.getPieceName()
        );

        // Convert the form (user input) into a real domain object.
        LegoSet legoSet = new LegoSet(
                legoSetViewModel.getName(),
                legoSetViewModel.getPieceCount(),
                legoSetViewModel.getPrice(),
                legoSetViewModel.getReleaseDate(),
                legoSetViewModel.getDifficulty(),
                legoSetViewModel.isRetired(),
                legoSetViewModel.getImageUrl()
        );

        legoSetService.addLegoSet(legoSet, legoSetViewModel.getPieceName()
        );

        log.info(
                "LEGO set '{}' added successfully; redirecting to /legosets",
                legoSetViewModel.getName()
        );

        return "redirect:/legosets";
    }
}
