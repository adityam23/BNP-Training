class Methods{
	int num1, num2, result;
	public static void main(String[] args){
		new Methods().takeInput();
	}
	void add(){
		this.result = this.num1 + this.num2;
		displayOutput();
	}

	void takeInput(){
		java.util.Scanner scan = new java.util.Scanner(System.in);
		this.num1 = scan.nextInt();
		this.num2 = scan.nextInt();
		this.add();
	}

	void displayOutput(){
		System.out.println("Addition : " + this.result);
	}
}