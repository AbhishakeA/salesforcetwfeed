package test.sftwitter.junits;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import test.sftwitter.servlets.TwitterServlet;
import test.sftwitter.utils.AuthUtility;
import twitter4j.Status;

/*##Salesforce Twitter Feed Application##
*
*This Junit Test case will test MVC controller and mainservlet and its operations
* It should make all neccessary calls to API to get the Feed
* It should fetch top 10 tweets from the given user*/

public class TwitterServletTester extends Mockito {

 @Mock
 HttpServletRequest request;
 @Mock
 HttpServletResponse response;
 @Mock
 HttpSession session;

 static TwitterServlet sampleServlet;
 @BeforeClass
 public static void loadProps() {
  sampleServlet = new TwitterServlet();


 }

 /*This test case will execute and checks if it is returning 10 tweets*/

 @Test
 public void test() throws ServletException, IOException {

  HttpServletRequest request = mock(HttpServletRequest.class);
  HttpServletResponse response = mock(HttpServletResponse.class);
  HttpSession stubHttpSession = mock(HttpSession.class);


  sampleServlet.doProcess(request, response);
  List < Status > statuses = (List < Status > ) request.getAttribute("statuses");
  assertEquals(10, statuses.size());;

 }

 /*This test case will execute and checks if it is returning expected User*/
 @Test
 public void test2() throws ServletException, IOException {

  HttpServletRequest request = mock(HttpServletRequest.class);
  HttpServletResponse response = mock(HttpServletResponse.class);
  HttpSession stubHttpSession = mock(HttpSession.class);


  sampleServlet.doProcess(request, response);
  List < Status > statuses = (List < Status > ) request.getAttribute("statuses");
  assertEquals(statuses.get(0).getUser(), "Salesforce");;

 }

}