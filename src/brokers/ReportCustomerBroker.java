/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Category;
import model.Item;
import model.OrderMgmt;
import model.ReportCustomer;
import model.TableMgmt;
import server.Connect2Server;

/***/
public class ReportCustomerBroker {

	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	boolean executedResult = false;
	ReportCustomer rc = new ReportCustomer();

	SimpleDateFormat t_format = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM");
	String today = t_format.format(new Date());
	String thisMonth = m_format.format(new Date()).concat("-01");

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

	public Connection connect() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}

}
