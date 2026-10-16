package be.kdg.legoproject.controller;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.Material;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.web.LegoPieceForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/legopieces")
public class LegoPieceController {

    private static final Logger log =
            LoggerFactory.getLogger(LegoPieceController.class);

    private final LegoPieceService legoPieceService;

    public LegoPieceController(LegoPieceService legoPieceService) {
        this.legoPieceService = legoPieceService;
    }

    // Makes the material values available before every controller request.
    @ModelAttribute("materials")
    public Material[] materials() {
        return Material.values();
    }

    // GET /legopieces - display all LEGO pieces.          ← RESTORED
    @GetMapping
    public String showLegoPieces(Model model) {
        log.debug("GET /legopieces called");
        return renderLegoPieces("", "", model);
    }

    // GET /legopieces/search - both filters are optional.
    @GetMapping("/search")
    public String searchLegoPieces(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "material", required = false, defaultValue = "") String material,
            Model model
    ) {
        log.debug("GET /legopieces/search called with name='{}', material='{}'",
                name, material);
        return renderLegoPieces(name, material, model);
    }

    // GET /legopieces/add - show an empty form.
    @GetMapping("/add")
    public String showAddLegoPieceForm(Model model) {
        log.debug("GET /legopieces/add called");
        model.addAttribute("legoPieceForm", new LegoPieceForm());
        return "addlegopiece";
    }

    // POST /legopieces/add - save the new piece, then redirect (PRG).   ← NEW
    @PostMapping("/add")
    public String processAddLegoPiece(
            @ModelAttribute("legoPieceForm") LegoPieceForm form
    ) {
        log.debug("POST /legopieces/add called with name='{}', color='{}', material={}",
                form.getName(), form.getColor(), form.getMaterial());

        LegoPiece legoPiece = new LegoPiece(
                form.getName(),
                form.getColor(),
                form.getMaterial()
        );
        legoPieceService.addLegoPiece(legoPiece);

        log.info("LEGO piece '{}' added, redirecting to /legopieces", form.getName());
        return "redirect:/legopieces";
    }

    // Shared helper: fills the model for legopieces.html.
    private String renderLegoPieces(String name, String material, Model model) {
        log.debug("Showing LEGO pieces with name substring '{}' and material '{}'",
                name, material);

        model.addAttribute("legoPieces", legoPieceService.searchLegoPieces(name, material));
        model.addAttribute("name", name);
        model.addAttribute("material", material);

        return "legopieces";
    }
}