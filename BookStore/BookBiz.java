//图书业务类
//包含对图书以及图书数组的基本操作
public class BookBiz{
	
	//获得图书仓库中Datas.BookStore数组中图书对象的个数
	public int getBookCount(){
		int count = 0;
		for(Book book :  Datas.BookStore){
			if(book == null) break;
			count++
		}
		return count;
	}
	
	//将传入的图书对象放置到图书仓库(数组)中去
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount){
			return false;
		}
		//如果仓库不满，就将传入的图书对象放置在数组的最后一个位置(第一个非null位置)
		Datas.BookStore[bookCount] = book;
		return true;
	}
}
