package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.Student;
@Repository
public class StudentDaoImpl  implements StudentDao{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
    @Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Student> listAllStudents() {
		String sql = "select id, name,department, country FROM Student";
		  
		  List<Student> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new StudentMapper());
		  
		  return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(Student student){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(student != null){
		   parameterSource.addValue("id", student.getId());
		   parameterSource.addValue("name", student.getName());
		   parameterSource.addValue("department", student.getDepartment());
		   parameterSource.addValue("country", student.getCountry());
		  }
		  return parameterSource;
		 }
		 
		 private static final class StudentMapper implements RowMapper<Student>{

		  public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Student student = new Student();
		   student.setId(rs.getInt("id"));
		   student.setName(rs.getString("name"));
		   student.setDepartment(rs.getString("department"));
		   student.setCountry(rs.getString("country"));
		   
		   return student;
		  }
		  
		 }

	public Student findStudentById(int id) {
		String sql = "SELECT * FROM student WHERE id = :id";
		  
		  return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Student(id)), new StudentMapper());
		 }

	public void deleteStudent(int id) {
		 String sql = "DELETE FROM student WHERE id = :id";
		 namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Student(id)));
	}

	public void addStudent(Student stud) {
		String sql="INSERT INTO student(name,department,country) VALUES(:name,:department,:country)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(stud));
		
	}

	public void updateStudent(Student stud) {
		String sql = "UPDATE student SET name = :name, department = :department, country = :country WHERE id = :id";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(stud));
	}

}
