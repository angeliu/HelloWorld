package test;

public class Full {
	public static void main(String[] args) {
		final int MAX_WEIGHT = 8;
		final int MIN_WEIGTH = 1;
		int[] key = new int[MAX_WEIGHT + 1];
		int[] value = new int[MAX_WEIGHT + 1];
		FruitInBag[] fruitInBags = {
			new FruitInBag("����", 4, 4500),
			new FruitInBag("ƻ��", 5, 5700),
			new FruitInBag("����", 2, 2250),
			new FruitInBag("��ݮ", 1, 1100),
			new FruitInBag("���", 6, 6700)
		};
		for (int i = 0; i < fruitInBags.length; i++) {
			for(int s = fruitInBags[i].getWeight(); s <= MAX_WEIGHT; s++) {
				int p = s - fruitInBags[i].getWeight();				
				int newvalue = value[p] + fruitInBags[i].getPrice();
				if (newvalue > value[s]) {
					value[s] = newvalue;
					key[s] = i;
				}
			}
		}
		System.out.println("��Ʒ\t�۸�");
		for (int i = MAX_WEIGHT; i >= MIN_WEIGTH; i = i - fruitInBags[key[i]].getWeight()) {
			System.out.println(fruitInBags[key[i]].getName() +  "\t" + fruitInBags[key[i]].getPrice());
		}
		System.out.println("�ϼƣ�" + value[MAX_WEIGHT]);
		
	}	
}
class  FruitInBag {
	private String name;
	private int weight;
	private int price;
	public FruitInBag(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
