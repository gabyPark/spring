package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		 * Exam exam = new NewlecExam(); // ExamConsole console = new
		 * InlineExamConsole(exam); // DI ExamConsole console = new GridExamConsole();
		 * 
		 * console.setExam(exam);
		 */
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		/* 메이븐 설치(나는 경로에서 문제가 떴기 때문에 pom.xml 에 직접 추가함)
		를 하고 나면, 지시서(setting.xml) 에 있는 객체들을 만들고, 인젝션까지 해서 컨테이너(IOC Container) 에 담아놨을 것
		만들어진 객체는 변수명으로 꺼내 쓸 수도 있고, 타입명을 가지고 꺼내 쓸 수도 있다.
		*/
		
		// 변수명
		ExamConsole console = (ExamConsole) context.getBean("console");
		
		// 타입명(자료형) => 더 선호되는 타입!
		// ExamConsole console = context.getBean(ExamConsole.class);
		
		console.print();
	}

}
