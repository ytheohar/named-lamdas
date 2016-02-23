package org.ytheohar.named.lamdas;

public interface NamedLamda {

	String apply(String s);

	default NamedLamda namedWith(String name) {
		return new NamedLamda() {

			@Override
			public String apply(String s) {
				return NamedLamda.this.apply(s);
			}

			@Override
			public String toString() {
				return name;
			}
		};
	}
}
