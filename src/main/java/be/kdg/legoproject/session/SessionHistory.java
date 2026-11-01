package be.kdg.legoproject.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// One SessionHistory per user session: every browser gets its own list.
@Component
@SessionScope
public class SessionHistory {

    private static final Logger log =
            LoggerFactory.getLogger(SessionHistory.class);

    private final List<PageVisit> visits = new ArrayList<>();

    public void addVisit(String page) {
        visits.add(new PageVisit(page, LocalDateTime.now()
                )
        );
        log.debug("Visit to '{}' added; this session now has {} visit(s)",
                page, visits.size()
        );
    }

    // A copy, so other classes cannot change the history.
    public List<PageVisit> getVisits() {
        return List.copyOf(visits);
    }
}