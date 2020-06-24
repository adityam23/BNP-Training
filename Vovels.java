class Vovels{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter a string : ");
		String input = scan.nextLine();
		int count = 0;
		for(int i = 0 ; i < input.length() ; i++ ){
			switch(input.charAt(i)){
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U': count++;
			}
		}
		System.out.println("The number of vowels are : " + count);
	}
}