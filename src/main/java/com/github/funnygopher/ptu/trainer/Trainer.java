package com.github.funnygopher.ptu.trainer;

import com.github.funnygopher.ptu.AbilityManager;
import com.github.funnygopher.ptu.CombatStatManager;
import com.github.funnygopher.ptu.Skill;
import com.github.funnygopher.ptu.trainer.inventory.Inventory;
import com.github.funnygopher.ptu.SkillManager;
import com.github.funnygopher.ptu.trainer.equipment.EquipmentManager;
import com.github.funnygopher.ptu.trainer.feature.FeatureManager;

public class Trainer {

	private String name, gender, background, size, description;
	private int age, weight;
	private int level, exp, actionPoints, hitPoints, injuries;
	private int money;

	private Attribute body, mind, spirit;

	private SkillManager skills;
	private CombatStatManager combatStats;
	private AbilityManager abilities;
	private FeatureManager features;
	private EdgeManager edges;
	private Inventory inventory;
	private EquipmentManager equipment;
	
	/**
	 * Instantiates a Trainer object
	 */
	public Trainer() {
		initAttributes();
		skills = new SkillManager();
		combatStats = new CombatStatManager(10, 5, 5, 5, 5, 5);
		level = 1;
		features = new FeatureManager();
		edges = new EdgeManager();
		setInventory(new Inventory());
		equipment = new EquipmentManager();
	}
	
	public AbilityManager getAbilities() {
		return abilities;
	}
	
	public int getActionPoints() {
		return actionPoints;
	}

	public int getAge() {
		return age;
	}

	public String getBackground() {
		return background;
	}

	public Attribute getBody() {
		return body;
	}
	
	public CombatStatManager getCombatStats() {
		return combatStats;
	}
	
	public String getDescription() {
		return description;
	}
	
	public EdgeManager getEdges() {
		return edges;
	}
	
	public EquipmentManager getEquipment() {
		return equipment;
	}

	public int getExp() {
		return exp;
	}
	
	public FeatureManager getFeatures() {
		return features;
	}
	
	public String getGender() {
		return gender;
	}

	public int getHighJump(boolean isRunning) {
		int highJump = 0;
		
		if(skills.getAcrobatics().compareTo(Skill.ADEPT) >= 0)
			highJump++;
		if(skills.getAcrobatics().compareTo(Skill.MASTER) >= 0)
			highJump++;
		if(isRunning)
			highJump++;
		
		return highJump;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getInjuries() {
		return injuries;
	}	

	public Inventory getInventory() {
		return inventory;
	}

	public int getLongJump() {
		return skills.getAcrobatics().getValue() / 2;
	}

	public int getMaxHitPoints() {
		return (level * 2) + (combatStats.getHP() * 3) + 10;
	}

	public Attribute getMind() {
		return mind;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getOverland() {
		return 3 + ((skills.getAcrobatics().getValue() + skills.getAthletics().getValue()) / 2);
	}

	public int getPower() {
		int power = 4;
		
		if(body.compareTo(Attribute.AVERAGE) < 0 | skills.getAthletics().equals(Skill.PATHETIC))
			power--;
		if(body.compareTo(Attribute.GOOD) >= 0)
			power++;
		if(body.compareTo(Attribute.FABULOUS) >= 0)
			power++;
		if(skills.getAthletics().compareTo(Skill.NOVICE) >= 0)
			power++;
		if(skills.getCombat().compareTo(Skill.ADEPT) >= 0)
			power++;
		
		return power;
	}

	public String getSize() {
		return size;
	}

	public Attribute getSpirit() {
		return spirit;
	}

	public int getSwimming() {
		return getOverland() / 2;
	}
	
	public int getThrowingRange() {
		return 4 + skills.getAthletics().getValue();
	}
	
	public int getWeight() {
		return weight;
	}
	
	private void initAttributes() {
		setBody(Attribute.AVERAGE);
		setMind(Attribute.AVERAGE);;
		setSpirit(Attribute.AVERAGE);
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setBody(Attribute body) {
		this.body = body;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void setInjuries(int injuries) {
		this.injuries = injuries;
	}

	private void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setMind(Attribute mind) {
		this.mind = mind;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSpirit(Attribute spirit) {
		this.spirit = spirit;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
