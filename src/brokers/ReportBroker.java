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
	String today = t_format.format(new Date());
	String thisMonth = m_format.format(new Date()).concat("-01");
	LocalDate today1 = LocalDate.now();
	String baseline_today = today1.minusDays(1) + "";
	String baseline_month = today1.minusDays(30) + "";

	ArrayList<ReportBest> Best_Today = new ArrayList<ReportBest>();
	ArrayList<ReportBest> Best_Month = new ArrayList<ReportBest>();

	/**
	 * 
	 * @return
	 * @throws SQLException
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

	public ReportSale getSaleTrend() throws SQLException {
		executedResult = false;
		connect();
		thisMonth = m_format.format(new Date()).concat("-31");

		String stmtString1 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-01') AND ?;";
		String stmtString2 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-02') AND DATE_FORMAT(? ,'%Y-%m-01');";
		String stmtString3 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-03') AND DATE_FORMAT(? ,'%Y-%m-02');";
		String stmtString4 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-04') AND DATE_FORMAT(? ,'%Y-%m-03')";
		String stmtString5 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-05') AND DATE_FORMAT(? ,'%Y-%m-04')";
		String stmtString6 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-06') AND DATE_FORMAT(? ,'%Y-%m-05');";
		String stmtString7 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-07') AND DATE_FORMAT(? ,'%Y-%m-06');";
		String stmtString8 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-08') AND DATE_FORMAT(? ,'%Y-%m-07');";
		String stmtString9 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-09') AND DATE_FORMAT(? ,'%Y-%m-08');";
		String stmtString10 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-10') AND DATE_FORMAT(? ,'%Y-%m-09');";
		String stmtString11 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-11') AND DATE_FORMAT(? ,'%Y-%m-10');";
		String stmtString12 = "select count(*) from capstone2020.order where timeStamp between  DATE_FORMAT(? ,'%Y-%m-12') AND DATE_FORMAT(? ,'%Y-%m-11');";

		PreparedStatement preparedStmt1 = con.prepareStatement(stmtString1);
		preparedStmt1.setString(1, today);
		preparedStmt1.setString(2, thisMonth);
		ResultSet rs1 = preparedStmt1.executeQuery();
		rs1.next();
		rs.setThisMonth_0(rs1.getInt(1));

		PreparedStatement preparedStmt2 = con.prepareStatement(stmtString2);
		preparedStmt2.setString(1, thisMonth);
		preparedStmt2.setString(2, thisMonth);
		ResultSet rs2 = preparedStmt2.executeQuery();
		rs2.next();
		rs.setThisMonth_1(rs2.getInt(1));

		PreparedStatement preparedStmt3 = con.prepareStatement(stmtString3);
		preparedStmt3.setString(1, thisMonth);
		preparedStmt3.setString(2, thisMonth);
		ResultSet rs3 = preparedStmt3.executeQuery();
		rs3.next();
		rs.setThisMonth_2(rs3.getInt(1));

		PreparedStatement preparedStmt4 = con.prepareStatement(stmtString4);
		preparedStmt4.setString(1, thisMonth);
		preparedStmt4.setString(2, thisMonth);
		ResultSet rs4 = preparedStmt4.executeQuery();
		rs4.next();
		rs.setThisMonth_3(rs4.getInt(1));

		PreparedStatement preparedStmt5 = con.prepareStatement(stmtString5);
		preparedStmt5.setString(1, thisMonth);
		preparedStmt5.setString(2, thisMonth);
		ResultSet rs5 = preparedStmt5.executeQuery();
		rs5.next();
		rs.setThisMonth_4(rs5.getInt(1));

		PreparedStatement preparedStmt6 = con.prepareStatement(stmtString6);
		preparedStmt6.setString(1, thisMonth);
		preparedStmt6.setString(2, thisMonth);
		ResultSet rs6 = preparedStmt6.executeQuery();
		rs6.next();
		rs.setThisMonth_5(rs6.getInt(1));

		PreparedStatement preparedStmt7 = con.prepareStatement(stmtString7);
		preparedStmt7.setString(1, thisMonth);
		preparedStmt7.setString(2, thisMonth);
		ResultSet rs7 = preparedStmt7.executeQuery();
		rs7.next();
		rs.setThisMonth_6(rs7.getInt(1));

		PreparedStatement preparedStmt8 = con.prepareStatement(stmtString8);
		preparedStmt8.setString(1, thisMonth);
		preparedStmt8.setString(2, thisMonth);
		ResultSet rs8 = preparedStmt8.executeQuery();
		rs8.next();
		rs.setThisMonth_7(rs8.getInt(1));

		PreparedStatement preparedStmt9 = con.prepareStatement(stmtString9);
		preparedStmt9.setString(1, thisMonth);
		preparedStmt9.setString(2, thisMonth);
		ResultSet rs9 = preparedStmt9.executeQuery();
		rs9.next();
		rs.setThisMonth_8(rs9.getInt(1));

		PreparedStatement preparedStmt10 = con.prepareStatement(stmtString10);
		preparedStmt10.setString(1, thisMonth);
		preparedStmt10.setString(2, thisMonth);
		ResultSet rs10 = preparedStmt10.executeQuery();
		rs10.next();
		rs.setThisMonth_9(rs10.getInt(1));

		PreparedStatement preparedStmt11 = con.prepareStatement(stmtString11);
		preparedStmt11.setString(1, thisMonth);
		preparedStmt11.setString(2, thisMonth);
		ResultSet rs11 = preparedStmt11.executeQuery();
		rs11.next();
		rs.setThisMonth_10(rs11.getInt(1));

		PreparedStatement preparedStmt12 = con.prepareStatement(stmtString12);
		preparedStmt12.setString(1, thisMonth);
		preparedStmt12.setString(2, thisMonth);
		ResultSet rs12 = preparedStmt12.executeQuery();
		rs12.next();
		rs.setThisMonth_11(rs12.getInt(1));

		return rs;

	}

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

	public Connection connect() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}

}
