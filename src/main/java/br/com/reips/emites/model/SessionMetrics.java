package br.com.reips.emites.model;

import java.util.Set;

import org.apache.mina.core.session.IoSession;

public class SessionMetrics {

    private IoSession session;
    private Set<Search> searches;

    public SessionMetrics(IoSession session, Set<Search> searches) {
        this.session = session;
        this.searches = searches;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    public Set<Search> getSearches() {
        return searches;
    }

    public void setSearches(Set<Search> searches) {
        this.searches = searches;
    }

}
