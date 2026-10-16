package be.kdg.legoproject.controller;

import be.kdg.legoproject.domain.Material;
import be.kdg.legoproject.service.LegoPieceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // GET /legopieces - display all LEGO pieces.
    @GetMapping
    public String showLegoPieces(Model model) {
        log.debug("GET /legopieces called");
        return renderLegoPieces("", "", model);
    }

    // GET /legopieces/search - both filters are optional.
    @GetMapping("/search")
    public String searchLegoPieces(
            @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue = ""
            ) String name,
            @RequestParam(
                    name = "material",
                    required = false,
                    defaultValue = ""
            ) String material,
            Model model
    ) {
        log.debug(
                "GET /legopieces/search called with name='{}', material='{}'",
                name,
                material
        );

        return renderLegoPieces(name, material, model);
    }

    private String renderLegoPieces(
            String name,
            String material,
            Model model
    ) {
        log.debug(
                "Showing LEGO pieces with name substring '{}' and material '{}'",
                name,
                material
        );

        model.addAttribute(
                "legoPieces",
                legoPieceService.searchLegoPieces(name, material)
        );

        // Preserve the submitted filter values.
        model.addAttribute("name", name);
        model.addAttribute("material", material);

        return "legopieces";
    }
}
