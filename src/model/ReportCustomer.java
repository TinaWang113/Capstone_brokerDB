package model;

public class ReportCustomer {

	private int todayCustomer;
	private int todayOrder;
	private int todayReview;
	private double q_avg_1;
	private double q_avg_2;
	private double q_avg_3;
	private double q_avg_4;
	private double q_avg_5;
	private double q_food;
	private double q_service;
	private double q_atmosphere;
	private double q_speed_svc;
	private double q_speec_food;
	private double q_recommendation;
	private double q_rate_app;

	public ReportCustomer() {
		super();
	}

	public ReportCustomer(int todayCustomer, int todayOrder, int todayReview, double q_avg_1, double q_avg_2,
			double q_avg_3, double q_avg_4, double q_avg_5, double q_food, double q_service, double q_atmosphere,
			double q_speed_svc, double q_speec_food, double q_recommendation, double q_rate_app) {
		super();
		this.todayCustomer = todayCustomer;
		this.todayOrder = todayOrder;
		this.todayReview = todayReview;
		this.q_avg_1 = q_avg_1;
		this.q_avg_2 = q_avg_2;
		this.q_avg_3 = q_avg_3;
		this.q_avg_4 = q_avg_4;
		this.q_avg_5 = q_avg_5;
		this.q_food = q_food;
		this.q_service = q_service;
		this.q_atmosphere = q_atmosphere;
		this.q_speed_svc = q_speed_svc;
		this.q_speec_food = q_speec_food;
		this.q_recommendation = q_recommendation;
		this.q_rate_app = q_rate_app;
	}

	public int getTodayCustomer() {
		return todayCustomer;
	}

	public void setTodayCustomer(int todayCustomer) {
		this.todayCustomer = todayCustomer;
	}

	public int getTodayOrder() {
		return todayOrder;
	}

	public void setTodayOrder(int todayOrder) {
		this.todayOrder = todayOrder;
	}

	public int getTodayReview() {
		return todayReview;
	}

	public void setTodayReview(int todayReview) {
		this.todayReview = todayReview;
	}

	public double getQ_avg_1() {
		return q_avg_1;
	}

	public void setQ_avg_1(double q_avg_1) {
		this.q_avg_1 = q_avg_1;
	}

	public double getQ_avg_2() {
		return q_avg_2;
	}

	public void setQ_avg_2(double q_avg_2) {
		this.q_avg_2 = q_avg_2;
	}

	public double getQ_avg_3() {
		return q_avg_3;
	}

	public void setQ_avg_3(double q_avg_3) {
		this.q_avg_3 = q_avg_3;
	}

	public double getQ_avg_4() {
		return q_avg_4;
	}

	public void setQ_avg_4(double q_avg_4) {
		this.q_avg_4 = q_avg_4;
	}

	public double getQ_avg_5() {
		return q_avg_5;
	}

	public void setQ_avg_5(double q_avg_5) {
		this.q_avg_5 = q_avg_5;
	}

	public double getQ_food() {
		return q_food;
	}

	public void setQ_food(double q_food) {
		this.q_food = q_food;
	}

	public double getQ_service() {
		return q_service;
	}

	public void setQ_service(double q_service) {
		this.q_service = q_service;
	}

	public double getQ_atmosphere() {
		return q_atmosphere;
	}

	public void setQ_atmosphere(double q_atmosphere) {
		this.q_atmosphere = q_atmosphere;
	}

	public double getQ_speed_svc() {
		return q_speed_svc;
	}

	public void setQ_speed_svc(double q_speed_svc) {
		this.q_speed_svc = q_speed_svc;
	}

	public double getQ_speec_food() {
		return q_speec_food;
	}

	public void setQ_speec_food(double q_speec_food) {
		this.q_speec_food = q_speec_food;
	}

	public double getQ_recommendation() {
		return q_recommendation;
	}

	public void setQ_recommendation(double q_recommendation) {
		this.q_recommendation = q_recommendation;
	}

	public double getQ_rate_app() {
		return q_rate_app;
	}

	public void setQ_rate_app(double q_rate_app) {
		this.q_rate_app = q_rate_app;
	}

	@Override
	public String toString() {
		return "ReportCustomer [todayCustomer=" + todayCustomer + ", todayOrder=" + todayOrder + ", todayReview="
				+ todayReview + ", q_avg_1=" + q_avg_1 + ", q_avg_2=" + q_avg_2 + ", q_avg_3=" + q_avg_3 + ", q_avg_4="
				+ q_avg_4 + ", q_avg_5=" + q_avg_5 + ", q_food=" + q_food + ", q_service=" + q_service
				+ ", q_atmosphere=" + q_atmosphere + ", q_speed_svc=" + q_speed_svc + ", q_speec_food=" + q_speec_food
				+ ", q_recommendation=" + q_recommendation + ", q_rate_app=" + q_rate_app + "]";
	}

}
