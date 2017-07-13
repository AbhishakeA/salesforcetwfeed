package test.sftwitter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.sftwitter.beans.TwitterBean;
import test.sftwitter.utils.Constants;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**##Salesforce Twitter Feed Application##
 *
 * The Twitterservlet class acts as controller object in this MVC pattern application
 * This is created we container and invoked based web.xml descriptions and returns tweets for given user.
 * 
 * We may add more functionalities on this bean for search later.
 *
 * @author  Abhishake A
 * @version 1.0
 * @since   2017/7/12
 */
public class TwitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	public TwitterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	* The doGet method have the Controller Logic 
	* This when invoked as accessed by URI, Creates Model Bean TwitterBean to retrieve top10 Tweets and
	* forwards the bean to index.JSP-VIEW of our MVC pattern.
	* We may add other functionalities on this controller
	*
	* @author  Abhishake A
	* @version 1.0
	* @since   2017/7/12
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		/*Step 1. Create the Model objects to make Twitter API calls*/
		TwitterBean tbean = new TwitterBean();
		List < Status > statuses = null;
		statuses = tbean.getTweets(Constants.User);
		
		/*Step 2. Dispatch the data to jsp(View) to display on page and render it properly*/
		request.setAttribute("statuses", statuses);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		doGet(request, response);
	}
	
	/*This is created only for testing purpose from mockittestcase*/
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
	
		doGet(request, response);
	}

}