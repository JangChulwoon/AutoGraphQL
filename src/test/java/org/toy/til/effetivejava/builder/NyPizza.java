package org.toy.til.effetivejava.builder;

public class NyPizza extends Pizza {

    private final Size size;

    public NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}
