public class TestCharacter {
	public static void main(String[] args) {
		Character Role1 = new Character("狱血魔神", 70,"崩山裂地斩");
		Role1.show();
		Character Role2 = new Character();
		Role2.name = "剑圣";
		Role2.level = 70;
		Role2.skill = "幻影剑舞";
		Role2.show();
				
	}
	public static class Character{
		public String name;
		public int level;
		public String skill;
		/**
		 * 构造方法
		 * 没有返回值
		 * 方法名和类名一致
		 * 简化使用时的分别赋值
		 */
		public Character() {};//默认构造，有无构造方法时均隐式存在，当显式时，可重载
		public Character(String name1,int level1,String skill1) {
			name = name1;
			level = level1;
			skill = skill1;
		}
		
		public void show(){
			System.out.println(name+"\t"+"Lv:"+level+"\t"+skill);
		}
	}
}
