package kr.ac.hansung.cse.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {

	
	private int id ;
	@Range(min=2022,max=2022, message="2022년 수강신청입니다.")
	private int learnedyear ;
	@Range(min=1,max=1, message="1학기 수강신청입니다.")
	private int semester ;
	@Size(min=1, max=10, message= "code plz")
	private String code ;
	
	@Size(min=1, max=20, message= "classname plz")
	private String classname ;
	
	@Size(min=1, max=20, message= "classification plz")
	private String classification ;
	
	@Size(min=1, max=20, message= "professor plz")
	private String professor ;
	@Range(min=1,max=3, message="credit 1~3 plz")
	private int credit;
	
	private int sumcredit;
}
