
package user.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.Author;
import user.domain.Paper;
import user.domain.PcMember;
import user.domain.Review;
import user.domain.User;
import user.domain.WritePaper;
import user.domain.Manager;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class UserDao {
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	final public String conInfo = "jdbc:mysql://127.0.0.1:3306/sampledb?"
            + "user=root&password=Shafiko93!";
	
	final public String connector = "com.mysql.cj.jdbc.Driver";
	
	public Manager findByUsername1(String musername) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Manager manager = new Manager();
		try {
			
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
		    String sql = "select * from manager where managerusername=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,musername);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String Manager_name = resultSet.getString("managerusername");
		    	if(Manager_name.equals(musername)){
		    		manager.setMusername(resultSet.getString("managerusername"));
		    		manager.setPassword(resultSet.getString("password"));
		    		manager.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return manager;
	}
	
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
		    String sql = "select * from tb_user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "insert into tb_user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * get data from tb_user
	 */
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from tb_user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	/**
	 * get data from author 
	 */
	public List<Object> Authorfindall()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from author";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Author author = new Author();
	    		author.setEmail(resultSet.getString("email"));
	    		author.setFirstname(resultSet.getString("firstname"));
	    		author.setLastname(resultSet.getString("lastname"));
	    		author.setAffiliation(resultSet.getString("affiliation"));
	    		list.add(author);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * get data from paper 
	 */
	public List<Object> Paperfindall()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from paper";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Paper paper = new Paper();
	    		paper.setPaperid(resultSet.getInt("paperid"));
	    		paper.setTitle(resultSet.getString("title"));
	    		paper.setAbs(resultSet.getString("abstract"));
	    		paper.setPdf(resultSet.getString("pdf"));
	    		list.add(paper);
			 }
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * get data from PcMember 
	 */
	public List<Object> PcMemberfindall()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from pcmember";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				PcMember pcmember = new PcMember();
				pcmember.setMemberid(resultSet.getInt("memberid"));
	    		pcmember.setEmail(resultSet.getString("email"));
	    		pcmember.setName(resultSet.getString("name"));
	    		list.add(pcmember);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * get data from writePaper 
	 */
	public List<Object> WritePaperfindall()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from writepaper";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				WritePaper writepaper = new WritePaper();
				writepaper.setPaperid(resultSet.getInt("paperid"));
	    		writepaper.setEmail(resultSet.getString("email"));
	    		writepaper.setOrdersignificance(resultSet.getInt("ordersignificance"));
	    		list.add(writepaper);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * get data from author 
	 */
	public List<Object> Reviewfindall()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(connector).newInstance();
			Connection connect = DriverManager.getConnection(conInfo);
			
			
			String sql = "select * from review";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Review review = new Review();
				review.setComment(resultSet.getString("comment"));
	    		review.setEmail(resultSet.getString("email"));
	    		review.setReportid(resultSet.getInt("reportid"));
	    		review.setRecommendation(resultSet.getString("recommendation"));
	    		review.setPaperid(resultSet.getInt("paperid"));
	    		review.setSdate(resultSet.getDate("sdate"));
	    		list.add(review);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * Insert for PcMember
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	 public void InsertPcMember(PcMember pcmember) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	        try {
	        	Class.forName(connector).newInstance();
				Connection connect = DriverManager.getConnection(conInfo);
				
				String sql = "insert into pcmember(email,name) values (?, ? )";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
	           
	            // Parameters start with 1
	            preparestatement.setString(1, pcmember.getEmail());
	            preparestatement.setString(2, pcmember.getName());
	            preparestatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	 /**
	  * Insert for Paper
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	  */
		 public void InsertPaper(Paper paper) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		        try {
		        	Class.forName(connector).newInstance();
					Connection connect = DriverManager.getConnection(conInfo);
					
					String sql = "insert into paper(title,abstract,pdf) values (?, ?, ?)";
					PreparedStatement preparestatement = connect.prepareStatement(sql); 
				
		           
		            // Parameters start with 1
		           
		            preparestatement.setString(1, paper.getTitle());
		            preparestatement.setString(2, paper.getAbs());
		            preparestatement.setString(3, paper.getPdf());
		            preparestatement.executeUpdate();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 /**
		  * Insert for Review
		 * @throws ClassNotFoundException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		  */
			 public void InsertReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			        try {
			        	Class.forName(connector).newInstance();
						Connection connect = DriverManager.getConnection(conInfo);
						
						String sql = "insert into review(sdate,comment,recommendation,paperid,email) values (?, ?, ?, ?, ?)";
						PreparedStatement preparestatement = connect.prepareStatement(sql); 
						
			           
			            // Parameters start with 1
			         
			            preparestatement.setDate(1, review.getSdate());
			            preparestatement.setString(2, review.getComment());
			            preparestatement.setString(3, review.getRecommendation());
			            preparestatement.setInt(4, review.getPaperid());
			            preparestatement.setString(5, review.getEmail());
			            preparestatement.executeUpdate();

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
		/**
		 * Delete for Review
		 * @throws ClassNotFoundException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 */
			 public void deleteReview(int reportid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			        try {
			        	Class.forName(connector).newInstance();
						Connection connect = DriverManager.getConnection(conInfo);
						String sql = "Delete from Review where reportid=?";
						PreparedStatement preparestatement = connect.prepareStatement(sql); 
					
			            // Parameters start with 1
			            preparestatement.setInt(1, reportid);
			            preparestatement.executeUpdate();

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
		/**
		 * Update for PcMemeber
		 * @param pcmember
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws ClassNotFoundException
		 */
			 public void updatePcmember(PcMember pcmember) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			        try {
			               Class.forName(connector).newInstance();
			               Connection connect = DriverManager.getConnection(conInfo);
			               String sql = "update pcmember set email=?, name=? where memberid=?";
			               PreparedStatement preparestatement = connect.prepareStatement(sql);
			              
			   
			            // Parameters start with 1
			            preparestatement.setString(1,pcmember.getEmail());
			            preparestatement.setString(2,pcmember.getName());
			            preparestatement.setInt(3,pcmember.getMemberid());
			            preparestatement.executeUpdate();
			 
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
		 /**
		  * update for paper
		  * @param user
		  * @throws ClassNotFoundException
		  * @throws IllegalAccessException
		  * @throws InstantiationException
		  */
			   public void updatePaper(Paper paper) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			        	try {
			        			Class.forName(connector).newInstance();
			                    Connection connect = DriverManager.getConnection(conInfo);
			                    String sql = "update paper set title=?, abstract=?, pdf=? where paperid=?";
			                    PreparedStatement preparestatement = connect.prepareStatement(sql);
			                 
			         
			            // Parameters start with 1
			            
			            preparestatement.setString(1,paper.getTitle());
			            preparestatement.setString(2,paper.getAbs());
			            preparestatement.setString(3,paper.getPdf());
			            preparestatement.setInt(4,paper.getPaperid());
			            preparestatement.executeUpdate();
			 
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
			 
			   /**
			    * update for review
			    * @throws ClassNotFoundException
			    * @throws IllegalAccessException
			    * @throws InstantiationException
			    */
			        public void updateReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			                try {
			                       Class.forName(connector).newInstance();
			                       Connection connect = DriverManager.getConnection(conInfo);
			                       String sql = "update review set comment=?, recommendation=?, paperid=?, email=? where reportid=?";
			                       PreparedStatement preparestatement = connect.prepareStatement(sql);
			                     
			                                                               
			               // Parameters start with 1
			             
			               preparestatement.setString(1, review.getComment());
			               preparestatement.setString(2, review.getRecommendation());
			               preparestatement.setInt(3, review.getPaperid());
			               preparestatement.setString(4, review.getEmail());
			               preparestatement.setInt(5, review.getReportid());
			               preparestatement.executeUpdate();
			 
			             } catch (SQLException e) {
			                   e.printStackTrace();
			                }
			            }
			      /**
			       * delete for pcmemebr
			       * @throws ClassNotFoundException
			       * @throws IllegalAccessException
			       * @throws InstantiationException
			       */
			           public void deletePcmember(int memberid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			                        try {
			                            Class.forName(connector).newInstance();
			                            Connection connect = DriverManager.getConnection(conInfo);
			                            String sql = "delete from pcmember where memberid=?";
			                            PreparedStatement preparestatement = connect.prepareStatement(sql);
			                          
			                 // Parameters start with 1
			                 preparestatement.setInt(1, memberid);
			                 preparestatement.executeUpdate();
			 
			                    } catch (SQLException e) {
			                            e.printStackTrace();
			                    		}
			                    }
			 
			      /**
			       * delete for paper
			       * @throws ClassNotFoundException
			       * @throws IllegalAccessException
			       * @throws InstantiationException
			       */
			               
			            public void deletePaper(int paperid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			                        try {
			                               Class.forName(connector).newInstance();
			                               Connection connect = DriverManager.getConnection(conInfo);
			                               String sql = "delete from paper where paperid=?";
			                               PreparedStatement preparestatement = connect.prepareStatement(sql);
			            
			                               preparestatement.setInt(1, paperid);
			                               preparestatement.executeUpdate();
			 
			                     } catch (SQLException e) {
			                            e.printStackTrace();
			                        		}
			                    }
			            /**
			             * find accepted paperss
			             * @return
			             * @throws InstantiationException
			             * @throws IllegalAccessException
			             * @throws ClassNotFoundException
			             */
			            public List<Object> Acceptedpaper()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
			        		List<Object> list = new ArrayList<>();
			        		try {
			        			Class.forName(connector).newInstance();
			        			Connection connect = DriverManager.getConnection(conInfo);
			        			
			        			
			        			String sql = "SELECT p.paperid, p.title, p.abstract, p.pdf "
			        						+"FROM accepted a,paper p "
			        						+"WHERE a.accept >1 "
			        						+"AND a.paperid = p.paperid";
			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			        			ResultSet resultSet = preparestatement.executeQuery();
			        			
			        			while(resultSet.next()){
			        				Paper paper1 = new Paper();
			        	    		paper1.setPaperid(resultSet.getInt("paperid"));
			        	    		paper1.setTitle(resultSet.getString("title"));
			        	    		paper1.setAbs(resultSet.getString("abstract"));
			        	    		paper1.setPdf(resultSet.getString("pdf"));
			        	    		list.add(paper1);
			        			 }
			        			
			        		} catch(SQLException e) {
			        			throw new RuntimeException(e);
			        		}
			        		return list;
			        	}
			            /**
			             * list pcmemebers with no assigned papers
			             * @return
			             * @throws InstantiationException
			             * @throws IllegalAccessException
			             * @throws ClassNotFoundException
			             */
			            public List<Object> nopaper()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
			        		List<Object> list = new ArrayList<>();
			        		try {
			        			Class.forName(connector).newInstance();
			        			Connection connect = DriverManager.getConnection(conInfo);
			        			
			        			
			        			String sql = "SELECT * "
			        					+"FROM pcmember p "
			        					+"WHERE p.email NOT "
			        					+"IN(SELECT r.email FROM review r)";
			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			        			ResultSet resultSet = preparestatement.executeQuery();
			        			
			        			while(resultSet.next()){
			        				PcMember pcmember1 = new PcMember();
			        				pcmember1.setMemberid(resultSet.getInt("memberid"));
			        	    		pcmember1.setEmail(resultSet.getString("email"));
			        	    		pcmember1.setName(resultSet.getString("name"));
			        	    		list.add(pcmember1);
			        			 }
			        			
			        		} catch(SQLException e) {
			        			throw new RuntimeException(e);
			        		}
			        		return list;
			        	}
			            /**

			        	 * Get single author from paper 

			        	 */

			       

			        	public List<Object> singleAuthor(String author)throws InstantiationException, IllegalAccessException, ClassNotFoundException{

			        		List<Object> list = new ArrayList<>();

			        		try {

			        			Class.forName(connector).newInstance();

			        			Connection connect = DriverManager.getConnection(conInfo);

			        			

			        			

			        			String sql = ("Select * from paper where paperid in (select paperid from writepaper where email in (select email from author where lastname = ?) and paperid not in (select paperid from writepaper where email <> (select email from author where lastname=?)))");

			        			

			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 

			        			 preparestatement.setString(1, author);

			        			 preparestatement.setString(2, author);

			        			 

			        			 ResultSet resultSet = preparestatement.executeQuery();

			        			 

			        			 while(resultSet.next()){

			        				 Paper paper = new Paper();

			        		    		paper.setPaperid(resultSet.getInt("paperid"));

			        		    		paper.setTitle(resultSet.getString("title"));

			        		    		paper.setAbs(resultSet.getString("abstract"));

			        		    		paper.setPdf(resultSet.getString("pdf"));

			        		    		list.add(paper);

			        				 }

			        		} catch(SQLException e) {

			        			throw new RuntimeException(e);

			        		}

			        		return list;

			        	}

			        	/**

			        	 * Get author as significance 1 

			        	 */

			       

			        	public List<Object> sigOne(String author)throws InstantiationException, IllegalAccessException, ClassNotFoundException{

			        		List<Object> list = new ArrayList<>();

			        		try {

			        			Class.forName(connector).newInstance();

			        			Connection connect = DriverManager.getConnection(conInfo);

			        			

			        			

			        			String sql = ("Select * from paper where paperid in (select paperid from writepaper where email = (select  email from author where lastname = ?) and ordersignificance=1)");

			        			

			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 

			        			 preparestatement.setString(1, author);

			       

			        			 

			        			 ResultSet resultSet = preparestatement.executeQuery();

			        			 

			        			 while(resultSet.next()){

			        				 Paper paper = new Paper();

			        		    		paper.setPaperid(resultSet.getInt("paperid"));

			        		    		paper.setTitle(resultSet.getString("title"));

			        		    		paper.setAbs(resultSet.getString("abstract"));

			        		    		paper.setPdf(resultSet.getString("pdf"));

			        		    		list.add(paper);

			        				 }

			        		} catch(SQLException e) {

			        			throw new RuntimeException(e);

			        		}

			        		return list;

			        	}

			        	

			        	/**

			        	 * Get coauthor 

			        	 */

			       

			        	public List<Object> CoAuthor(String author1, String author2)throws InstantiationException, IllegalAccessException, ClassNotFoundException{

			        		List<Object> list = new ArrayList<>();

			        		try {

			        			Class.forName(connector).newInstance();

			        			Connection connect = DriverManager.getConnection(conInfo);

			        			

			        			

			        			String sql = ("Select * from paper where paperid in (select paperid from writepaper where email = (select  email from author where lastname = ?)) and paperid in (select paperid from writepaper where email = (select email from author where lastname = ?))");

			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 

			        			 preparestatement.setString(1, author1);

			        			 preparestatement.setString(2, author2);

			       

			        			 

			        			 ResultSet resultSet = preparestatement.executeQuery();

			        			 

			        			 while(resultSet.next()){

			        				 Paper paper = new Paper();

			        		    		paper.setPaperid(resultSet.getInt("paperid"));

			        		    		paper.setTitle(resultSet.getString("title"));

			        		    		paper.setAbs(resultSet.getString("abstract"));

			        		    		paper.setPdf(resultSet.getString("pdf"));

			        		    		list.add(paper);

			        				 }

			        		} catch(SQLException e) {

			        			throw new RuntimeException(e);

			        		}

			        		return list;

			        	}

			        	/**

			        	 * Get reject by 2 

			        	 */

			       

			        	public List<Object> Rejected(String pcmem1, String pcmem2)throws InstantiationException, IllegalAccessException, ClassNotFoundException{

			        		List<Object> list = new ArrayList<>();

			        		try {

			        			Class.forName(connector).newInstance();

			        			Connection connect = DriverManager.getConnection(conInfo);

			        			

			        			

			        			String sql = ("select * from paper where paperid = (select paperid from review where email = (select email from pcmember where name=? and recommendation = 'n') and paperid in (select paperid from review where email = (select email from pcmember where name = ? and recommendation = 'n')))");

			        			PreparedStatement preparestatement = connect.prepareStatement(sql); 

			        			 preparestatement.setString(1, pcmem1);

			        			 preparestatement.setString(2, pcmem2);

			       

			        			 

			        			 ResultSet resultSet = preparestatement.executeQuery();

			        			 

			        			 while(resultSet.next()){

			        				 Paper paper = new Paper();

			        		    		paper.setPaperid(resultSet.getInt("paperid"));

			        		    		paper.setTitle(resultSet.getString("title"));

			        		    		paper.setAbs(resultSet.getString("abstract"));

			        		    		paper.setPdf(resultSet.getString("pdf"));

			        		    		list.add(paper);

			        				 }

			        		} catch(SQLException e) {

			        			throw new RuntimeException(e);

			        		}

			        		return list;

			        	}

			        	

			 


}