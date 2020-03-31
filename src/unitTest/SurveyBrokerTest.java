/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.SurveyBroker;
import brokers.TableBroker;
import model.Survey;
import model.Table;

/**
 * @author 730693
 *
 */
class SurveyBrokerTest {
	
	TableBroker tBroker = new TableBroker();
	SurveyBroker sb = new SurveyBroker();
	Survey survey_1;
	Survey survey_2;
	Survey survey_3;
	ArrayList<Table>tables;
	ArrayList<Survey> surveys;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Double>survArrayList = new ArrayList<Double>();
		Random r = new Random(); 
	    double d =  0.0; 
	    tables = (ArrayList<Table>) tBroker.findAll();
	    for(int i=0; i< 8; i++) {
			d =  Math.round((r.nextDouble() * 10.0)*10.0)/10.0;
			survArrayList.add(d);
		}
		tBroker = new TableBroker();
		sb = new SurveyBroker();
		survey_1 = new Survey(survArrayList, tables.get(1).getTableID(), tables.get(1).getStartTime());
		survey_2 = new Survey(survArrayList, tables.get(2).getTableID(), tables.get(2).getStartTime());
		survey_3 = new Survey(survArrayList, tables.get(3).getTableID(), tables.get(3).getStartTime());
		TimeUnit.SECONDS.sleep(2);
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#InsertSurvey(model.Survey)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertSurvey() throws SQLException {
		assertFalse(sb.isExisting(survey_1));
		assertTrue(sb.InsertSurvey(survey_1));
		surveys = sb.getAll();
		assertTrue(sb.isExisting(surveys.get(surveys.size()-1)));
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#isExisting(model.Survey)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisting() throws SQLException {
		surveys = sb.getAll();
		assertTrue(sb.isExisting(surveys.get(1)));
		assertFalse(sb.isExisting(survey_1));
		assertTrue(sb.deleteByID(surveys.get(1)));
		assertFalse(sb.isExisting(surveys.get(1)));
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#getSurvey(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testGetSurveyInt() throws SQLException {
		surveys = sb.getAll();
		Survey findSurvey = sb.getSurvey(surveys.get(1).getSurveyID());
		System.out.println("[unitest]findSurvey: "+ findSurvey.toString());
		assertEquals(findSurvey.getSurveyID(), surveys.get(1).getSurveyID());
		assertTrue(sb.InsertSurvey(survey_1));
		surveys = sb.getAll();
		findSurvey = sb.getSurvey(surveys.get(surveys.size()-1).getSurveyID());
		System.out.println("[unitest]findSurvey: "+ findSurvey.toString());
		assertEquals(findSurvey.getTableID(), survey_1.getTableID());
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#getSurvey(model.Survey)}.
	 * @throws SQLException 
	 */
	@Test
	void testGetSurveySurvey() throws SQLException {
		surveys = sb.getAll();
		Survey findSurvey = sb.getSurvey(surveys.get(1));
		System.out.println("[uniTest_SB] findSurvey = " + findSurvey.toString());
		System.out.println("[uniTest_SB] surveys.get(1) = " + surveys.get(1).toString());
		assertEquals(findSurvey.getSurveyAs().get(1), surveys.get(1).getSurveyAs().get(1));
		assertTrue(sb.deleteByID(surveys.get(1)));
		findSurvey = sb.getSurvey(surveys.get(1));
		assertEquals(findSurvey,null);
		
		assertTrue(sb.InsertSurvey(survey_3));
		surveys = sb.getAll();
		findSurvey = sb.getSurvey(surveys.get(surveys.size()-1));
		assertEquals(findSurvey.getTableID(), survey_3.getTableID());
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#getSurvey(int, java.sql.Timestamp)}.
	 * @throws SQLException 
	 */
	@Test
	void testGetSurveyIntTimestamp() throws SQLException {
		surveys = sb.getAll();
		Survey findSurvey = sb.getSurvey(tables.get(5).getTableID(), tables.get(5).getStartTime());
		assertEquals(findSurvey, null);
		assertTrue(sb.InsertSurvey(survey_1));
		findSurvey = sb.getSurvey(survey_1.getTableID(),survey_1.getTable_startTime());
		surveys = sb.getAll();
		assertEquals(findSurvey.getSurveyID(), surveys.get(surveys.size()-1).getSurveyID());
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#getAll()}.
	 */
	@Test
	void testGetAll() throws SQLException {
		int qty = sb.qtyData();
		surveys = sb.getAll();
		assertEquals(surveys.size(), qty);
		assertTrue(sb.InsertSurvey(survey_3));
		qty = sb.qtyData();
		surveys = sb.getAll();
		assertEquals(surveys.size(), qty);
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#deleteByID(model.Survey)}.
	 */
	@Test
	void testDeleteByID() throws SQLException {
		int qty = sb.qtyData();
		surveys = sb.getAll();
		assertTrue(sb.isExisting(surveys.get(1)));
		assertTrue(sb.deleteByID(surveys.get(1)));
		assertEquals(sb.qtyData(), qty-1);
		assertFalse(sb.isExisting(surveys.get(1)));
		
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#qtyData()}.
	 */
	@Test
	void testQtyData() throws SQLException {
		int qty = sb.qtyData();
		surveys = sb.getAll();
		assertTrue(sb.InsertSurvey(survey_3));
		assertEquals(sb.qtyData(),qty+1);
		assertTrue(sb.deleteByID(surveys.get(1)));
		assertEquals(sb.qtyData(), qty);
	}

	/**
	 * Test method for {@link brokers.SurveyBroker#update(model.Survey)}.
	 */
	@Test
	void testUpdate() throws SQLException {
		surveys = sb.getAll();
		Survey updateSurvey = surveys.get(1);
		ArrayList<Double> survArrayList = new ArrayList<Double>();
		Random r = new Random(); 
	    double d =  0.0; 
	    for(int i=0; i< 8; i++) {
			d =  Math.round((r.nextDouble() * 10.0)*10.0)/10.0;
			survArrayList.add(d);
		}
		updateSurvey.setSurveyAs(survArrayList);
		System.out.println("[uniTest]updateSurvey: " + updateSurvey.toString());
		assertTrue(sb.update(updateSurvey));
		Survey compareSurvey = sb.getSurvey(surveys.get(1).getSurveyID());
		System.out.println("[uniTest]compareSurvey: "+ compareSurvey.toString());
		for(int i=0; i< compareSurvey.getSurveyAs().size();i++) {
			assertEquals(compareSurvey.getSurveyAs().get(i), updateSurvey.getSurveyAs().get(i));
		}
		//update wrongData;
		
		assertFalse(sb.update(survey_3));
		updateSurvey.setSurveyID(99);
		assertFalse(sb.update(updateSurvey));
	}

}
