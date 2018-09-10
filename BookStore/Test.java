package BookStore;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book();
		book1.setBookName("Sword Art Online");
		book1.setBookId("0001");
		book1.setCount(100);

		BookBiz bookBiz = new BookBiz();
		bookBiz.addBook(book1);
//		show();
//		bookBiz.inStore("0001", 50000);
//		show();
//		
//		Book book2 = new Book();
//		book2.setBookName("No game No life");
//		book2.setBookId("0002");
//		book2.setCount(50);
//		bookBiz.addBook(book2);
//		show();
//		
//		bookBiz.outStore("0001", 40000);
//		show();
//		
//		bookBiz.delBook(book2);
//		show();
		
		BookView bookView = new BookView();
		show();
	}
	
	public static void show() {
		BookBiz bookBiz = new BookBiz();
		if(bookBiz.getBookCount()==0) {
			System.out.println("≤÷ø‚ø’ø’»Á“≤£°");
			return;
		}
		for(int i=0;i<bookBiz.getBookCount();i++) {
			System.out.println(Datas.BookStore[i].getBookId()+"\t"+Datas.BookStore[i].getBookName()+"\t"+Datas.BookStore[i].getCount());
		}
	}
}
