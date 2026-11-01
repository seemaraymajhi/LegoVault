package be.kdg.legoproject.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

// One visited page with the moment it was visited.
public class PageVisit {

    private static final Logger log =
            LoggerFactory.getLogger(PageVisit.class);

    private final String page;
    private final LocalDateTime timestamp;

    public PageVisit(String page, LocalDateTime timestamp) {
        this.page = page;
        this.timestamp = timestamp;
        log.debug("Created page visit for '{}' at {}", page, timestamp);
    }

    public String getPage() {
        return page;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}