class Palindrome{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter string to check for palindrome : ");
		String input = scan.nextLine();
		int strLength = input.length();
		boolean flag = true;
		for(int i = 0; i < strLength/2 ; i++){
			if(input.charAt(i) == input.charAt(strLength-i-1)){
				flag = true;
			}
			else{
				flag = false;
			}
		}
		if(flag){
			System.out.println("String is palindrome");
		}
		else{
			System.out.println("String is not a palindrome");
		}
	}
}