package model;

public class ReportBest {
	private String best_item;
	private int best_qty;

	public ReportBest() {
		super();
	}

	public ReportBest(String best_item, int best_qty) {
		super();
		this.best_item = best_item;
		this.best_qty = best_qty;
	}

	public String getBest_item() {
		return best_item;
	}

	public void setBest_item(String best_item) {
		this.best_item = best_item;
	}

	public int getBest_qty() {
		return best_qty;
	}

	public void setBest_qty(int best_qty) {
		this.best_qty = best_qty;
	}

	@Override
	public String toString() {
		return "ReportBest [best_item=" + best_item + ", best_qty=" + best_qty + "]";
	}

}
