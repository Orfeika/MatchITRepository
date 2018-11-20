package exercise1;

public class PrimeList {
	private int n;
	private boolean list[];

	public PrimeList(int n) {
		this.n = n;
		prepareList();
	}

	private void prepareList() {
		list = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = true;
		}
		int counter = 0;

		list[0] = false;
		list[1] = false;
		int n = counter >= 3 ? (int) Math.sqrt(list.length) + 1 : list.length;
		for (int j = 2; j < n; j++) {
			if (list[j]) {
				for (int k = j; k < list.length; k++) {
					if (k != j && k % j == 0) {
						list[k] = false;

					}
					counter++;
				}

			}
		}

	}

	public boolean isPrime(int nbr) {
		for (int i = 0; i < list.length; i++) {
			if (i == nbr) {
				return list[nbr];

			}
		}
		return false;
	}

	public void printPrimeList() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.length; i++) {
			if (isPrime(i)) {
				sb.append(i);
				sb.append(" ");

			}
		}
		System.out.println(sb.toString());
	}

}
