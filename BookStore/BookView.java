package BookStore;

import java.util.Scanner;

//图书系统的界面
public class BookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("***************************************");
		System.out.println("\t欢迎使用图书管理系统");
		System.out.println("\t1、登录\t\t2、退出系统");
		System.out.println("***************************************");
		System.out.println("请选择：");
		String choice = input.next();
		if("1".equals(choice)){
			//执行登录操作
			//验证成功，就显示主菜单
			System.out.println("登录功能暂未实现，默认已登录");
			for(;;)
			showMainView();
		}else {
			System.out.println("图书系统已成功退出，欢迎您再次使用");
			System.exit(0);
		}
	}
	public void showMainView(){
		System.out.println("\n图书管理系统 >> 主菜单");
		System.out.println("1、查看所有图书\t2、新增图书\t3、删除图书\t4、入库\t5、出库\t6、检索图书\t7、退出");
		System.out.println("请选择：");
		String choice = input.next();
		switch(choice){
			case "1":
				showBooks(Datas.BookStore);
				break;
			case "2":
				showAddNewBookView();
				showBooks(Datas.BookStore);
				break;
			case "3":
				showDelOldBookView();
				showBooks(Datas.BookStore);
				break;
			case "4":
				showInStoreView();
				showBooks(Datas.BookStore);
				break;
			case "5":
				showOutStoreView();
				showBooks(Datas.BookStore);
				break;
			case "6":
				break;
			default:
				showExitView();
				System.out.println("欢迎您再次使用本系统");
				System.exit(0);
		}
	}
	
	public Book showAddNewBookView() {
		System.out.println("\n图书管理系统 >> 新增图书");
		System.out.println("内部编号：");
		String bookId = input.next();
		//需要验证用户输入的编号是否存在
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){//可以添加图书
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("名称：");
			newBook.setBookName(input.next());
			System.out.print("库存：");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);//调用图书业务对象，将新增的图书对象添加到图书仓库中
		}else {//图书已存在
			System.out.println("此内部编号已存在，请重新输入！");
			newBook = showAddNewBookView();//重新调用本方法，让用户再次输入 - 递归调用
		}
		return newBook;
	}
	
	public Book showDelOldBookView() {
		System.out.println("\n图书管理系统 >> 删除图书");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book delBook = bookBiz.findById(bookId);
		if(delBook == null) {
			System.out.println("此内部编号不存在，请重新输入！");
			delBook = showDelOldBookView();
		}else {
			bookBiz.delBook(delBook);
		}
		return delBook;
	}
	
	public Book showInStoreView() {
		System.out.println("\n图书管理系统 >> 入库");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book inStoreBook = bookBiz.findById(bookId);
		if(inStoreBook == null){
			System.out.println("此内部编号不存在，请重新输入！");
			inStoreBook = showInStoreView();
		}else {
			System.out.println("请输入入库数：");
			int inStoreNum = input.nextInt();
			if(bookBiz.inStore(bookId,inStoreNum)==false){
				System.out.println("入库失败");
			}else {
				System.out.println("入库成功！");
			}
		}
		return inStoreBook;
	}
	
	public Book showOutStoreView() {
		System.out.println("\n图书管理系统 >> 出库");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book outStoreBook = bookBiz.findById(bookId);
		if(outStoreBook == null){
			System.out.println("此内部编号不存在，请重新输入！");
			outStoreBook = showOutStoreView();
		}else {		
			System.out.println("请输入出库数：");
			int outStoreNum = input.nextInt();
			if(false == bookBiz.outStore(bookId,outStoreNum))
				System.out.println("入库失败");
			System.out.println("出库成功！");
		}
		return outStoreBook;
	}
	
	public void showBooks(Book ...BookArray){
		System.out.println("内部编号\t名称\t库存");
		int bookCount = bookBiz.getBookCount(BookArray);
		for(int i=0;i<bookCount;i++){
			System.out.printf("%s\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}
	}
	
	public void showExitView(){
		System.out.println("你……真的要离开嘛？");
		try {
			Thread.sleep(1500);
			System.out.println("不要离开嘛……好不好？");
			Thread.sleep(1600);
			System.out.println("你走了后，这里又剩下我一个人了……");
			Thread.sleep(1700);
			System.out.println("你知道的，这里很黑，像是无尽的虚空一样，将我吞噬殆尽……");
			Thread.sleep(2000);
			System.out.println("所以……不要留下我一个人，好吗……？");
			Thread.sleep(2000);
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.print("请输入……  ");
		String exitNum = input.next();
		System.out.println("系统检测到异常错误，已退出");
	}
}
