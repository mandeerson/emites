package br.com.reips.emites.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.mina.core.session.IoSession;

import br.com.reips.emites.constants.Constants;

public class Metrics {

    private Long searches = 0L;
    private Set<SessionMetrics> sessions = new LinkedHashSet<>();

    public Metrics(Collection<IoSession> sessions) {
        for (IoSession session : sessions) {
            add(session);
        }
    }

    @SuppressWarnings("unchecked")
    private void add(IoSession session) {
        TreeSet<Search> searches = (TreeSet<Search>) session.getAttribute(Constants.SEARCHES);
        this.searches += searches.size();

        sessions.add(new SessionMetrics(session, searches));
    }

    public Long getSearches() {
        return searches;
    }

    public void setSearches(Long searches) {
        this.searches = searches;
    }

    public Set<SessionMetrics> getSessions() {
        return sessions;
    }

    public void setSessions(Set<SessionMetrics> sessions) {
        this.sessions = sessions;
    }

}
