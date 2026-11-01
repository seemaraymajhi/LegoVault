package be.kdg.legoproject.controller;

import be.kdg.legoproject.session.SessionHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    private static final Logger log =
            LoggerFactory.getLogger(HistoryController.class);

    private final SessionHistory sessionHistory;

    public HistoryController(SessionHistory sessionHistory
    ) {
        this.sessionHistory = sessionHistory;
    }

    // GET /history - show the pages visited in this session.
    @GetMapping("/history")
    public String showHistory(Model model
    ) {
        log.debug("GET /history called");
        sessionHistory.addVisit("/history");
        model.addAttribute("visits", sessionHistory.getVisits()
        );
        return "history";
    }
}