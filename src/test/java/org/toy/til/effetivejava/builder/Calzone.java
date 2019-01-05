package org.toy.til.effetivejava.builder;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    public Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
