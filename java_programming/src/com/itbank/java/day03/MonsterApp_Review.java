package com.itbank.java.day03;

// 자바를 처음 해보신다고 하셨는데 학습속도와 이해력이 아주 뛰어나시네요! 
// 문제에서 주어진 조건대로 구현 잘 하셨습니다, 고생하셨어요 :) 
class Monster{
	String name, habitat;   // habitat = 서식지
	int health;
	int level = 0;
	public Monster(String name, String habitat, int health) {
		this.name = name;
		this.habitat = habitat;
		this.health = health;
	}
	public void levelUp() {
		level++;
	}
	public void levelDown() {
		level--;
	}
	public int healthChange(boolean win) {
		if(win) {
			levelUp();
			return health *= 2;
		}else {
			levelDown();
			return health /= 2;
		}
	}
}
class Batman extends Monster{
	String skill;
	boolean isLive = true;
	public Batman(String name, String habitat, int health,String skill) {
		super(name, habitat, health);
		this.skill = skill;
	}
	@Override
	public void levelDown() {
		if(level>0) {
			super.levelDown();
		}else {
			//level = 0; // level이 0보다 작거나 같을 때 else문으로 빠지기 때문에 0으로 할당해주는 것은 불필요합니다
			isLive = false;
			System.out.println("level이 0보다 작아질 수 없습니다. 몬스터는 살아있는가? " + isLive);
		}
	}
	public int getPower() {
		return level+health;
	}
	
	public int getPower(String medicine) {
		if(medicine.equals("Bat")) {
			return (level+health)*2;
		}else if(medicine.equals("Meat")){
			return (level+health)*3;
		}else return level+health;
	}
}

public class MonsterApp_Review {

	public static void main(String[] args) {
		/*
		* Monster클래스, Batman클래스, 실행클래스(MonsterApp)클래스 세가지 만들기 
		* 1) Monster 클래스 
		* Monster는  name(이름, String), habitat(서식지, String), health(체력, int), level(레벨, int) 변수를 가지고 있다. level의 초기값=0
		* Monster의 name, habitat, health는 객체 생성 시 초기화를 반드시 해줘야함 
		* 
		* levelUp() 메소드 생성: void리턴타입, 레벨 1 증가
		* levelDown() 메소드 생성: void리턴타입, 레벨 1 감소 
		* 
		* healthChange메소드 생성 : int리턴타입
		* 전투에서의 승리 여부(boolean)에 따라 health가 바뀌고 바뀐 health값 리턴 
		* 이겼다면, health 2배 증가시키고 levelUp() 메소드 호출, 
		* 졌다면, health 2배 감소시키고 levelDown() 메소드 호출 
		
		* 2) Monster클래스를 상속받는  Batman 클래스 생성하기 
		* Batman의 name, habitat, health, skill(능력, String), isLive(생존여부, boolean) 변수를 가지고 있으며, isLive초기값 = true이다. 
		* Batman의 name, habitat, health, skill은 객체 생성 시 초기화를 반드시 해줘야 함 
		* 
		* 레벨 1감소시키는 메소드를 재정의한다 
		* 만약, 현재 레벨이 0보다 작거나 같다면, isLive 상태를 false로 바꿈과 동시에
		* 							다음의 메세지 출력 "level이 0보다 작아질 수 없습니다. 몬스터는 살아있는가? ???????"  살아있는지 여부를 boolean으로 함께 출력
		* 	      그렇지 않다면, Monster클래스의 메소드 로직을 그대로 실행한다. 
		* 
		* 기능추가) 파워값을 계산하는 메소드를 생성한다. 
		* 		   매개변수는 필요하지 않고, level과 health를 더한값으로 power는 정의되며, 이를 리턴해준다.
		* 
		* 만약 String 자료형의 medicine을 먹었다고 했을때도 파워값을 계산해줄 수 있다. 
		* 만약, medicine이 "Bat"일 경우, power는 level과 health를 더한값의 2배로 정의된다. 
		* 만약, medicine이 "Meat"일 경우, power는 level과 health를 더한값의 3배로 정의된다.
		* medicine이 위 두경우에 해당하지 않으면, level과 health를 더한값으로 정의됨 
		* 
		*/
		
		// 예상 결과값
		Monster zombie = new Monster("좀비", "Cemetery", 200);
		System.out.println(zombie.name + " " + zombie.habitat + " " + zombie.health); //좀비 Cemetery 200
		zombie.healthChange(true); // 400
		System.out.println(zombie.health + " " + zombie.level); // 400 1
		
		Batman bat = new Batman("배트맨", "Cave", 150, "Fly");
		System.out.println(bat.name + " " + bat.habitat + " " + bat.health + " " + bat.skill); // 배트맨 Cave 150 Fly
		bat.healthChange(false); // level이 0보다 작아질 수 없습니다.현재 이 몬스터는 살아있는가? false
		System.out.println(bat.health + " " + bat.level); // 75 0
		bat.healthChange(true);
		System.out.println(bat.health + " " + bat.level); //150 1
		System.out.println(bat.healthChange(true) + " " + bat.level); // 300 2
		System.out.println("power는" + bat.getPower()); // power는302
		System.out.println("power는" + bat.getPower("Bat")); // power는604
		System.out.println("power는" + bat.getPower("Meat")); // power는906
		System.out.println("power는" + bat.getPower("Human")); // power는302
		

	}

}
