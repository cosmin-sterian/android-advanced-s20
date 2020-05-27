package ro.example.android.data.remote;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NewsQuery {
    private String q;
    private String country;
    private String category;
    private Set<String> sources;

    private NewsQuery(final NewsQuery.Builder builder) {
        this.q = builder.q;
        this.country = builder.country;
        this.category = builder.category;
        this.sources = builder.sources;
    }

    public String getQ() {
        return q;
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getSources() {
        return sources == null ? null : new LinkedList<>(sources);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String q;
        private String country;
        private String category;
        private Set<String> sources;

        Builder() {
            q = null;
            country = null;
            category = null;
            sources = null;
        }

        public Builder setQ(String q) {
            this.q = q;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            resetSources();
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            resetSources();
            return this;
        }

        public Builder addAllSources(Collection<String> sources) {
            if (this.sources == null) {
                this.sources = new LinkedHashSet<>(sources);
            } else {
                this.sources.addAll(sources);
            }
            resetCountryAndCategory();
            return this;
        }

        public Builder addSource(String source) {
            if (this.sources == null) {
                this.sources = new LinkedHashSet<>();
            }
            this.sources.add(source);
            resetCountryAndCategory();
            return this;
        }

        public NewsQuery build() {
            return new NewsQuery(this);
        }

        private void resetSources() {
            this.sources = null;
        }

        private void resetCountryAndCategory() {
            this.country = null;
            this.category = null;
        }
    }
}
