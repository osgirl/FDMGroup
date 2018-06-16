package com.fdmgroup.game;
import java.util.Random;

public class Wizard extends MyPlayer{
	private static final long serialVersionUID = -8220519592818914725L;
	Random myGenerator;

	private MyBackpack inventory;
	private int magicDmg;
	private int magicDef;
	private String specialty;
	private String weakness;
	private boolean isAlive;
	private int shieldpoints;
	private int level;
	private int currentExperience;
	private int experienceTillNext;
	
	public Wizard(){
		super();
	}
	
	public Wizard(int healthpoints, String name, int magicDamage, int magicDefense, String special, String weak){
		myGenerator = new Random();

		inventory = new MyBackpack();
		super.setHealthPoints(healthpoints);
		super.setName(name);
		this.magicDmg = magicDamage;
		this.magicDef = magicDefense;
		this.specialty = special;
		this.weakness = weak;
		this.isAlive = true;
		this.shieldpoints = 0;
		this.level = 1;
		this.currentExperience = 0;
		this.experienceTillNext = 10;
	}
	
	public void attack(Wizard rival){
		int chance = myGenerator.nextInt(100) + 1;
		if(chance > 20){
			if(rival.getWeakness().equals(this.getSpecialty())){
				int defense = rival.getShieldpoints() + rival.getMagicDef();
				if(defense < (this.getMagicDmg() * 2)){
					rival.setHealthPoints((rival.getHealthPoints() - ((this.getMagicDmg() * 2) - defense)));
					System.out.println(this.getName() + " dealt " + (this.getMagicDmg() * 2) + " DMG to " + rival.getName() + "; " + rival.getHealthPoints() + " health left." );
				}
				else
					System.out.println(this.getName() + " attacked " + rival.getName() + " did no DMG; defense is too strong!"); 
			}
			else{
				int defense = rival.getShieldpoints() + rival.getMagicDef();
				if(defense < this.getMagicDmg()){
					rival.setHealthPoints((rival.getHealthPoints() - (this.getMagicDmg() - defense)));
					System.out.println(this.getName() + " dealt " + (this.getMagicDmg() * 2) + " DMG to " + rival.getName() + "; " + rival.getHealthPoints() + " health left." );
				}
				else
					System.out.println(this.getName() + " attacked " + rival.getName() + " did no DMG; defense is too strong!"); 
			}
		}
		
		if(rival.getHealthPoints() <= 0){
			rival.setAlive(false);
		}
		
		this.setCurrentExperience(this.getCurrentExperience() + this.getLevel());
		if(this.getCurrentExperience() >= this.getExperienceTillNext()){
			this.setLevel(this.getLevel() + 1);
			this.setExperienceTillNext(this.getCurrentExperience() * 2);
			this.setCurrentExperience(0);
			System.out.println("CONGRATS! " + this.getName() + " has leveled up to " + this.getLevel() + "!");
		}
	}
	
	public void shieldOn(){
		this.shieldpoints = 25;
	}

	protected Random getMyGenerator() {
		return myGenerator;
	}

	protected void setMyGenerator(Random myGenerator) {
		this.myGenerator = myGenerator;
	}

	protected MyBackpack getInventory() {
		return inventory;
	}

	protected void setInventory(MyBackpack inventory) {
		this.inventory = inventory;
	}

	protected int getMagicDmg() {
		return magicDmg;
	}

	protected void setMagicDmg(int magicDmg) {
		this.magicDmg = magicDmg;
	}

	protected int getMagicDef() {
		return magicDef;
	}

	protected void setMagicDef(int magicDef) {
		this.magicDef = magicDef;
	}

	protected String getSpecialty() {
		return specialty;
	}

	protected void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	protected String getWeakness() {
		return weakness;
	}

	protected void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	protected boolean isAlive() {
		return isAlive;
	}

	protected void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected int getShieldpoints() {
		return shieldpoints;
	}

	protected void setShieldpoints(int shieldpoints) {
		this.shieldpoints = shieldpoints;
	}

	protected int getLevel() {
		return level;
	}

	protected void setLevel(int level) {
		this.level = level;
	}

	protected int getCurrentExperience() {
		return currentExperience;
	}

	protected void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}

	protected int getExperienceTillNext() {
		return experienceTillNext;
	}

	protected void setExperienceTillNext(int experienceTillNext) {
		this.experienceTillNext = experienceTillNext;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}
}
