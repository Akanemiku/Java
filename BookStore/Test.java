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
		BookView bookView = new BookView();
	}
	
	public static void show() {
		BookBiz bookBiz = new BookBiz();
		if(bookBiz.getBookCount()==0) {
			System.out.println("仓库空空如也！");
			return;
		}
		for(int i=0;i<bookBiz.getBookCount();i++) {
			System.out.println(Datas.BookStore[i].getBookId()+"\t"+Datas.BookStore[i].getBookName()+"\t"+Datas.BookStore[i].getCount());
		}
	}
}
