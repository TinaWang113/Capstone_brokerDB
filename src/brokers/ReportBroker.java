/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Category;
import model.Item;
import model.OrderMgmt;
import model.ReportBest;
import model.ReportCustomer;
import model.ReportSale;
import model.TableMgmt;
import server.Connect2Server;

/***/
public class ReportBroker {

	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	boolean executedResult = false;
	ReportCustomer rc = new ReportCustomer();
	ReportSale rs = new ReportSale();

	SimpleDateFormat t_format = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM");
	SimpleDateFormat month = new SimpleDateFormat("MM");
	String today = t_format.format(new Date());
	String thisMonth = m_format.format(new Date()).concat("-01");
	LocalDate today1 = LocalDate.now();
	String baseline_today = today1.minusDays(1) + "";
	String baseline_month = today1.minusDays(30) + "";

	ArrayList<ReportBest> Best_Today = new ArrayList<ReportBest>();
	ArrayList<ReportBest> Best_Month = new ArrayList<ReportBest>();

	/**
	 * Get the table information for the report
	 * 
	 * @return ReportCustomer ReportCustomer object
	 * @throws SQLException SQLException
	 */
	public ReportCustomer getCustomerReport() throws SQLException {
		executedResult = false;
		connect();

		String stmtString1 = "select count(*) from capstone2020.table where startTime >=?;";
		PreparedStatement preparedStmt1 = con.prepareStatement(stmtString1);
		preparedStmt1.setString(1, today);
		ResultSet rs1 = preparedStmt1.executeQuery();
		rs1.next();
		rc.setTodayCustomer(rs1.getInt(1));

		String stmtString2 = "select count(*) from capstone2020.order where timeStamp >=?;";
		PreparedStatement preparedStmt2 = con.prepareStatement(stmtString2);
		preparedStmt2.setString(1, today);
		ResultSet rs2 = preparedStmt2.executeQuery();
		rs2.next();
		rc.setTodayOrder(rs2.getInt(1));

		String stmtString3 = "select count(*) from capstone2020.survey s where  s.table_startTime >=?;";
		PreparedStatement preparedStmt3 = con.prepareStatement(stmtString3);
		preparedStmt3.setString(1, today);
		ResultSet rs3 = preparedStmt3.executeQuery();
		rs3.next();
		rc.setTodayReview(rs3.getInt(1));

		String stmtString4 = "select avg(SurveyA1),avg(SurveyA2),avg(SurveyA3),avg(SurveyA4),avg(SurveyA5),avg(SurveyA6) ,avg(SurveyA7) from capstone2020.survey where table_startTime >=?;";
		PreparedStatement preparedStmt4 = con.prepareStatement(stmtString4);
		preparedStmt4.setString(1, thisMonth);
		ResultSet rs4 = preparedStmt4.executeQuery();
		rs4.next();
		rc.setQ_food(rs4.getDouble(1));
		rc.setQ_service(rs4.getDouble(2));
		rc.setQ_atmosphere(rs4.getDouble(3));
		rc.setQ_speed_svc(rs4.getDouble(4));
		rc.setQ_speec_food(rs4.getDouble(5));
		rc.setQ_recommendation(rs4.getDouble(6));
		rc.setQ_rate_app(rs4.getDouble(7));

		int q_avg_1 = 0;
		int q_avg_2 = 0;
		int q_avg_3 = 0;
		int q_avg_4 = 0;
		int q_avg_5 = 0;

		String stmtString5 = " select s.surveyA1, s.surveyA2, s.surveyA3, s.surveyA4, s.surveyA5, s.surveyA6,s.surveyA7 "
				+ "from capstone2020.survey s where  s.table_startTime >=?;";
		PreparedStatement preparedStmt5 = con.prepareStatement(stmtString5);
		preparedStmt5.setString(1, thisMonth);
		ResultSet rs5 = preparedStmt4.executeQuery();
		while (rs5.next()) {
			for (int i = 1; i < 7; i++) {
				switch (rs5.getInt(i)) {
				case 1:
					q_avg_1++;
				case 2:
					q_avg_2++;
				case 3:
					q_avg_3++;
				case 4:
					q_avg_4++;
				case 5:
					q_avg_5++;

				}
			}
		}
		rc.setQ_avg_1(q_avg_1);
		rc.setQ_avg_2(q_avg_2);
		rc.setQ_avg_3(q_avg_3);
		rc.setQ_avg_4(q_avg_4);
		rc.setQ_avg_5(q_avg_5);

		rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		rs5.close();
		return rc;
	}

	/**
	 * Get the trend of order count within 1 year.
	 * 
	 * @return ReportSale object
	 * @throws SQLException SQLException
	 */
	public ReportSale getSaleTrend() throws SQLException {
		executedResult = false;
		connect();

		String checkMonth = month.format(new Date());
		if (checkMonth.equals("02")) {
			thisMonth = m_format.format(new Date()).concat("-28");
		} else if (checkMonth.equals("04") || checkMonth.equals("06") || checkMonth.equals("09")
				|| checkMonth.equals("11")) {
			thisMonth = m_format.format(new Date()).concat("-30");
		} else {
			thisMonth = m_format.format(new Date()).concat("-31");
		}

		String month_0 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-01');";
		String month_1 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-02');";
		String month_2 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-03');";
		String month_3 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-04');";
		String month_4 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-05');";
		String month_5 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-06');";
		String month_6 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-07');";
		String month_7 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-08');";
		String month_8 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-09');";
		String month_9 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-10');";
		String month_10 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-11');";
		String month_11 = "select count(*) from capstone2020.order where timeStamp >=  DATE_FORMAT(? ,'%Y-%m-12');";

		int gap_0 = 0;
		int gap_1 = 0;
		int gap_2 = 0;
		int gap_3 = 0;
		int gap_4 = 0;
		int gap_5 = 0;
		int gap_6 = 0;
		int gap_7 = 0;
		int gap_8 = 0;
		int gap_9 = 0;
		int gap_10 = 0;
		int gap_11 = 0;

		PreparedStatement preparedStmt1 = con.prepareStatement(month_0);
		preparedStmt1.setString(1, thisMonth);
		ResultSet rs1 = preparedStmt1.executeQuery();
		rs1.next();
		gap_0 = rs1.getInt(1);

		PreparedStatement preparedStmt2 = con.prepareStatement(month_1);
		preparedStmt2.setString(1, thisMonth);
		ResultSet rs2 = preparedStmt2.executeQuery();
		rs2.next();
		gap_1 = rs2.getInt(1) - gap_0;
		if (gap_1 < 0) {
			gap_1 = gap_1 * -1;
		}

		PreparedStatement preparedStmt3 = con.prepareStatement(month_2);
		preparedStmt3.setString(1, thisMonth);
		ResultSet rs3 = preparedStmt3.executeQuery();
		rs3.next();
		gap_2 = rs3.getInt(1) - gap_1;
		if (gap_2 < 0) {
			gap_2 = gap_2 * -1;
		}

		PreparedStatement preparedStmt4 = con.prepareStatement(month_3);
		preparedStmt4.setString(1, thisMonth);
		ResultSet rs4 = preparedStmt4.executeQuery();
		rs4.next();
		gap_3 = rs4.getInt(1) - gap_2;
		if (gap_3 < 0) {
			gap_3 = gap_3 * -1;
		}

		PreparedStatement preparedStmt5 = con.prepareStatement(month_4);
		preparedStmt5.setString(1, thisMonth);
		ResultSet rs5 = preparedStmt5.executeQuery();
		rs5.next();
		gap_4 = rs5.getInt(1) - gap_3;
		if (gap_4 < 0) {
			gap_4 = gap_4 * -1;
		}

		PreparedStatement preparedStmt6 = con.prepareStatement(month_5);
		preparedStmt6.setString(1, thisMonth);
		ResultSet rs6 = preparedStmt6.executeQuery();
		rs6.next();
		gap_5 = rs6.getInt(1) - gap_4;
		if (gap_5 < 0) {
			gap_5 = gap_5 * -1;
		}

		PreparedStatement preparedStmt7 = con.prepareStatement(month_6);
		preparedStmt7.setString(1, thisMonth);
		ResultSet rs7 = preparedStmt7.executeQuery();
		rs7.next();
		gap_6 = rs7.getInt(1) - gap_5;
		if (gap_6 < 0) {
			gap_6 = gap_6 * -1;
		}

		PreparedStatement preparedStmt8 = con.prepareStatement(month_7);
		preparedStmt8.setString(1, thisMonth);
		ResultSet rs8 = preparedStmt8.executeQuery();
		rs8.next();
		gap_7 = rs8.getInt(1) - gap_6;
		if (gap_7 < 0) {
			gap_7 = gap_7 * -1;
		}

		PreparedStatement preparedStmt9 = con.prepareStatement(month_8);
		preparedStmt9.setString(1, thisMonth);
		ResultSet rs9 = preparedStmt9.executeQuery();
		rs9.next();
		gap_8 = rs9.getInt(1) - gap_7;
		if (gap_8 < 0) {
			gap_8 = gap_8 * -1;
		}

		PreparedStatement preparedStmt10 = con.prepareStatement(month_9);
		preparedStmt10.setString(1, thisMonth);
		ResultSet rs10 = preparedStmt10.executeQuery();
		rs10.next();
		gap_9 = rs10.getInt(1) - gap_8;
		if (gap_9 < 0) {
			gap_9 = gap_9 * -1;
		}

		PreparedStatement preparedStmt11 = con.prepareStatement(month_10);
		preparedStmt11.setString(1, thisMonth);
		ResultSet rs11 = preparedStmt11.executeQuery();
		rs11.next();
		gap_10 = rs11.getInt(1) - gap_9;
		if (gap_10 < 0) {
			gap_10 = gap_10 * -1;
		}

		PreparedStatement preparedStmt12 = con.prepareStatement(month_11);
		preparedStmt12.setString(1, thisMonth);
		ResultSet rs12 = preparedStmt12.executeQuery();
		rs12.next();
		gap_11 = rs12.getInt(1) - gap_10;
		if (gap_11 < 0) {
			gap_11 = gap_11 * -1;
		}

		rs.setThisMonth_0(gap_0);
		rs.setThisMonth_1(gap_1);
		rs.setThisMonth_2(gap_2);
		rs.setThisMonth_3(gap_3);
		rs.setThisMonth_4(gap_4);
		rs.setThisMonth_5(gap_5);
		rs.setThisMonth_6(gap_6);
		rs.setThisMonth_7(gap_7);
		rs.setThisMonth_8(gap_8);
		rs.setThisMonth_9(gap_9);
		rs.setThisMonth_10(gap_10);
		rs.setThisMonth_11(gap_11);

		return rs;
	}

	/**
	 * Get today's sale information
	 * 
	 * @return ArrayList<ReportBest>
	 * @throws SQLException SQLException
	 */
	public ArrayList<ReportBest> getSaleBestToday() throws SQLException {
		executedResult = false;
		connect();
		String stmt_top10_today = "select i.itemName, sum(o.orderItemQty)"
				+ "from capstone2020.order o, capstone2020.item i "
				+ "where i.itemID=o.item_itemID and o.timestamp > ? "
				+ "group by i.itemName  order by 2 desc limit 10;";
		PreparedStatement topStatementToday = con.prepareStatement(stmt_top10_today);
		topStatementToday.setString(1, baseline_today);
		ResultSet rs_today = topStatementToday.executeQuery();

		while (rs_today.next()) {
			ReportBest rb = new ReportBest();
			rb.setBest_item(rs_today.getString(1));
			rb.setBest_qty(rs_today.getInt(2));
			Best_Today.add(rb);
		}

		return Best_Today;
	}

	/**
	 * Get the best month for the sale
	 * 
	 * @return ArrayList<ReportBest>
	 * @throws SQLException SQLException
	 */
	public ArrayList<ReportBest> getSaleBestMonth() throws SQLException {

		executedResult = false;
		connect();
		String stmt_top10_today = "select i.itemName, sum(o.orderItemQty)"
				+ "from capstone2020.order o, capstone2020.item i "
				+ "where i.itemID=o.item_itemID and o.timestamp > ? "
				+ "group by i.itemName  order by 2 desc limit 10;";
		PreparedStatement topStatementToday = con.prepareStatement(stmt_top10_today);
		topStatementToday.setString(1, baseline_month);
		ResultSet rs_today = topStatementToday.executeQuery();

		while (rs_today.next()) {
			ReportBest rb = new ReportBest();
			rb.setBest_item(rs_today.getString(1));
			rb.setBest_qty(rs_today.getInt(2));
			Best_Month.add(rb);
		}

		return Best_Month;
	}

	/**
	 * Establish database connection
	 * 
	 * @return Connection
	 * @throws SQLException SQLException
	 */
	public Connection connect() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}

}
