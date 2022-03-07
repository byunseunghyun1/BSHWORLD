package kr.ac.hansung.cse.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Offer;



@Repository("offerDao")
public class OfferDao {
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int getRowCount() {
    	
    	String sqlStatement = "select count(*) from manage";
    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class); 
    	
    }
    
    
    // cRud method 
    // query and return a sigleton object 
    public Offer getOffer(String name) {
    	String sqlStatement="select * from manage " ; 
    	
     return   jdbcTemplate.queryForObject(sqlStatement,new RowMapper<Offer>() {
    			
    			@Override
    			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
  
    				
    				Offer offer =new Offer();
    				
    				
    				
    				offer.setId(rs.getInt("id"));
    				offer.setLearnedyear(rs.getInt("learnedyear"));
    				offer.setSemester(rs.getInt("semester"));
    				offer.setCode(rs.getString("code"));
    				offer.setClassname(rs.getString("classname"));
    				offer.setClassification(rs.getString("classification"));
    				offer.setProfessor(rs.getString("professor"));
    				offer.setCredit(rs.getInt("semester"));
    				
    	
    				
    				return offer;
    				
    			}
    			
    			}, new Object[] {name});
    }
    
    public List<Offer>  getOffer() {
    	
    	String sqlStatement="select *,sum(credit) AS 'sumcredit' from manage WHERE learnedyear<2022 GROUP BY learnedyear, semester ORDER BY learnedyear DESC, semester DESC " ; 
    	return jdbcTemplate.query(sqlStatement,new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
			
				
				Offer offer =new Offer();
				
				
				offer.setId(rs.getInt("id"));
				offer.setLearnedyear(rs.getInt("learnedyear"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setClassname(rs.getString("classname"));
				offer.setClassification(rs.getString("classification"));
				offer.setProfessor(rs.getString("professor"));
				offer.setCredit(rs.getInt("credit"));
				offer.setSumcredit(rs.getInt("sumcredit"));
				return offer;
			}
			}); 
    }
    
  public List<Offer>  getOffer1() {
    	
    	String sqlStatement="select * from manage " ;  
    	return jdbcTemplate.query(sqlStatement,new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
			
				
				Offer offer =new Offer();
				
			
				
				offer.setId(rs.getInt("id"));
				offer.setLearnedyear(rs.getInt("learnedyear"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setClassname(rs.getString("classname"));
				offer.setClassification(rs.getString("classification"));
				offer.setProfessor(rs.getString("professor"));
				offer.setCredit(rs.getInt("credit"));
				return offer;
			}
			}); 
    }
  public List<Offer>  getOffer2(int learnedyear) {
  	
  	String sqlStatement="SELECT * FROM manage WHERE learnedyear=?" ;  
  	return jdbcTemplate.query(sqlStatement,new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
			
				
				Offer offer =new Offer();
				
			
				
				offer.setId(rs.getInt("id"));
				offer.setLearnedyear(rs.getInt("learnedyear"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setClassname(rs.getString("classname"));
				offer.setClassification(rs.getString("classification"));
				offer.setProfessor(rs.getString("professor"));
				offer.setCredit(rs.getInt("credit"));
				return offer;
			}
			}); 
  }

    
    
    //Crud method 
    
    public boolean insert(Offer offer) {
   
    	int learnedyear =offer.getLearnedyear();
    	int semester =offer.getSemester();
    	String code =offer.getCode();
    	String classname =offer.getClassname();
    	String classification =offer.getClassification();
    	String professor =offer.getProfessor();
    	int credit =offer.getCredit();
    	
    	
    	
    	String sqlStatement="insert into manage(learnedyear,semester,code,classname,classification,professor,credit) value (?,?,?,?,?,?,?)"  ;
		return (jdbcTemplate.update(sqlStatement, new Object[] {learnedyear,semester,code,classname,classification,professor,credit})==1);
    	
    	
    }
    
    
    
  
    
   
    
    //crud method 
    
    public boolean update(Offer offer) {

    	int id =offer.getId();
    	int learnedyear =offer.getLearnedyear();
    	int semester =offer.getSemester();
    	String code =offer.getCode();
    	String classname =offer.getClassname();
    	String classification =offer.getClassification();
    	String professor =offer.getProfessor();
    	int credit =offer.getCredit();
    	
    	String sqlStatement ="update manage set learnedyear=?, semester =?, code=?, classname=? ,classification=?,professor=?,credit=? where id =? ";
    	return (jdbcTemplate.update(sqlStatement, new Object[] {semester,code,classname,classification,professor,credit})==1);
    	
    }
    
    
    //crud method 
    public boolean delete(int id ) {
    	String sqlStatement ="delete manage from offers where id =? ";
    	return (jdbcTemplate.update(sqlStatement, new Object[] {id})==1);
    	
    	
    	
    }





    
}
