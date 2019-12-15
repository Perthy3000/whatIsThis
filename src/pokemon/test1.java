package pokemon;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import test.skill;

public abstract class test1 {
	private String name;
	private Element element;
	private int attack;
	private int defense;
	private int maxHp;
	private int speed;
	private int currentHp;
	private Status status;
	protected List<skill> skillList;
	private PieChart pieChart;
	public test1(String name, Element element, int maxHp, int attack, int defense, int speed) {
		this.name = name;
		this.element = element;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		currentHp = maxHp;
		status = Status.READY;
		skillList = new ArrayList<skill>();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
   	         new PieChart.Data("HP", this.maxHp), 
   	         new PieChart.Data("Attack", this.attack), 
   	         new PieChart.Data("Defense",this.defense), 
   	         new PieChart.Data("Speed", this.speed)); 
   	       
   	      //Creating a Pie chart 
   	      pieChart = new PieChart(pieChartData); 
   	              
   	      //Setting the title of the Pie chart 
   	      pieChart.setTitle(""); 
   	       
   	      //setting the direction to arrange the data 
   	      pieChart.setClockwise(true); 
   	       
   	      //Setting the length of the label line 
   	      pieChart.setLabelLineLength(50); 

   	      //Setting the labels of the pie chart visible  
   	      pieChart.setLabelsVisible(true); 
   	       
   	      //Setting the start angle of the pie chart  
   	      pieChart.setStartAngle(180);
	}
	public PieChart getPieChart() {
		return this.pieChart;
		}
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int doDamage(test1 sandbag, skill move) {
		int calDamage = getAttack()+move.getPower()-sandbag.getDefense();
		if(calDamage <= 0) {
			calDamage = 1;
		}
		sandbag.setCurrentHp(sandbag.getCurrentHp()-calDamage);
		return calDamage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getmaxHp() {
		return maxHp;
	}
	
	public void setCurrentHp(int currentHp) {
		if(currentHp <= 0) {
			currentHp = 0;
			status = Status.FAINTED;
		}
		this.currentHp = currentHp;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}

	public void fullHeal() {
		currentHp = maxHp;
		status = Status.READY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setEvasion(int speed) {
		this.speed = speed;
	}
	
	public List<skill> getSkillList() {
		return skillList;
	}
	
	public skill getskill(int num) {
		return skillList.get(num);
	}
	
}
